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
                repository.save(new Vehicule(null, "123-TN-456", "Peugeot", "208", CategorieVehicule.CITADINE, new BigDecimal("90.00"), StatutVehicule.DISPONIBLE));
                repository.save(new Vehicule(null, "789-TN-101", "Volkswagen", "Passat", CategorieVehicule.BERLINE, new BigDecimal("180.00"), StatutVehicule.LOUE));
                repository.save(new Vehicule(null, "112-TN-314", "Toyota", "RAV4", CategorieVehicule.SUV, new BigDecimal("220.00"), StatutVehicule.MAINTENANCE));
            }
        };
    }
}
