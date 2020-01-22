import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Chao extends JLabel implements Runnable{
	
	Random sorteia = new Random();

	public Chao(TelaLesma tela){

		setSize(sorteia.nextInt(266-90)+90, sorteia.nextInt(161-55)+55);
		tela.tempoPlataforma =(getWidth()*2000)/265;
		
		setLocation(768, 430-getHeight());
		setLayout(null);
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/chao.png")).getImage().getScaledInstance(getWidth(), getHeight(), 4)));
		new Thread(this).start();
		
		if(tela.pode){
			Moeda moeda = new Moeda((sorteia.nextInt(getWidth())+768), getY()-40);
			tela.booster.add(moeda);
			tela.container.add(moeda);
			tela.pode = false;
		}
		
	}

	@Override
	public void run() {
		while(getX() > 0-getWidth()){
			setLocation(getX()-10, getY());
			try { Thread.sleep(50); } catch (Exception e) { }
		}
		
	}
	
	
	
}
