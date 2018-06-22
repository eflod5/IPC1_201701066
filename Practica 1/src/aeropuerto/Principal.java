package aeropuerto;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import lista.*;

public class Principal extends JFrame implements ActionListener{

	private JPanel panelFunciones, panelConsola;
	private JTextField cAviones,cEstaciones;
	private JButton bEmpezar,bPasarTurno;
	private JTextArea aConsola;
	private static ListaAviones lAvion;
	private static ColaPasajero cPasajero;
	private static ListaMaletas lMaletas;
	private int cantAviones,turno=0,n=1,contador;
	private int pasajeros,desabordaje,mantenimiento,maletas,documentos;
	private String tam;
	
	public Principal() {
		super("AEROPUERTO");
		init();
		lAvion = new ListaAviones();
		cPasajero = new ColaPasajero();
		lMaletas = new ListaMaletas();
	}
	public void init() {
		setLayout(null);
		setSize(900,650);
		add(panelFunciones());
		add(panelConsola());
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);		
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
		
		cAviones = new JTextField();
		cAviones.setBounds(210, 70, 40, 20);
		cAviones.setVisible(true);
		panelFunciones.add(cAviones);
		
		cEstaciones = new JTextField();
		cEstaciones.setBounds(210, 120, 40, 20);
		cEstaciones.setVisible(true);
		panelFunciones.add(cEstaciones);
		
		bEmpezar = new JButton("Empezar");
		bEmpezar.setBounds(60, 180, 85, 25);
		bEmpezar.setVisible(true);
		bEmpezar.addActionListener(this);
		panelFunciones.add(bEmpezar);
		
		bPasarTurno = new JButton("Pasar Turno");
		bPasarTurno.setBounds(180, 180, 105, 25);
		bPasarTurno.setVisible(true);
		bPasarTurno.addActionListener(this);
		panelFunciones.add(bPasarTurno);
		
		return panelFunciones;
	}

	public JPanel panelConsola() {
		panelConsola = new JPanel();	
		panelConsola.setBounds(400, 0, 500, 650);		
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
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bEmpezar) {
			cantAviones = Integer.parseInt(cAviones.getText());
			
		}
		else if(e.getSource()==bPasarTurno) {						
			lAvion.bajaTurno();
			lAvion.eliminaAvion();
			sacaPasajeros();
			agregarAviones();			
			turno++;						
			imprimir();			
		}
	}
	
	public void determinaTam() {
		int x = (int)(Math.random()*3+1);
		if(x==1) {
			tam = "Peque�o";
			desabordaje = 1;
			pasajeros = (int) Math.floor(Math.random()*(10-5+1)+5);
			mantenimiento = (int)(Math.random()*3+1);
		}
		else if(x==2) {
			tam = "Mediano";
			desabordaje = 2;
			pasajeros = (int) Math.floor(Math.random()*(25-15+1)+15);
			mantenimiento =  (int) Math.floor(Math.random()*(4-2+1)+2);
		}
		else if(x==3) {
			tam ="Grande";
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
	
	public void sacaPasajeros() {
		int x =5;
		while(x!=0) {
			cPasajero.eliminarPasajero();			
			x--;
		}
		lMaletas.eliminar(1);
	}
	
	public void agregarPasajeros() {
		contador+=pasajeros;
		for (int i = (contador- pasajeros+1); i < (contador+1) ; i++) {
			determinarDoc();
			cPasajero.setPasajero(i, maletas, documentos);
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
	}
	
	public void imprimir() {
		aConsola.append("\n+++++++++++++++++TURNO " + turno + "++++++++++++++++\n");
		aConsola.append("----------- AVIONES -----------\n");
		lAvion.printAviones(aConsola);
		aConsola.append("----------- PASAJEROS -----------\n");
		cPasajero.printPasajero(aConsola);
		aConsola.append("---------MALETAS---------\n");
		lMaletas.printMaletas(aConsola);
	}

private int contadorMaletas,numeroMaleta=1;
}