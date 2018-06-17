package tablero;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;

public class Tablero extends JPanel {
	
	public JLabel [][] tablero;		
	public Integer [][] tableroIndice;
	public int tam;
	public Image fondo;
	public int personajes=6;	
	public boolean mago1 = true;
	public boolean mago2 = true;
	public boolean p1 = true;
	public boolean p2 = true;
	public boolean c1 = true;
	public boolean c2 = true;

	public Tablero(int tam) {
		setTam(tam);		
		setBounds(50,50,500,500);
		setLayout(new GridLayout(tam,tam));				
		pintarMatriz(tam);						
	}	
	public void setTam(int tam) {
		this.tam=tam;
	}	
	public int getTam() {
		return tam;
	}	
	public void pintarMatriz(int tam) {
		this.tam=tam;			
		tablero = new JLabel[tam][tam];
		tableroIndice = new Integer[tam][tam];
		for(int i=0; i<tam; i++) {
			for (int j = 0; j < tam; j++) {
				tablero[i][j] = new JLabel();				
				Border border = BorderFactory.createLineBorder(Color.BLACK,1);
				tablero[i][j].setBorder(border);
				add(tablero[i][j]);
				tableroIndice[i][j]=2;
			}
		}		
	}	
	public void pintarVidas(int tam) {
		this.tam=tam;
		int no = (int) ((tam*tam)*0.05);		
		while(no!=0) {
			int fila = (int) Math.floor(Math.random()*(tam));
			int columna = (int) Math.floor(Math.random()*(tam));		
			
			while(tableroIndice[fila][columna] == 2) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/vida.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna] = 1;
				no --;			
			}
		}
	}	
	public void pintarBombas(int tam) {
		this.tam=tam;
		int no = (int) ((tam*tam)*0.1);				
		
		while(no!=0) {
			int fila = (int) Math.floor(Math.random()*(tam));
			int columna = (int) Math.floor(Math.random()*(tam));			
			
			while(tableroIndice[fila][columna]==2) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/bomba.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna]=0;
				no--;			
			}
		}				
	}	
	
	public void aggJugadoresCentro(int tam,int personaje,String ruta) {
		int centro, i, iz, der, vuelta = 0;
		
		centro = (int)(tam/2);
		
		while(vuelta<= centro) {
			if(vuelta==0) {
				if(tableroIndice[centro][centro] ==2) {
					tablero[centro][centro].setIcon(new ImageIcon(getClass().getResource(ruta)));					
					tablero[centro][centro].setHorizontalAlignment(JLabel.CENTER);
					tablero[centro][centro].setVerticalAlignment(JLabel.CENTER);
					tableroIndice[centro][centro]=personaje;
					return;
				}
				vuelta++;
			}
			else {
				while(vuelta<=centro) { //izquierda
					for (iz = (centro + vuelta - 1); iz >= (centro - vuelta + 1); iz--) {
						if(tableroIndice[iz][centro-vuelta]==2) {
							tablero[iz][centro-vuelta].setIcon(new ImageIcon(getClass().getResource(ruta)));					
							tablero[iz][centro-vuelta].setHorizontalAlignment(JLabel.CENTER);
							tablero[iz][centro-vuelta].setVerticalAlignment(JLabel.CENTER);
							tableroIndice[iz][centro-vuelta]=personaje;
							return;
						}               
                    }
					for (i = (-vuelta); i <= (vuelta); i++) {                           // fila superior
                        if(tableroIndice[centro-vuelta][centro+1]==2) {
                        	tablero[centro-vuelta][centro+1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
							tablero[centro-vuelta][centro+1].setHorizontalAlignment(JLabel.CENTER);
							tablero[centro-vuelta][centro+1].setVerticalAlignment(JLabel.CENTER);
							tableroIndice[centro-vuelta][centro+1]=personaje;
							return;
                        }						
                    }
					for (der = (centro - vuelta + 1); der <= (centro + vuelta - 1); der++) {        // derecha
                       if(tableroIndice[der][centro+vuelta]==2) {
                    	   	tablero[der][centro+vuelta].setIcon(new ImageIcon(getClass().getResource(ruta)));					
       						tablero[der][centro+vuelta].setHorizontalAlignment(JLabel.CENTER);
       						tablero[der][centro+vuelta].setVerticalAlignment(JLabel.CENTER);
       						tableroIndice[der][centro+vuelta]=personaje;
       						return;
                       }						
                    }
					for (i = (centro + vuelta); i >= (centro - vuelta); i--) {          // fila inferior 
						if(tableroIndice[centro+vuelta][i]==2) {
							tablero[centro+vuelta][i].setIcon(new ImageIcon(getClass().getResource(ruta)));					
							tablero[centro+vuelta][i].setHorizontalAlignment(JLabel.CENTER);
							tablero[centro+vuelta][i].setVerticalAlignment(JLabel.CENTER);
							tableroIndice[centro+vuelta][i]=personaje;
							return;
						}						
                    }
					vuelta++;
				}
			}
		}
	}
	
	public void xxx(int tam,int personaje,String ruta) {		
		int x=((tam/2));
		if(tableroIndice[x][x]==2) {
			tablero[x][x].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x][x].setHorizontalAlignment(JLabel.CENTER);
			tablero[x][x].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x][x]=personaje;				
		}
		else if(tableroIndice[x][x+1]==2) {
			tablero[x][x+1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x][x+1].setHorizontalAlignment(JLabel.CENTER);
			tablero[x][x+1].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x][x+1]=personaje;				
		}
		else if(tableroIndice[x+1][x+1]==2) {
			tablero[x+1][x+1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x+1][x+1].setHorizontalAlignment(JLabel.CENTER);
			tablero[x+1][x+1].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x+1][x+1]=personaje;				
		}
		else if(tableroIndice[x+1][x]==2) {
			tablero[x+1][x].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x+1][x].setHorizontalAlignment(JLabel.CENTER);
			tablero[x+1][x].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x+1][x]=personaje;				
		}
		else if(tableroIndice[x+1][x-1]==2) {
			tablero[x+1][x-1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x+1][x-1].setHorizontalAlignment(JLabel.CENTER);
			tablero[x+1][x-1].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x+1][x-1]=personaje;				
		}
		else if(tableroIndice[x][x-1]==2) {
			tablero[x][x-1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x][x-1].setHorizontalAlignment(JLabel.CENTER);
			tablero[x][x-1].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x][x-1]=personaje;				
		}
		else if(tableroIndice[x-1][x-1]==2) {
			tablero[x-1][x-1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x-1][x-1].setHorizontalAlignment(JLabel.CENTER);
			tablero[x-1][x-1].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x-1][x-1]=personaje;			
		}
		else if(tableroIndice[x-1][x]==2) {
			tablero[x-1][x].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x-1][x].setHorizontalAlignment(JLabel.CENTER);
			tablero[x-1][x].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x-1][x]=personaje;			
		}
		else if(tableroIndice[x-1][x+1]==2) {
			tablero[x-1][x+1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x-1][x+1].setHorizontalAlignment(JLabel.CENTER);
			tablero[x-1][x+1].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x-1][x+1]=personaje;			
		}		
		else if(tableroIndice[x][x-2]==2) {
			tablero[x][x-2].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x][x-2].setHorizontalAlignment(JLabel.CENTER);
			tablero[x][x-2].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x-2][x]=personaje;			
		}
		else if(tableroIndice[x+1][x-2]==2) {
			tablero[x+1][x-2].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x+1][x-2].setHorizontalAlignment(JLabel.CENTER);
			tablero[x+1][x-2].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x+1][x-2]=personaje;			
		}		
		else if(tableroIndice[x-1][x-2]==2) {
			tablero[x-1][x-2].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x-1][x-2].setHorizontalAlignment(JLabel.CENTER);
			tablero[x-1][x-2].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x-1][x-2]=personaje;			
		}
		else if(tableroIndice[x-2][x]==2) {
			tablero[x-2][x].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x-2][x].setHorizontalAlignment(JLabel.CENTER);
			tablero[x-2][x].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x-2][x]=personaje;			
		}
		else if(tableroIndice[x-2][x+1]==2) {
			tablero[x-2][x+1].setIcon(new ImageIcon(getClass().getResource(ruta)));					
			tablero[x-2][x+1].setHorizontalAlignment(JLabel.CENTER);
			tablero[x-2][x+1].setVerticalAlignment(JLabel.CENTER);
			tableroIndice[x-2][x+1]=personaje;			
		}
	}	
	public void limpiarTablero(int tam) {
		this.tam=tam;		
		for(int i=0; i<tam; i++) {
			for (int j = 0; j < tam; j++) {
				tablero[i][j].setIcon(null);				
				tableroIndice[i][j]=2;
			}
		}
	}		
	public void aggJugadores(int tam) {					
		while(personajes!=0) {			
		int fila = (int) Math.floor(Math.random()*(tam));
		int columna = (int) Math.floor(Math.random()*(tam));					
			if(tableroIndice[fila][columna]==2 && mago1) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/mago.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna]=31;
				mago1=false;
				personajes--;
			}			
			else if(tableroIndice[fila][columna]==2 && mago2) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/mago1.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna]=32;
				mago2=false;
				personajes--;
			}			
			else if(tableroIndice[fila][columna]==2 && p1) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/princesa.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna]=11;
				p1=false;
				personajes--;
			}			
			else if(tableroIndice[fila][columna]==2 && p2) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/princesa1.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna]=12;
				p2=false;
				personajes--;
			}			
			else if(tableroIndice[fila][columna]==2 && c1) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/caballero.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna] = 21;
				c1=false;
				personajes--;
			}			
			else if(tableroIndice[fila][columna]==2 && c2) {
				tablero[fila][columna].setIcon(new ImageIcon(getClass().getResource("/imagenes/caballero1.png")));
				tablero[fila][columna].setHorizontalAlignment(JLabel.CENTER);
				tablero[fila][columna].setVerticalAlignment(JLabel.CENTER);
				tableroIndice[fila][columna]= 22 ;
				c2=false;
				personajes--;
			}			
		}
	}			
	public void iMat(int tam) {
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				System.out.print(" " + tableroIndice[i][j] + " ");				
			}
				System.out.println(" ");				
		}
			System.out.println("---------------------");
	}				
	public void paintComponent(Graphics g) {
		super.paintComponent(g);					
		int width = this.getSize().width;
		int height = this.getSize().height;		
		try {		
			fondo = ImageIO.read(getClass().getResource("/imagenes/fondo.jpg"));
		}
		catch(IOException e) {
			System.out.println("No se encuentra la imagen");
		}
		g.drawImage(fondo,0,0,width,height,null);		
	}				
}
