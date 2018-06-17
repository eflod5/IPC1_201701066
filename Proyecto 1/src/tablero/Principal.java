package tablero;
import java.awt.*;
import objetos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class Principal extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Tablero tablero;	
	private JPanel funciones;
	private JMenuBar menu;
	private JMenu inicio,opcionesMenu,top10;
	private JMenuItem juegoNuevo,salir,configuracion,pausar,reanudar,terminarJuego;
	private JButton arriba,abajo,izquierda,derecha,tirar,atacar,terminar,atacaArriba,atacaAbajo,atacaIzquierda,atacaDerecha;
	private JLabel labelTiempo, labelJ1,labelJ2,labelP1,labelP2,labelP3,labelP1J2,labelP2J2,labelP3J2;
	private boolean iniciado = true;
	private Cronometro cronometro;
	private Opciones opciones;	
	private Turno turno;	
	private int direccion=0;	
	public String p1,p2,p3,p11,p22,p33,r1j1,r2j1,r3j1,r1j2,r2j2,r3j2,ruta;
	private boolean a,b,c,aa,bb,cc;
	public boolean turnoJ1,turnoJ2;
	private int p1j1,p2j1,p3j1,p1j2,p2j2,p3j2,x,dim,personaje;	
	public int vidaJ1,vidaJ2,espera1=1,espera2=1;
	public Vida vidas;		
	public Jugador[] vecJugador;
	public boolean vectorCreado=false;
	public Top10 top;
	
	public Principal() {
		super("Arcade Game");		
		dim=14;
		iniciado=true;
		tablero = new Tablero(dim);					
		cronometro = new Cronometro(tablero,this);		
		this.getContentPane().add(cronometro).setVisible(true);
		this.getContentPane().add(tablero).setVisible(true);
		add(getJMenuBar());
		add(getPanelFunciones());
		init();						
	}	
	
	public void terminarJuego() {		
		arriba.setEnabled(false);
		abajo.setEnabled(false);
		izquierda.setEnabled(false);
		derecha.setEnabled(false);
		tirar.setEnabled(false);
		atacar.setEnabled(false);
		terminar.setEnabled(false);
		tablero.setVisible(false);
		funciones.setVisible(false);
		vidas.getPanelJ1().setVisible(false);
		vidas.getPanelJ2().setVisible(false);
			
			labelP1.setBackground(null);			
			labelP2.setBackground(null);
			labelP3.setBackground(null);
			labelP1J2.setBackground(null);
			labelP2J2.setBackground(null);
			labelP3J2.setBackground(null);
			atacar.setEnabled(false);
			System.out.println(cronometro.getMinutos() + "" + cronometro.getSegundos());
		cronometro.pararCronometro();		
		this.getContentPane().add(cronometro).setVisible(false);
		
		if(vidaJ1>vidaJ2) {
			JOptionPane.showMessageDialog(null, "Ganador: " + opciones.getNombreJ1(), "GANADOR", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (vidaJ2>vidaJ1) {
			JOptionPane.showMessageDialog(null, "Ganador: " + opciones.getNombreJ2(), "GANADOR", JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			JOptionPane.showMessageDialog(null, "Ganador: " + opciones.getNombreJ1() + " Y " + opciones.getNombreJ2(), "EMPATE", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void init() {
		setLayout(null);
		setSize(900,650);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
		
	public void prueba() {
		top = new Top10();
		top.crear();
		
		try {
			vecJugador=top.optenerJugadores("Top10.txt");
		}
		catch(IOException ex){		
		}
		
		
		int tam = vecJugador.length;
		for(int i =0; i<tam;i++) {
			System.out.println(i + " " + vecJugador[i].getGanador());
		}
		vectorCreado=true;
	}
	
	public JMenuBar getJMenuBar(){
		menu = new JMenuBar();
		inicio = new JMenu("Inicio");		
		opcionesMenu = new JMenu("Opciones");
		top10 = new JMenu("Top 10");
		
		terminarJuego = new JMenuItem("Terminar Juego");
		terminarJuego.addActionListener(this);
		
		juegoNuevo = new JMenuItem("Juego Nuevo");
		juegoNuevo.addActionListener(this);
		
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		
		configuracion = new JMenuItem("Configuracion");
		configuracion.addActionListener(this);
		
		
		pausar = new JMenuItem("Pausar");
		pausar.setEnabled(false);
		pausar.addActionListener(this);
		reanudar = new JMenuItem("Reanudar");
		reanudar.setEnabled(false);
		reanudar.addActionListener(this);
						
		inicio.add(juegoNuevo);
		inicio.add(terminarJuego);
		inicio.add(salir);		
		
		opcionesMenu.add(configuracion);		
		opcionesMenu.add(pausar);
		opcionesMenu.add(reanudar);
				
		menu.add(inicio);		
		menu.add(opcionesMenu);
		menu.add(top10);		
		menu.setBounds(0, 0, 900,30);		
		return menu;
	}

	public JPanel getPanelFunciones() {
		int x=10, xc=80, xd=150;		
		int ya=380, y=440, ye=410;
		int width = 80, height=25;
		
		funciones = new JPanel();
		funciones.setBounds(560, 120, 320, 500);
		funciones.setLayout(null);							
		
		arriba = new JButton("Arriba");
		arriba.setBounds(xc, ya, width, height);
		arriba.addActionListener(this);
		arriba.setEnabled(false);
		funciones.add(arriba);		
		
		abajo = new JButton("Abajo");
		abajo.setBounds(xc, y, width, height);
		abajo.addActionListener(this);
		abajo.setEnabled(false);
		funciones.add(abajo);
		
		derecha = new JButton("Derecha");
		derecha.setBounds(xd, ye, width, height);
		derecha.addActionListener(this);
		derecha.setEnabled(false);
		funciones.add(derecha);
		
		izquierda = new JButton("Izquierda");
		izquierda.setBounds(x, ye, width, height);
		izquierda.addActionListener(this);
		izquierda.setEnabled(false);
		funciones.add(izquierda);
		
		tirar = new JButton("Tirar");
		tirar.setBounds(20, 345, width, height);
		tirar.addActionListener(this);
		funciones.add(tirar);
		
		terminar = new JButton("Terminar");
		terminar.setBounds(220, 345, width, height);
		terminar.addActionListener(this);
		terminar.setEnabled(false);
		funciones.add(terminar);
		
		atacar = new JButton("Atacar");
		atacar.setBounds(120, 345, width, height);
		atacar.addActionListener(this);
		atacar.setEnabled(false);
		funciones.add(atacar);
		
		labelTiempo=new JLabel();
		labelTiempo.setBounds(20, 250, 70, 70);
		labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/dados.png")));
		funciones.add(labelTiempo);
		
		atacaArriba = new JButton();
		atacaArriba.setBounds(190, 240, 20, 20);
		atacaArriba.addActionListener(this);
		funciones.add(atacaArriba);
		
		atacaAbajo = new JButton();
		atacaAbajo.setBounds(190, 280, 20, 20);
		atacaAbajo.addActionListener(this);
		funciones.add(atacaAbajo);
		
		atacaDerecha = new JButton();
		atacaDerecha.setBounds(210, 260, 20, 20);
		atacaDerecha.addActionListener(this);
		funciones.add(atacaDerecha);
		
		atacaIzquierda = new JButton();
		atacaIzquierda.setBounds(170, 260, 20, 20);
		atacaIzquierda.addActionListener(this);
		funciones.add(atacaIzquierda);
		
		atacaDerecha.setEnabled(false);
		 atacaIzquierda.setEnabled(false);
		 atacaArriba.setEnabled(false);
		 atacaAbajo.setEnabled(false);
		
		labelJ1 = new JLabel();
			labelP1 = new JLabel();
			labelP2 = new JLabel();
			labelP3 = new JLabel();
		
		labelJ1.setBounds(10, 10, 80, 20);
		labelJ1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		funciones.add(labelJ1);				
			
			labelP1.setBounds(200, 30, 80, 20);
			labelP1.setBorder(BorderFactory.createLineBorder(Color.black));
			funciones.add(labelP1);
			
			labelP2.setBounds(200, 60, 80, 20);
			labelP2.setBorder(BorderFactory.createLineBorder(Color.black));
			funciones.add(labelP2);
			
			labelP3.setBounds(200, 90, 80, 20);
			labelP3.setBorder(BorderFactory.createLineBorder(Color.black));
			funciones.add(labelP3);
		
		
			vidas = new Vida();
			
			vidas.getPanelJ1().setVisible(true);			
			funciones.add(vidas.getPanelJ1());
					
			vidas.getPanelJ2().setVisible(true);		
			funciones.add(vidas.getPanelJ2());
			
			
		labelJ2 = new JLabel();
			labelP1J2 = new JLabel();
			labelP2J2 = new JLabel();
			labelP3J2 = new JLabel();
		
		labelJ2.setBounds(10, 110, 80, 20);
		labelJ2.setBorder(BorderFactory.createLineBorder(Color.black));
		funciones.add(labelJ2);
		
			labelP1J2.setBounds(200, 140, 80, 20);
			labelP1J2.setBorder(BorderFactory.createLineBorder(Color.black));
			funciones.add(labelP1J2);
			
			labelP2J2.setBounds(200, 170, 80, 20);
			labelP2J2.setBorder(BorderFactory.createLineBorder(Color.black));
			funciones.add(labelP2J2);
			
			labelP3J2.setBounds(200, 200, 80, 20);
			labelP3J2.setBorder(BorderFactory.createLineBorder(Color.black));
			funciones.add(labelP3J2);

		funciones.setVisible(false);					
		return funciones;	
	}	
	
	public void addNombres() {
		labelJ1.setText(opciones.getNombreJ1());
		labelJ2.setText(opciones.getNombreJ2());		
		labelP1.setText(opciones.getPersonaje1J1());
		p1=opciones.getPersonaje1J1();
		labelP2.setText(opciones.getPersonaje2J1());
		p2=opciones.getPersonaje2J1();
		labelP3.setText(opciones.getPersonaje3J1());
		p3=opciones.getPersonaje3J1();
		labelP1J2.setText(opciones.getPersonaje1J2());
		p11=opciones.getPersonaje1J2();
		labelP2J2.setText(opciones.getPersonaje2J2());
		p22=opciones.getPersonaje2J2();
		labelP3J2.setText(opciones.getPersonaje3J2());
		p33=opciones.getPersonaje3J2();			
	}
	
	public void iniciar() {
		if(iniciado) {
			JOptionPane.showMessageDialog(null,"Defina las configuraciones antes de empezar","Eror",JOptionPane.WARNING_MESSAGE);
		}		
		else if(!iniciado) {			
			dim=opciones.getDimension();			
			if(cronometro.cronometroActivo) {
				cronometro.terminarHilo();
			}
			labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/dados.png")));
			cronometro.pararCronometro();
			cronometro.comMin=opciones.getMinutos();
			cronometro.comSeg=opciones.getSegundos();
			this.remove(tablero);
			this.repaint();
			tablero = new Tablero(dim);
			this.getContentPane().add(tablero).setVisible(true);				
			funciones.setVisible(true);
			tablero.pintarBombas(dim);
			tablero.pintarVidas(dim);						
			tablero.aggJugadores(dim);
			pausar.setEnabled(true);
			reanudar.setEnabled(false);
			addNombres();
			
			turno = new Turno(p1,p2,p3,p11,p22,p33);
			turno.determinarTurnosJ1(p1,p2,p3);
			turno.determinarTurnosJ2(p11,p22,p33);							
			cronometro.iniciarCronometro();			
			tirar.setEnabled(true);
			
			turnoJ1=true;
			a=true;
			turnoJ2=false;
			aa=true;
			
			p1j1=turno.getpersonajeT1J1();
			p2j1=turno.getpersonajeT2J1();
			p3j1=turno.getpersonajeT3J1();
			p1j2=turno.getpersonajeT1J2();
			p2j2=turno.getpersonajeT2J2();
			p3j2=turno.getpersonajeT3J2();
			r1j1=turno.getrutaT1J1();
			r2j1=turno.getrutaT2J1();
			r3j1=turno.getrutaT3J1();
			r1j2=turno.getrutaT1J2();
			r2j2=turno.getrutaT2J2();
			r3j2=turno.getrutaT3J2();
			
			this.getContentPane().add(cronometro).setVisible(true);
			vidaJ1 =5;
			vidaJ2 =5;
			
			vidas.getPanelJ1().setVisible(true);		
			vidas.getPanelJ2().setVisible(true);		
			vidas.aggVidasJ1(vidaJ1);
			vidas.aggVidasJ2(vidaJ2);
		}
	}
	
	public void tirarDados() {
		int i=100;		
		x = (int) (Math.random()*6+1);		
		if(x==1) {
			labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/uno.png")));
		}
		else if(x==2) {
			labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/dos.png")));
		}
		else if(x==3) {
			labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/tres.png")));
		}
		else if(x==4) {
			labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/cuatro.png")));
		}
		else if(x==5) {
			labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/cinco.png")));
		}
		else if(x==6) {
			labelTiempo.setIcon(new ImageIcon(getClass().getResource("/imagenes/seis.png")));
		}		
		arriba.setEnabled(true);
		abajo.setEnabled(true);
		derecha.setEnabled(true);
		izquierda.setEnabled(true);
		tirar.setEnabled(false);
	}	
	public void determinaTurno() {			
		
		if(turnoJ1) {
			if(a) {
				personaje = p1j1;
				ruta = r1j1;
				turnoJ1 = false;
				turnoJ2=true;
				a=false;
				b=true;
				c=false;				
				labelP1.setBackground(Color.GRAY);
				labelP1.setOpaque(true);
				labelP2.setBackground(null);
				labelP3.setBackground(null);
				labelP1J2.setBackground(null);
				labelP2J2.setBackground(null);
				labelP3J2.setBackground(null);
			}			
			else if(b) {
				personaje = p2j1;
				ruta = r2j1;
				turnoJ1=false;
				turnoJ2=true;
				a=false;
				b=false;
				c=true;		
				labelP2.setBackground(Color.GRAY);
				labelP2.setOpaque(true);
				labelP1.setBackground(null);
				labelP3.setBackground(null);
				labelP1J2.setBackground(null);
				labelP2J2.setBackground(null);
				labelP3J2.setBackground(null);
			}
			else if(c) {
				personaje = p3j1;
				ruta = r3j1;
				turnoJ1=false;
				turnoJ2=true;
				a=true;
				b=false;
				c=false;		
				labelP3.setBackground(Color.GRAY);
				labelP3.setOpaque(true);
				labelP2.setBackground(null);
				labelP1.setBackground(null);
				labelP1J2.setBackground(null);
				labelP2J2.setBackground(null);
				labelP3J2.setBackground(null);
			}
		}		
		else if(turnoJ2) {	
			if(aa) {
				personaje = p1j2;
				ruta = r1j2;
				turnoJ1=true;
				turnoJ2=false;
				aa=false;
				bb=true;
				cc=false;
				labelP1J2.setBackground(Color.GRAY);
				labelP1J2.setOpaque(true);
				labelP2J2.setBackground(null);
				labelP3J2.setBackground(null);
				labelP3.setBackground(null);
				labelP2.setBackground(null);
				labelP1.setBackground(null);
			}
			else if(bb) {
				personaje = p2j2;
				ruta = r2j2;
				turnoJ1=true;
				turnoJ2=false;
				aa=false;
				bb=false;
				cc=true;
				labelP2J2.setBackground(Color.GRAY);
				labelP2J2.setOpaque(true);
				labelP1J2.setBackground(null);
				labelP3J2.setBackground(null);
				labelP3.setBackground(null);
				labelP2.setBackground(null);
				labelP1.setBackground(null);
			}
			else if(cc) {
				personaje = p3j2;
				ruta = r3j2;
				turnoJ1=true;
				turnoJ2=false;
				aa=true;
				bb=false;
				cc=false;				
				labelP3J2.setBackground(Color.GRAY);
				labelP3J2.setOpaque(true);
				labelP2J2.setBackground(null);
				labelP1J2.setBackground(null);
				labelP3.setBackground(null);
				labelP2.setBackground(null);
				labelP1.setBackground(null);
			}
		}
	}	
	
	public void moverArriba() {
		direccion = 0;		
		Movimiento mov = new Movimiento(x,tablero,direccion,personaje,ruta,this);			
		mov.start();
	}
	
	public void moverAbajo() {
		direccion = 1;
		 Movimiento mov = new Movimiento(x,tablero,direccion,personaje,ruta,this);
		 mov.start();		 
	}
	
	public void moverDerecha() {
		 direccion = 2;			 
		 Movimiento mov = new Movimiento(x,tablero,direccion,personaje,ruta,this);
		 mov.start();
		 
	}
	
	public void moverIzquierda() {
		direccion = 3;			 
		Movimiento mov = new Movimiento(x,tablero,direccion,personaje,ruta,this);
		mov.start();		
	}
	
	public void agregarVidas(int jugador) {
		if(jugador==1) {
			vidaJ1++;	
			vidas.aggVidasJ1(vidaJ1);
		}
		else if(jugador==2) {
			vidaJ2++;			
			vidas.aggVidasJ2(vidaJ2);
		}
		else {
			
		}
	}
	
	public void quitarVidas(int jugador) {
		if(jugador==1) {
			vidaJ1--;	
			vidas.aggVidasJ1(vidaJ1);
		}
		else if(jugador==2) {
			vidaJ2--;		
			vidas.aggVidasJ2(vidaJ2);
		}
		else {
			
		}
	}
	
	public void quitarVidaAtaque(int jugador) {
		if(jugador==1) {
			vidaJ2--;
			vidas.aggVidasJ2(vidaJ2);
		}
		else if(jugador==2) {
			vidaJ1--;
			vidas.aggVidasJ1(vidaJ1);
		}	
	}
	
	public void siguienteTurno() {
		//agregarVidas();
		//quitarVidas();
		//vidas.aggVidasJ1(vidaJ1);
		//vidas.aggVidasJ2(vidaJ2);
		tirar.setEnabled(true);	
		prueba();
	}
	
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getSource()==juegoNuevo) {					
			iniciar();
		 }
		
		else if(e.getSource()==configuracion) {
			iniciado = false;
			opciones = new Opciones();
		}
				
		else if(e.getSource()==arriba) {
			//tablero.limpiarTablero(dim);
			//x = (int) (Math.random()*6+1);			
			moverArriba();
			arriba.setEnabled(false);
			abajo.setEnabled(false);
			derecha.setEnabled(false);
			izquierda.setEnabled(false);	
			terminar.setEnabled(true);
			atacar.setEnabled(true);
		 }
		 else if(e.getSource()==abajo) {			 			
			 moverAbajo();
			 arriba.setEnabled(false);
			 abajo.setEnabled(false);
			 derecha.setEnabled(false);
			 izquierda.setEnabled(false);
			 terminar.setEnabled(true);
			 atacar.setEnabled(true);
		 }
		 else if(e.getSource()==derecha) {				 
			 moverDerecha();
			 arriba.setEnabled(false);
			 abajo.setEnabled(false);
			 derecha.setEnabled(false);
			 izquierda.setEnabled(false);
			 terminar.setEnabled(true);
			 atacar.setEnabled(true);
		 }		
		 else if(e.getSource()==izquierda) {
			 moverIzquierda();
			 arriba.setEnabled(false);
			 abajo.setEnabled(false);
			 derecha.setEnabled(false);
			 izquierda.setEnabled(false);
			 terminar.setEnabled(true);
			 atacar.setEnabled(true);
		 }
		 
		 else if(e.getSource()==salir) {			 
			 System.exit(1);
		 }		 
		
		 else if(e.getSource()==atacar) {
			 if(personaje==11 || personaje==12) {
				 Atacar ataque = new Atacar(tablero,personaje,this);
				 ataque.atacarPrincesa(personaje);
				 atacar.setEnabled(false);
			 }
			 else {
			 atacaDerecha.setEnabled(true);
			 atacaIzquierda.setEnabled(true);
			 atacaArriba.setEnabled(true);
			 atacaAbajo.setEnabled(true);
			 atacar.setEnabled(false);
			 }
		 }		 
		 else if(e.getSource()==atacaDerecha) {
			 Atacar ataque = new Atacar(tablero,personaje,this);
			 ataque.atacarDerecha(personaje);
			 atacaDerecha.setEnabled(false);
			 atacaIzquierda.setEnabled(false);
			 atacaArriba.setEnabled(false);
			 atacaAbajo.setEnabled(false);
		 }
		 else if(e.getSource()==atacaIzquierda) {
			 Atacar ataque = new Atacar(tablero,personaje,this);
			 ataque.atacarIzquierda(personaje);
			 atacaDerecha.setEnabled(false);
			 atacaIzquierda.setEnabled(false);
			 atacaArriba.setEnabled(false);
			 atacaAbajo.setEnabled(false);
		 }
		
		 else if(e.getSource()==atacaArriba) {
			 Atacar ataque = new Atacar(tablero,personaje,this);
			 ataque.atacarArriba(personaje);
			 atacaDerecha.setEnabled(false);
			 atacaIzquierda.setEnabled(false);
			 atacaArriba.setEnabled(false);
			 atacaAbajo.setEnabled(false);
		 }
		 else if(e.getSource()==atacaAbajo) {
			 Atacar ataque = new Atacar(tablero,personaje,this);
			 ataque.atacarAbajo(personaje);
			 atacaDerecha.setEnabled(false);
			 atacaIzquierda.setEnabled(false);
			 atacaArriba.setEnabled(false);
			 atacaAbajo.setEnabled(false);
		 }
		
		 else if(e.getSource()==tirar) {			 
			 determinaTurno();
			 tirarDados();			
		 }
		 else if(e.getSource()==pausar) {
			 pausar.setEnabled(false);
			 reanudar.setEnabled(true);
			 tablero.setVisible(false);
			 cronometro.paraCronometro();
			 funciones.setVisible(false);			 
		 }
		 else if(e.getSource()==reanudar) {
			 reanudar.setEnabled(false);
			 pausar.setEnabled(true);
			 tablero.setVisible(true);
			 cronometro.paraCronometro();
			 funciones.setVisible(true);
		 }
		 else if (e.getSource()==terminar) {
			 siguienteTurno();
			 terminar.setEnabled(false);
			 atacar.setEnabled(false);
			 tablero.iMat(dim);
		 }
		 else if(e.getSource()==terminarJuego) {
			 terminarJuego();
		 }
	}		
}
//tablero.pintarBombas(dim);
//tablero.pintarVidas(dim);
//tablero.aggJugadores(dim);			 
//int x = (int) (Math.random()*6+1);