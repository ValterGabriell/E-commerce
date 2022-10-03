package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Admin.AdminDTO;
import com.ecomerce.ecommerce.model.Admin.AdminRequest;
import com.ecomerce.ecommerce.model.Admin.AdminResponse;
import com.ecomerce.ecommerce.model.Sellers.SellerDTO;
import com.ecomerce.ecommerce.model.Sellers.SellerResponse;
import com.ecomerce.ecommerce.services.AdminS;
import com.ecomerce.ecommerce.services.ProductsS;
import com.ecomerce.ecommerce.services.SellerS;
import com.ecomerce.ecommerce.util.Constantes;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/admin")
public class AdminC {
    @Autowired
    AdminS adminS;
    @Autowired
    ProductsS productsS;


    /**
     * Método responsável por criar um novo usuário administrador de sistema
     *
     * @param adminRequest
     * @return Admin User
     */
    @PostMapping("/signUp")
    public ResponseEntity<AdminResponse> createNewAdminUser(@RequestBody AdminRequest adminRequest) {

        AdminDTO adminDTO = Utils.getModelMapperInstance(adminRequest, AdminDTO.class);
        adminDTO = adminS.signUp(adminDTO);
        AdminResponse adminResponse = Utils.getModelMapperInstance(adminDTO, AdminResponse.class);
        return new ResponseEntity<>(adminResponse, HttpStatus.CREATED);
    }


    /**
     * Método responsável por logar um usuário administrador de sistema
     *
     * @param adminRequest
     * @return Admin User
     */
    @PostMapping("/signIn")
    public ResponseEntity<AdminResponse> signInUser(@RequestBody AdminRequest adminRequest) {
        AdminDTO adminDTO = Utils.getModelMapperInstance(adminRequest, AdminDTO.class);
        adminDTO = adminS.signIn(adminDTO);

        if (adminDTO != null) {
            AdminResponse adminResponse = Utils.getModelMapperInstance(adminDTO, AdminResponse.class);
            return new ResponseEntity<>(adminResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new AdminResponse(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sellers")
    public ResponseEntity<List<SellerResponse>> getAllSellers() {
        List<SellerDTO> sellerDTOList = adminS.getAllSellers();
        List<SellerResponse> sellerResponseList = sellerDTOList.stream().map(element -> Utils.getModelMapperInstance(element, SellerResponse.class)).collect(Collectors.toList());
        return new ResponseEntity<>(sellerResponseList, HttpStatus.OK);
    }

    @GetMapping("/sellers/{seller_id}")
    public ResponseEntity<SellerResponse> getSellerById(@PathVariable Integer seller_id) {
            SellerDTO sellerDTO = adminS.getSellerById(seller_id);
            SellerResponse sellerResponse = Utils.getModelMapperInstance(sellerDTO, SellerResponse.class);
            return new ResponseEntity<>(sellerResponse, HttpStatus.OK);
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable Integer productId) {
        String response = productsS.deleteProductByIdWhitoutSeller(productId);
        if (response.equals(Constantes.DELETED_FAIL)){
            return new ResponseEntity<>(Constantes.NOT_FOUND, HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }



}
