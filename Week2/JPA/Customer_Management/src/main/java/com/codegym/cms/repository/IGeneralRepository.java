package com.codegym.cms.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGeneralRepository<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t);

    void remove(Long id);
}