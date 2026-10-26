package tn.esprit.nomprenomclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse.Domain.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> {
}
