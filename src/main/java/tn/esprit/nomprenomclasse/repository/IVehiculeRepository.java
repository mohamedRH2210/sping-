package tn.esprit.nomprenomclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse.Domain.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> {
}
