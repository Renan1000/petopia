package br.com.petopia.repository;

import br.com.petopia.model.PetPartner;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class PetPartnerRepositoryImpl extends LocalStorageRepository implements PetPartnerRepository {

    private static final String ENTITY_NAME = "petPartner";

    @Override
    public List<PetPartner> findAll() {
        return findAll(ENTITY_NAME, PetPartner.class);
    }

    @Override
    public PetPartner findById(Long id) {
        return findById(ENTITY_NAME, PetPartner.class, id);
    }

    @Override
    public PetPartner save(PetPartner petPartner) {
        List<PetPartner> entities = findAll(ENTITY_NAME, PetPartner.class);

        

        return petPartner;
    }

    @Override
    public void delete(Long id) {
        
    }


}
