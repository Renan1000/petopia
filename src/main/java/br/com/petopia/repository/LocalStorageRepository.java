package br.com.petopia.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LocalStorageRepository {

    private static final String LOCAL_STORAGE_KEY_PREFIX = "petopia_";
    private ObjectMapper objectMapper = new ObjectMapper();

    protected <T> List<T> findAll(String entityName, Class<T> entityType) {
        String localStorageKey = LOCAL_STORAGE_KEY_PREFIX + entityName;
        String entitiesJson = getFromLocalStorage(localStorageKey);
        try {
            if (entitiesJson != null) {
                return objectMapper.readValue(entitiesJson, new TypeReference<List<T>>() {});
            } else {
                return new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    protected <T> T findById(String entityName, Class<T> entityType, Long id) {
        List<T> entities = findAll(entityName, entityType);
        if (entities != null) {
            return entities.stream()
                    .filter(entity -> id.equals(getEntityId(entity)))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    protected <T> T save(String entityName, T entity) {
        List<T> entities = findAll(entityName, (Class<T>) entity.getClass());

        if (entities == null) {
            entities = new ArrayList<>();
        }

        entities.add(entity);

        String localStorageKey = LOCAL_STORAGE_KEY_PREFIX + entityName;
        saveEntitiesToLocalStorage(localStorageKey, entities);

        return entity;
    }

    protected <T> void delete(String entityName, Long id) {
        List<T> entities = findAll(entityName, null);
        if (entities != null) {
            entities.removeIf(entity -> id.equals(getEntityId(entity)));
            String localStorageKey = LOCAL_STORAGE_KEY_PREFIX + entityName;
            saveEntitiesToLocalStorage(localStorageKey, entities);
        }
    }

    private String getFromLocalStorage(String key) {
        // Lógica para recuperar dados do localStorage (implemente conforme necessário)
        return null;
    }

    private <T> void saveEntitiesToLocalStorage(String key, List<T> entities) {
        try {
            String entitiesJson = objectMapper.writeValueAsString(entities);
            // Lógica para salvar dados no localStorage (implemente conforme necessário)
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    private <T> Long getEntityId(T entity) {
        // Método para obter o ID da entidade (implemente conforme necessário)
        return null;
    }
}
