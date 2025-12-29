package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin("*")
public class VehicleController {

    @Autowired
    private VehicleService service;

    @PostMapping
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return service.getAllVehicles();
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id,
                                 @RequestBody Vehicle vehicle) {
        return service.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        service.deleteVehicle(id);
    }
}