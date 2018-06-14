package tablero;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.jdesktop.swingx.prompt.PromptSupport;

public class Opciones extends JFrame implements ActionListener{
	private JLabel labelNombre1, labelNombre2, personaje1, personaje2, personaje3,personaje11,personaje22,personaje33, labelTiempo,labelNivel;
	public JButton aceptar,salir;
	private JTextField nombreJ1, nombreJ2;
	private JPanel panelOpciones;	
	private SpinnerNumberModel model,modelMinutos,modelSegundos;
	private SpinnerListModel modelPersonaje1,modelPersonaje2,modelPersonaje3,modelp1,modelp2,modelp3;	
	private JSpinner spinner,spinnerMinutos,spinnerSegundos,spinnerPersonaje1,spinnerPersonaje2,spinnerPersonaje3,spinnerp1,spinnerp2,spinnerp3;	
	
	public Opciones() {
		super("Configuración");
		setSize(300,450);		
		setLayout(null);
		setLocationRelativeTo(null);
		add(getPanel());
		setVisible(true);
		setResizable(false);	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}	
	public JPanel getPanel() {		
		panelOpciones = new JPanel();
		panelOpciones.setBounds(0, 0, 300, 500);
		panelOpciones.setLayout(null);
		
		labelNombre1 = new JLabel("Jugador 1:");
		labelNombre1.setBounds(10, 10, 80, 20);
		panelOpciones.add(labelNombre1);
		
			personaje1 = new JLabel("Per. 1");
			personaje1.setBounds(30, 45, 80, 20);
			panelOpciones.add(personaje1);
			
			personaje2 = new JLabel("Per. 2");
			personaje2.setBounds(30,80,80,20);
			panelOpciones.add(personaje2);
			
			personaje3 = new JLabel("Per. 3");
			personaje3.setBounds(30,115,80,20);
			panelOpciones.add(personaje3);
		
		labelNombre2 = new JLabel("Jugador 2:");
		labelNombre2.setBounds(10, 150, 80, 20);
		panelOpciones.add(labelNombre2);
		
			personaje11 = new JLabel("Per. 1");
			personaje11.setBounds(30, 185, 80, 20);
			panelOpciones.add(personaje11);
		
			personaje22 = new JLabel("Per. 2");
			personaje22.setBounds(30, 220, 80, 20);
			panelOpciones.add(personaje22);
		
			personaje33 = new JLabel("Per. 3");
			personaje33.setBounds(30, 255, 80, 20);
			panelOpciones.add(personaje33);

		nombreJ1 = new JTextField();
		nombreJ1.setBounds(100, 10, 150, 20);		
		panelOpciones.add(nombreJ1);		
		
		nombreJ2 = new JTextField();
		nombreJ2.setBounds(100, 150, 150, 20);
		panelOpciones.add(nombreJ2);		
		
		labelTiempo = new JLabel("Tiempo de la Partida: ");
		labelTiempo.setBounds(10, 290, 160, 20);
		panelOpciones.add(labelTiempo);														
		
		labelNivel = new JLabel("Dimension: ");
		labelNivel.setBounds(10, 340, 80, 20);
		panelOpciones.add(labelNivel);
		
		aceptar = new JButton("Aceptar");
		aceptar.setBounds(10,380,100,30);
		aceptar.addActionListener(this);
		panelOpciones.add(aceptar);
		
		salir = new JButton("Salir");
		salir.setBounds(150, 380, 100, 30);
		salir.addActionListener(this);
		panelOpciones.add(salir);
		
		String[] personajes = {"Princesa", "Mago", "Caballero"};
		modelPersonaje1 = new SpinnerListModel(personajes);
		modelPersonaje2 = new SpinnerListModel(personajes);
		modelPersonaje3 = new SpinnerListModel(personajes);
		modelp1 = new SpinnerListModel(personajes);
		modelp2 = new SpinnerListModel(personajes);
		modelp3 = new SpinnerListModel(personajes);		
		
		spinnerPersonaje1 = new JSpinner(modelPersonaje1);		
		spinnerPersonaje1.setBounds(100,45,100,20);		
		panelOpciones.add(spinnerPersonaje1);
		JFormattedTextField prueba6 = ((JSpinner.DefaultEditor)spinnerPersonaje1.getEditor()).getTextField();
		prueba6.setEditable(false);
		
		spinnerPersonaje2 = new JSpinner(modelPersonaje2);
		spinnerPersonaje2.setBounds(100, 80, 100, 20);
		panelOpciones.add(spinnerPersonaje2);
		JFormattedTextField prueba7 = ((JSpinner.DefaultEditor)spinnerPersonaje2.getEditor()).getTextField();
		prueba7.setEditable(false);
		
		spinnerPersonaje3 = new JSpinner(modelPersonaje3);
		spinnerPersonaje3.setBounds(100, 115, 100, 20);
		panelOpciones.add(spinnerPersonaje3);		
		JFormattedTextField prueba8 = ((JSpinner.DefaultEditor)spinnerPersonaje3.getEditor()).getTextField();
		prueba8.setEditable(false);
		
		spinnerp1 = new JSpinner(modelp1);
		spinnerp1.setBounds(100, 185, 100, 20);
		panelOpciones.add(spinnerp1);
		JFormattedTextField prueba5 = ((JSpinner.DefaultEditor)spinnerp1.getEditor()).getTextField();
		prueba5.setEditable(false);
		
		spinnerp2 = new JSpinner(modelp2);
		spinnerp2.setBounds(100, 220, 100, 20);
		panelOpciones.add(spinnerp2);
		JFormattedTextField prueba4 = ((JSpinner.DefaultEditor)spinnerp2.getEditor()).getTextField();
		prueba4.setEditable(false);
				
		spinnerp3 = new JSpinner(modelp3);
		spinnerp3.setBounds(100, 255, 100, 20);
		panelOpciones.add(spinnerp3);
		JFormattedTextField prueba3 = ((JSpinner.DefaultEditor)spinnerp3.getEditor()).getTextField();
		prueba3.setEditable(false);
				
		model = new SpinnerNumberModel(new Integer(8),new Integer(8),new Integer(18),new Integer(1));
		modelMinutos = new SpinnerNumberModel(new Integer(1),new Integer(0),new Integer(10),new Integer(1));
		modelSegundos = new SpinnerNumberModel(new Integer(0),new Integer(0),new Integer(45),new Integer(15));
		
		spinner = new JSpinner(model);		
		spinner.setBounds(100, 340, 40, 20);
		panelOpciones.add(spinner);
		JFormattedTextField prueba2 = ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
		prueba2.setEditable(false);				
		
		spinnerMinutos = new JSpinner(modelMinutos);
		spinnerMinutos.setBounds(150, 290, 40, 20);
		panelOpciones.add(spinnerMinutos);
		JFormattedTextField prueba1 = ((JSpinner.DefaultEditor)spinnerMinutos.getEditor()).getTextField();
		prueba1.setEditable(false);
		
		spinnerSegundos = new JSpinner(modelSegundos);
		spinnerSegundos.setBounds(200, 290, 40, 20);
		JFormattedTextField prueba = ((JSpinner.DefaultEditor)spinnerSegundos.getEditor()).getTextField();
		prueba.setEditable(false);
		
		panelOpciones.add(spinnerSegundos);
		
		panelOpciones.setVisible(true);
		
		return panelOpciones;		
	}
	public Integer getMinutos() {				
		return Integer.parseInt(((SpinnerNumberModel)spinnerMinutos.getModel()).getNumber().toString());				
	}
	public Integer getSegundos() {
		return Integer.parseInt(((SpinnerNumberModel)spinnerSegundos.getModel()).getNumber().toString());
	}
	public String getNombreJ1() {						
		return nombreJ1.getText();
	}
	public String getNombreJ2() {
		
		return nombreJ2.getText();
	}
	public int getDimension() {
		return Integer.parseInt(((SpinnerNumberModel)spinner.getModel()).getNumber().toString());
	}
	public String getPersonaje1J1() {
		return spinnerPersonaje1.getValue().toString();
		
	}
	public String getPersonaje2J1() {
		return spinnerPersonaje2.getValue().toString();
	}
	public String getPersonaje3J1() {
		return spinnerPersonaje3.getValue().toString();
	}	
	public String getPersonaje1J2() {
		return spinnerp1.getValue().toString();
	}	
	public String getPersonaje2J2() {
		return spinnerp2.getValue().toString();
	}	
	public String getPersonaje3J2() {
		return spinnerp3.getValue().toString();
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==aceptar) {					
			if(getPersonaje1J1().equals(getPersonaje2J1()) || getPersonaje1J1().equals(getPersonaje3J1()) || getPersonaje2J1().equals(getPersonaje3J1())
					|| getPersonaje1J2().equals(getPersonaje2J2()) || getPersonaje1J2().equals(getPersonaje3J2()) || getPersonaje2J2().equals(getPersonaje3J2())) {
				JOptionPane.showMessageDialog(this, "No puede seleccionar dos personajes iguales");											
			}
			else {				
				dispose();				
			}
				
		}
		
		else if(e.getSource()==salir) {
			System.exit(1);
		}	
	}
}
