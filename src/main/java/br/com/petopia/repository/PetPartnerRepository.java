package br.com.petopia.repository;

import br.com.petopia.model.PetPartner;
import java.util.List;

public interface PetPartnerRepository {
    List<PetPartner> findAll();
    PetPartner findById(Long id);
    PetPartner save(PetPartner petPartner);
    void delete(Long id);
}
