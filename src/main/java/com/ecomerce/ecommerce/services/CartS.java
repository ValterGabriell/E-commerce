package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Cart.Cart;
import com.ecomerce.ecommerce.model.Cart.CartDTO;
import com.ecomerce.ecommerce.model.Cart.CartRep;
import com.ecomerce.ecommerce.model.Costumer.Costumer;
import com.ecomerce.ecommerce.model.Costumer.CostumerRep;
import com.ecomerce.ecommerce.model.Products.Products;
import com.ecomerce.ecommerce.model.Products.ProductsRep;
import com.ecomerce.ecommerce.util.ImportantsMethods;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartS {
    @Autowired
    CartRep cartRep;
    @Autowired
    CostumerRep costumerRep;
    @Autowired
    ProductsRep productsRep;

    public CartDTO getCartById(Integer costumer_id){
        Optional<Cart> cart = cartRep.findById(costumer_id);
        if (cart.isPresent()){
            return Utils.getModelMapperInstance(cart.get(), CartDTO.class);
        }
        return new CartDTO();
    }

    public CartDTO addCar(CartDTO cartDTO) {
        boolean existId = ImportantsMethods.Companion.verifyIfProductExists(cartDTO.getProduct(), productsRep);
        Costumer costumer = costumerRep.findById(cartDTO.getCostumer().getId()).get();
        //verificar se o usuario ja tem carrinho, senao tiver criar um
        if (existId){
            if (costumer.getCart() == null){
                Cart cart = Utils.getModelMapperInstance(cartDTO, Cart.class);
                //retornando a lista de produtos passados na request como uma lista de inteiro filtrando por id
                List<Integer> listIds = ImportantsMethods.Companion.returnIds(cart.getProduct());

                //identificamos todos na lista de produtos gerais que tenham esses ids
                List<Products> productsList = productsRep.findAllById(listIds);

                //calculando o valor total da lista
                Double totalValue = ImportantsMethods.Companion.calculateTotalValue(productsList);

                //trecho responsavel por salvar os dados para que seja retornado ao controller
                cartDTO.setAmount(totalValue);
                cartDTO.setProduct(productsList);
                cartDTO.setCostumer(costumer);

                cart.setAmount(totalValue);
                cartRep.save(cart);
                cartDTO.setId(cart.getId());
                return cartDTO;
            }else{
                Cart cart = Utils.getModelMapperInstance(cartDTO, Cart.class);
                //retornando a lista de produtos passados na request como uma lista de inteiro filtrando por id
                List<Integer> listIds = ImportantsMethods.Companion.returnIds(cart.getProduct());

                //identificamos todos na lista de produtos gerais que tenham esses ids
                List<Products> productsList = productsRep.findAllById(listIds);

                //calculando o valor total da lista
                Double totalValue = ImportantsMethods.Companion.calculateTotalValue(productsList);

                //trecho responsavel por salvar os dados para que seja retornado ao controller
                cartDTO.setAmount(totalValue);
                cartDTO.setProduct(productsList);
                cartDTO.setCostumer(costumer);
                cartDTO.setId(costumer.getId());
                //salvando o id do cart como id so usuario para que nao se repita e o valor total
                cart.setAmount(totalValue);
                cart.setId(costumer.getId());
                cartRep.save(cart);

                return cartDTO;
            }
        }else{
            return new CartDTO();
        }
    }

}
