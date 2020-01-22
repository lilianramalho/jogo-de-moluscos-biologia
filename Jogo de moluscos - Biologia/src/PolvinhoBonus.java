

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PolvinhoBonus extends JLabel implements Runnable{
	
	Random sorteiaypolvinho = new Random();
	String direcao;
	JLabel bonus = new JLabel();
	
	public PolvinhoBonus(int x, String direcao){
		
		setSize(50, 50);
		setLocation(x, sorteiaypolvinho.nextInt(380));
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/polvinho/polvoFinal2.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		setBackground(new Color(0, 0, 0, 0));
		setBorder(null);
		setLayout(null);
		setVisible(true);
		
		this.direcao = direcao;
		
		bonus();
	}

	@Override
	public void run() {
		if (direcao == "direita"){
			while(getX() < 768+getWidth()){
				setLocation(getX()+10, getY());
				nadar();
			}
		}else{
			while (getX() > 0-getWidth()){
				setLocation(getX()-10, getY());
				nadar();
			}
		}
		
		if(direcao == "direita"){
			direcao = "esquerda";
			setLocation(getX(), sorteiaypolvinho.nextInt(380));
		}else{
			direcao = "direita";
			setLocation(getX(), sorteiaypolvinho.nextInt(380));
		}
		
		setVisible(true);
		
	}
	
	public void bonus(){
		bonus.setSize(50, 50);
		bonus.setOpaque(false);
		bonus.setText("+50");
		bonus.setForeground(Color.WHITE);
		bonus.setHorizontalAlignment(SwingConstants.CENTER);
		bonus.setFont(new Font("Bebas Neue", 0, 30));
		add(bonus);
	}
	
	public void nadar(){
		bonus.setLocation(getX(), getY());
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

}
