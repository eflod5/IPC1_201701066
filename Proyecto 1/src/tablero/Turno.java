package tablero;

public class Turno {		
	public int t1j1,t2j1,t3j1,t1j2,t2j2,t3j2,personaje;
	public String r1j1,r2j1,r3j1,r1j2,r2j2,r3j2,ruta;
	private String per11,per21,per31,per12,per22,per32;
		
	public Turno(String per11, String per21,String per31, String per12, String per22,String p32) {	
		setPer11(per11);
		setPer21(per21);
		setPer31(per31);
		setPer12(per12);
		setPer22(per22);
		setPer32(per32);		
	}					
	public void determinarTurnosJ1(String per11,String per21, String per31) {		
		if(per11=="Mago" && per21=="Princesa" && per31=="Caballero") {
			t1j1 = 31;			
			t2j1 = 11;
			t3j1 = 21;
			r1j1 = "/imagenes/mago.png";
			r2j1 = "/imagenes/princesa.png";
			r3j1 = "/imagenes/caballero.png";
		}
		else if(per11=="Mago" && per21=="Caballero" && per31=="Princesa") {
			t1j1 = 31;			
			t2j1 = 21;
			t3j1 = 11;			
			r1j1="/imagenes/mago.png";
			r3j1="/imagenes/princesa.png";
			r2j1="/imagenes/caballero.png";
		}
		else if(per11=="Princesa" && per21=="Mago" && per31=="Caballero") {
			t1j1 = 11;			
			t2j1 = 31;
			t3j1 = 21;		
			r2j1="/imagenes/mago.png";
			r1j1="/imagenes/princesa.png";
			r3j1="/imagenes/caballero.png";
		}
		else if(per11=="Princesa" && per21=="Caballero" && per31=="Mago") {
			t1j1 = 11;			
			t2j1 = 21;
			t3j1 = 31;			
			r3j1="/imagenes/mago.png";
			r1j1="/imagenes/princesa.png";
			r2j1="/imagenes/caballero.png";
		}
		else if(per11=="Caballero" && per21=="Mago" && per31=="Princesa") {
			t1j1 = 21;			
			t2j1 = 31;
			t3j1 = 11;			
			r2j1="/imagenes/mago.png";
			r3j1="/imagenes/princesa.png";
			r1j1="/imagenes/caballero.png";
		}
		else if(per11=="Caballero" && per21=="Princesa" && per31=="Mago") {
			t1j1 = 21;			
			t2j1 = 11;
			t3j1 = 31;			
			r3j1="/imagenes/mago.png";
			r2j1="/imagenes/princesa.png";
			r1j1="/imagenes/caballero.png";
		}		
	}		
	public void determinarTurnosJ2(String per12, String per22, String per32) {				
		if(per12=="Mago" && per22=="Princesa" && per32=="Caballero") {
			t1j2 = 32;			
			t2j2 = 12;
			t3j2 = 22;		
			r1j2="/imagenes/mago1.png";
			r2j2="/imagenes/princesa1.png";
			r3j2="/imagenes/caballero1.png";
		}
		else if(per12=="Mago" && per22=="Caballero" && per32=="Princesa") {
			t1j2 = 32;			
			t2j2 = 22;
			t3j2 = 12;			
			r1j2="/imagenes/mago1.png";
			r3j2="/imagenes/princesa1.png";
			r2j2="/imagenes/caballero1.png";
		}
		else if(per12=="Princesa" && per22=="Mago" && per32=="Caballero") {
			t1j2 = 12;			
			t2j2 = 32;
			t3j2 = 22;			
			r2j2="/imagenes/mago1.png";
			r1j2="/imagenes/princesa1.png";
			r3j2="/imagenes/caballero1.png";
		}
		else if(per12=="Princesa" && per22=="Caballero" && per32=="Mago") {
			t1j2 = 12;			
			t2j2 = 22;
			t3j2 = 32;			
			r3j2="/imagenes/mago1.png";
			r1j2="/imagenes/princesa1.png";
			r2j2="/imagenes/caballero1.png";
		}
		else if(per12=="Caballero" && per22=="Mago" && per32=="Princesa") {
			t1j2 = 22;			
			t2j2 = 32;
			t3j2 = 12;			
			r2j2="/imagenes/mago1.png";
			r3j2="/imagenes/princesa1.png";
			r1j2="/imagenes/caballero1.png";
		}
		else if(per12=="Caballero" && per22=="Princesa" && per32=="Mago") {
			t1j2 = 22;			
			t2j2 = 12;
			t3j2 = 32;			
			r3j2="/imagenes/mago1.png";
			r2j2="/imagenes/princesa1.png";
			r1j2="/imagenes/caballero1.png";
		}		
	}	
	public String getrutaT1J1() {
		return r1j1;
	}
	public String getrutaT2J1() {
		return r2j1;
	}
	public String getrutaT3J1() {
		return r3j1;
	}
	public String getrutaT1J2() {
		return r1j2;
	}	
	public String getrutaT2J2() {
		return r2j2;
	}
	public String getrutaT3J2() {
		return r3j2;
	}	
	public int getpersonajeT1J1() {
		return t1j1;
	}
	public int getpersonajeT2J1() {
		return t2j1;
	}
	public int getpersonajeT3J1() {
		return t3j1;
	}
	public int getpersonajeT1J2() {
		return t1j2;
	}
	public int getpersonajeT2J2() {
		return t2j2;
	}
	public int getpersonajeT3J2() {
		return t3j2;
	}	
	public String getPer11() {
		return per11;
	}
	public String getPer21() {
		return per21;
	}
	public String getPer31() {
		return per31;
	}
	public String getPer12() {
		return per12;
	}
	public String getPer22() {
		return per22;
	}
	public String getPer32() {
		return per32;
	}
	public void setPer11(String per11) {
		this.per11=per11;
	}
	public void setPer21(String per21) {
		this.per11=per21;
	}
	public void setPer31(String per31) {
		this.per31=per31;
	}
	public void setPer12(String per12) {
		this.per12=per12;
	}
	public void setPer22(String per22) {
		this.per22=per22;
	}
	public void setPer32(String per32) {
		this.per32=per32;
	}
}
