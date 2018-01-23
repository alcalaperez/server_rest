package business.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rutina")
public class Rutina implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String descripcion;
	private List<DiaEntreno> diasEntrenamiento;

	public Rutina() {

	}
	
	public Rutina(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		diasEntrenamiento = new ArrayList<>();
	}
	@XmlElement
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@XmlElement
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@XmlElementWrapper
    @XmlElement(name="diasEntrenamiento")
	public List<DiaEntreno> getDiasEntrenamiento() {
		return diasEntrenamiento;
	}

	public void setDiasEntrenamiento(List<DiaEntreno> diasEntrenamiento) {
		this.diasEntrenamiento = diasEntrenamiento;
	}

	public void addDiaEntrenamiento(DiaEntreno dia) {
		diasEntrenamiento.add(dia);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Rutina other = (Rutina) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	
}
