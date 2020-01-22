import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class TelaLesma extends JFrame implements Runnable, MouseListener{
	
	JLabel container = new JLabel();
	JLabel bg = new JLabel();
	JLabel bg2 = new JLabel();
	JLabel mao = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/mao.png")).getImage().getScaledInstance(230, 270, 4)));
	JLabel barraS = new JLabel();
	JLabel borda = new JLabel(new ImageIcon(getClass().getResource("imagens/lesminha/bordaBarra.png")));
	JLabel moeda = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/bonus1.png")).getImage().getScaledInstance(35, 35, 4)));
	JLabel numMoeda = new JLabel();
	JLabel escudo = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/bonus2.png")).getImage().getScaledInstance(35, 35, 4)));
	JLabel metros = new JLabel();
	
	JProgressBar barraP = new JProgressBar();
	
	Chao lblprimeirochao;
	Lesma lesminha;
	
	JLabel perdeu = new JLabel();
	JLabel perdeuTitle = new JLabel();
	JLabel meusMetros = new JLabel();
	JLabel continuar = new JLabel();
	JLabel moedinha = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/bonus1.png")).getImage().getScaledInstance(30, 30, 4)));
	JLabel jogarN = new JLabel();
	JLabel sair = new JLabel("SAIR");
	
	int tempoPlataforma=2000;
	int addMoeda = 00;
	int contaPode = 0;
	int addMetro = 0;
	int contaTempo = 50;
	int aux =0;
	
	boolean cima = true;
	boolean pode = true;
	
	ArrayList<Chao> chaozinho = new ArrayList<>();
	ArrayList<Moeda> booster = new ArrayList<>();

	public TelaLesma(){
		
		setTitle("Fuja do sal");
		setSize(768, 457);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		componentes();
		
		setVisible(true);
		
	}
	
	public void componentes(){
		
		//perdeu
		
		perdeu.setSize(321, 178);
		perdeu.setLocation(223, 87);
		perdeu.setOpaque(true);
		perdeu.setBackground(Color.white);
		perdeu.setBorder(BorderFactory.createLineBorder(new Color(0, 213, 0), 3));
		perdeu.setVisible(false);
		add(perdeu);
		
		perdeuTitle.setSize(321, 41);
		perdeuTitle.setLocation(0, 0);
		perdeuTitle.setOpaque(true);
		perdeuTitle.setBackground(new Color(0, 213, 0));
		perdeuTitle.setText("VOCÊ PERDEU");
		perdeuTitle.setForeground(Color.white);
		perdeuTitle.setFont(new Font("Bebas Neue", 0, 24));
		perdeuTitle.setHorizontalAlignment(SwingConstants.CENTER);
		perdeu.add(perdeuTitle);
		
		meusMetros.setSize(80, 23);
		meusMetros.setLocation(120, 85);
		meusMetros.setText("");
		meusMetros.setForeground(new Color(0, 231, 0));
		meusMetros.setFont(new Font("Bebas Neue", 0, 24));
		meusMetros.setHorizontalAlignment(SwingConstants.CENTER);
		perdeu.add(meusMetros);
		
		continuar.setSize(151, 23);
		continuar.setLocation(90, 107);
		continuar.setText("CONTINUAR 30");
		continuar.setFont(new Font("Bebas Neue", 0, 24));
		continuar.setForeground(new Color(0, 213, 0));
		continuar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		continuar.addMouseListener(this);
		perdeu.add(continuar);
		
		moedinha.setSize(30, 30);
		moedinha.setLocation(215, 103);
		perdeu.add(moedinha);
		
		jogarN.setSize(143, 18);
		jogarN.setLocation(400, 270);
		jogarN.setText("JOGAR NOVAMENTE");
		jogarN.setFont(new Font("Bebas Neue", 0, 24));
		jogarN.setForeground(Color.white);
		jogarN.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jogarN.addMouseListener(this);
		jogarN.setVisible(false);
		container.add(jogarN);
		
		sair.setSize(43, 23);
		sair.setLocation(230, 270);
		sair.setForeground(Color.white);
		sair.setFont(new Font("Bebas Neue", 0, 24));
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sair.addMouseListener(this);
		sair.setVisible(false);
		container.add(sair);
		
		//geral
		
		escudo.setSize(35, 35);
		escudo.setLocation(105, 5);
		escudo.setVisible(false);
		add(escudo);
		
		borda.setSize(155, 29);
		borda.setLocation(123, 9);
		borda.setVisible(false);
		add(borda);
		
		barraP.setSize(155, 29);
		barraP.setLocation(123, 9);
		barraP.setOpaque(false);
		barraP.setValue(100);
		barraP.setForeground(Color.white);
		barraP.setVisible(false);
		add(barraP);
		
		container.setSize(768, 457);
		container.setLocation(0, 0);
		add(container);
		
		mao.setSize(230, 270);
		mao.setLocation(-67, 0);
		container.add(mao);
		
		moeda.setSize(35, 35);
		moeda.setLocation(21, 7);
		container.add(moeda);
		
		numMoeda.setSize(37, 40);
		numMoeda.setLocation(62, 14);
		numMoeda.setText(""+addMoeda);
		numMoeda.setForeground(Color.white);
		numMoeda.setFont(new Font("Bebas Neue", 0, 24));
		numMoeda.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(numMoeda);
		
		metros.setSize(67, 23);
		metros.setLocation(681, 15);
		metros.setText(""+addMetro+"M");
		metros.setForeground(Color.white);
		metros.setFont(new Font("Bebas Neue", 0, 24));
		metros.setHorizontalAlignment(SwingConstants.RIGHT);
		container.add(metros);
		
		barraS.setSize(768, 49);
		barraS.setLocation(0, 0);
		barraS.setOpaque(true);
		barraS.setBackground(new Color(0, 213, 0));
		container.add(barraS);
		
		bg.setSize(768, 430);
		bg.setLocation(0, 0);
		bg.setOpaque(true);
		bg.setBackground(new Color(63, 198, 237));
		add(bg);
		
		lblprimeirochao = new Chao(this);
		lblprimeirochao.setSize(700 , 180);
		lblprimeirochao.setLocation(0, 250);
		lblprimeirochao.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("imagens/lesminha/chao.png")).getImage().getScaledInstance(700, 180, 4)));
		tempoPlataforma = 10;
		chaozinho.add(lblprimeirochao);
		
		lesminha = new Lesma(this);
		addKeyListener(lesminha);
		
		container.add(lesminha);
		container.add(lblprimeirochao);
		
		
		TelaLesma eu = this;
		new Thread(new Runnable (){
			int contadorSegundos =0;
			@Override
			public void run() {
				while(true){
					try {
						Thread.sleep(50);
						contadorSegundos+=50;
						if(!pode){
							contaPode+=50;
						}
						
						if(contaPode == 8000){
							contaPode = 0;
							pode = true;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					if(contadorSegundos >= tempoPlataforma){
						Chao c = new Chao(eu);
						container.add(c);
						chaozinho.add(c);
						contadorSegundos = 0;
					}
					
				}
				
			}
			
		}).start();
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent clicou) {
		if(clicou.getSource().equals(continuar)){
			if(addMoeda >= 30){
				removeKeyListener(lesminha);
				lesminha = new Lesma(this);
				container.add(lesminha);
				addKeyListener(lesminha);
				lesminha.setLocation(400, 10);
				lesminha.bati = false;
				perdeu.setVisible(false);
				jogarN.setVisible(false);
				sair.setVisible(false);
				addMoeda-=30;
				numMoeda.setText(""+addMoeda);
			}
		}
		
		if(clicou.getSource().equals(jogarN)){
			new TelaLesma();
			dispose();
		}
		
		if(clicou.getSource().equals(sair)){
			dispose();
			Tela a = new Tela();
			a.playCaracol.setVisible(false);
			a.playPolvo.setVisible(false);
			a.playOstra.setVisible(false);
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
	
	
	
}
