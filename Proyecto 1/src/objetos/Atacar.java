package objetos;
import java.util.*;
import javax.swing.*;
import tablero.*;

public class Atacar {
	public Tablero tab=null;	
	private int personaje;	
	private int quitarVida=0;
	private Principal principal;
	
	public Atacar(Tablero tab, int personaje,Principal principal) {		
		setTablero(tab);
		setPersonaje(personaje);
		setPrincipal(principal);
	}
	
	public void setPrincipal(Principal principal) {
		this.principal=principal;
	}
	
	public void setTablero(Tablero tab) {
		this.tab=tab;
	}
	public void setPersonaje(int personaje) {
		this.personaje=personaje;
	}
	
	public void atacarDerecha(int personaje) {
		int x = tab.tableroIndice.length;
		for (int i = 0; i < x; i++) {			
			for (int j = 0; j < x; j++) {
				if(tab.tableroIndice[i][j]==personaje) {
					if(personaje==31) {
						if(j==x-1) {
							return;
						}
						else if(j==x-2) {
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {
								principal.quitarVidaAtaque(1);
							}
						}
						else if(j==x-3) {
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j+2]==12 || tab.tableroIndice[i][j+2]==22 || tab.tableroIndice[i][j+2]==32) {
								principal.quitarVidaAtaque(1);
							}
						}
						else if(j==x-4) {
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j+2]==12 || tab.tableroIndice[i][j+2]==22 || tab.tableroIndice[i][j+2]==32) {
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j+3]==12 || tab.tableroIndice[i][j+3]==22 || tab.tableroIndice[i][j+3]==32) {
								principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j+2]==12 || tab.tableroIndice[i][j+2]==22 || tab.tableroIndice[i][j+2]==32) {
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j+3]==12 || tab.tableroIndice[i][j+3]==22 || tab.tableroIndice[i][j+3]==32) {
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j+4]==12 || tab.tableroIndice[i][j+4]==22 || tab.tableroIndice[i][j+4]==32) {
								principal.quitarVidaAtaque(1);
							}
						}
					}
					else if(personaje==32) {
						if(j==x-1) {
							return;
						}
						else if(j==x-2) {
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {
								principal.quitarVidaAtaque(2);
							}
						}
						else if(j==x-3) {
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j+2]==11 || tab.tableroIndice[i][j+2]==21 || tab.tableroIndice[i][j+2]==31) {
								principal.quitarVidaAtaque(2);
							}
						}
						else if(j==x-4) {
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j+2]==11 || tab.tableroIndice[i][j+2]==21 || tab.tableroIndice[i][j+2]==31) {
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j+3]==11 || tab.tableroIndice[i][j+3]==21 || tab.tableroIndice[i][j+3]==31) {
								principal.quitarVidaAtaque(2);
							}
						}
						else {
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j+2]==11 || tab.tableroIndice[i][j+2]==21 || tab.tableroIndice[i][j+2]==31) {
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j+3]==11 || tab.tableroIndice[i][j+3]==21 || tab.tableroIndice[i][j+3]==31) {
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j+4]==11 || tab.tableroIndice[i][j+4]==21 || tab.tableroIndice[i][j+4]==31) {
								principal.quitarVidaAtaque(2);
							}
						}
					}				
					else if(personaje==21) {
						if(j==x-1) {
							return;
						}
						else if(j==x-2) {
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)									
								principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j+2]==12 || tab.tableroIndice[i][j+2]==22 || tab.tableroIndice[i][j+2]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
						}
					}
					
					else if(personaje==22) {
						if(j==x-1) {
							return;
						}
						else if(j==x-2) {
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
								if(principal.vidaJ1!=0)
								principal.quitarVidaAtaque(2);
							}
						}
						else {
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
								if(principal.vidaJ1!=0)
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j+2]==11 || tab.tableroIndice[i][j+2]==21 || tab.tableroIndice[i][j+2]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
								if(principal.vidaJ1!=0)
								principal.quitarVidaAtaque(2);
							}
						}
					}					
				}	
			}
		}
	}
	
	public void atacarIzquierda(int personaje) {
		int x = tab.tableroIndice.length;
		for (int i = 0; i < x; i++) {			
			for (int j = 0; j < x; j++) {
				if(tab.tableroIndice[i][j]==personaje) {
					if(personaje==31) {
						if(j==0) {
							return;
						}
						else if(j==1) {
							if(tab.tableroIndice[i][0]==12 || tab.tableroIndice[i][0]==22 || tab.tableroIndice[i][0]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else if(j==2) {
							if(tab.tableroIndice[i][0]==12 || tab.tableroIndice[i][0]==22 || tab.tableroIndice[i][0]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][1]==12 || tab.tableroIndice[i][1]==22 || tab.tableroIndice[i][1]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else if(j==3) {
							if(tab.tableroIndice[i][2]==12 || tab.tableroIndice[i][2]==22 || tab.tableroIndice[i][2]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][1]==12 || tab.tableroIndice[i][1]==22 || tab.tableroIndice[i][1]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][0]==12 || tab.tableroIndice[i][0]==22 || tab.tableroIndice[i][0]==32) {
								principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i][j-1]==12 || tab.tableroIndice[i][j-1]==22 || tab.tableroIndice[i][j-1]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j-2]==12 || tab.tableroIndice[i][j-2]==22 || tab.tableroIndice[i][j-2]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j-3]==12 || tab.tableroIndice[i][j-3]==22 || tab.tableroIndice[i][j-3]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j-4]==12 || tab.tableroIndice[i][j-4]==22 || tab.tableroIndice[i][j-4]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
					}
					else if(personaje==32) {
						if(j==0) {
							return;
						}
						else if(j==1) {
							if(tab.tableroIndice[i][0]==11 || tab.tableroIndice[i][0]==21 || tab.tableroIndice[i][0]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else if(j==2) {
							if(tab.tableroIndice[i][0]==11 || tab.tableroIndice[i][0]==21 || tab.tableroIndice[i][0]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][1]==11 || tab.tableroIndice[i][1]==21 || tab.tableroIndice[i][1]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else if(j==3) {
							if(tab.tableroIndice[i][2]==11 || tab.tableroIndice[i][2]==21 || tab.tableroIndice[i][2]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][1]==11 || tab.tableroIndice[i][1]==21 || tab.tableroIndice[i][1]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][0]==11 || tab.tableroIndice[i][0]==21 || tab.tableroIndice[i][0]==31) {
								principal.quitarVidaAtaque(2);
							}
						}
						else {
							if(tab.tableroIndice[i][j-1]==11 || tab.tableroIndice[i][j-1]==21 || tab.tableroIndice[i][j-1]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j-2]==11 || tab.tableroIndice[i][j-2]==21 || tab.tableroIndice[i][j-2]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j-3]==11 || tab.tableroIndice[i][j-3]==21 || tab.tableroIndice[i][j-3]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j-4]==11 || tab.tableroIndice[i][j-4]==21 || tab.tableroIndice[i][j-4]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
					}				
					else if(personaje==21) {
						if(j==0) {
							return;
						}
						else if(j==1) {
							if(tab.tableroIndice[i][0]==12 || tab.tableroIndice[i][0]==22 || tab.tableroIndice[i][0]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i][j-1]==12 || tab.tableroIndice[i][j-1]==22 || tab.tableroIndice[i][j-1]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i][j-2]==12 || tab.tableroIndice[i][j-2]==22 || tab.tableroIndice[i][j-2]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
						}
					}
					
					else if(personaje==22) {
						if(j==0) {
							return;
						}
						else if(j==1) {
							if(tab.tableroIndice[i][0]==11 || tab.tableroIndice[i][0]==21 || tab.tableroIndice[i][0]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
								if(principal.vidaJ1!=0)
								principal.quitarVidaAtaque(2);
							}
						}
						else {
							if(tab.tableroIndice[i][j-1]==11 || tab.tableroIndice[i][j-1]==21 || tab.tableroIndice[i][j-1]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
								if(principal.vidaJ1!=0)
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i][j-2]==11 || tab.tableroIndice[i][j-2]==21 || tab.tableroIndice[i][j-2]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
								if(principal.vidaJ1!=0)
								principal.quitarVidaAtaque(2);
							}
						}
					}					
				}	
			}
		}
	}	
	
	public void atacarArriba(int personaje) {
		int x = tab.tableroIndice.length;
		for (int i = 0; i < x; i++) {			
			for (int j = 0; j < x; j++) {
				if(tab.tableroIndice[i][j]==personaje) {
					if(personaje==31) {
						if(i==0) {
							return;
						}
						else if(i==1) {
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else if(i==2) {
							if(tab.tableroIndice[i-2][j]==12 || tab.tableroIndice[i-2][j]==22 || tab.tableroIndice[i-2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else if(i==3) {
							if(tab.tableroIndice[i-3][j]==12 || tab.tableroIndice[i-3][j]==22 || tab.tableroIndice[i-3][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i-2][j]==12 || tab.tableroIndice[i-2][j]==22 || tab.tableroIndice[i-2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i-2][j]==12 || tab.tableroIndice[i-2][j]==22 || tab.tableroIndice[i-2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i-3][j]==12 || tab.tableroIndice[i-3][j]==22 || tab.tableroIndice[i-3][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i-4][j]==12 || tab.tableroIndice[i-4][j]==22 || tab.tableroIndice[i-4][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
					}
					else if(personaje==32) {
						if(i==0) {
							return;
						}
						else if(i==1) {
							if(tab.tableroIndice[0][j]==11 || tab.tableroIndice[0][j]==21 || tab.tableroIndice[0][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else if(i==2) {
							if(tab.tableroIndice[1][j]==11 || tab.tableroIndice[1][j]==21 || tab.tableroIndice[1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[0][j]==11 || tab.tableroIndice[0][j]==21 || tab.tableroIndice[0][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else if(i==3) {
							if(tab.tableroIndice[2][j]==11 || tab.tableroIndice[2][j]==21 || tab.tableroIndice[2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[1][j]==11 || tab.tableroIndice[1][j]==21 || tab.tableroIndice[1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[0][j]==11 || tab.tableroIndice[0][j]==21 || tab.tableroIndice[0][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else {
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i-2][j]==11 || tab.tableroIndice[i-2][j]==21 || tab.tableroIndice[i-2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i-3][j]==11 || tab.tableroIndice[i-3][j]==21 || tab.tableroIndice[i-3][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i-4][j]==11 || tab.tableroIndice[i-4][j]==21 || tab.tableroIndice[i-4][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
					}
					else if(personaje==21) {
						if(i==0) {
							return;
						}
						else if(i==1) {
							if(tab.tableroIndice[0][j]==12 || tab.tableroIndice[0][j]==22 || tab.tableroIndice[0][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i-2][j]==12 || tab.tableroIndice[i-2][j]==22 || tab.tableroIndice[i-2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
								if(principal.vidaJ2!=0)
								principal.quitarVidaAtaque(1);
							}
						}
					}
					
					else if(personaje==22) {
						if(i==0) {
							return;
						}
						else if(i==1) {
							if(tab.tableroIndice[0][j]==11 || tab.tableroIndice[0][j]==21 || tab.tableroIndice[0][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
								if(principal.vidaJ1!=0)principal.quitarVidaAtaque(2);
							}
						}
						else {
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);if(principal.vidaJ1!=0)principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i-2][j]==11 || tab.tableroIndice[i-2][j]==21 || tab.tableroIndice[i-2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);if(principal.vidaJ1!=0)principal.quitarVidaAtaque(2);
							}
						}
					}					
				}	
			}
		}
	}	
	
	public void atacarAbajo(int personaje) {
		int x = tab.tableroIndice.length;
		for (int i = 0; i < x; i++) {			
			for (int j = 0; j < x; j++) {
				if(tab.tableroIndice[i][j]==personaje) {
					if(personaje==31) {
						if(i==x-1) {
							return;
						}
						else if(i==x-2) {
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else if(i==x-3) {
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+2][j]==12 || tab.tableroIndice[i+2][j]==22 || tab.tableroIndice[i+2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else if(i==x-4) {
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+2][j]==12 || tab.tableroIndice[i+2][j]==22 || tab.tableroIndice[i+2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+3][j]==12 || tab.tableroIndice[i+3][j]==22 || tab.tableroIndice[i+3][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+2][j]==12 || tab.tableroIndice[i+2][j]==22 || tab.tableroIndice[i+2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+3][j]==12 || tab.tableroIndice[i+3][j]==22 || tab.tableroIndice[i+3][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+4][j]==12 || tab.tableroIndice[i+4][j]==22 || tab.tableroIndice[i+4][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);
							}
						}
					}
					else if(personaje==32) {
						if(i==x-1) {
							return;
						}
						else if(i==x-2) {
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else if(i==x-3) {
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i+2][j]==11 || tab.tableroIndice[i+2][j]==21 || tab.tableroIndice[i+2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else if(i==x-4) {
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i+2][j]==11 || tab.tableroIndice[i+2][j]==21 || tab.tableroIndice[i+2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i+3][j]==11 || tab.tableroIndice[i+3][j]==21 || tab.tableroIndice[i+3][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
						else {
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i+2][j]==11 || tab.tableroIndice[i+2][j]==21 || tab.tableroIndice[i+2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i+3][j]==11 || tab.tableroIndice[i+3][j]==21 || tab.tableroIndice[i+3][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
							if(tab.tableroIndice[i+4][j]==11 || tab.tableroIndice[i+4][j]==21 || tab.tableroIndice[i+4][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);
							}
						}
					}				
					else if(personaje==21) {
						if(i==x-1) {
							return;
						}
						else if(i==x-2) {
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);if(principal.vidaJ2!=0)principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);if(principal.vidaJ2!=0)principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+2][j]==12 || tab.tableroIndice[i+2][j]==22 || tab.tableroIndice[i+2][j]==32) {
								//ATACA
								principal.quitarVidaAtaque(1);if(principal.vidaJ2!=0)principal.quitarVidaAtaque(1);
							}
						}
					}
					
					else if(personaje==22) {
						if(i==x-1) {
							return;
						}
						else if(i==x-2) {
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);if(principal.vidaJ1!=0)principal.quitarVidaAtaque(1);
							}
						}
						else {
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);if(principal.vidaJ1!=0)principal.quitarVidaAtaque(1);
							}
							if(tab.tableroIndice[i+2][j]==11 || tab.tableroIndice[i+2][j]==21 || tab.tableroIndice[i+2][j]==31) {
								//ATACA
								principal.quitarVidaAtaque(2);if(principal.vidaJ1!=0)principal.quitarVidaAtaque(1);
							}
						}
					}					
				}	
			}
		}
	}
	
	public void atacarPrincesa(int personaje) {
		int x = tab.tableroIndice.length;
		for (int i = 0; i < x; i++) {			
			for (int j = 0; j < x; j++) {
				if(tab.tableroIndice[i][j]==personaje) {
					if(personaje==11) {
						if(i==0 && j==0) {
							if(tab.tableroIndice[0][1]==12 || tab.tableroIndice[0][1]==22 || tab.tableroIndice[0][1]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[1][0]==12 || tab.tableroIndice[1][0]==22 || tab.tableroIndice[1][0]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else if(i==0 && j==x-1) {
							if(tab.tableroIndice[0][j-1]==12 || tab.tableroIndice[0][j-1]==22 || tab.tableroIndice[0][j-1]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[1][j]==12 || tab.tableroIndice[1][j]==22 || tab.tableroIndice[1][j]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else if(i==x-1 && j==0) {
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else if(i==x-1 && j==x-1) {
							if(tab.tableroIndice[i][j-1]==12 || tab.tableroIndice[i][j-1]==22 || tab.tableroIndice[i][j-1]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else if(i==0) {
							if(tab.tableroIndice[0][j-1]==12 || tab.tableroIndice[0][j-1]==22 || tab.tableroIndice[0][j-1]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[0][j+1]==12 || tab.tableroIndice[0][j+1]==22 || tab.tableroIndice[0][j+1]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[1][j]==12 || tab.tableroIndice[1][j]==22 || tab.tableroIndice[1][j]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else if(j==0) {
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else if(i==x-1) {
							if(tab.tableroIndice[i][j-1]==12 || tab.tableroIndice[i][j-1]==22 || tab.tableroIndice[i][j-1]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {							
								principal.quitarVidaAtaque(1);principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {							
								principal.quitarVidaAtaque(1);principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else if(j==x-1) {
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								principal.quitarVidaAtaque(1);principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {							
								principal.quitarVidaAtaque(1);principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i][j-1]==12 || tab.tableroIndice[i][j-1]==22 || tab.tableroIndice[i][j-1]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
						else {
							if(tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==32) {
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
							if(tab.tableroIndice[i][j-1]==12 || tab.tableroIndice[i][j-1]==22 || tab.tableroIndice[i][j-1]==32) {							
								principal.quitarVidaAtaque(1);
								principal.turnoJ1=true;
								principal.turnoJ2=false;
							}
						}
					}
					else if(personaje==12) {
						if(i==0 && j==0) {
							if(tab.tableroIndice[0][1]==11 || tab.tableroIndice[0][1]==21 || tab.tableroIndice[0][1]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[1][0]==11 || tab.tableroIndice[1][0]==21 || tab.tableroIndice[1][0]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else if(i==0 && j==x-1) {
							if(tab.tableroIndice[0][j-1]==11 || tab.tableroIndice[0][j-1]==21 || tab.tableroIndice[0][j-1]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[1][j]==11 || tab.tableroIndice[1][j]==21 || tab.tableroIndice[1][j]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else if(i==x-1 && j==0) {
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else if(i==x-1 && j==x-1) {
							if(tab.tableroIndice[i][j-1]==11 || tab.tableroIndice[i][j-1]==21 || tab.tableroIndice[i][j-1]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else if(i==0) {
							if(tab.tableroIndice[0][j-1]==11 || tab.tableroIndice[0][j-1]==21 || tab.tableroIndice[0][j-1]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[0][j+1]==11 || tab.tableroIndice[0][j+1]==21 || tab.tableroIndice[0][j+1]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[1][j]==11 || tab.tableroIndice[1][j]==21 || tab.tableroIndice[1][j]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else if(j==0) {
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else if(i==x-1) {
							if(tab.tableroIndice[i][j-1]==11 || tab.tableroIndice[i][j-1]==21 || tab.tableroIndice[i][j-1]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else if(j==x-1) {
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i][j-1]==11 || tab.tableroIndice[i][j-1]==21 || tab.tableroIndice[i][j-1]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
						else {
							if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==21 || tab.tableroIndice[i-1][j]==31) {
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==21 || tab.tableroIndice[i+1][j]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==21 || tab.tableroIndice[i][j+1]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
							if(tab.tableroIndice[i][j-1]==11 || tab.tableroIndice[i][j-1]==21 || tab.tableroIndice[i][j-1]==31) {							
								principal.quitarVidaAtaque(2);
								principal.turnoJ1=false;
								principal.turnoJ2=true;
							}
						}
					}	
				}
			}
		}
	}	
}