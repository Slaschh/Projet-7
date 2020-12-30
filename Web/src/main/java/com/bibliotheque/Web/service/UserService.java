package com.bibliotheque.Web.service;

import com.bibliotheque.Web.Entity.Dto.UserDTO;
import com.bibliotheque.Web.utility.LoggingController;
import com.bibliotheque.Web.utility.OperateurDiamant;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class UserService {

    HttpClient httpClient = HttpClient.newBuilder().build();

   Logger logger = LoggerFactory.getLogger(LoggingController.class);

    String token;

    public void connexion(UserDTO userDTO) throws JsonProcessingException {
        logger.info("connexion de : " + userDTO.name );

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/user/login?username=" + userDTO.name + "&pwd=" + userDTO.password)).setHeader("Content-Type" , "application/json").POST(HttpRequest.BodyPublishers.ofString("")).build();
        HttpResponse response = null;
        //HttpResponse response = operateurDiamant.post("http://localhost:8080/user/login?username=" + userDTO.name + "&pwd=" + userDTO.password, "vide");

        UserDTO userDTO1 = (UserDTO) operateurDiamant.singleObject(response,UserDTO.class);
       token = userDTO1.getToken();
       logger.info(token);
    }

    public UserDTO idUser(int id) throws JsonProcessingException {

        HttpResponse response = operateurDiamant.RequestSecure("http://localhost:8080/user/" + id, token);
        UserDTO userDTO = (UserDTO) operateurDiamant.singleObject(response, UserDTO.class);

        return userDTO;
    }


}
