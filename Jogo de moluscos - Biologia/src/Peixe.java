import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Peixe extends JLabel implements Runnable{
	
	String direcao, velocidade;
	int xInicial;
	boolean esta = false;
	public Polvo polvo;

	public Peixe(int width, int height, int x, int y, String imagemPeixe, String direcao, String velocidade){
		setLayout(null);
		setSize(width, height);
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/polvinho/"+imagemPeixe)).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH )));
		setLocation(x, y);
		setBorder(null);
		setVisible(true);
		
		this.direcao = direcao;
		this.velocidade = velocidade;
		xInicial = x;
		
	}

	@Override
	public void run() {
		if(direcao.equals("direita")){
			while(getX() < getWidth()+768){
				setLocation(getX()+1, getY());
				if(velocidade == "rapida"){
					nadarrapido();
				}else{
					nadarnormal();
				}
			}
		}else{
			while(getX() > 0-getWidth()){
				setLocation(getX()-1, getY());
				if(velocidade == "rapida"){
					nadarrapido();
				}else{
					nadarnormal();
				}
			}
		}
		
		setLocation(xInicial, getY());
			
	}
	
	public boolean cima(){
		if((polvo.getX() == getX()) && (polvo.getY() == getY())){
			esta = true;
		}else{
			esta = false;
		}
		return esta;
	}
	
	public void nadarrapido(){
		try {
			Thread.sleep(1);
			if(cima()){
				polvo.setVisible(true);
				polvo.pausa = false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void nadarnormal(){
		try {
			Thread.sleep(2);
			if(cima()){
				polvo.setVisible(true);
				polvo.pausa = false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
		
}
	
