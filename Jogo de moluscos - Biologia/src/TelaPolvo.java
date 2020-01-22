
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
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

public class TelaPolvo extends JFrame implements MouseListener{
	
	ArrayList<Ponto> arraypolvo;
	ArrayList<Peixe> arraypeixe;
	ArrayList<Peixinho> arraypeixinho;
	PolvinhoBonus polvinhobonus;
	
	Banco bancoPolvo = new Banco();
	Banco bancoPeixe = new Banco();
	Banco bancoPeixinho = new Banco();
	Banco bancoPolvinho = new Banco();
	
	Polvo polvo = new Polvo();
	Random sortear = new Random();
	
	JLabel container = new JLabel();
	JLabel barraS = new JLabel();
	JLabel bordaBarra = new JLabel(new ImageIcon(getClass().getResource("imagens/polvinho/barraContorno.png")));
	JProgressBar barra = new JProgressBar();
	JLabel pontos = new JLabel();
	JLabel errou = new JLabel();
	JLabel background = new JLabel(new ImageIcon(getClass().getResource("imagens/polvinho/bg.png")));
	
	JLabel perdeu = new JLabel();
	JLabel bgperdeu = new JLabel (new ImageIcon(getClass().getResource("imagens/polvinho/bg.png")));
	JLabel perdeuTitle = new JLabel();
	JLabel caixa = new JLabel();
	JLabel ranking = new JLabel();
	JLabel polvoPerdeu = new JLabel(new ImageIcon(getClass().getResource("imagens/polvinho/polvoFinal2.png")));
	JLabel jogarN = new JLabel();
	JLabel sair = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/sair.png")).getImage().getScaledInstance(30, 30, 4)));
	
	
	boolean ganhou = false;
	int addponto = 000, I;
	
	public TelaPolvo(){
		
		setTitle("Ache o polvo");
		setSize(768, 457);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		arraypolvo = bancoPolvo.pegarPolvo();
		arraypeixe = bancoPeixe.pegarPeixe();
		arraypeixinho = bancoPeixinho.pegarPeixinho();
		polvinhobonus = bancoPolvinho.pegarPolvinho(); 
		
		componentes();

		setVisible(true);
		
	}
	
