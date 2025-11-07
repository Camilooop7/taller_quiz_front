package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.dto.NoticiaDTO;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.service.NoticiaService;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.util.ClienteHTTP;

@RestController
@CrossOrigin(origins = { "*" })
@RequestMapping(path = { "/noticia" })
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;

	@PostMapping(path = "/crear")
	public ResponseEntity<String> crear(@RequestBody NoticiaDTO nuevaNoticia) {
		if (nuevaNoticia.getTitulo() == null || nuevaNoticia.getContenido() == null || nuevaNoticia.getImagen() == null
				|| nuevaNoticia.getCreador() == null) {
			return new ResponseEntity<>("Todos los campos son obligatorios", HttpStatus.BAD_REQUEST);
		}

		String geoData = ClienteHTTP.doGetGeo("https://api.vatcomply.com/geolocate").toString();
		nuevaNoticia.setLocalizacion(geoData);

		int status = noticiaService.create(nuevaNoticia);
		if (status == 0) {
			return new ResponseEntity<>("Noticia creada con éxito", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al crear la noticia", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping(path = "/getall")
	public ResponseEntity<List<NoticiaDTO>> getAll() {
		List<NoticiaDTO> noticias = noticiaService.getAll();
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}

	@GetMapping(path = "/findByCreador")
	public ResponseEntity<List<NoticiaDTO>> findByCreador(String creador) {
		List<NoticiaDTO> noticias = noticiaService.findByCreador(creador);
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}

	@DeleteMapping(path = "/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		int status = noticiaService.deleteById(id);
		if (status == 0) {
			return new ResponseEntity<>("Noticia eliminada con éxito", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Error al eliminar la noticia", HttpStatus.NOT_FOUND);
		}
	}
}
