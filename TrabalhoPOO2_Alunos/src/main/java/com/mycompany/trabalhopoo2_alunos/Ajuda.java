///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.trabalhopoo2_alunos;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//
///**
// *
// * @author User
// */
//public class Ajuda {
//    
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
//    
//}
