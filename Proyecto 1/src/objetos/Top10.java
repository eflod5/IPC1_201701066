package objetos;

import java.io.*;

public class Top10 {
	private File archivo;
    private String ruta;
    
    
    public void crear() {    
    	ruta = "Top10.txt";
    	archivo = new File(ruta);
    	PrintWriter pw;
    	try {
    		if(archivo.exists()) {
    			pw = new PrintWriter(new FileWriter(ruta,true));
    		}
    		else {
    			pw = new PrintWriter(new FileWriter(ruta,true));
    			pw.println("Erik");
    		}
    		pw.close();
    	}
    	catch(IOException ex){
    		
    	}
    }
    
    public Jugador[] optenerJugadores(String archivo) throws FileNotFoundException, IOException{
    	String cadena="";
    	Jugador [] jugador = new Jugador[9];
    	FileReader fr = new FileReader(archivo);
    	BufferedReader br = new BufferedReader(fr);
    	int linea=0;
    	
    	while((cadena=br.readLine())!= null && linea<9) {
    		String [] cadenasplit=cadena.split(",");
    		jugador[linea] = new Jugador(cadenasplit[0],cadenasplit[1],cadenasplit[2],cadenasplit[3],
    				cadenasplit[4],cadenasplit[5],cadenasplit[6],cadenasplit[7], cadenasplit[8],
    				Integer.parseInt(cadenasplit[9].trim()),Integer.parseInt(cadenasplit[10].trim())
    				,Integer.parseInt(cadenasplit[11].trim()));
    		linea++;
    	}
    	br.close();
    	return jugador;
    }
} 
