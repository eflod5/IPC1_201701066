package aeropuerto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lista.*;

public class Principal extends JFrame implements ActionListener{

	private JPanel panelFunciones, panelConsola;
	private JTextField cAviones,cEstaciones,cEscritorios;
	private JButton bEmpezar,bPasarTurno;
	private JTextArea aConsola;
	private JMenuBar menu;
	private JMenu Graficas;
	private JMenuItem JLlegadaAviones,JDesabordaje,JEscritorios,JEquipaje,JMantenimiento,JTodo;
	private ListaAviones lAvion;
	private ColaPasajero cPasajero;
	private ListaMaletas lMaletas;
	private ListaEscritorio lEscritorio;
	private ColaAvion cAvion;
	private ListaMantenimiento lMantenimiento;	
	private int cantAviones,turno=0,n=1,contador,cantEstaciones,pasajeros,desabordaje,mantenimiento,maletas,documentos,turnosRegistro,cantEscritorios;
	public static final String pequeño="Pequeño",mediano="Mediano",grande="Grande";
	public static final int salidaPasajero=5;
	private String tam;
	
	public Principal() {
		super("AEROPUERTO");
		init();		
	}
	public void init() {
		setLayout(null);
		setSize(900,650);
		add(jMenuBar());
		add(panelFunciones());
		add(panelConsola());		
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
	}
	
	public JMenuBar jMenuBar() {
		menu = new JMenuBar();
		Graficas = new JMenu("Graficas");
		
		JLlegadaAviones = new JMenuItem("Llegada Aviones");
		JLlegadaAviones.addActionListener(this);
		
		JDesabordaje = new JMenuItem("Desabordaje");
		JDesabordaje.addActionListener(this);
		
		JEscritorios = new JMenuItem("Escritorios");
		JEscritorios.addActionListener(this);
		
		JEquipaje = new JMenuItem("Equipaje");
		JEquipaje.addActionListener(this);
		
		JMantenimiento = new JMenuItem("Mantenimiento");
		JMantenimiento.addActionListener(this);
		
		JTodo = new JMenuItem("Sistema Completo");
		JTodo.addActionListener(this);
		
		
		Graficas.add(JLlegadaAviones);		
		Graficas.add(JDesabordaje);
		Graficas.add(JEscritorios);
		Graficas.add(JEquipaje);
		Graficas.add(JMantenimiento);
		Graficas.add(JTodo);
		
		menu.add(Graficas);
		menu.setBounds(0, 0, 900, 30);		
		return menu;
	}
	
	public JPanel panelFunciones() {
		panelFunciones = new JPanel();
		panelFunciones.setBounds(0, 0, 400, 650);
		panelFunciones.setLayout(null);
		panelFunciones.setVisible(true);		
		
		JLabel labelAviones = new JLabel("Cantidad de Aviones");
		labelAviones.setBounds(40, 70, 170, 20);
		labelAviones.setVisible(true);
		panelFunciones.add(labelAviones);
		
		JLabel labelEstaciones = new JLabel("Cantidad de Estaciones");
		labelEstaciones.setBounds(40, 120, 170, 20);
		labelEstaciones.setVisible(true);
		panelFunciones.add(labelEstaciones);
		
		JLabel labelEscritorios = new JLabel("Cantidad de Escritorios");
		labelEscritorios.setBounds(40, 170, 170, 20);
		labelEscritorios.setVisible(true);
		panelFunciones.add(labelEscritorios);
		
		cAviones = new JTextField();
		cAviones.setBounds(210, 70, 40, 20);
		cAviones.setVisible(true);
		panelFunciones.add(cAviones);
		
		cEstaciones = new JTextField();
		cEstaciones.setBounds(210, 120, 40, 20);
		cEstaciones.setVisible(true);
		panelFunciones.add(cEstaciones);
		
		cEscritorios = new JTextField();
		cEscritorios.setBounds(210, 170, 40, 20);
		cEscritorios.setVisible(true);
		panelFunciones.add(cEscritorios);
		
		bEmpezar = new JButton("Empezar");
		bEmpezar.setBounds(60, 210, 85, 25);
		bEmpezar.setVisible(true);
		bEmpezar.addActionListener(this);
		panelFunciones.add(bEmpezar);
		
		bPasarTurno = new JButton("Pasar Turno");
		bPasarTurno.setBounds(180, 210, 105, 25);
		bPasarTurno.setVisible(true);
		bPasarTurno.addActionListener(this);
		panelFunciones.add(bPasarTurno);
		
		return panelFunciones;
	}

