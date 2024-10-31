package com.example.sportzone.Controller;

import com.example.sportzone.dto.RegistrationDTO;
import com.example.sportzone.entity.Utilisateur;
import com.example.sportzone.Services.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UtilisateurService utilisateurService;

    // 1. Display the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registrationDTO", new RegistrationDTO());
        return "register_form";  // return the registration form view
    }

    // 2. Save the user (Client or ProprietaireSalle)
    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registrationDTO") RegistrationDTO registrationDTO) {
        utilisateurService.registerUser(registrationDTO);
        return "redirect:/users";  // redirect to user list after registration
    }

    // 3. Get all registered users
    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<Utilisateur> users = utilisateurService.getAllUsers();
        model.addAttribute("users", users);
        return "user_list";  // return the user list view
    }

    // 4. Get user details by ID
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        Utilisateur user = utilisateurService.getUserById(id);
        model.addAttribute("user", user);
        return "user_detail";  // return the user detail view
    }

    // 5. Delete a user by ID
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id) {
        utilisateurService.deleteUser(id);
        return "redirect:/users";  // redirect to the user list after deletion
    }
}
