package com.ecomerce.ecommerce.controller;

import com.ecomerce.ecommerce.model.Admin.AdminDTO;
import com.ecomerce.ecommerce.model.Admin.AdminRequest;
import com.ecomerce.ecommerce.model.Admin.AdminResponse;
import com.ecomerce.ecommerce.services.AdminS;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AdminC {
    @Autowired
    AdminS adminS;

    /**
     *
     * Método responsável por criar um novo usuário administrador de sistema
     * @param adminRequest
     * @return Admin User
     */
    @PostMapping("/admin/signUp")
    public ResponseEntity<AdminResponse> createNewAdminUser(@RequestBody AdminRequest adminRequest) {
        ModelMapper mapper = new ModelMapper();
        AdminDTO adminDTO = mapper.map(adminRequest, AdminDTO.class);
        adminDTO = adminS.signUp(adminDTO);
        AdminResponse adminResponse = mapper.map(adminDTO, AdminResponse.class);
        return new ResponseEntity<>(adminResponse, HttpStatus.CREATED);
    }


    /**
     * Método responsável por logar um usuário administrador de sistema
     * @param adminRequest
     * @return Admin User
     */
    @PostMapping("/admin/signIn")
    public ResponseEntity<AdminResponse> signInUser(@RequestBody AdminRequest adminRequest) {
        ModelMapper mapper = new ModelMapper();
        AdminDTO adminDTO = mapper.map(adminRequest, AdminDTO.class);
        adminDTO = adminS.signIn(adminDTO);
        AdminResponse adminResponse = mapper.map(adminDTO, AdminResponse.class);
        return new ResponseEntity<>(adminResponse, HttpStatus.OK);
    }






}
