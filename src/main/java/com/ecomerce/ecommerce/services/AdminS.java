package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Admin.Admin;
import com.ecomerce.ecommerce.model.Admin.AdminDTO;
import com.ecomerce.ecommerce.model.Admin.AdminRep;
import com.ecomerce.ecommerce.util.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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


        Admin admin = Utils.getModelMapperInstance(adminDTO, Admin.class);
        String username = admin.getUsername();

        Admin getAdmin = adminRep.findByUsername(username);

        if (getAdmin == null) {
            String password = admin.getPassword();
            admin.setPassword(Utils.encodePassword(password));
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
            String coded = Utils.encodePassword(currentPassword);
            if (coded.equals(admin.getPassword())) {

                return Utils.getModelMapperInstance(admin, AdminDTO.class);
            }
        }
        return new AdminDTO();
    }


}
