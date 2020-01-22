import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Ostra extends JLabel {
	boolean verdadeira = false;
	ImageIcon aberta;
	ImageIcon fechada;
	int x;
	int y;
	
	public Ostra(boolean souVerdadeira, int x, int y){
		setBounds( x, y, 70 , 70);
		fechada = (new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/fechada.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
		aberta = (souVerdadeira)? 
					new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/certa.png")).getImage().getScaledInstance(70, 70, 4))
				:
					new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/errada.png")).getImage().getScaledInstance(70, 70, 4))
				;
					
			
		
		setVisible(true);
		verdadeira = souVerdadeira;
	}
	
	public void abrir(){
		setIcon(aberta);
	}
	
	public void fechada(){
		setIcon(fechada);
	}
	
	public void anda(ArrayList<Ostra> posicoes){
		new Thread(new Runnable() {
			public void run() {
				
				while (getX() != x) {
					if(x > getX()){
						setLocation(getX() + 1 , getY());
					}else{
						setLocation(getX() - 1, getY());
					}
					
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
	}

		
		
}
