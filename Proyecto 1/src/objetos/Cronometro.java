package objetos;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import tablero.*;
import javax.swing.*;


public class Cronometro extends JPanel implements Runnable{
	private Integer minutos,segundos;
	public Integer comMin, comSeg;	
	private Tablero tablero;
	private Principal principal;
		
	public Cronometro(Tablero tablero,Principal principal) {
		setBounds(560,50,320,60);
		setLayout(null);						
		tiempo = new JLabel( "00:00" );
        tiempo.setFont( new Font( Font.SERIF, Font.BOLD, 30 ) );
        tiempo.setHorizontalAlignment( JLabel.CENTER );
        tiempo.setForeground( Color.black );
        tiempo.setBorder(BorderFactory.createLineBorder(Color.BLACK));        
        tiempo.setOpaque( true );
        tiempo.setBounds(60, 10, 80, 30);
        add(tiempo);        
        labelTiempo = new JLabel("Tiempo: ");
		labelTiempo.setBounds(10, 10, 50, 30);		
		add(labelTiempo);                               
        setVisible(true);		
        comMin=0;
        comSeg=0;
        setTablero(tablero);
        setPrincipal(principal);
	}
	
	public void comprobar() {
		if(comMin==minutos && comSeg==segundos) {
			cronometroActivo=false;
			tiempo.setText("00:00");
			principal.terminarJuego();
		}
		if(principal.vidaJ1==0 || principal.vidaJ2==0) {
			cronometroActivo=false;
			tiempo.setText("00:00");
			principal.terminarJuego();
		}
		else
			cronometroActivo=true;
	}
	public void setTablero(Tablero tablero) {
		this.tablero=tablero;
	}
	public void setPrincipal(Principal principal) {
		this.principal=principal;
	}
	
	public void run(){
        minutos = 0; 
        segundos = 0;                        
        String min="", seg="";
        try{           
            while(cronometroActivo){            	
                Thread.sleep(1000);
                segundos++;                                                              
                    if(segundos==60){
                    	segundos=0;
                    	minutos++;
                    }                                
                    if( minutos < 10 ) {
                    	min="0" + minutos;
                	}                
                    else {
                    	min = minutos.toString();
                    }                    
                if( segundos < 10 ) {
                	seg = "0" + segundos;
                }
                else {
                	seg = segundos.toString();                                                                                  
                }                
                tiempo.setText( min + ":" + seg);                
                comprobar();
            }            
        }
        catch(InterruptedException ex) {
			Logger.getLogger(Movimiento.class.getName()).log(Level.SEVERE, null, ex);
		}
        tiempo.setText( "00:00" );
    }
           
    public void iniciarCronometro() {
        cronometroActivo = true;
        hilo = new Thread( this );
        hilo.start();
    }
    
    public void pararCronometro(){
        cronometroActivo = false;
        tiempo.setText("00:00");
    }
    
    boolean x = true;    
	public void terminarHilo(){
    	hilo.stop();
    }
    
    
    public void paraCronometro() {    	
    	if(x) {
    		hilo.suspend();
    		x=false;
    	}
    	else {
    		hilo.resume();
    		x=true;
    	}
    }
	
	JLabel tiempo, labelTiempo;
    Thread hilo;
    public boolean cronometroActivo = false;;    
}
