package com.example.exam.controller;

import com.example.exam.dto.PetDto;
import com.example.exam.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PetController {

    @Autowired
    private PetService pSrvc;
    @GetMapping("/pet")
    public String getPetLst(){
        return "Pet listing";
    }
    @GetMapping("/pet/{petId}")
    public String getPet(@PathVariable  String petId){
        PetDto pDto;
        pDto=pSrvc.buscarPet(petId);
        return pDto.toString();
    }
    @PostMapping("/pet")

    public String postPet(@RequestParam String id, @RequestParam String status, @RequestParam String name ){
        PetDto pDto = new PetDto();
        pDto.setId(id);
        pDto.setName(name);
        pDto.setStatus(status);
        pDto=pSrvc.agregarPet(pDto);
        return pDto.toString();
    }

    @PostMapping("/tst")
    public String pstTst(){
        return "probamos servicio tst";
    }
}
