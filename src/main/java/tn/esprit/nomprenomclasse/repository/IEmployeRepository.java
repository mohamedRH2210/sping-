package tn.esprit.nomprenomclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse.Domain.Employe;

public interface IEmployeRepository extends JpaRepository<Employe, Long> {
}
