/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nisira.clientservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jpretel
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws SignServiceException_Exception 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, SignServiceException_Exception {
        SignService ss = new SignService();
        SignServicePortType sp = ss.getSignServiceHttpSoap11Endpoint();

        File archivo = new File("xml.XML");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);

        String linea, xml = "";
        while ((linea = br.readLine()) != null) {
            xml = xml.concat(xml.isEmpty() ? "" : "\n").concat(linea);
        }
        System.out.println(xml);
        System.out.println(sp.sign("asdasd", xml, 1,"","asdasd", "", ""));
                
    }

}
