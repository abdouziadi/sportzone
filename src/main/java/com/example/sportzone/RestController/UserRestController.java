package com.example.sportzone.RestController;

import com.example.sportzone.Services.UtilisateurService;
import com.example.sportzone.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserRestController {
    @Autowired
    private UtilisateurService utilisateurService;

  /*  @PostMapping("/save")
    public Utilisateur createUser(@RequestBody Utilisateur utilisateur) {
        utilisateurService.registerUser(utilisateur);

    }
*/
}
