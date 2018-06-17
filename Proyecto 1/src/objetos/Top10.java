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
    			for (int i = 0; i < 10; i++) {
					pw.write("xxx,xxx,xxx,xxx,xxx,xxx,xxx,xxx,xxx,1000,1000,1000"+"\r\n");
				}
    		}
    		pw.close();
    	}
    	catch(IOException ex){
    		
    	}
    }
    
    public Jugador[] optenerJugadores(String archivo) throws FileNotFoundException, IOException{

    	String cadena="";
    	Jugador [] jugador = new Jugador[10];
    	FileReader fr = new FileReader(archivo);
    	BufferedReader br = new BufferedReader(fr);
    	int linea=0;
    	
    	while((cadena=br.readLine())!= null && linea<10) {
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
    
    public void guardarDatos(String archivo, Jugador[] jugador) {
    	try {
    		PrintWriter pw = new PrintWriter(new FileWriter(archivo));
    		int tam = jugador.length;
    		for (int i = 0; i < tam; i++) {
				pw.write(jugador[i].getJugador1()+","+jugador[i].getJugador2()+","+jugador[i].getPer1J1()+","+jugador[i].getPer2J1()+","+jugador[i].getPer3J1()+","+jugador[i].getPer1J2()+","+jugador[i].getPer2J2()+","+jugador[i].getPer3J2()
				+ ","+jugador[i].getGanador()+","+jugador[i].getVidasJ1()+","+jugador[i].getVidasJ2()+","+jugador[i].getTiempo()+"\r\n");
			}
    		pw.close();
    	}
    	catch(IOException ex) {
    		
    	}
    }
} 
