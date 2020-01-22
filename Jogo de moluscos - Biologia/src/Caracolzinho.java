import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Caracolzinho extends JLabel implements KeyListener, Runnable{
	
	int qual, eu;
	Caracolzinho caracolzinho;
	TelaCaracol tela;

	public Caracolzinho(int y, String imagem, int qual, TelaCaracol tela){
		
		setSize(70, 70);
		setLocation(16, y);
		setOpaque(false);
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/caracolzinho/"+imagem)).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
		setLayout(null);
		setBorder(null);
		setVisible(true);
		
		this.qual = qual;
		this.tela = tela;
		
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		if(qual == 1){		
			if((tecla.getKeyCode() == 39) && !ganhei()) andar();
			if((tecla.getKeyCode() == 10) && !ganhei() && (tela.bonus1.getValue() == 100)){
				bonus();
				tela.bonus1.setValue(0);
				new Thread(this).start();
			}
		}else{
			if((tecla.getKeyCode() == 68) && !ganhei()) andar();
			if((tecla.getKeyCode() == 32) && !ganhei() && (tela.bonus2.getValue() == 100)){
				bonus();
				tela.bonus2.setValue(0);
				new Thread(this).start();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void andar(){
		setLocation(getX()+12, getY());
		if((getX() > 350) && (getX()>caracolzinho.getX() && (tela.background.getX() > -1528))){
			tela.background.setLocation(tela.background.getX()-12, tela.background.getY());
		}
		if(qual == 1){
			tela.caracollocal1.setLocation(tela.caracollocal1.getX()+2, tela.caracollocal1.getY());
		}else{
			tela.caracollocal2.setLocation(tela.caracollocal2.getX()+2, tela.caracollocal2.getY());
		}
		
	}
	
	public void bonus(){
			setLocation(getX()+100, getY());
			if(qual == 1){
				tela.caracollocal1.setLocation(tela.caracollocal1.getX()+16, tela.caracollocal1.getY());
			}else{
				tela.caracollocal2.setLocation(tela.caracollocal2.getX()+16, tela.caracollocal2.getY());
			}
			if((getX() > 350) && (getX()>caracolzinho.getX() && (tela.background.getX() > -1528))){
					tela.background.setLocation(tela.background.getX()-100, tela.background.getY());
			}
	}
	
	public boolean ganhei(){
		if(getX() < 2200){
			return false;
		}
		
		tela.container.setVisible(false);
		tela.ganhou.setVisible(true);
		
		if(eu == 1){
			tela.vencedor2.setVisible(false);
		}else{
			tela.vencedor1.setVisible(false);
		}
		
		return true;
	}

	@Override
	public void run() {
		if(qual == 1){
			while(tela.bonus1.getValue() != 100){
				tela.bonus1.setValue(tela.bonus1.getValue()+1);
				dormir();
			}
		}else{
			while(tela.bonus2.getValue() != 100){
				tela.bonus2.setValue(tela.bonus2.getValue()+1);
				dormir();
			}
		}
		
	}
	
	public void dormir(){
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
