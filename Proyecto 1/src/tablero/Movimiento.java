package tablero;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JLabel;



public class Movimiento extends Thread{

	public int cantidad=0;
	public Tablero tab=null;
	private int direccion;
	private int personaje;
	private String ruta;			
	private int quitarVida=0,agregarVida=0;
	private int posXbomba, posYbomba,posXvida,posYvida;
	private boolean pasarBomba = false,pasarVida=false;
	private Principal principal;
		
	
	public Movimiento(int cantidad, Tablero tab, int direccion,int personaje,String ruta,Principal principal) {
		this.cantidad=cantidad;
		setDireccion(direccion);
		this.personaje=personaje;
		this.ruta=ruta;
		setTablero(tab);	
		setPrincipal(principal);
	}
	public Movimiento(int cantidad, Tablero tab,int direccion) {
		this.cantidad=cantidad;
		this.direccion=direccion;
		setTablero(tab);
	}
	
	public void setPrincipal (Principal principal) {
		this.principal=principal;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad=cantidad;
	}
	
	public void setTablero(Tablero tab) {
		this.tab=tab;
	}
	
	public void setDireccion(int direccion) {
		this.direccion=direccion;
	}
						
	public void pintarBomba() {
		tab.tableroIndice[posYbomba][posXbomba]=0;
		tab.tablero[posYbomba][posXbomba].setIcon(new ImageIcon(getClass().getResource("/imagenes/bomba.png")));
		tab.tablero[posYbomba][posXbomba].setHorizontalAlignment(JLabel.CENTER);
		tab.tablero[posYbomba][posXbomba].setVerticalAlignment(JLabel.CENTER);		
	}
	public void pintarVida() {
		tab.tableroIndice[posYvida][posXvida]=1;
		tab.tablero[posYvida][posXvida].setIcon(new ImageIcon(getClass().getResource("/imagenes/vida.png")));
		tab.tablero[posYvida][posXvida].setHorizontalAlignment(JLabel.CENTER);
		tab.tablero[posYvida][posXvida].setVerticalAlignment(JLabel.CENTER);		
	}
	
