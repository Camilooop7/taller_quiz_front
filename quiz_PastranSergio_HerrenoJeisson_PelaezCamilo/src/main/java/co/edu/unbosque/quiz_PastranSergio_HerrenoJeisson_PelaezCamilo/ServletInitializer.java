package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(QuizPastranSergioHerrenoJeissonPelaezCamiloApplication.class);
	}

}
