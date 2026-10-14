package tn.esprit.nomprenomclasse.Domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehicule {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long idVehicule;
     String immatriculation;
     String marque;
     String modele;
     @Enumerated(value = EnumType.STRING)
     CategorieVehicule categorie;
     BigDecimal tarifJournalier;
    @Enumerated(value = EnumType.STRING)
     StatutVehicule statut;

    @ManyToOne
    @ToString.Exclude
    Agence agence;

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude
    List<Maintenance> maintenances;

    @ManyToMany
    @ToString.Exclude
    List<Equipement> equipements;

    @OneToMany(mappedBy = "vehicule")
    @ToString.Exclude
    List<Reservation> reservations;
}
