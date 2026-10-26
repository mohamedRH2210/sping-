package tn.esprit.nomprenomclasse.demo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import tn.esprit.nomprenomclasse.Domain.Contrat;
import tn.esprit.nomprenomclasse.repository.IContratRepository;

@Component
@ConditionalOnProperty(name = "app.crud-demo.enabled", havingValue = "true")
public class CrudDemoRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(CrudDemoRunner.class);

    private final IContratRepository contratRepository;

    public CrudDemoRunner(IContratRepository contratRepository) {
        this.contratRepository = contratRepository;
    }

    @Override
    public void run(String... args) {
        Contrat contrat = Contrat.builder()
                .dateSignature(LocalDate.now(ZoneId.of("Africa/Tunis")))
                .montantTotal(BigDecimal.valueOf(500))
                .valide(false)
                .build();

        Contrat savedContrat = contratRepository.save(contrat);
        LOGGER.info("save - contrat cree avec l'identifiant {}", savedContrat.getIdContrat());

        contratRepository.findById(savedContrat.getIdContrat())
                .ifPresentOrElse(
                        foundContrat -> LOGGER.info("findById - contrat trouve : {}", foundContrat.getIdContrat()),
                        () -> LOGGER.warn("findById - contrat introuvable : {}", savedContrat.getIdContrat()));

        savedContrat.setValide(true);
        Contrat updatedContrat = contratRepository.save(savedContrat);
        LOGGER.info("save - contrat mis a jour : valide={}", updatedContrat.isValide());

        contratRepository.deleteById(updatedContrat.getIdContrat());
        LOGGER.info("deleteById - contrat supprime : {}", updatedContrat.getIdContrat());
    }
}
