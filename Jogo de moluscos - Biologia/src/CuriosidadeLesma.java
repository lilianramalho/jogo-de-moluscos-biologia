import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CuriosidadeLesma extends JFrame implements MouseListener, Runnable{
	
	JLabel titulo = new JLabel();
	JLabel caixa = new JLabel();
	JLabel barraS = new JLabel();
	JLabel barraI = new JLabel();
	JLabel bg = new JLabel(new ImageIcon(getClass().getResource("imagens/lesminha/bg.png")));
	JLabel curiosidades = new JLabel(new ImageIcon(getClass().getResource("imagens/lesminha/curiosidades.png")));
	JLabel prox = new JLabel();
	JLabel sair = new JLabel();
	Color corDaCaixa = new Color(0, 213, 0);
	
	int ir, c;

	public CuriosidadeLesma(){
		
		setSize(768, 457);
		setTitle("Curiosidades");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		componentes();
		
		setVisible(true);
		
	}
	
	public void componentes(){
		
		titulo.setSize(768, 49);
		titulo.setLocation(0, 0);
		titulo.setOpaque(true);
		titulo.setBackground(new Color(0, 213, 0));
		titulo.setText("CURIOSIDADES");
		titulo.setForeground(Color.white);
		titulo.setFont(new Font("Bebas Neue", 0, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		add(titulo);
		
		prox.setSize(38, 17);
		prox.setLocation(636, 368);
		prox.setText("PROX");
		prox.setForeground(Color.white);
		prox.setFont(new Font("Bebas Neue", 0, 18));
		prox.setHorizontalAlignment(SwingConstants.CENTER);
		prox.setCursor(new Cursor(Cursor.HAND_CURSOR));
		prox.addMouseListener(this);
		add(prox);
		
		sair.setSize(38, 17);
		sair.setLocation(636, 368);
		sair.setText("SAIR");
		sair.setForeground(Color.white);
		sair.setFont(new Font("Bebas Neue", 0, 18));
		sair.setHorizontalAlignment(SwingConstants.CENTER);
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sair.addMouseListener(this);
		sair.setVisible(false);
		add(sair);
		
		curiosidades.setSize(2052, 303);
		curiosidades.setLocation(86, 88);
		add(curiosidades);
		
		caixa.setSize(596, 303);
		caixa.setLocation(86, 88);
		caixa.setOpaque(true);
		caixa.setBackground(corDaCaixa);
		add(caixa);
		
		barraS.setSize(242, 3);
		barraS.setLocation(177, 72);
		barraS.setOpaque(true);
		barraS.setBackground(Color.white);
		caixa.add(barraS);
		
		barraI.setSize(barraS.getWidth(), barraS.getHeight());
		barraI.setLocation(barraS.getX(), 231);
		barraI.setOpaque(true);
		barraI.setBackground(Color.white);
		caixa.add(barraI);
		
		bg.setSize(768, 430);
		bg.setLocation(0, 0);
		add(bg);
		
	}

	@Override
	public void mouseClicked(MouseEvent clicou) {
		if(clicou.getSource().equals(prox)){
			new Thread(this).start();
		}
		
		if(clicou.getSource().equals(sair)){
			dispose();
			Tela a = new Tela();
			a.playCaracol.setVisible(false);
			a.playLesma.setVisible(true);
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
	
	@Override
	public void run() {
		ir = curiosidades.getX() -682;
		c++;
		if(c == 2){
			prox.setVisible(false);
			sair.setVisible(true);
		}
		while(curiosidades.getX() > ir){
			curiosidades.setLocation(curiosidades.getX()-3, curiosidades.getY());
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
		
	
	}
	
}
