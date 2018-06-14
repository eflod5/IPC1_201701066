package objetos;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Vida {	
	public int vida,vidasJ1 = 5,vidasJ2 =5;
	JLabel[][] tabVidasJ1,tabVidasJ2;
	JPanel panelVidasJ1,panelVidasJ2;
	int [][] iVidasJ1, iVidasJ2;
	
	int vidasj1,vidasj2;
	
	public Vida() {
		
		panelVidasJ1 = new JPanel();
		panelVidasJ1.setBounds(10, 35, 150, 75);		
		panelVidasJ1.setLayout(new GridLayout(6,3));
		pintarVidasJ1();
		
		panelVidasJ2 = new JPanel();
		panelVidasJ2.setBounds(10, 140, 150, 75);	
		panelVidasJ2.setLayout(new GridLayout(6,3));
		pintarVidasJ2();
		
		aggVidas(5);
	}	
	
	public void aggVidas(int vida) {		
		aggVidasJ1(vida);		
		aggVidasJ2(vida);
	}
	
	public int getVidaJ1() {
		return vidasJ1;
	}	
	public int getVidaJ2() {
		return vidasJ1;
	}
	public void pintarVidasJ1() {				
		tabVidasJ1 = new JLabel[3][6];
		iVidasJ1 = new int[3][6];		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				tabVidasJ1[i][j] = new JLabel();
				iVidasJ1[i][j] = 0;
				Border border = BorderFactory.createLineBorder(Color.BLACK,1);
				tabVidasJ1[i][j].setBorder(border);
				panelVidasJ1.add(tabVidasJ1[i][j]);
			}
		}
	}
	public void pintarVidasJ2() {
		tabVidasJ2 = new JLabel[3][6];
		iVidasJ2 = new int [3][6];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				tabVidasJ2[i][j] = new JLabel();
				iVidasJ2[i][j] = 0;
				Border border = BorderFactory.createLineBorder(Color.BLACK,1);
				tabVidasJ2[i][j].setBorder(border);
				panelVidasJ2.add(tabVidasJ2[i][j]);
			}
		}
	}	
	
	public void aggVidasJ1(int vidas) {		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				if(vidas!=0) {					
					tabVidasJ1[i][j].setBackground(Color.RED);
					tabVidasJ1[i][j].setOpaque(true);
					vidas--;
				}
				else {
					tabVidasJ1[i][j].setBackground(Color.gray);
					tabVidasJ1[i][j].setOpaque(true);
				}					
			}			
		}
	}	
	public void aggVidasJ2(int vidas) {		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				if(vidas!=0) {
					tabVidasJ2[i][j].setBackground(Color.red);
					tabVidasJ2[i][j].setOpaque(true);
					vidas--;
				}
				else {
					tabVidasJ2[i][j].setBackground(Color.gray);
					tabVidasJ2[i][j].setOpaque(true);
				}
			}			
		}				
	}
	
	public JPanel getPanelJ1() {
		return panelVidasJ1;
	}
	public JPanel getPanelJ2() {
		return panelVidasJ2;
	}
}