	public void componentes(){
		
		//principal game
		
		container.setSize(768, 457);
		container.setLocation(0, 0);
		add(container);
		
		polvinhobonus.addMouseListener(this);
		container.add(polvinhobonus);
		
		for(Peixe peixinho : arraypeixe){
			peixinho.polvo = polvo;
			container.add(peixinho);
		}
		
		for(Peixinho peixinho : arraypeixinho){
			container.add(peixinho);
			new Thread (peixinho).start();
		}
		
		barraS.setSize(768, 49);
		barraS.setLocation(0, 0);
		barraS.setOpaque(true);
		barraS.setBackground(new Color(0, 145, 206));
		container.add(barraS);
		
		bordaBarra.setSize(155, 29);
		bordaBarra.setLocation(578, 7);
		barraS.add(bordaBarra);
		
		barra.setSize(155, 29);
		barra.setLocation(578, 7);
		barra.setOpaque(false);
		barra.setValue(100);
		barra.setForeground(Color.white);
		barraS.add(barra);
		
		pontos.setSize(40, 25);
		pontos.setLocation(530, 9);
		pontos.setText(""+addponto);
		pontos.setForeground(Color.white);
		pontos.setFont(new Font("Bebas Neue", 0, 25));
		pontos.setHorizontalAlignment(SwingConstants.RIGHT);
		barraS.add(pontos);
		
		int index = sortear.nextInt(arraypolvo.size());
		polvo.setLocation(arraypolvo.get(index).x , arraypolvo.get(index).y);
		polvo.setIcon(arraypolvo.get(index).imagemPolvo);
		arraypolvo.remove(index);
		polvo.addMouseListener(this);
		container.add(polvo);
		
		errou.setSize(getSize());
		errou.setLocation(0, 0);
		errou.addMouseListener(this);
		container.add(errou);
		
		background.setSize(768, 430);
		background.setLocation(0, 0);
		container.add(background);
		
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(barra.getValue() != 0 && !ganhou){
					if(polvo.pausa) continue;
					barra.setValue(barra.getValue()-1);
					try { Thread.sleep(140); } catch (Exception e) {  System.out.println(e.getMessage());
					}
				}
				
				if(!ganhou){
					container.setVisible(false);
					perdeu.setVisible(true);
				}
			}
		}).start();
		
		//menu
		
		perdeu.setSize(768, 457);
		perdeu.setLocation(0, 0);
		perdeu.setOpaque(true);
		add(perdeu);
		setVisible(false);
		
		perdeuTitle.setSize(768, 49);
		perdeuTitle.setLocation(0, 0);
		perdeuTitle.setOpaque(true);
		perdeuTitle.setBackground(new Color(0, 145, 206));
		perdeuTitle.setText("VOCÊ PERDEU");
		perdeuTitle.setForeground(Color.white);
		perdeuTitle.setFont(new Font("Bebas Neue", 0, 36));
		perdeuTitle.setHorizontalAlignment(SwingConstants.CENTER);
		perdeu.add(perdeuTitle);
		
		sair.setSize(30, 30);
		sair.setLocation(722, 10);
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sair.addMouseListener(this);
		perdeuTitle.add(sair);
		
		jogarN.setSize(143, 18);
		jogarN.setLocation(540, 395);
		jogarN.setText("JOGAR NOVAMENTE");
		jogarN.setFont(new Font("Bebas Neue", 0, 24));
		jogarN.setForeground(Color.white);
		jogarN.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jogarN.addMouseListener(this);
		perdeu.add(jogarN);
		
		caixa.setSize(596, 303);
		caixa.setLocation(86, 88);
		caixa.setOpaque(true);
		caixa.setBackground(Color.white);
		caixa.setBorder(BorderFactory.createLineBorder(new Color(0, 145, 206), 4));
		perdeu.add(caixa);
		
		ranking.setSize(caixa.getWidth(), 55);
		ranking.setLocation(0, 0);
		ranking.setOpaque(true);
		ranking.setBackground(new Color(0, 145, 206));
		ranking.setText("RANKING");
		ranking.setForeground(Color.white);
		ranking.setFont(new Font("Bebas Neue", 0, 24));
		ranking.setHorizontalAlignment(SwingConstants.CENTER);
		caixa.add(ranking);
		
		polvoPerdeu.setSize(150, 150);
		polvoPerdeu.setLocation(27, 129);
		caixa.add(polvoPerdeu);
		
		bgperdeu.setSize(768, 430);
		bgperdeu.setLocation(0, 0);
		perdeu.add(bgperdeu);
		
	}
	

	@Override
	public void mouseClicked(MouseEvent clicou) {
		if(clicou.getSource().equals(errou)){
			barra.setValue(barra.getValue()-10);
		}else if(clicou.getSource().equals(polvinhobonus)){
			addponto+=50;
			pontos.setText(""+addponto);
			polvinhobonus.setVisible(false);
		}else if(clicou.getSource().equals(jogarN)){
			new TelaPolvo();
		}else if(clicou.getSource().equals(sair)){
			dispose();
			Tela a = new Tela();
			a.playCaracol.setVisible(false);
			a.playPolvo.setVisible(true);
		}else{
			if (!arraypolvo.isEmpty()){
				
				for (Peixe peixinho : arraypeixe){
					new Thread (peixinho).start();
				}
				
				polvinhobonus.setVisible(true);
				new Thread(polvinhobonus).start();
				
				int sorteia = sortear.nextInt(arraypolvo.size());
				polvo.setLocation(arraypolvo.get(sorteia).x , arraypolvo.get(sorteia).y);
				polvo.setIcon(arraypolvo.get(sorteia).imagemPolvo);
				polvo.setVisible(false);
				polvo.pausa = true;
				
				revalidate();
				repaint();
				
				addponto += 10;
				pontos.setText(""+addponto);
				
				barra.setValue(barra.getValue()+10);
				
				arraypolvo.remove(sorteia);
				
			}else{
				ganhou = true;
				addponto += 10;
				pontos.setText(""+addponto);
				JOptionPane.showMessageDialog(null, "Você ganhou");
				dispose();
			}
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
