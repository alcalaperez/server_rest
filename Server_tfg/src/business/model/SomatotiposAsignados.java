package business.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "somatotiposAsignados")
public class SomatotiposAsignados implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String rutinaAsignada;
	private String somatotipo;
	private String objetivo;

	public SomatotiposAsignados() {

	}
	
	public SomatotiposAsignados(String rutinaAsignada, String somatotipo, String objetivo) {
		this.setRutinaAsignada(rutinaAsignada);
		this.setObjetivo(objetivo);
		this.setSomatotipo(somatotipo);
	}
	
	
	@XmlElement
	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	@XmlElement
	public String getSomatotipo() {
		return somatotipo;
	}

	public void setSomatotipo(String somatotipo) {
		this.somatotipo = somatotipo;
	}
	
	@XmlElement
	public String getRutinaAsignada() {
		return rutinaAsignada;
	}

	public void setRutinaAsignada(String rutinaAsignada) {
		this.rutinaAsignada = rutinaAsignada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((objetivo == null) ? 0 : objetivo.hashCode());
		result = prime * result + ((rutinaAsignada == null) ? 0 : rutinaAsignada.hashCode());
		result = prime * result + ((somatotipo == null) ? 0 : somatotipo.hashCode());
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
		SomatotiposAsignados other = (SomatotiposAsignados) obj;
		if (objetivo == null) {
			if (other.objetivo != null)
				return false;
		} else if (!objetivo.equals(other.objetivo))
			return false;
		if (rutinaAsignada == null) {
			if (other.rutinaAsignada != null)
				return false;
		} else if (!rutinaAsignada.equals(other.rutinaAsignada))
			return false;
		if (somatotipo == null) {
			if (other.somatotipo != null)
				return false;
		} else if (!somatotipo.equals(other.somatotipo))
			return false;
		return true;
	}


	
	
}
