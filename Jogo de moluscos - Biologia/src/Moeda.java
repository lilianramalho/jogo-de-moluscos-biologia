import java.awt.Color;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Moeda extends JLabel implements Runnable{
	
	Random sorteia = new Random();
	Lesma lesminha;
	String tipo;
	int essa;
	int vetor[] = new int[]{1,1,2,2,1};

	public Moeda(int x, int y){
		
		essa = vetor[sorteia.nextInt(5)];
		
		setSize(25, 25);
		setLocation(x, y);
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/bonus"+essa+".png")).getImage().getScaledInstance(25, 25, 4)));
		setLayout(null);
		setVisible(true);
		new Thread(this).start();
		
		if(essa == 1){
			tipo = "moeda";
		}else{
			tipo = "escudo";
		}
		
	}

	@Override
	public void run() {
		while(getX() > 0-getWidth()){
			setLocation(getX()-10, getY());
			try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
}
