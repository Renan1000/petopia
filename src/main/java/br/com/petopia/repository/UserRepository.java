package br.com.petopia.repository;

import br.com.petopia.model.User;
import java.util.List;

public interface UserRepository {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void delete(Long id);
}
