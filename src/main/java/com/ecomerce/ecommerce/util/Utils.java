package com.ecomerce.ecommerce.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;

abstract public class Utils {

    public static String encodePassword(String password) {
        return new Base64().encodeToString(password.getBytes());
    }

    public static <C> C getModelMapperInstance(Object from, Class<C> to) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(from, to);
    }

}
