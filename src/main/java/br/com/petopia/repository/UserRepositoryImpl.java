package br.com.petopia.repository;

import br.com.petopia.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends LocalStorageRepository implements UserRepository {

    private static final String ENTITY_NAME = "user";

    @Override
    public List<User> findAll() {
        return findAll(ENTITY_NAME, User.class);
    }

    @Override
    public User findById(Long id) {
        return findById(ENTITY_NAME, User.class, id);
    }

    @Override
    public User save(User user) {
        return save(ENTITY_NAME, user);
    }

    @Override
    public void delete(Long id) {
        delete(ENTITY_NAME, id);
    }
}
