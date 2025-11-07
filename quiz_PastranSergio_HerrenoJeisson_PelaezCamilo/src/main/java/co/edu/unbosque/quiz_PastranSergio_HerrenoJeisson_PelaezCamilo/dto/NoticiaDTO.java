package co.edu.unbosque.quiz_PastranSergio_HerrenoJeisson_PelaezCamilo.dto;

import java.util.Objects;

public class NoticiaDTO {

	private Long id;

	private String titulo;
	private String contenido;
	private String imagen;
	private String creador;
	private String localizacion;

	public NoticiaDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return titulo;
	}

	public void setNombre(String nombre) {
		this.titulo = nombre;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public NoticiaDTO(String titulo, String contenido, String imagen, String creador, String localizacion) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.imagen = imagen;
		this.creador = creador;
		this.localizacion = localizacion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contenido, creador, id, imagen, localizacion, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NoticiaDTO other = (NoticiaDTO) obj;
		return Objects.equals(contenido, other.contenido) && Objects.equals(creador, other.creador)
				&& Objects.equals(id, other.id) && Objects.equals(imagen, other.imagen)
				&& Objects.equals(localizacion, other.localizacion) && Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Noticia [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", imagen=" + imagen
				+ ", creador=" + creador + ", localizacion=" + localizacion + "]";
	}

}
