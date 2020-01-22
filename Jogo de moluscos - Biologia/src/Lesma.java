import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Lesma extends JLabel implements KeyListener , Runnable{
	
	TelaLesma tela;
	boolean  bati = false, direita = false, atras = false, pula = false, podePular, achei = false, protegido = false;
	
	public Lesma(TelaLesma tela){
		this.tela = tela;
		setSize(70 , 70);
		setLocation(500 ,tela.lblprimeirochao.getY()-120);
		setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/lesma.png")).getImage().getScaledInstance(70, 70, 4)));
		setVisible(true);
		new Thread(this).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true){
					if(pula && !bati){
						setLocation(getX()+2 , getY()-5);
						metros(1);
						tela.aux+=1;
						dormir(1);
					}
					if(direita && !bati){
						setLocation(getX() + 5, getY());
						metros(2);
						tela.aux+=2;
						dormir(1);
					}
					if(atras){
						setLocation(getX() - 3, getY());
						tela.addMetro-=1;
						tela.metros.setText(""+tela.addMetro+"M");
						tela.aux-=1;
						dormir(1);
					}
					
					if(tela.aux == 1500){
						tela.contaTempo-=1;
						tela.aux = 0;
					}
					
					dormir(10);
				}
					
				
			}
		}).start();
		this.tela = tela;
		
	}

	@Override
	public void keyPressed(KeyEvent tecla) {
		if (tecla.getKeyCode()==38 && podePular)  {
			pula = true;
			podePular = false;
			new Thread(new Runnable() {
				@Override
				public void run() {
					dormir(500);
					pula = false;
				}
			}).start();
		}
		direita = (tecla.getKeyCode() == 39);
		atras = (tecla.getKeyCode() == 37);
	}
	

	@Override
	public void keyReleased(KeyEvent tecla) {
		if(tecla.getKeyCode() == 39) direita = false ;
		if(tecla.getKeyCode() == 37) atras = false ;
			
	}

	@Override
	public void keyTyped(KeyEvent arg0) { 
	}
	

	@Override
	public void run() {
		while (true) {
			achei = false;
			for(Chao c :  tela.chaozinho){
				if (c.getBounds().intersects(getBounds())) {
					if(isEmCima(c)){
						achei = true;
						podePular = true;
					}else{
						bati = true;
					}
				}
			}
			pegar();
			if(bati){
				cair();
				break;
			}else if(achei){
				setLocation(getX() - 3 , getY());
				dormir(15);
				if(!protegido){
					if(getX()<=161){
						cair();
						break;
					}
				}
				
			}else{
				setLocation(getX()-1, getY()+3);
				dormir(15);
			}
			
		}
		
	}
	private void cair() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(getY()<500){
					setLocation(getX()-1 , getY()+1);
					dormir(5);
				}
				tela.perdeu.setVisible(true);
				tela.jogarN.setVisible(true);
				tela.sair.setVisible(true);
				tela.meusMetros.setText(tela.metros.getText());
			}
		}).start();
	}

	public boolean isEmCima(JLabel plataforma){
		if(getY()+55 <= plataforma.getY()){
			return true;
		}
		return false;
		
	}
	public void dormir(int milis){
		try {
			Thread.sleep(milis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void pegar(){
		try{
			for(Moeda booster : tela.booster){
				if(booster.getBounds().intersects(getBounds())){
					booster.setVisible(false);
					if(booster.tipo == "moeda"){
						tela.addMoeda+=10;
						tela.numMoeda.setText(""+tela.addMoeda);
						tela.booster.remove(booster);
					}else{
						tela.booster.remove(booster);
						protegido = true;
						tela.escudo.setVisible(true);
						tela.barraP.setVisible(true);
						tela.borda.setVisible(true);
						tela.barraP.setValue(100);
						new Thread(new Runnable(){
							public void run(){
								while(tela.barraP.getValue() != 0){
									tela.barraP.setValue(tela.barraP.getValue()-3);
									try { Thread.sleep(300); } catch (Exception e) {  System.out.println(e.getMessage());
									}
								}
								protegido = false;
								tela.escudo.setVisible(false);
								tela.barraP.setVisible(false);
								tela.borda.setVisible(false);
							}
						}).start();
						
					}

				}
			}
		}catch(Exception e){
			
		}
	}
	
	public void metros(int add){
		tela.addMetro+=add;
		tela.metros.setText(""+tela.addMetro+"M");
	}

}