	public JPanel panelConsola() {
		panelConsola = new JPanel();	
		panelConsola.setBounds(400, 30, 500, 650);		
		panelConsola.setLayout(null);
		panelConsola.setVisible(true);		
		
		JLabel lConsola = new JLabel("CONSOLA");
		lConsola.setBounds(10, 20, 60, 20);
		lConsola.setVisible(true);
		panelConsola.add(lConsola);
		
		aConsola = new JTextArea();				
		aConsola.setBackground(Color.black);
		aConsola.setForeground(Color.white);
		aConsola.setEditable(false);
				
		JScrollPane scroll = new JScrollPane(aConsola);
		scroll.setBounds(10, 50, 380, 480);
		scroll.setVisible(true);
		panelConsola.add(scroll);
		
		return panelConsola;
	}	
	boolean iniciado = false;
	
	public void determinaTam() {
		int x = (int)(Math.random()*3+1);
		if(x==1) {
			tam = pequeño;
			desabordaje = 1;
			pasajeros = (int) Math.floor(Math.random()*(10-5+1)+5);
			mantenimiento = (int)(Math.random()*3+1);
		}
		else if(x==2) {
			tam = mediano;
			desabordaje = 2;
			pasajeros = (int) Math.floor(Math.random()*(25-15+1)+15);
			mantenimiento =  (int) Math.floor(Math.random()*(4-2+1)+2);
		}
		else if(x==3) {
			tam = grande;
			desabordaje=3;
			pasajeros = (int) Math.floor(Math.random()*(40-30+1)+30);
			mantenimiento =  (int) Math.floor(Math.random()*(6-3+1)+3);
		}
	}
	
	public void agregarAviones() {		
		if(cantAviones>0) {			
			determinaTam();
			lAvion.setAvion(n,tam, pasajeros, desabordaje, mantenimiento);
			n++;
			cantAviones--;
			agregarPasajeros();
			agregarMaletas();
		}									
	}
	
	public void agregarEstaciones() {		
		while(cantEstaciones!=0) {
			lMantenimiento.iniciarLista(cantEstaciones);
			cantEstaciones--;
		}
	}
	
	public void agregarEscritorios() {			
		while(cantEscritorios!=0) {			
			lEscritorio.iniciarLista();
			cantEscritorios--;
		}
	}
	
	public void sacaPasajeros(int cantidad) {
		if(cantidad>0) {
			//lMaletas.eliminarMaleta(cPasajero.getMaletas());
			if(lEscritorio.determinaEspacio()) {
				lEscritorio.agregarPasajerosCola((Pasajero)cPasajero.quitar());
			}
			else {
				lMaletas.eliminarMaleta(cPasajero.getMaletas());
				cPasajero.eliminarPasajero();	
			}			
			sacaPasajeros(cantidad-1);
		}
	}
	
	public void agregarPasajeros() {
		contador+=pasajeros;
		for (int i = (contador- pasajeros+1); i < (contador+1) ; i++) {
			determinarDoc();
			cPasajero.setPasajero(i, maletas, documentos,turnosRegistro);
			contadorMaletas+=maletas;
		}		
	}
	
	public void agregarMaletas() {		
		while(contadorMaletas!=0) {
			lMaletas.setMaleta(numeroMaleta);			
			numeroMaleta++;
			contadorMaletas--;
		}
	}
		
	
	public void determinarDoc() {
		maletas = (int)(Math.random()*4+1);
		documentos = (int)(Math.random()*10+1);	
		turnosRegistro = (int)(Math.random()*3+1);
	}
	
	public void imprimir() {
		aConsola.append("\n+++++++++++++++++ TURNO " + turno + "++++++++++++++++\n");
		aConsola.append("----------- AVIONES -----------\n");
		lAvion.printAviones(aConsola);
		aConsola.append("----------- PASAJEROS -----------\n");
		cPasajero.printPasajero(aConsola);
		aConsola.append("---------MALETAS---------\n");
		lMaletas.printMaletas(aConsola);
		aConsola.append("\n---------ESTACIONES---------\n");
		lMantenimiento.printListaMantenimiento(aConsola);
		aConsola.append("\n---------COLA---------\n");
		cAvion.printColaAviones(aConsola);
		aConsola.append("\n-----------ESCRITORIOS---------\n");
		lEscritorio.printListaEscritorio(aConsola);
		aConsola.append("\n+++++++++++++++++ FIN TURNO " + turno + "++++++++++++++++\n");		
	}

