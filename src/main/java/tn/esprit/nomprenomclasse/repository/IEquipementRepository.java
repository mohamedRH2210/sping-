package tn.esprit.nomprenomclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse.Domain.Equipement;

public interface IEquipementRepository extends JpaRepository<Equipement, Long> {
}
