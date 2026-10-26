package tn.esprit.nomprenomclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse.Domain.Agence;

public interface IAgenceRepository extends JpaRepository<Agence, Long> {
}
