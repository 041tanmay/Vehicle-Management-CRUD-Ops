package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository repository;

    public Vehicle addVehicle(Vehicle vehicle) {
        return repository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return repository.findAll();
    }

    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        Vehicle v = repository.findById(id).orElseThrow();
        v.setBrand(vehicle.getBrand());
        v.setModel(vehicle.getModel());
        v.setNumber(vehicle.getNumber());
        v.setPrice(vehicle.getPrice());
        return repository.save(v);
    }

    public void deleteVehicle(Long id) {
        repository.deleteById(id);
    }
}