import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Tela extends JFrame implements MouseListener{
	
	JLabel menu[] = new JLabel[4];
	
	
	JLabel playCaracol = new JLabel();
	JLabel playCaracolbg = new JLabel (new ImageIcon(getClass().getResource("imagens/caracolzinho/bgInicial.png")));
	JLabel barraCaracol = new JLabel();
	JLabel plusCaracol = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/plus.png")).getImage().getScaledInstance(20, 20, 4)));
	JLabel caracol1 = new JLabel (new ImageIcon(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho.png")).getImage().getScaledInstance(70,  70, 4)));
	JLabel caracol2 = new JLabel (new ImageIcon(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho2.png")).getImage().getScaledInstance(70,  70, 4)));
	JLabel jogarCaracol = new JLabel();
	JLabel instrCaracol = new JLabel();
	JLabel proxCaracol = new JLabel();
	
	JLabel playPolvo = new JLabel();
	JLabel playPolvobg = new JLabel(new ImageIcon(getClass().getResource("imagens/polvinho/bg.png")));
	JLabel barraPolvo = new JLabel();
	JLabel plusPolvo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/plus.png")).getImage().getScaledInstance(20, 20, 4)));
	JLabel jogarPolvo = new JLabel();
	JLabel instrPolvo = new JLabel();
	JLabel proxPolvo = new JLabel();
	
	JLabel playOstra = new JLabel();
	JLabel playOstrabg = new JLabel(new ImageIcon(getClass().getResource("imagens/ostrinha/bg.png")));
	JLabel barraOstra = new JLabel();
	JLabel plusOstra = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/plus.png")).getImage().getScaledInstance(20, 20, 4)));
	JLabel jogarOstra = new JLabel();
	JLabel instrOstra = new JLabel();
	JLabel proxOstra = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/prox.png")).getImage().getScaledInstance(50, 50, 4)));
	ImageIcon abertinha = (new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/errada.png")).getImage().getScaledInstance(70, 70, 4))); 
	ImageIcon perola = (new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/certa.png")).getImage().getScaledInstance(70, 70, 4)));
	ImageIcon fechadinha = (new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/fechada.png")).getImage().getScaledInstance(70, 70, 4)));
	JLabel ostra1 = new JLabel();
	JLabel ostra2 = new JLabel();
	JLabel ostra3 = new JLabel();
	
	JLabel playLesma = new JLabel();
	JLabel playLesmabg = new JLabel(new ImageIcon(getClass().getResource("imagens/lesminha/bg.png")));
	JLabel barraLesma = new JLabel();
	JLabel plusLesma = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/plus.png")).getImage().getScaledInstance(20, 20, 4)));
	JLabel jogarLesma = new JLabel();
	JLabel instrLesma = new JLabel();
	JLabel proxLesma = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/prox.png")).getImage().getScaledInstance(50, 50, 4)));
	
	ArrayList<Peixinho> arraypeixinho;
	Banco bancoPeixinho = new Banco();
	
	public Tela(){
		
		setTitle("Moluscos");
		setSize(768, 457);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		arraypeixinho = bancoPeixinho.pegarPeixinho();
		
		componentes();
		
		setVisible(true);
		
	}
	
	public void componentes(){
		
		playCaracol.setSize(768, 457);
		playCaracol.setLocation(0, 0);
		playCaracol.setOpaque(false);
		add(playCaracol);
		
		barraCaracol.setSize(768, 49);
		barraCaracol.setLocation(0, 0);
		barraCaracol.setOpaque(true);
		barraCaracol.setBackground(new Color(234, 0, 0));
		barraCaracol.setText("CORRIDA DE CARACÓIS");
		barraCaracol.setForeground(Color.white);
		barraCaracol.setFont(new Font("Bebas Neue", 0, 24));
		barraCaracol.setHorizontalAlignment(SwingConstants.CENTER);
		playCaracol.add(barraCaracol);
		
		plusCaracol.setSize(20, 20);
		plusCaracol.setLocation(724, 15);
		plusCaracol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		plusCaracol.addMouseListener(this);
		barraCaracol.add(plusCaracol);
		
		caracol1.setSize(70, 70);
		caracol1.setLocation(16, 334);
		playCaracol.add(caracol1);
		
		caracol2.setSize(70, 70);
		caracol2.setLocation(178, 363);
		playCaracol.add(caracol2);
		
		jogarCaracol.setSize(220, 86);
		jogarCaracol.setLocation(284, 134);
		jogarCaracol.setOpaque(true);
		jogarCaracol.setBackground(new Color(234, 0, 0));
		jogarCaracol.setForeground(Color.white);
		jogarCaracol.setText("JOGAR");
		jogarCaracol.setFont(new Font("Bebas Neue", 0, 48));
		jogarCaracol.setHorizontalAlignment(SwingConstants.CENTER);
		jogarCaracol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jogarCaracol.addMouseListener(this);
		playCaracol.add(jogarCaracol);
		
		instrCaracol.setSize(220, 69);
		instrCaracol.setLocation(jogarCaracol.getX(), jogarCaracol.getY()+90);
		instrCaracol.setOpaque(true);
		instrCaracol.setBackground(new Color(234, 0, 0));
		instrCaracol.setText("INSTRUÇÕES");
		instrCaracol.setForeground(Color.white);
		instrCaracol.setFont(new Font("Bebas Neue", 0, 31));
		instrCaracol.setHorizontalAlignment(SwingConstants.CENTER);
		instrCaracol.addMouseListener(this);
		instrCaracol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		playCaracol.add(instrCaracol);
		
		proxCaracol.setSize(50, 50);
		proxCaracol.setLocation(710, 375);
		proxCaracol.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/prox.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		proxCaracol.setCursor(new Cursor(Cursor.HAND_CURSOR));
		proxCaracol.addMouseListener(this);
		playCaracol.add(proxCaracol);
		
		playCaracolbg.setSize(768, 430);
		playCaracolbg.setLocation(0, 0);
		playCaracol.add(playCaracolbg);
		
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(true){
					while ((caracol1.getX() < 838) || (caracol2.getX() < 838)){
						caracol1.setLocation(caracol1.getX()+10, 334);
						dormir();
						
						caracol2.setLocation(caracol2.getX()+10, 363);
						dormir();
					}
					
					caracol2.setLocation(-70, 363);
					caracol1.setLocation(-170, 334);
					
				}
			}
		}).start();
		
		//play polvo

		playPolvo.setSize(768, 457);
		playPolvo.setLocation(0, 0);
		add(playPolvo);
		playPolvo.setVisible(false);
		
		barraPolvo.setSize(768, 49);
		barraPolvo.setLocation(0, 0);
		barraPolvo.setOpaque(true);
		barraPolvo.setBackground(new Color(0, 145, 206));
		barraPolvo.setText("ENCONTRE O POLVO");
		barraPolvo.setForeground(Color.white);
		barraPolvo.setFont(new Font("Bebas Neue", 0, 24));
		barraPolvo.setHorizontalAlignment(SwingConstants.CENTER);
		playPolvo.add(barraPolvo);
		
		plusPolvo.setSize(20, 20);
		plusPolvo.setLocation(724, 15);
		plusPolvo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		plusPolvo.addMouseListener(this);
		barraPolvo.add(plusPolvo);
		
		proxPolvo.setSize(50, 50);
		proxPolvo.setLocation(710, 375);
		proxPolvo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/prox.png")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		proxPolvo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		proxPolvo.addMouseListener(this);
		playPolvo.add(proxPolvo);
		
		jogarPolvo.setSize(220, 86);
		jogarPolvo.setLocation(284, 134);
		jogarPolvo.setOpaque(true);
		jogarPolvo.setBackground(new Color(0, 145, 206));
		jogarPolvo.setText("JOGAR");
		jogarPolvo.setForeground(Color.white);
		jogarPolvo.setFont(new Font("Bebas Neue", 0, 48));
		jogarPolvo.setHorizontalAlignment(SwingConstants.CENTER);
		jogarPolvo.addMouseListener(this);
		jogarPolvo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		playPolvo.add(jogarPolvo);
		
		instrPolvo.setSize(220, 69);
		instrPolvo.setLocation(jogarPolvo.getX(), jogarPolvo.getY()+90);
		instrPolvo.setOpaque(true);
		instrPolvo.setBackground(new Color(0, 145, 206));
		instrPolvo.setText("INSTRUÇÕES");
		instrPolvo.setForeground(Color.white);
		instrPolvo.setFont(new Font("Bebas Neue", 0, 31));
		instrPolvo.setHorizontalAlignment(SwingConstants.CENTER);
		instrPolvo.addMouseListener(this);
		instrPolvo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		playPolvo.add(instrPolvo);
		
		for(Peixinho peixinho : arraypeixinho){
			playPolvo.add(peixinho);
			new Thread (peixinho).start();
		}
		
		playPolvobg.setSize(768, 430);
		playPolvobg.setLocation(0, 0);
		playPolvo.add(playPolvobg);
		
		//play ostra
		
		playOstra.setSize(768, 457);
		playOstra.setLocation(0, 0);
		add(playOstra);
		playOstra.setVisible(false);
		
		barraOstra.setSize(768, 49);
		barraOstra.setLocation(0, 0);
		barraOstra.setOpaque(true);
		barraOstra.setBackground(new Color(11, 102, 147));
		barraOstra.setText("ACHE A PÉROLA");
		barraOstra.setForeground(Color.white);
		barraOstra.setFont(new Font("Bebas Neue", 0, 24));
		barraOstra.setHorizontalAlignment(SwingConstants.CENTER);
		playOstra.add(barraOstra);
		
		ostra1.setSize(70 , 70);
		ostra1.setLocation(269, 315);
		playOstra.add(ostra1);
		
		ostra2.setSize(70 , 70);
		ostra2.setLocation(348, 315);
		playOstra.add(ostra2);
		
		ostra3.setSize(70 ,70);
		ostra3.setLocation(425 , 315);
		playOstra.add(ostra3);
		
		plusOstra.setSize(20, 20);
		plusOstra.setLocation(724, 15);
		plusOstra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		plusOstra.addMouseListener(this);
		barraOstra.add(plusOstra);
		
		jogarOstra.setSize(220, 86);
		jogarOstra.setLocation(284, 134);
		jogarOstra.setOpaque(true);
		jogarOstra.setBackground(new Color(11, 102, 147));
		jogarOstra.setText("JOGAR");
		jogarOstra.setForeground(Color.white);
		jogarOstra.setFont(new Font("Bebas Neue", 0, 48));
		jogarOstra.setHorizontalAlignment(SwingConstants.CENTER);
		jogarOstra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jogarOstra.addMouseListener(this);
		playOstra.add(jogarOstra);
		
		instrOstra.setSize(220, 69);
		instrOstra.setLocation(jogarOstra.getX(), jogarOstra.getY()+90);
		instrOstra.setOpaque(true);
		instrOstra.setBackground(new Color(11, 102, 147));
		instrOstra.setText("INSTRUÇÕES");
		instrOstra.setForeground(Color.white);
		instrOstra.setFont(new Font("Bebas Neue", 0, 31));
		instrOstra.setHorizontalAlignment(SwingConstants.CENTER);
		instrOstra.addMouseListener(this);
		instrOstra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		playOstra.add(instrOstra);
		
		proxOstra.setSize(50, 50);
		proxOstra.setLocation(710, 375);
		proxOstra.setCursor(new Cursor(Cursor.HAND_CURSOR));
		proxOstra.addMouseListener(this);
		playOstra.add(proxOstra);
		
		playOstrabg.setSize(768, 430);
		playOstrabg.setLocation(0, 0);
		playOstra.add(playOstrabg);
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true){
					ostra1.setIcon(abertinha);
					sleep();
					
					ostra2.setIcon(perola);
					sleep();
					
					ostra3.setIcon(abertinha);
					sleep();
					
					ostra1.setIcon(fechadinha);
					sleep();
					
					ostra3.setIcon(fechadinha);
					sleep();
					
					ostra2.setIcon(fechadinha);
					sleep();
				}
				
			}
		}).start();
		
		//play lesma
		
		playLesma.setSize(768, 457);
		playLesma.setLocation(0, 0);
		add(playLesma);
		playLesma.setVisible(false);
		
		barraLesma.setSize(768, 49);
		barraLesma.setLocation(0, 0);
		barraLesma.setOpaque(true);
		barraLesma.setBackground(new Color(0, 213, 0));
		barraLesma.setText("FUJA DO SAL");
		barraLesma.setForeground(Color.white);
		barraLesma.setFont(new Font("Bebas Neue", 0, 24));
		barraLesma.setHorizontalAlignment(SwingConstants.CENTER);
		playLesma.add(barraLesma);
		
		plusLesma.setSize(20, 20);
		plusLesma.setLocation(724, 15);
		plusLesma.setCursor(new Cursor(Cursor.HAND_CURSOR));
		plusLesma.addMouseListener(this);
		barraLesma.add(plusLesma);
		
		jogarLesma.setSize(220, 86);
		jogarLesma.setLocation(284, 134);
		jogarLesma.setOpaque(true);
		jogarLesma.setBackground(new Color(0, 213, 0));
		jogarLesma.setText("JOGAR");
		jogarLesma.setForeground(Color.white);
		jogarLesma.setFont(new Font("Bebas Neue", 0, 48));
		jogarLesma.setHorizontalAlignment(SwingConstants.CENTER);
		jogarLesma.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jogarLesma.addMouseListener(this);
		playLesma.add(jogarLesma);
		
		instrLesma.setSize(220, 69);
		instrLesma.setLocation(jogarLesma.getX(), jogarLesma.getY()+90);
		instrLesma.setOpaque(true);
		instrLesma.setBackground(new Color(0, 213, 0));
		instrLesma.setText("INSTRUÇÕES");
		instrLesma.setForeground(Color.white);
		instrLesma.setFont(new Font("Bebas Neue", 0, 31));
		instrLesma.setHorizontalAlignment(SwingConstants.CENTER);
		instrLesma.addMouseListener(this);
		instrLesma.setCursor(new Cursor(Cursor.HAND_CURSOR));
		playLesma.add(instrLesma);
		
		proxLesma.setSize(50, 50);
		proxLesma.setLocation(710, 375);
		proxLesma.setCursor(new Cursor(Cursor.HAND_CURSOR));
		proxLesma.addMouseListener(this);
		playLesma.add(proxLesma);
		
		playLesmabg.setSize(768, 430);
		playLesmabg.setLocation(0, 0);
		playLesmabg.setOpaque(true);
		playLesmabg.setBackground(new Color(63, 198, 237));
		playLesma.add(playLesmabg);
	}
	
	public void dormir(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void sleep() {
		try {
			Thread.sleep(400);
		} catch (Exception e) {
			
		}
	}
	
	

	
	@Override
	public void mouseClicked(MouseEvent clicou) {

		prox(clicou);
		jogar(clicou);
		plus(clicou);
		instr(clicou);
		
	}

	private void instr(MouseEvent clicou) {
		if(clicou.getSource().equals(instrPolvo)){
			dispose();
			new polvoInstrucoes();
		}
		
		if(clicou.getSource().equals(instrCaracol)){
			dispose();
			new caracolInstrucoes();
		}
		
		if(clicou.getSource().equals(instrOstra)){
			dispose();
			new instrOstra();
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
	
	public void prox(MouseEvent clicou){
		if(clicou.getSource().equals(proxCaracol)){
			playPolvo.setVisible(true);
			playCaracol.setVisible(false);
		}
		
		if(clicou.getSource().equals(proxPolvo)){
			playOstra.setVisible(true);
			playPolvo.setVisible(false);
		}
		
		if(clicou.getSource().equals(proxOstra)){
			playOstra.setVisible(false);
			playLesma.setVisible(true);
		}
		
		if(clicou.getSource().equals(proxLesma)){
			playLesma.setVisible(false);
			playCaracol.setVisible(true);
		}
	}
	
	public void jogar(MouseEvent clicou){
		if(clicou.getSource().equals(jogarCaracol)){
			new TelaCaracol();
			dispose();
		}
		
		if(clicou.getSource().equals(jogarPolvo)){
			new TelaPolvo();
			dispose();
		}
		
		if(clicou.getSource().equals(jogarOstra)){
			new TelaOstra();
			dispose();
		}
		
		if(clicou.getSource().equals(jogarLesma)){
			new TelaLesma();
			dispose();
		}
	}
	
	public void plus(MouseEvent clicou){
		if(clicou.getSource().equals(plusPolvo)){
			new CuriosidadePolvo();
			dispose();
		}
		
		if(clicou.getSource().equals(plusCaracol)){
			new CuriosidadeCaracol();
			dispose();
		}
		
		if(clicou.getSource().equals(plusOstra)){
			new CuriosidadeOstra();
			dispose();
		}
		
		if(clicou.getSource().equals(plusLesma)){
			new CuriosidadeLesma();
			dispose();
		}
	}}
