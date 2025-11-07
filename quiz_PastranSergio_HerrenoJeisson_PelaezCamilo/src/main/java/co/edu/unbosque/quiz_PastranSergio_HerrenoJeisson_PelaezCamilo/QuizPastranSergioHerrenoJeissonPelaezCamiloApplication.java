package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuizPastranSergioHerrenoJeissonPelaezCamiloApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizPastranSergioHerrenoJeissonPelaezCamiloApplication.class, args);
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
