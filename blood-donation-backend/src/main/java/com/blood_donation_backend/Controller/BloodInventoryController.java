package com.blood_donation_backend.Controller;

import com.blood_donation_backend.Entity.BloodInventory;
import com.blood_donation_backend.Service.BloodInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bloodinventory")
public class BloodInventoryController {

    @Autowired
    private BloodInventoryService service;

    @GetMapping
    public List<BloodInventory> getAll() {
        return service.getAll();
    }

    @PostMapping
    public BloodInventory create(@RequestBody BloodInventory inventory) {
        return service.save(inventory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
