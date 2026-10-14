package tn.esprit.nomprenomclasse.Domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPaiement;
    BigDecimal montant;
    LocalDate datePaiement;

    @Enumerated(EnumType.STRING)
    ModePaiement modePaiement;

    @ManyToOne
    @ToString.Exclude
    Contrat contrat;

}
