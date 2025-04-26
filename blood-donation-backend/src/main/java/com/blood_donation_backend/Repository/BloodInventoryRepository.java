package com.blood_donation_backend.Repository;

import com.blood_donation_backend.Entity.BloodInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodInventoryRepository extends JpaRepository<BloodInventory, Long> {
}
