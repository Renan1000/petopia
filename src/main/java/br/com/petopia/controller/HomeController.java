//package br.com.petopia.controller;
//
//import br.com.petopia.model.DogAdoption;
//import br.com.petopia.service.DogAdoptionService;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.http.HttpResponse;
//import java.util.List;
//
//
//@RestController
//public class HomeController {
//
//    public DogAdoptionService service;
//
//    @GetMapping("/test")
//    public String home() {
//        return "home"; // Isso corresponderá a um arquivo chamado home.html
//    }
//
//    @PostMapping
//    public String cadastro(@RequestBody DogAdoption dogAdoption){
//        service.cadastro(dogAdoption);
//        return HttpStatus.CREATED.toString();
//    }
//
//    @GetMapping("/ongs")
//    public List<DogAdoption> listar(){
//        return service.listar();
//    }
//}
