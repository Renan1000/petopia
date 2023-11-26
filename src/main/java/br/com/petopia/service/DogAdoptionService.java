package br.com.petopia.service;

import br.com.petopia.model.DogAdoption;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogAdoptionService {

    public void cadastro(DogAdoption dogAdoption){
        //regra de cadastro
    }

    public List<DogAdoption> listar(){
        //regra para listar as ongs

        return new ArrayList<>();
    }

}
