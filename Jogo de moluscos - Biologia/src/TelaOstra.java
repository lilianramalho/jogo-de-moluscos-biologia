import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TelaOstra extends JFrame implements MouseListener{

	Ostra ostra;
	ArrayList<Point> posicoes1 = new ArrayList<>();
	ArrayList<Point> posicoes2 = new ArrayList<>();
	ArrayList<Point> posicoes3 = new ArrayList<>();
	ArrayList<Ostra> ostras = new ArrayList<>(); 
	JLabel lblCerta = new JLabel();
	JLabel lblErrada = new JLabel();
	JLabel lblFundinho = new JLabel(new ImageIcon(getClass().getResource("imagens/ostrinha/fundo.png")));
	JLabel lblpontos = new JLabel();
	boolean apertou = false, acabou = false;
	int dificudade =1;
	int ostra3 = 1;
	
	JLabel perdeu = new JLabel();
	JLabel perdeubg = new JLabel(new ImageIcon(getClass().getResource("imagens/ostrinha/fundo.png")));
	JLabel perdeuTitle = new JLabel();
	JLabel caixa = new JLabel();
	JLabel acabaram = new JLabel();
	JLabel fechada1 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/fechada.png")).getImage().getScaledInstance(150, 150, 4)));
	JLabel fechada2 = new JLabel();
	JLabel aberta = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/errada.png")).getImage().getScaledInstance(150, 150, 4)));
	JLabel jogarN = new JLabel();
	JLabel sair = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/sair.png")).getImage().getScaledInstance(30, 30, 4)));
	
	
	public TelaOstra() {
		
		setSize(768 , 457);
		setTitle("Ache a pérola");
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		componentes();
		
		posicoes1.add(new Point(269, 315));
		posicoes1.add(new Point(348, 315));
		posicoes1.add(new Point(425 , 315));
		
		posicoes2.add(new Point(230 , 315));
		posicoes2.add(new Point(311 , 315));
		posicoes2.add(new Point(392 , 315));
		posicoes2.add(new Point(473 , 315));
		
		posicoes3.add(new Point(160, 315));
		posicoes3.add(new Point(238, 315));
		posicoes3.add(new Point(319, 315));
		posicoes3.add(new Point(400, 315));
		posicoes3.add(new Point(481, 315));
		posicoes3.add(new Point(561, 315));
		
		novasOstras();
		
		setVisible(true);
		
		
	}
	
	public void novasOstras() {
		ostras = new ArrayList<>();
		apertou = true;
		
	
		if (dificudade == 1){ 
			
			for (int i = 0; i < 3; i++) {
				Ostra o;
				if(i == 0){
					o = new Ostra(true, posicoes1.get(i).x, posicoes1.get(i).y);
				}else{
					o = new Ostra(false, posicoes1.get(i).x, posicoes1.get(i).y);
				}
				
				ostras.add(o);
				o.addMouseListener(this);
				lblFundinho.add(o);
			}
		
		}else if(dificudade == 2){
			for (int i = 0; i < 4; i++) {
				Ostra o;
				if(i == 0){
					o = new Ostra(true, posicoes2.get(i).x, posicoes2.get(i).y);
				}else{
					o = new Ostra(false, posicoes2.get(i).x, posicoes2.get(i).y);
				}
				
				ostras.add(o);
				o.addMouseListener(this);
				lblFundinho.add(o);
			}
		}else if(dificudade == 3){
			for (int i = 0; i < 6; i++) {
				Ostra o;
				if(i == 0){
					o = new Ostra(true, posicoes3.get(i).x, posicoes3.get(i).y);
				}else{
					o = new Ostra(false, posicoes3.get(i).x, posicoes3.get(i).y);
				}
				
				ostras.add(o);
				o.addMouseListener(this);
				lblFundinho.add(o);
			}
			
		} 
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (Ostra ostra : ostras) 
					ostra.abrir();
				
				sleep(1000);
				
				for (Ostra ostra : ostras) 
					ostra.fechada();
				
				sleep(50);
				
				if(dificudade == 1){
					int n=2;
					while(n!=0){
						Efeito.getInstance().embaralha(ostras);
						sleep(30);
						Efeito.getInstance().embaralha(ostras);
						sleep(30);
						Efeito.getInstance().embaralha(ostras);
						n--;
					}
				}
				
				if(dificudade == 2){
					int number=2;
					while(number!=0){
						Efeito.getInstance().embaralha2(ostras);
						sleep(20);
						Efeito.getInstance().embaralha2(ostras);
						sleep(20);
						Efeito.getInstance().embaralha2(ostras);
						number--;
					
					}
				}
					if(dificudade == 3){
						int numero=2;
						while (numero!=0) {
							Efeito.getInstance().embaralha3(ostras);
							sleep(10);
							Efeito.getInstance().embaralha3(ostras);
							sleep(10);
							Efeito.getInstance().embaralha3(ostras);
							numero--;
						}
				}
				apertou = false;
				
			}
		}).start();
		
	}
	
	public void componentes() {
		
		//perdeu
		
		perdeu.setSize(768, 457);
		perdeu.setLocation(0, 0);
		add(perdeu);
		perdeu.setVisible(false);
		
		jogarN.setSize(143, 18);
		jogarN.setLocation(530, 395);
		jogarN.setText("JOGAR NOVAMENTE");
		jogarN.setFont(new Font("Bebas Neue", 0, 24));
		jogarN.setForeground(Color.white);
		jogarN.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jogarN.addMouseListener(this);
		perdeu.add(jogarN);
		
		sair.setSize(30, 30);
		sair.setLocation(720, 6);
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sair.addMouseListener(this);
		perdeu.add(sair);
				
		perdeuTitle.setSize(768, 49);
		perdeuTitle.setLocation(0, 0);
		perdeuTitle.setOpaque(true);
		perdeuTitle.setBackground(new Color(11, 102, 147));
		perdeuTitle.setText("VOCÊ PERDEU");
		perdeuTitle.setForeground(Color.white);
		perdeuTitle.setHorizontalAlignment(SwingConstants.CENTER);
		perdeuTitle.setFont(new Font("Bebas Neue", 0, 24));
		perdeu.add(perdeuTitle);
		
		caixa.setSize(592, 303);
		caixa.setLocation(86, 88);
		caixa.setOpaque(true);
		caixa.setBackground(Color.white);
		caixa.setBorder(BorderFactory.createLineBorder(new Color(11, 102, 147), 3));
		perdeu.add(caixa);
		
		acabaram.setSize(caixa.getWidth(), 55);
		acabaram.setLocation(0, 0);
		acabaram.setOpaque(true);
		acabaram.setBackground(new Color(11, 102, 147));
		acabaram.setText("ACABARAM SUAS VIDAS");
		acabaram.setForeground(Color.white);
		acabaram.setFont(new Font("Bebas Neue", 0, 24));
		acabaram.setHorizontalAlignment(SwingConstants.CENTER);
		caixa.add(acabaram);
		
		fechada1.setSize(150, 150);
		fechada1.setLocation(63, 150);
		caixa.add(fechada1);
		
		fechada2.setSize(150, 150);
		fechada2.setLocation(401, 150);
		fechada2.setIcon(fechada1.getIcon());
		caixa.add(fechada2);
		
		aberta.setSize(150, 150);
		aberta.setLocation(233, 120);
		caixa.add(aberta);
				
		perdeubg.setSize(768, 430);
		perdeubg.setLocation(0, 0);
		perdeu.add(perdeubg);

		//jogo
		
		lblFundinho.setSize(768 , 430);
		lblFundinho.setLocation(0 , 0);
		add(lblFundinho);
		
		lblpontos.setSize(50 , 30);
		lblpontos.setLocation(578 , 7);
		lblpontos.setText("vidas: "+vidas);
		lblpontos.setForeground(Color.white);
		lblpontos.setFont(new Font("Bebas Neue", 0, 16));
		lblpontos.setOpaque(false);
		lblpontos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpontos.setForeground(Color.WHITE);
		
		lblFundinho.add(lblpontos);
		
		
		
	}
	public void sleep(int i) {
		try { Thread.sleep(i); } catch (Exception e) {	}
	}
	
	int vidas = 3;
	int addpontos = 0;
	@Override
	public void mouseClicked(MouseEvent clicou) {
		
		if(clicou.getSource().equals(jogarN)){
			new TelaOstra();
		}else
		
		if(clicou.getSource().equals(sair)){
			Tela a = new Tela();
			a.playCaracol.setVisible(false);
			a.playPolvo.setVisible(false);
			a.playOstra.setVisible(true);
			dispose();
		}else
		
		
		if(!apertou){
			Ostra ostra = (Ostra) clicou.getSource();
			ostra.abrir();
			ostra.setLocation(ostra.getX(), 302);
			if (ostra.verdadeira) {
				JOptionPane.showMessageDialog(null,"Voce acertou");
				dificudade++;
				if(dificudade>2){
					dificudade = 3;
				}
				
				vidas++;
				lblpontos.setText("vidas: "+vidas);
			//	System.out.println(vidas);
				
			}else{
				vidas--;
				lblpontos.setText("vidas: "+vidas);
				
				
				dificudade--;
				if(dificudade<2){
					dificudade = 1;
				}
			}
			for (Ostra ostr : ostras) {
				ostr.abrir();
				ostr.setLocation(ostr.getX(), 302);
			}
			sleep(1000);
			for (Ostra osa : ostras) 
				osa.setVisible(false);
			
			novasOstras();
		}
		
		if(vidas==0){
			perdeu.setVisible(true);
		}
	} 
	

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
           	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	
}}
