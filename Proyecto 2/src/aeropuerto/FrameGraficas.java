package aeropuerto;
import java.awt.*;
import javax.swing.*;

public class FrameGraficas extends JFrame {	
	private ImageIcon nuevo;	
	
	
	public FrameGraficas(ImageIcon nuevo, String titulo) {
		super("Grafica");
		this.nuevo=nuevo;		
		add(getTitulo(titulo));
		JScrollPane scroll = new JScrollPane(new JLabel(nuevo));
		scroll.setBounds(20, 100, 600, 450);
		add(scroll);
		init();
	}
	
	public void setIcon(ImageIcon nuevo) {
		this.nuevo = nuevo;
	}
	public ImageIcon getIcon() {
		return nuevo;
	}		
	
	public void init() {
		setLayout(null);
		setResizable(false);
		setSize(640,640);
		setLocationRelativeTo(null);		
		setVisible(true);
	}
		
	public JLabel getTitulo(String title) {
		JLabel titulo = new JLabel(title);
		titulo.setBounds(220, 10, 200, 70);
		titulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		titulo.setForeground(Color.black);
		titulo.setBackground(Color.blue);
		titulo.setOpaque(true);
		titulo.setFont(new Font("Tahoma",1,16));
		titulo.setVerticalAlignment(JLabel.CENTER);
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setVisible(true);
		return titulo;
	}
	
	
	/*public JLabel getImagen(ImageIcon nuevo) {
		imagen = new JLabel();		
		imagen.setVisible(true);	
		//fondo = nuevo.getImage();
		//ImageIcon nuevoDim = new ImageIcon(fondo.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		
		imagen.setIcon(nuevo);
		imagen.setHorizontalAlignment(JLabel.CENTER);
		imagen.setVerticalAlignment(JLabel.CENTER);
		imagen.setBounds(0, 0, 250, 600);		
		return imagen;
	}*/
		
}
