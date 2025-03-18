/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalhopoo2_alunos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author User
 */
public class Ajuda {
    
//    public static endereco ConsultarCEP(String cep) throws MalformedURLException, IOException{
//        endereco ender = null;
//        
//        URL link = new URL ("https://viacep.com.br/ws/" + cep + "/json/");
//        
//        HttpURLConnection connection = (HttpURLConnection) link.openConnection();
//        connection.setRequestMethod("GET");
//        
//        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//        StringBuilder response =  new StringBuilder();
//        
//        String line;
//        while((line = reader.readLine()) != null){
//            response.append(line);
//        }
//        
//        JSONObject jsonObject = new JSONObject(response.toString());
//        
//        if(!jsonObject.has("erro")){
//            
//            ender = new endereco();
//            ender.setLogradouro(jsonObject.getString("logradouro"));
//            ender.setbairro(jsonObject.getString("bairro"));
//            ender.setcidade(jsonObject.getString("localidade"));
//            ender.setuf(jsonObject.getString("uf"));
//            
//        }else{
//            System.out.println("CEP não encontrado");
//        }
//        
//        connection.disconnect();
//        return ender;
//    }
    
    
    public static boolean isCPF(String parcpf){
        String cpf;
        cpf = parcpf.replace(".", "");
        cpf = parcpf.replace(".", "");
        cpf = parcpf.replace("-","");
        
        if(cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || (cpf.length()!=11)){
            return false;
        }
                
        char dig10, dig11;
        int sm, i, r, num, peso;
        
        sm = 0;
        peso = 0;
        for(i = 0; i <9; i++){
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        
        r = 11 - (sm % 11);
        if((r == 10) || (r == 11)){
           dig10 = '0'; 
        }else{
            dig10 = (char) (r+48);
        }
        
        sm = 0;
        peso = 11;
        
        for(i = 0; i<10;i++){
            num = (int) (cpf.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
        }
        
        r = 11 - (sm % 11);
        if((r == 10) || (r == 11)){
           dig11 = '0'; 
        }else{
            dig11 = (char) (r+48);
        }
        
        if((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10))){
            return true;
        }else{
            return false;
        }
    }
}
