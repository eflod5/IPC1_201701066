package objetos;

public class Jugador {
	private String jugador1,jugador2,per1J1,per2J1,per3J1,per1J2,per2J2,per3J2,ganador;
	private int vidasJ1,vidasJ2,tiempo;
	
	
	public String getJugador1() {
		return jugador1;
	}
	public Jugador(String jugador1, String jugador2, String per1J1, String per2J1, String per3J1, String per1J2,
			String per2J2, String per3J2, String ganador, int vidasJ1, int vidasJ2, int tiempo) {		
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.per1J1 = per1J1;
		this.per2J1 = per2J1;
		this.per3J1 = per3J1;
		this.per1J2 = per1J2;
		this.per2J2 = per2J2;
		this.per3J2 = per3J2;
		this.ganador = ganador;
		this.vidasJ1 = vidasJ1;
		this.vidasJ2 = vidasJ2;
		this.tiempo = tiempo;
	}

	public void setJugador1(String jugador1) {
		this.jugador1 = jugador1;
	}
	public String getJugador2() {
		return jugador2;
	}
	public void setJugador2(String jugador2) {
		this.jugador2 = jugador2;
	}
	public String getPer1J1() {
		return per1J1;
	}
	public void setPer1J1(String per1j1) {
		per1J1 = per1j1;
	}
	public String getPer2J1() {
		return per2J1;
	}
	public void setPer2J1(String per2j1) {
		per2J1 = per2j1;
	}
	public String getPer3J1() {
		return per3J1;
	}
	public void setPer3J1(String per3j1) {
		per3J1 = per3j1;
	}
	public String getPer1J2() {
		return per1J2;
	}
	public void setPer1J2(String per1j2) {
		per1J2 = per1j2;
	}
	public String getPer2J2() {
		return per2J2;
	}
	public void setPer2J2(String per2j2) {
		per2J2 = per2j2;
	}
	public String getPer3J2() {
		return per3J2;
	}
	public void setPer3J2(String per3j2) {
		per3J2 = per3j2;
	}
	public String getGanador() {
		return ganador;
	}
	public void setGanador(String ganador) {
		this.ganador = ganador;
	}
	public int getVidasJ1() {
		return vidasJ1;
	}
	public void setVidasJ1(int vidasJ1) {
		this.vidasJ1 = vidasJ1;
	}
	public int getVidasJ2() {
		return vidasJ2;
	}
	public void setVidasJ2(int vidasJ2) {
		this.vidasJ2 = vidasJ2;
	}
	public int getTiempo() {
		return tiempo;
	}
	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}
}
