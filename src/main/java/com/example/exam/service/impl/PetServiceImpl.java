package com.example.exam.service.impl;

import com.example.exam.dto.PetDto;
import com.example.exam.service.PetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@SuppressWarnings("unchecked")
@Service("petService")
public class PetServiceImpl implements PetService {
    public static final Logger logger = LoggerFactory.getLogger(PetServiceImpl.class);

    @Autowired
    private RestTemplate rTmplt;
    @Override
    public PetDto buscarPet(String id) {
        logger.info("inicia busqueda de pet");
        Map<String, String> params = new HashMap<>();
        params.put("petId",id);
        PetDto response = rTmplt.getForObject("https://petstore.swagger.io/v2/pet/{petId}",PetDto.class,params);
        logger.info(" Pet"+response);
        return response;
    }

    @Override
    public PetDto agregarPet(PetDto pDto) {
        String url = "https://petstore.swagger.io/v2/pet";
        String body = "{\"id\":"+pDto.getId()+",\"status\":\""+pDto.getStatus()+"\",\"name\":\""+pDto.getName()+"\"}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<String>(body,headers);
        ResponseEntity<String> response = rTmplt.exchange(url,HttpMethod.POST,request, String.class);
        logger.info("Response body : ",response.getBody());
        logger.info("Status code :",response.getStatusCode().value());
        pDto.setDateCreated(new Date());
        pDto.setTransactionId("60cc5c22-3250-4e07-a519-a6dab99c6713");
        return pDto;
    }
}
