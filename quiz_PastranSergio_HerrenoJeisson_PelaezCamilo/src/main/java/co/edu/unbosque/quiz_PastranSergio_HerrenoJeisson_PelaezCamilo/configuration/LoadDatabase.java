package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.configuration;

import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.model.User;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.repository.UserRepository;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Clase de configuración para cargar datos iniciales en la base de datos. Crea usuarios
 * predeterminados (administrador y usuario normal) al iniciar la aplicación si estos no existen
 * previamente.
 */
@Configuration
public class LoadDatabase {
  /** Logger para registrar mensajes durante la carga de datos. */
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  /**
   * Inicializa la base de datos con usuarios predeterminados. Crea un usuario administrador y un
   * usuario normal si no existen.
   *
   * @param userRepo Repositorio de usuarios para acceder a la base de datos
   * @param passwordEncoder Codificador de contraseñas para encriptar las contraseñas de los
   *     usuarios
   * @return Un CommandLineRunner que se ejecuta al iniciar la aplicación
   */
  @Bean
  CommandLineRunner initDatabase(UserRepository userRepo, PasswordEncoder passwordEncoder) {

    return args -> {
      Optional<User> found = userRepo.findByUsername("admin");
      if (found.isPresent()) {
        log.info("El administrador ya existe, omitiendo la creación del administrador...");
      } else {
        User adminUser = new User("admin", passwordEncoder.encode("1234567890"), User.Role.ADMIN);
        userRepo.save(adminUser);
        log.info("Precargando usuario administrador");
      }
      Optional<User> found2 = userRepo.findByUsername("editor");
      if (found2.isPresent()) {
        log.info("El usuario editor ya existe, omitiendo la creación del usuario normal...");
      } else {
        User normalUser =
            new User("editor", passwordEncoder.encode("1234567890"), User.Role.EDITOR);
        userRepo.save(normalUser);
        log.info("Precargando usuario normal");
      } 
      Optional<User> found3 = userRepo.findByUsername("visitante");
      if (found3.isPresent()) {
    	  log.info("El usuario visitante ya existe, omitiendo la creación del usuario editor...");
      } else {
    	  User editorUser =
    			  new User("visitante", passwordEncoder.encode("1234567890"), User.Role.VISITANTE);
    	  userRepo.save(editorUser);
    	  log.info("Precargando usuario normal");
      } 
     
      
    };
  }
}
