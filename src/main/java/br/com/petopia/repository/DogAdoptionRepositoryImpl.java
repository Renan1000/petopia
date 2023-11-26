package br.com.petopia.repository;

import br.com.petopia.model.DogAdoption;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogAdoptionRepositoryImpl extends LocalStorageRepository implements DogAdoptionRepository {

    private static final String ENTITY_NAME = "dogAdoption";

    @Override
    public List<DogAdoption> findAll() {
        return findAll(ENTITY_NAME, DogAdoption.class);
    }

    @Override
    public DogAdoption findById(Long id) {
        return findById(ENTITY_NAME, DogAdoption.class, id);
    }

    @Override
    public DogAdoption save(DogAdoption dogAdoption) {
        return save(ENTITY_NAME, dogAdoption);
    }

    @Override
    public void delete(Long id) {
        delete(ENTITY_NAME, id);
    }
}
