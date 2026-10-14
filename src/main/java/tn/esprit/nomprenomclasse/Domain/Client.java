package tn.esprit.nomprenomclasse.Domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idClient;
    String nom;
    String prenom;
    String email;
    String telephone;
    String numPermis;
    LocalDate dateInscription;

    @OneToMany(mappedBy = "client")
    @ToString.Exclude
    List<Reservation> reservations;
}
