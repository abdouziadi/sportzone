package com.example.sportzone.RestController;

import com.example.sportzone.Services.AdminService;
import com.example.sportzone.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/save")
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    @GetMapping("/all")
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getOne/{id}")
    public Admin getAdminById(@PathVariable long id) {
        return adminService.getAdminById(id).orElse(null);
    }

    @PutMapping("/update/{id}")
    public Admin updateAdmin(@PathVariable long id, @RequestBody Admin admin) {
        Admin existingAdmin = adminService.getAdminById(id).orElse(null);

        if (existingAdmin != null) {
            admin.setId(id);
            return adminService.updateAdmin(admin);
        } else {
            throw new RuntimeException("Admin not found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAdmin(@PathVariable long id) {
        adminService.deleteAdmin(id);
    }
}
