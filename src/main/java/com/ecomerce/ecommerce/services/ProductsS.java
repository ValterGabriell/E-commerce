package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Cart.Cart;
import com.ecomerce.ecommerce.model.Cart.CartDTO;
import com.ecomerce.ecommerce.model.Cart.CartRep;
import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Costumer.CostumerRep;
import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.ProductsDTO;
import com.ecomerce.ecommerce.model.Products.ProductsRep;
import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerRep;
import com.ecomerce.ecommerce.util.Constantes;
import com.ecomerce.ecommerce.util.Utils;
import com.ecomerce.ecommerce.util.ImportantsMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductsS {
    @Autowired
    ProductsRep productsRep;
    @Autowired
    SellerRep sellerRep;
    @Autowired
    CartRep cartRep;
    @Autowired
    CostumerRep costumerRep;

    public ProductsDTO createNewProduct(ProductsDTO productsDTO) {
        productsDTO.setId(null);

        Products products = Utils.getModelMapperInstance(productsDTO, Products.class);

        productsRep.save(products);

        productsDTO.setId(products.getId());
        return productsDTO;
    }

    public CartDTO addCar(CartDTO cartDTO) {
        boolean existId = ImportantsMethods.Companion.verifyIfProductExists(cartDTO.getProduct(), productsRep);
        Costumer costumer = costumerRep.findById(cartDTO.getCostumer().getId()).get();
        if (existId){
            //setando o id do carrinho sendo o id do usuario
            cartDTO.setId(costumer.getId());

            Cart cart = Utils.getModelMapperInstance(cartDTO, Cart.class);
            //returnando a lista de produtos passados na request como uma lista de inteiro
            List<Integer> listIds = ImportantsMethods.Companion.returnIds(cart.getProduct());

            //identificamos todos na lista de produtos gerais que tenham esses ids
            List<Products> productsList = productsRep.findAllById(listIds);

            //calculando o valor totalm da lista
            Double totalValue = ImportantsMethods.Companion.calculateTotalValue(productsList);

            cartDTO.setAmount(totalValue);
            cartDTO.setCostumer(costumer);
            cart.setAmount(totalValue);

            cartRep.save(cart);

            cartDTO.setProduct(productsList);
            cartDTO.setId(cart.getId());

            return cartDTO;
        }else{
            return new CartDTO();
        }

    }

    public List<ProductsDTO> listAllProducts() {
        List<Products> productsList = productsRep.findAll();
        return productsList.stream().map(element -> Utils.getModelMapperInstance(element, ProductsDTO.class)).collect(Collectors.toList());
    }


    public String deleteProductById(Integer seller_id, Integer productId) {
        Optional<Seller> seller = sellerRep.findById(seller_id);
        List<Products> productsList = seller.get().getProductsList();
        return ImportantsMethods.Companion.verifyAndDeleteProduct(productsList, productId, productsRep);
    }

    public String deleteProductByIdWhitoutSeller(Integer productId) {
            productsRep.deleteById(productId);
            return Constantes.DELETED_OK;
    }


}
