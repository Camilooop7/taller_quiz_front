package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.model.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Long>{

	
	public List<Noticia>  findByCreador(String creador);
	
}
