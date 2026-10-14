package tn.esprit.nomprenomclasse.Domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Fetch;

import java.math.BigDecimal;
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
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idContrat;
    LocalDate dateSignature;
    BigDecimal montantTotal;
    boolean valide;

    @OneToOne
    @ToString.Exclude
    Reservation reservation;

    @OneToMany(mappedBy = "contrat")
    @ToString.Exclude
    List<Paiement> paiements;

}
