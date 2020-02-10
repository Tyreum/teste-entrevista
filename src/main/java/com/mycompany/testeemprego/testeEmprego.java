/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testeemprego;

import java.io.IOException;

/**
 * 35 44
 * @author Biel
 */
public class testeEmprego {
    public static void main(String[] args) throws IOException{
        testeEmprego teste = new testeEmprego();
        testeID ID = new testeID();
        testeCapture CP = new testeCapture();
        testeRefund RF = new testeRefund();
        String aux;
        
        System.out.println("====================================================");
        aux = ID.request();
        CP.request(aux);
        System.out.println(RF.request(aux));
        System.out.println("====================================================");
        
        
    }
    }

