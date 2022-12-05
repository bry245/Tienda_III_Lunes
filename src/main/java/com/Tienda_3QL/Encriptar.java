package com.Tienda_3QL;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encriptar {
    
    public static void main(String[] args){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        var claveAdmin = encoder.encode("123");
        var claveVendedor = encoder.encode("456");
        var claveUser = encoder.encode("789");
        
        System.out.println("Admin (123): "+claveAdmin);
        System.out.println("Vendedor (456): "+claveVendedor);
        System.out.println("User (789): "+claveUser);
        
        
    }
    
}