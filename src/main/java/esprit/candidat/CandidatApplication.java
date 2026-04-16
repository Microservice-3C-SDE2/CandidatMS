package esprit.candidat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class CandidatApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandidatApplication.class, args);
	}
	@Autowired
	public CandidatRepository repository;
	@Bean
	ApplicationRunner init() { return
			(args) -> {
				// Vérifier si le repository est vide
				if (repository.count() == 0) {
					repository.save(new Candidat("Mariem", "Ch", "ma@esprit.tn"));
					repository.save(new Candidat("Sarra", "ab", "sa@esprit.tn"));
					repository.save(new Candidat("Mohamed", "ba", "mo@esprit.tn"));
					repository.save(new Candidat("Maroua", "dh", "maroua@esprit.tn"));
				}

				repository.findAll().forEach(System.out::println);
			};
	}
}
