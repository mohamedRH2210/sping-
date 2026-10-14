package tn.esprit.nomprenomclasse.Domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idReservation;
    LocalDate dateDebut;
    LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    StatutReservation statut;

    @ManyToOne
    @ToString.Exclude
    Client client;

    @ManyToOne
    @ToString.Exclude
    Vehicule vehicule;

    @OneToOne(mappedBy = "reservation")
    @ToString.Exclude
    Contrat contrat;
}
