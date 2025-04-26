package com.blood_donation_backend.Controller;

import com.blood_donation_backend.Entity.Appointment;
import com.blood_donation_backend.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Appointment create(@RequestBody Appointment appointment) {
        return service.save(appointment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}
