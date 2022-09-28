package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Admin.AdminDTO;
import com.ecomerce.ecommerce.model.Admin.AdminRequest;
import com.ecomerce.ecommerce.model.Admin.AdminResponse;
import com.ecomerce.ecommerce.services.AdminS;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminC {
    @Autowired
    AdminS adminS;

    /**
     *
     * Método responsável por criar um novo usuário administrador de sistema
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
     * @param adminRequest
     * @return Admin User
     */
    @PostMapping("/signIn")
    public ResponseEntity<AdminResponse> signInUser(@RequestBody AdminRequest adminRequest) {

        AdminDTO adminDTO = Utils.getModelMapperInstance(adminRequest, AdminDTO.class);
        adminDTO = adminS.signIn(adminDTO);
        AdminResponse adminResponse = Utils.getModelMapperInstance(adminDTO, AdminResponse.class);
        return new ResponseEntity<>(adminResponse, HttpStatus.OK);
    }






}
