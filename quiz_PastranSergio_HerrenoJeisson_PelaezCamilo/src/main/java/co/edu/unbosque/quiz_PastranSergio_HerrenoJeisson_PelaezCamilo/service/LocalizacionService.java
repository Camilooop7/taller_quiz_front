package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.service;

import org.springframework.stereotype.Service;

import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.dto.LocalizacionDTO;
import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.util.ClienteHTTP;

@Service
public class LocalizacionService {

	public LocalizacionService() {
		// TODO Auto-generated constructor stub
	}

	public LocalizacionDTO obtenerLocalizacion() {
		return ClienteHTTP.doGetGeo("https://api.vatcomply.com/geolocate");

	}

}
