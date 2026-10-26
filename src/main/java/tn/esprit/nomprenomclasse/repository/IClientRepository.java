package tn.esprit.nomprenomclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse.Domain.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {
}