	public void moverDerecha(int cantidad,int personaje,String ruta) {
		boolean xxx = true;
		try {
			if(cantidad<=0) {				
				return;			
			}					
			int x = tab.tableroIndice.length;			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {										
					if(tab.tableroIndice[i][j]==personaje && xxx) {
						if(j==tab.tableroIndice.length-1) { 
							cantidad = 0;							
							tab.tableroIndice[i][j]=2;							
							tab.tablero[i][j].setIcon(null);
							tab.aggJugadoresCentro(x, personaje, ruta);
							if(personaje==12 || personaje==22 || personaje==32) {
								quitarVida = 2;			
								principal.quitarVidas(2);
								//tab.setQuitarVida(quitarVida);												
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								quitarVida = 1;
								principal.quitarVidas(quitarVida);
								//tab.setQuitarVida(quitarVida);								
							}
							if(pasarBomba) {
								pintarBomba();
								pasarBomba=false;
							}
							else if(pasarVida) {
								pintarVida();
								pasarVida=false;
							}
							return;							
						}
						else {
							quitarVida=0;							
							//tab.setQuitarVida(quitarVida);
						}
						
						if(tab.tableroIndice[i][j+1]==11 || tab.tableroIndice[i][j+1]==12 || tab.tableroIndice[i][j+1]==21
							|| tab.tableroIndice[i][j+1]==22 || tab.tableroIndice[i][j+1]==31 || tab.tableroIndice[i][j+1]==32) {
							int p = (int) Math.floor(Math.random()*2);							
							if(p==0) {
								moverArriba(cantidad,personaje,ruta);
								xxx =false;
								return;
							}
							else if(p==1) {
								moverAbajo(cantidad,personaje,ruta);
								xxx=false;
								return;
							}
						}
						
						if(tab.tableroIndice[i][j+1] ==0 && cantidad==1) {	
							if(personaje==12 || personaje==22 || personaje==32) {							
								quitarVida = 2;	
								principal.quitarVidas(quitarVida);
								//tab.setQuitarVida(quitarVida);			
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								quitarVida = 1;
								principal.quitarVidas(quitarVida);
								//tab.setQuitarVida(quitarVida);
							}							
						}
						else {
							quitarVida=0;							
							//tab.setQuitarVida(quitarVida);							
						}
						
						if(tab.tableroIndice[i][j+1] == 1 && cantidad==1) {
							if(personaje==12 || personaje==22 || personaje==32) {							
								agregarVida=2;
								principal.agregarVidas(agregarVida);
								//tab.setAgregarVida(agregarVida);							
							}							
							else if(personaje==11 || personaje ==21 || personaje==31) {
								agregarVida=1;
								principal.agregarVidas(agregarVida);
								//tab.setAgregarVida(agregarVida);								
							}																	
						}	
						else {						
							agregarVida=0;							
							//tab.setAgregarVida(agregarVida);
						}
						
						if(pasarBomba) {
							pintarBomba();
							pasarBomba=false;
						}
						else if(pasarVida){
							pintarVida();
							pasarVida=false;
						}
						else {
							tab.tablero[i][j].setIcon(null);
							tab.tableroIndice[i][j] =2;		
						}
						
						if(tab.tableroIndice[i][j+1]==0  && cantidad!=1 ) {
							posXbomba = j+1;
							posYbomba = i;
							pasarBomba=true;
						}
						else if(tab.tableroIndice[i][j+1]==1 && cantidad!=1) {
							posXvida = j+1;
							posYvida= i;
							pasarVida=true;
						}
							tab.tablero[i][j+1].setIcon(new ImageIcon(getClass().getResource(ruta)));
							tab.tablero[i][j+1].setHorizontalAlignment(JLabel.CENTER);
							tab.tablero[i][j+1].setVerticalAlignment(JLabel.CENTER);
							tab.tableroIndice[i][j+1]=personaje;								
							Thread.sleep(500);							
							cantidad--;
							xxx = false;							
							moverDerecha(cantidad,personaje,ruta);							
					}
				}
			}														
		}				
		catch(InterruptedException ex) {
			Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
			
	public void moverIzquierda(int cantidad,int personaje,String ruta) {
		boolean xxx = true;		
		try {
			if(cantidad<=0) { 				
				return;			
			}					
			int x = tab.tableroIndice.length;			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {										
					if(tab.tableroIndice[i][j]==personaje && xxx) {
						if(j==0) { 
							cantidad = 0;							
							tab.tableroIndice[i][j]=2;							
							tab.tablero[i][j].setIcon(null);
							tab.aggJugadoresCentro(x, personaje, ruta);
							if(personaje==12 || personaje==22 || personaje==32) {
								quitarVida=2;								
								principal.quitarVidas(quitarVida);								
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {								
								quitarVida=1;								
								principal.quitarVidas(quitarVida);							
							}
							if(pasarBomba) {
								pintarBomba();
								pasarBomba=false;
							}
							else if(pasarVida) {
								pintarVida();
								pasarVida=false;
							}
							return;							
						}
						else {
							quitarVida=0;																	
						}
						
						if(tab.tableroIndice[i][j-1]==11 || tab.tableroIndice[i][j-1]==12 || tab.tableroIndice[i][j-1]==21
								|| tab.tableroIndice[i][j-1]==22 || tab.tableroIndice[i][j-1]==31 || tab.tableroIndice[i][j-1]==32) {
								int p = (int) Math.floor(Math.random()*2);System.out.println(p);
								if(p==0) {
									moverArriba(cantidad,personaje,ruta);
									xxx =false;
									return;
								}
								else if(p==1) {
									moverAbajo(cantidad,personaje,ruta);
									xxx=false;
									return;
								}
							}
						
						if(tab.tableroIndice[i][j-1] ==0 && cantidad==1) {
							if(personaje==12 || personaje==22 || personaje==32) {							
								quitarVida=2;								
								principal.quitarVidas(quitarVida);
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								quitarVida=1;								
								principal.quitarVidas(quitarVida);						
							}											
						}
						else {
							quitarVida=0;																		
						}
						
						if(tab.tableroIndice[i][j-1] ==1 && cantidad==1) {
							if(personaje==12 || personaje==22 || personaje==32) {							
								agregarVida=2;
								principal.agregarVidas(agregarVida);
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								agregarVida=1;
								principal.agregarVidas(agregarVida);
							}								
						}
						else {							
							agregarVida=0;													
						}						
						if(pasarBomba) {
							pintarBomba();
							pasarBomba=false;
						}
						else if(pasarVida) {
							pintarVida();
							pasarVida=false;
						}
						else {
							tab.tablero[i][j].setIcon(null);
							tab.tableroIndice[i][j] =2;		
						}
						
						if(tab.tableroIndice[i][j-1]==0  && cantidad!=1 ) {
							posXbomba = j-1;
							posYbomba = i;
							pasarBomba=true;
						}		
						else if(tab.tableroIndice[i][j-1]==1 && cantidad!=1) {
							posXvida = j-1;
							posYvida=i;
							pasarVida=true;
						}
							tab.tablero[i][j-1].setIcon(new ImageIcon(getClass().getResource(ruta)));
							tab.tablero[i][j-1].setHorizontalAlignment(JLabel.CENTER);
							tab.tablero[i][j-1].setVerticalAlignment(JLabel.CENTER);
							tab.tableroIndice[i][j-1]=personaje;								
							Thread.sleep(500);							
							cantidad--;
							xxx = false;
							moverIzquierda(cantidad,personaje,ruta);																											
					}
				}
			}														
		}				
		catch(InterruptedException ex) {
			Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
		}
	}	
	public void moverArriba(int cantidad,int personaje,String ruta) {
		boolean xxx = true;
		try {
			if(cantidad<=0) {				
				return;			
			}					
			int x = tab.tableroIndice.length;			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {											
					if(tab.tableroIndice[i][j]==personaje && xxx) {
						if(i==0) { 
							cantidad = 0;							
							tab.tableroIndice[i][j]=2;							
							tab.tablero[i][j].setIcon(null);
							tab.aggJugadoresCentro(x, personaje, ruta);
							if(personaje==12 || personaje==22 || personaje==32) {
								quitarVida=2;								
								principal.quitarVidas(quitarVida);												
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								quitarVida=1;
								principal.quitarVidas(quitarVida);												
							}
							if(pasarBomba) {
								pintarBomba();
								pasarBomba=false;
							}
							else if(pasarVida) {
								pintarVida();
								pasarVida=false;
							}
							return;							
						}
						else {							
							quitarVida=0;						
							
						}						
						if(tab.tableroIndice[i-1][j]==11 || tab.tableroIndice[i-1][j]==12 || tab.tableroIndice[i-1][j]==21
								|| tab.tableroIndice[i-1][j]==22 || tab.tableroIndice[i-1][j]==31 || tab.tableroIndice[i-1][j]==32) {
								int p = (int) Math.floor(Math.random()*2);								
								if(p==0) {
									moverDerecha(cantidad,personaje,ruta);
									xxx =false;
									return;
								}
								else if(p==1) {
									moverIzquierda(cantidad,personaje,ruta);
									xxx=false;
									return;
								}
							}						
						if(tab.tableroIndice[i-1][j] ==0 && cantidad==1) {
							if(personaje==12 || personaje==22 || personaje==32) {							
								quitarVida=2;
								principal.quitarVidas(quitarVida);																		
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								quitarVida=1;								
								principal.quitarVidas(quitarVida);
										
							}							
						}
						else {
							quitarVida=0;							
												
						}
						if(tab.tableroIndice[i-1][j] ==1 && cantidad==1) {
							if(personaje==12 || personaje==22 || personaje==32) {							
								agregarVida=2;								
								principal.agregarVidas(agregarVida);														
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								agregarVida=1;								
								principal.agregarVidas(agregarVida);					
							}													
						}
						else {
							agregarVida=0;
							//tab.setAgregarVida(agregarVida);
						}
						if(pasarBomba) {
							pintarBomba();
							pasarBomba=false;
						}
						else if(pasarVida) {
							pintarVida();
							pasarVida=false;
						}
						else {
							tab.tablero[i][j].setIcon(null);
							tab.tableroIndice[i][j] =2;		
						}
						
						if(tab.tableroIndice[i-1][j]==0  && cantidad!=1 ) {
							posXbomba = j;
							posYbomba = i-1;
							pasarBomba=true;
						}					
						else if(tab.tableroIndice[i-1][j]==1 && cantidad!=1) {
							posXvida = j;
							posYvida=i-1;
							pasarVida=true;
						}
							tab.tablero[i-1][j].setIcon(new ImageIcon(getClass().getResource(ruta)));
							tab.tableroIndice[i-1][j]=personaje;
							tab.tablero[i-1][j].setHorizontalAlignment(JLabel.CENTER);
							tab.tablero[i-1][j].setVerticalAlignment(JLabel.CENTER);
							Thread.sleep(500);							
							cantidad--;
							xxx = false;
							moverArriba(cantidad,personaje,ruta);																											
					}
				}
			}														
		}				
		catch(InterruptedException ex) {
			Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void moverAbajo(int cantidad,int personaje,String ruta) {
		boolean xxx = true;
		try {
			if(cantidad<=0) {	
				return;			
			}					
			int x = tab.tableroIndice.length;			
			for (int i = 0; i < x; i++) {
				for (int j = 0; j < x; j++) {										
					if(tab.tableroIndice[i][j]==personaje && xxx) {
						if(i==tab.tableroIndice.length-1) { 
							cantidad = 0;							
							tab.tableroIndice[i][j]=2;							
							tab.tablero[i][j].setIcon(null);
							tab.aggJugadoresCentro(x, personaje, ruta);
							if(personaje==12 || personaje==22 || personaje==32) {
								quitarVida = 2;
								principal.quitarVidas(quitarVida);								
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {
								quitarVida =1;
								principal.quitarVidas(quitarVida);					
							}
							if(pasarBomba) {
								pintarBomba();
								pasarBomba=false;
							}
							else if(pasarVida) {
								pintarVida();
								pasarVida=false;
							}
							return;							
						}
						else {
							quitarVida=0;							
						}
						
						if(tab.tableroIndice[i+1][j]==11 || tab.tableroIndice[i+1][j]==12 || tab.tableroIndice[i+1][j]==21
								|| tab.tableroIndice[i+1][j]==22 || tab.tableroIndice[i+1][j]==31 || tab.tableroIndice[i+1][j]==32) {
								int p = (int) Math.floor(Math.random()*2);								
								if(p==0) {
									moverDerecha(cantidad,personaje,ruta);
									xxx =false;
									return;
								}
								else if(p==1) {
									moverIzquierda(cantidad,personaje,ruta);
									xxx=false;
									return;
								}
							}
						if(tab.tableroIndice[i+1][j] ==0 && cantidad==1) {
							if(personaje==12 || personaje==22 || personaje==32) {									
								quitarVida=2;
								principal.quitarVidas(quitarVida);
																				
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {								
								quitarVida=1;
								principal.quitarVidas(quitarVida);
																						
							}							
						}
						else {
							quitarVida=0;							
						}
						if(tab.tableroIndice[i+1][j] ==1 && cantidad==1) {
							if(personaje==12 || personaje==22 || personaje==32) {								
								agregarVida=2;
								principal.agregarVidas(agregarVida);													
							}
							else if(personaje==11 || personaje ==21 || personaje==31) {								
								agregarVida=1;
								principal.agregarVidas(agregarVida);					
							}							
						}
						else {
							agregarVida=0;							
						}
						if(pasarBomba) {
							pintarBomba();
							pasarBomba=false;
						}
						else if(pasarVida) {
							pintarVida();
							pasarVida=false;
						}
						else {
							tab.tablero[i][j].setIcon(null);
							tab.tableroIndice[i][j] =2;		
						}
						
						if(tab.tableroIndice[i+1][j]==0  && cantidad!=1 ) {
							posXbomba = j;
							posYbomba = i+1;
							pasarBomba=true;
						}					
						else if(tab.tableroIndice[i+1][j]==1 && cantidad!=1) {
							posXvida = j;
							posYvida=i+1;
							pasarVida=true;
						}
							tab.tablero[i+1][j].setIcon(new ImageIcon(getClass().getResource(ruta)));
							tab.tablero[i+1][j].setHorizontalAlignment(JLabel.CENTER);
							tab.tablero[i+1][j].setVerticalAlignment(JLabel.CENTER);
							tab.tableroIndice[i+1][j]=personaje;								
							Thread.sleep(500);							
							cantidad--;
							xxx = false;
							moverAbajo(cantidad,personaje,ruta);																	
					}
				}
			}														
		}				
		catch(InterruptedException ex) {
			Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void run() {		
		if(direccion==2) {
			moverDerecha(cantidad,personaje,ruta);
		}
		else if(direccion == 3) {
			moverIzquierda(cantidad,personaje,ruta);			
		}
		else if(direccion == 0)
			moverArriba(cantidad,personaje,ruta);
		else if(direccion==1){
			moverAbajo(cantidad,personaje,ruta);
		}
	}		
}
