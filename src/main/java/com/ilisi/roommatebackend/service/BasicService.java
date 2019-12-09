package com.ilisi.roommatebackend.service;

import com.ilisi.roommatebackend.core.exception.BusinessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public abstract class BasicService<T, ID> {

    public abstract JpaRepository<T, ID> getRepository();

    @Transactional
    public T create(T entity) {
        if (entity == null) {
            //exception
        }

        return getRepository().save(entity);
    }

    @Transactional
    public List<T> retrieve() { return getRepository().findAll();    }

    @Transactional
    public void deleteById(ID id) {   getRepository().deleteById(id);   }

    @Transactional
    public void delete(T entity) {   getRepository().delete(entity);   }

    @Transactional
    public T update(T entity) {   return getRepository().save(entity);   }

    @Transactional
    public T findById(ID id) throws BusinessException {   return getRepository().findById(id).orElseThrow(() -> new BusinessException("entity not found"));   }

}
