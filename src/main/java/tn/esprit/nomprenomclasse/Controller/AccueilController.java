package tn.esprit.nomprenomclasse.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccueilController {

    @GetMapping("/")
    public String accueil() {
        return "Application Smart Examination Distribution Centre opérationnelle.";
    }
}
