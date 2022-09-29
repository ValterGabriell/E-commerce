package com.ecomerce.ecommerce.services;

import com.ecomerce.ecommerce.model.Admin.Admin;
import com.ecomerce.ecommerce.model.Admin.AdminDTO;
import com.ecomerce.ecommerce.model.Admin.AdminRep;
import com.ecomerce.ecommerce.model.Sellers.Seller;
import com.ecomerce.ecommerce.model.Sellers.SellerDTO;
import com.ecomerce.ecommerce.model.Sellers.SellerRep;
import com.ecomerce.ecommerce.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AdminS {
    @Autowired
    AdminRep adminRep;
    @Autowired
    SellerRep sellerRep;

    /**
     * Método responsavel por validar se um usuário existe ou não no sistema, para só entao criar ele
     *
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
     *
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
        return null;
    }

    public List<SellerDTO> getAllSellers() {
        List<Seller> sellerList = sellerRep.findAll();
        return sellerList.stream().map(element -> Utils.getModelMapperInstance(element, SellerDTO.class)).collect(Collectors.toList());
    }

    public SellerDTO getSellerById(Integer seller_id) {
        Optional<Seller> seller = sellerRep.findById(seller_id);
        return seller.map(value -> Utils.getModelMapperInstance(value, SellerDTO.class)).orElse(null);
    }


}
