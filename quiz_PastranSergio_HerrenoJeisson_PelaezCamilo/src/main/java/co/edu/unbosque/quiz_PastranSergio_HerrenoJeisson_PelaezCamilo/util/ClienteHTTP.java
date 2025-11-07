package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.dto.LocalizacionDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ClienteHTTP {
	private static final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2)
			.connectTimeout(Duration.ofMinutes(5)).build();
	private static final Gson gson = new GsonBuilder().create();

	public static LocalizacionDTO doGetGeo(String url) {
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("Content-Type", "application/json")
				.GET().build();

		try {
			HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
			int statusCode = response.statusCode();
			String jsonResponse = response.body();

			LocalizacionDTO locDTO = gson.fromJson(jsonResponse, LocalizacionDTO.class);
			locDTO.setStatusCode(statusCode);
			return locDTO;
		} catch (IOException e) {
			System.err.println("Error al solicitar geolocalización: " + e.getMessage());
			LocalizacionDTO errorDTO = new LocalizacionDTO();
			errorDTO.setStatusCode(500);
			return errorDTO;
		} catch (InterruptedException e) {
			System.err.println("Error de interrupción en la comunicación: " + e.getMessage());
			Thread.currentThread().interrupt();
			LocalizacionDTO errorDTO = new LocalizacionDTO();
			errorDTO.setStatusCode(500);
			return errorDTO;
		} catch (Exception e) {
			System.err.println("Error inesperado al obtener geolocalización: " + e.getMessage());
			LocalizacionDTO errorDTO = new LocalizacionDTO();
			errorDTO.setStatusCode(500);
			return errorDTO;
		}
	}

}
