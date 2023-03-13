package co.edu.unbosque.model;

public class EncartaDTO {

	private String texto;
	private int hojas;
	private String autor;  
	private String tema; 
	
	
	public EncartaDTO(String texto, int hojas, String autor, String tema) {
		super();
		this.texto = texto;
		this.hojas = hojas;
		this.autor = autor;
		this.tema = tema;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getHojas() {
		return hojas;
	}

	public void setHojas(int hojas) {
		this.hojas = hojas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	@Override
	public String toString() {
		return "EncartaDTO [texto=" + texto + ", hojas=" + hojas + ", autor=" + autor + ", tema=" + tema + "]";
	}
	
}
