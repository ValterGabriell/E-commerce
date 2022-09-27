package com.ecomerce.ecommerce.util;

import org.apache.tomcat.util.codec.binary.Base64;

abstract public class Utils {

     public static String encodePassword(String password) {
        return new Base64().encodeToString(password.getBytes());
    }

}
