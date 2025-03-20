package com.hospital.santajoana.domain.service.impl;

import com.hospital.santajoana.domain.repository.BaseRepository;
import com.hospital.santajoana.domain.service.BaseService;

import java.util.List;

public abstract class BaseServiceImpl<T, ID> implements BaseService<T, ID> {
    
    protected final BaseRepository<T> repository;
    
    public BaseServiceImpl(BaseRepository<T> repository) {
        this.repository = repository;
    }
    
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
