package tn.esprit.nomprenomclasse.Domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAgence;
    String nom;
    String ville;
    String adresse;
    String telephone;

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    List<Employe> employes;

    @OneToMany(mappedBy = "agence")
    @ToString.Exclude
    List<Vehicule> vehicules;
}
