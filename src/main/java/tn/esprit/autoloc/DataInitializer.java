package tn.esprit.autoloc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tn.esprit.autoloc.domain.CategorieVehicule;
import tn.esprit.autoloc.domain.StatutVehicule;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(VehiculeRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Vehicule v1 = new Vehicule();
                v1.setImmatriculation("123-TN-456");
                v1.setMarque("Peugeot");
                v1.setModele("208");
                v1.setCategorie(CategorieVehicule.CITADINE);
                v1.setTarifJournalier(new BigDecimal("90.00"));
                v1.setStatut(StatutVehicule.DISPONIBLE);
                repository.save(v1);

                Vehicule v2 = new Vehicule();
                v2.setImmatriculation("789-TN-101");
                v2.setMarque("Volkswagen");
                v2.setModele("Passat");
                v2.setCategorie(CategorieVehicule.BERLINE);
                v2.setTarifJournalier(new BigDecimal("180.00"));
                v2.setStatut(StatutVehicule.LOUE);
                repository.save(v2);

                Vehicule v3 = new Vehicule();
                v3.setImmatriculation("112-TN-314");
                v3.setMarque("Toyota");
                v3.setModele("RAV4");
                v3.setCategorie(CategorieVehicule.SUV);
                v3.setTarifJournalier(new BigDecimal("220.00"));
                v3.setStatut(StatutVehicule.MAINTENANCE);
                repository.save(v3);
            }
        };
    }
}
