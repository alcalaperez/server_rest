package business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "diaentreno")
public class DiaEntreno implements Serializable {	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int calorias;
	private int ordenSemanal;
	private int id;
	private String nombreRutina;
	private List<Serie> series;

	
	public DiaEntreno() {

	}

	public DiaEntreno(int id, String nombreRutina, int calorias, int ordenSemanal) {
		super();
		this.calorias = calorias;
		this.ordenSemanal = ordenSemanal;
		this.id = id;
		this.nombreRutina = nombreRutina;
		series = new ArrayList<>();

	}

	@XmlElement
	public int getCalorias() {
		return calorias;
	}

	public void setCalorias(int calorias) {
		this.calorias = calorias;
	}

	@XmlElement
	public int getOrdenSemanal() {
		return ordenSemanal;
	}

	public void setOrdenSemanal(int ordenSemanal) {
		this.ordenSemanal = ordenSemanal;
	}

	@XmlElement
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement
	public String getNombreRutina() {
		return nombreRutina;
	}

	public void setNombreRutina(String nombreRutina) {
		this.nombreRutina = nombreRutina;
	}

	public List<Serie> getSeries() {
		return series;
	}

	public void setSeries(List<Serie> series) {
		this.series = series;
	}
	
	public void addSerie(Serie serie) {
		series.add(serie);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calorias;
		result = prime * result
				+ ((nombreRutina == null) ? 0 : nombreRutina.hashCode());
		result = prime * result + ordenSemanal;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaEntreno other = (DiaEntreno) obj;
		if (calorias != other.calorias)
			return false;
		if (nombreRutina == null) {
			if (other.nombreRutina != null)
				return false;
		} else if (!nombreRutina.equals(other.nombreRutina))
			return false;
		if (ordenSemanal != other.ordenSemanal)
			return false;
		return true;
	}
	
	
	
	

}
