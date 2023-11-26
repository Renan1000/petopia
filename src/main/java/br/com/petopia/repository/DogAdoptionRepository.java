package br.com.petopia.repository;

import br.com.petopia.model.DogAdoption;
import java.util.List;

public interface DogAdoptionRepository {
    List<DogAdoption> findAll();
    DogAdoption findById(Long id);
    DogAdoption save(DogAdoption dogAdoption);
    void delete(Long id);
}
