package com.example.sportzone.Services;

import com.example.sportzone.Repository.ProprietairesalleRepository;
import com.example.sportzone.entity.Proprietairesalle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProprietairesalleService {

    @Autowired
    private ProprietairesalleRepository proprietairesalleRepository;

    @Transactional
    public Proprietairesalle createProprietairesalle(Proprietairesalle proprietairesalle) {
        return proprietairesalleRepository.save(proprietairesalle);
    }

    public List<Proprietairesalle> getAllProprietairesalle() {
        return proprietairesalleRepository.findAll();
    }

    public Optional<Proprietairesalle> getProprietairesalleById(long id) {
        return proprietairesalleRepository.findById(id);
    }

    @Transactional
    public Proprietairesalle updateProprietairesalle(Proprietairesalle proprietairesalle) {
        return proprietairesalleRepository.save(proprietairesalle);
    }

    @Transactional
    public void deleteProprietairesalle(long id) {
        if (proprietairesalleRepository.existsById(id)) {
            proprietairesalleRepository.deleteById(id);
        } else {
            throw new RuntimeException("Proprietairesalle not found with id: " + id);
        }
    }
}
