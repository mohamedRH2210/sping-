package tn.esprit.nomprenomclasse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.nomprenomclasse.Domain.Reservation;

public interface IReservationRepository extends JpaRepository<Reservation, Long> {
}