	public void comprobarVacio() {
		if(lAvion.estaVacia() && cAvion.estaVacia() && lMaletas.estaVacia() && cPasajero.estaVacia() && lMantenimiento.estaVacio()) {
			JOptionPane.showMessageDialog(null, "Simulación finalizada con éxito","Fin",JOptionPane.INFORMATION_MESSAGE);
		}		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bEmpezar) {
			turno=0;
			n=1;
			contador=0;
			numeroMaleta=1;
			aConsola.setText("");
			lAvion = new ListaAviones();
			cPasajero = new ColaPasajero();
			lMaletas = new ListaMaletas();
			lMantenimiento = new ListaMantenimiento();
			cAvion = new ColaAvion();
			lEscritorio = new ListaEscritorio();
			iniciado = false;
			try {
				cantAviones = Integer.parseInt(cAviones.getText());
				cantEstaciones = Integer.parseInt(cEstaciones.getText());
				cantEscritorios = Integer.parseInt(cEscritorios.getText()); 
				
			}
			catch(NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Unicamente se permiten numeros","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			agregarEstaciones();
			agregarEscritorios();
		}
		
		else if(e.getSource()==bPasarTurno) {						
			if(!iniciado) {
				agregarAviones();			
				turno++;						
				imprimir();
				iniciado = true;
				graficar();
				return ;
			}			
			lAvion.bajaTurno();
			lMantenimiento.bajarTurno();			
			lEscritorio.bajarTurno(lMaletas);
			
			int x = 5;
			while(x!=0) {
			lAvion.eliminaAvion(cAvion);
			lMantenimiento.terminaMantenimiento();
			cAvion.pasarMantenimiento(lMantenimiento);
			x--;
			}
			
			sacaPasajeros(salidaPasajero);
			lEscritorio.addPasajeros();
			lEscritorio.estaDisponible();
			agregarAviones();			
			turno++;						
			imprimir();
			comprobarVacio();
			graficar();
													
			//g.crearDot(lAvion.getPrimero(), "listaDoble");
			//g.generarImagen("listaDoble.dot", "listaDobl.png");
			//g.crearDotColaAvion(cAvion.getInicioNodo(), "colaAvion");
			//g.generarImagen("colaAvion.dot", "colaAvion.png");
			//g.crearDotListaMaleta(lMaletas.getInicioNodo(), lMaletas.getInicioNodo(), "colaMaleta");
		//g.generarImagen("colaMaleta.dot", "colaMaleta.png");							
		}
		else if(e.getSource()==JLlegadaAviones) {
			ruta = "C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaDobl.png";
			ImageIcon icono = new ImageIcon(ruta);
			icono.getImage().flush();
			String titulo = "LLEGADA AVIONES";
			FrameGraficas frameGraficas = new FrameGraficas(icono,titulo);
		}
		else if (e.getSource()==JDesabordaje) {
			ruta ="C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\colaPasajero.png";
			ImageIcon icono =new ImageIcon(ruta);
			icono.getImage().flush();			
			String titulo = "DESABORDAJE";
			FrameGraficas frameGraficas = new FrameGraficas(icono,titulo);
		}
		else if(e.getSource()==JEscritorios) {
			ruta ="C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaEscritorio.png";
			ImageIcon icono = new ImageIcon(ruta);
			icono.getImage().flush();
			String titulo = "ESCRITORIOS DE REGISTRO";
			FrameGraficas frameGraficas = new FrameGraficas(icono,titulo);
		}
		else if(e.getSource()==JMantenimiento) {
			ruta ="C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaMantenimiento.png";
			ImageIcon icono = new ImageIcon(ruta);
			icono.getImage().flush();
			String titulo = "MANTENIMIENTO";
			FrameGraficas frameGraficas = new FrameGraficas(icono,titulo);
		}
		else if(e.getSource()==JEquipaje) {
			ruta ="C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaEquipaje.png";
			ImageIcon icono = new ImageIcon(ruta);
			icono.getImage().flush();
			String titulo = "EQUIPAJE";
			FrameGraficas frameGraficas = new FrameGraficas(icono,titulo);
		}
	}
	
	public void graficar() {
		Graficador g = new Graficador();
		g.crearDot(lAvion.getPrimero(), "listaDoble.dot");
		g.generarImagen("listaDoble.dot", "C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaDobl.png");
		
		g.crearDesabordaje(cPasajero.getInicioNodo(), "colaPasajero.dot");
		g.generarImagen("colaPasajero.dot", "C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\colaPasajero.png");
		
		g.crearDotMantenimiento(lMantenimiento.getInicioNodo(), "listaMantenimiento.dot",cAvion.getInicioNodo());
		g.generarImagen("listaMantenimiento.dot", "C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaMantenimiento.png");
	
		g.crearDotEscritorio(lEscritorio.getInicioNodo(), "listaEscritorio.dot");
		g.generarImagen("listaEscritorio.dot", "C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaEscritorio.png");
	
		g.crearDotListaMaleta(lMaletas.getInicioNodo(), lMaletas.getInicioNodo(), "colaMaleta");
		g.generarImagen("colaMaleta.dot", "C:\\Users\\Erik Flores\\Desktop\\Nueva carpeta\\IPC1_201701066\\Proyecto 2\\src\\imagenes\\listaEquipaje.png");
	}
	
	private String ruta;
	private int contadorMaletas,numeroMaleta=1;
}