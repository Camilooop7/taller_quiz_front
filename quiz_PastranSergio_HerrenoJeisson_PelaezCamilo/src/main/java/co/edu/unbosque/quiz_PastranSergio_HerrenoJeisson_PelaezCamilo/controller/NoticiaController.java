package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.dto.NoticiaDTO;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.service.NoticiaService;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.util.ClienteHTTP;

import java.util.List;

@RestController
@RequestMapping(path = { "/noticia" })
@CrossOrigin(origins = { "*" })
@Tag(name = "Gestión de Noticias", description = "Endpoints para administrar noticias")
@SecurityRequirement(name = "bearerAuth")
public class NoticiaController {

	@Autowired
	private NoticiaService noticiaService;

	@Operation(summary = "Crear una nueva noticia", description = "Crea una nueva noticia en el sistema.")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Noticia creada con éxito"),
			@ApiResponse(responseCode = "400", description = "Todos los campos son obligatorios"),
			@ApiResponse(responseCode = "406", description = "Error al crear la noticia") })
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

	@Operation(summary = "Obtener todas las noticias", description = "Obtiene una lista de todas las noticias.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Lista de noticias recuperada correctamente") })
	@GetMapping(path = "/getall")
	public ResponseEntity<List<NoticiaDTO>> getAll() {
		List<NoticiaDTO> noticias = noticiaService.getAll();
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}

	@Operation(summary = "Obtener noticias por creador", description = "Obtiene noticias filtradas por el nombre del creador.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Noticias recuperadas correctamente") })
	@GetMapping(path = "/findByCreador")
	public ResponseEntity<List<NoticiaDTO>> findByCreador(@RequestParam String creador) {
		List<NoticiaDTO> noticias = noticiaService.findByCreador(creador);
		return new ResponseEntity<>(noticias, HttpStatus.OK);
	}

	@Operation(summary = "Eliminar una noticia por ID", description = "Elimina una noticia específica por su ID.")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Noticia eliminada con éxito"),
			@ApiResponse(responseCode = "404", description = "Error al eliminar la noticia") })
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
