package com.example.exam.service;

import com.example.exam.dto.PetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public interface PetService {
/*    @Autowired
    private RestTemplate restTemplate; */

/*    public PetDto getPet(String petId){
        PetDto response = restTemplate.getForObject("https://petstore.swagger.io/#/",PetDto.class);
        return response;
    }*/
    PetDto buscarPet(String id);
    PetDto  agregarPet(PetDto pDto);
}
