package com.blood_donation_backend.Service;

import com.blood_donation_backend.Entity.BloodInventory;
import com.blood_donation_backend.Repository.BloodInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloodInventoryService {

    @Autowired
    private BloodInventoryRepository repository;

    public List<BloodInventory> getAll() {
        return repository.findAll();
    }

    public BloodInventory save(BloodInventory inventory) {
        return repository.save(inventory);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
