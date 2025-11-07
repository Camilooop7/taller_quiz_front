package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.dto.NoticiaDTO;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.model.Noticia;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.repository.NoticiaRepository;

@Service
public class NoticiaService implements CRUDOperation<NoticiaDTO> {

	@Autowired
	private NoticiaRepository noticiaRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<NoticiaDTO> getAll() {
		List<Noticia> entityList = noticiaRepository.findAll();
		List<NoticiaDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity) -> {
			NoticiaDTO dto = modelMapper.map(entity, NoticiaDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}
	
	public NoticiaDTO random() {
		List<Noticia> entityList = noticiaRepository.findAll();

		if (entityList.isEmpty()) {
			return null;
		}
		int randomIndex = (int) (Math.random() * entityList.size());
		Noticia randomNoticia = entityList.get(randomIndex);
		NoticiaDTO noticiaDTO = modelMapper.map(randomNoticia, NoticiaDTO.class);
		return noticiaDTO;
	}

	@Override
	public int deleteById(Long id) {
		Optional<Noticia> found = noticiaRepository.findById(id);
		if (found.isPresent()) {
			noticiaRepository.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}

	public List<NoticiaDTO> findByCreador(String nombre) {
		List<Noticia> entityList = noticiaRepository.findByCreador(nombre);
		List<NoticiaDTO> dtoList = new ArrayList<>();
		entityList.forEach((entity) -> {
			NoticiaDTO dto = modelMapper.map(entity, NoticiaDTO.class);
			dtoList.add(dto);
		});
		return dtoList;
	}

	@Override
	public int updateById(Long id, NoticiaDTO newData) {
		Optional<Noticia> found = noticiaRepository.findById(id);
		if (found.isPresent()) {
			Noticia noticia = found.get();
			noticia.setTitulo(newData.getTitulo());
			noticia.setContenido(newData.getContenido());
			noticia.setImagen(newData.getImagen());
			noticia.setCreador(newData.getCreador());
			noticia.setLocalizacion(newData.getLocalizacion());
			noticiaRepository.save(noticia);
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public long count() {
		return noticiaRepository.count();
	}

	@Override
	public boolean exist(Long id) {
		return noticiaRepository.existsById(id);
	}

	@Override
	public int create(NoticiaDTO data) {
		try {
			Noticia noticia = modelMapper.map(data, Noticia.class);
			noticiaRepository.save(noticia);
			return 0; // Éxito
		} catch (Exception e) {
			return 1; // Error
		}
	}
}
