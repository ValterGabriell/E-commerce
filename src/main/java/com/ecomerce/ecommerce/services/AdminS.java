package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Admin.Admin;
import com.ecomerce.ecommerce.model.Admin.AdminDTO;
import com.ecomerce.ecommerce.model.Admin.AdminRep;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;


@Service
public class AdminS {
    @Autowired
    AdminRep adminRep;


    /**
     * Método responsavel por validar se um usuário existe ou não no sistema, para só entao criar ele
     * @param adminDTO
     * @return
     */
    public AdminDTO signUp(AdminDTO adminDTO) {
        adminDTO.setId(null);
        ModelMapper mapper = new ModelMapper();

        Admin admin = mapper.map(adminDTO, Admin.class);
        String username = admin.getUsername();
        Admin adm = adminRep.findByUsername(username);

        if (adm == null) {
            String password = admin.getPassword();
            admin.setPassword(Base64.getEncoder().encodeToString(password.getBytes()));
            admin = adminRep.save(admin);
            adminDTO.setId(admin.getId());
        }
        return adminDTO;
    }

    /**
     * Método responsavel por logar o usuario caso coloque a senha correta
     * @param adminDTO
     * @return
     */
    public AdminDTO signIn(AdminDTO adminDTO) {
        String username = adminDTO.getUsername();
        Admin admin = adminRep.findByUsername(username);

        if (admin != null) {
            String currentPassword = adminDTO.getPassword();
            String coded = Base64.getEncoder().encodeToString(currentPassword.getBytes());
            if (coded.equals(admin.getPassword())) {
                ModelMapper mapper = new ModelMapper();
                return mapper.map(admin, AdminDTO.class);
            }
        }
        return new AdminDTO();
    }


}
