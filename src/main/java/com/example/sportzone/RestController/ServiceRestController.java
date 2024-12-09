package com.example.sportzone.RestController;

import com.example.sportzone.Services.ServiceService;
import com.example.sportzone.entity.ServiceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceRestController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/save")
    public ServiceEntity createService(@RequestBody ServiceEntity service) {
        return serviceService.createService(service);
    }

    @GetMapping("/all")
    public List<ServiceEntity> getAllServices() {
        return serviceService.getAllServices();
    }

    @GetMapping("/getOne/{id}")
    public ServiceEntity getServiceById(@PathVariable Long id) {
        return serviceService.getServiceById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public ServiceEntity updateService(@PathVariable Long id, @RequestBody ServiceEntity service) {
        ServiceEntity existingService = serviceService.getServiceById(id).orElse(null);

        if (existingService != null) {
            service.setId(id);
            return serviceService.updateService(service);
        } else {
            throw new RuntimeException("Service not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteService(@PathVariable Long id) {
        serviceService.deleteService(id);
    }
}
