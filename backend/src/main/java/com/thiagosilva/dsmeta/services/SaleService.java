package com.thiagosilva.dsmeta.services;

import com.thiagosilva.dsmeta.entities.Sale;
import com.thiagosilva.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public List<Sale> findSales(){
        return repository.findAll();
    }
}
