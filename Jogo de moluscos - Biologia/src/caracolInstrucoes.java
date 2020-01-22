import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class caracolInstrucoes extends JFrame implements MouseListener{
	JLabel[] vetor = new JLabel[3];
	
	JLabel label1 = new JLabel(new ImageIcon(getClass().getResource("img/bgInicial.png")));
	JLabel seta1 = new JLabel (new ImageIcon(new ImageIcon(getClass().getResource("imagens/prox.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
	
	JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("img/bgInicial2.png")));
	JLabel seta2 = new JLabel (new ImageIcon(new ImageIcon(getClass().getResource("imagens/ant.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
	
	JLabel sair = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/sair.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
	 
	
	
	public caracolInstrucoes(){
		
		setTitle("Moluscos");
		setSize(768, 457);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		componentes();
	
		setVisible(true);
		
	}
	
	public void componentes(){
		
		label1.setSize(768, 430);
		label1.setLocation(0,0);
		add(label1);
		
		seta1.setSize(50, 50);
		seta1.setLocation(710, 375);
		seta1.setOpaque(false);
		seta1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		seta1.addMouseListener(this);
		label1.add(seta1);
		
		
		label2.setSize(768, 430);
		label2.setLocation(0,0);
		add(label2);
		
		seta2.setSize(50, 50);
		seta2.setLocation(58, 375);
		seta2.setOpaque(false);
		seta2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		seta2.addMouseListener(this);
		label2.add(seta2);
		
		
		
		sair.setSize(30, 30);
		sair.setLocation(720, 6);
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sair.addMouseListener(this);
		label2.add(sair);
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent clicou) {
		if(clicou.getSource().equals(seta1)){
			label1.setVisible(false);
			label2.setVisible(true);
		}
		
		if(clicou.getSource().equals(seta2)){
			label2.setVisible(false);
			label1.setVisible(true);
			
		}
		
		
		if(clicou.getSource().equals(sair)){
			dispose();
			Tela a = new Tela();
			a.playPolvo.setVisible(false);
			a.playCaracol.setVisible(true);
			
			}
		}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}




