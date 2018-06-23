package aeropuerto;

public class Mantenimiento {
	private boolean estado;
	private Avion avion;
	
	public Mantenimiento(boolean estado, Avion avion) {
		this.estado=estado;
		this.avion=avion;
	}

	public boolean getEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Avion getAvion() {
		return avion;
	}
	
	
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	public String getDisponible() {
		if(getEstado()) {
			return "Disponible";
		}
		else {
			return "Ocupado";
		}
	}
}
