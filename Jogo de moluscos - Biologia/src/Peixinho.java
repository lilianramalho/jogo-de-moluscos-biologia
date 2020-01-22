import java.awt.Color;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Peixinho extends JLabel implements Runnable{
	
	Random posicaoy = new Random();
	Random novopeixinho = new Random();
	String direcao;

	public Peixinho(int width, int height, int x, String imagemPeixinho, String direcao){
		setSize(width, height);
		setLocation(x, posicaoy.nextInt(450));
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/polvinho/"+imagemPeixinho)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		setLayout(null);
		setBackground(new Color(0, 0, 0, 0));
		setBorder(null);
		setVisible(true);
		
		this.direcao = direcao;
		
	}

	@Override
	public void run() {
		if(direcao == "direita"){
			while(getX() < getWidth()+768){
				setLocation(getX()+5, getY());
				andar();
			}
		}else{
			while(getX() > 0-getWidth()){
				setLocation(getX()-5, getY());
				andar();
			}
		}
		
		if(direcao == "direita"){
			direcao = "esquerda";
			setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/polvinho/peixe"+(novopeixinho.nextInt(5)+1)+"e.png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
			setLocation(getX(), posicaoy.nextInt(450));
		}else{
			direcao = "direita";
			setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/polvinho/peixe"+(novopeixinho.nextInt(5)+1)+".png")).getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH)));
			setLocation(getX(), posicaoy.nextInt(450));
		}
		
		new Thread(this).start();
	}
	
	public void novopolvinho(){
		
	}
	
	public void andar(){
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
		
}
