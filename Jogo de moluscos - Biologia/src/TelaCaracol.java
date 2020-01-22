import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class TelaCaracol extends JFrame implements MouseListener{
	
	Caracolzinho caracolzinho1;
	Caracolzinho caracolzinho2;
	
	JLabel container = new JLabel();
	JLabel barraS = new JLabel();
	JLabel caracolbonus1 = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho1barra.png")));
	JLabel caracolbonus2 = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho2barra.png")));
	JProgressBar bonus1 = new JProgressBar();
	JProgressBar bonus2 = new JProgressBar();
	JLabel borda1 = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/bordaBarra.png")));
	JLabel borda2 = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/bordaBarra.png")));
	JLabel local = new JLabel();
	JLabel caracollocal1 = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho1barra.png")));
	JLabel caracollocal2 = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho2barra.png")));
	JLabel background = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/pistaNormal.png")));
	
	JLabel ganhou = new JLabel();
	JLabel barraS2 = new JLabel();
	JLabel venceu = new JLabel();
	JLabel branca = new JLabel();
	JLabel coroa = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/caracolzinho/coroa.png")).getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH)));
	JLabel vencedor1 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
	JLabel vencedor2 = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/caracolzinho/caracolzinho2.png")).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
	JLabel jogarN = new JLabel();
	JLabel sair = new JLabel(new ImageIcon(new ImageIcon(getClass().getResource("imagens/sair.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
	JLabel ganhoubg = new JLabel(new ImageIcon(getClass().getResource("imagens/caracolzinho/bgInicial.png")));
	
	TelaCaracol(){
		
		setTitle("Corrida de caracóis");
		setSize(768, 457);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		componentes();
		
		setVisible(true);
		
	}
	
	public void componentes(){
		
		container.setSize(768, 457);
		container.setLocation(0, 0);
		add(container);
		
		
		caracolzinho2 = new Caracolzinho(362, "caracolzinho2.png", 2, this);
		caracolzinho2.eu = 2;
		addKeyListener(caracolzinho2);
		background.add(caracolzinho2);
		
		caracolzinho1 = new Caracolzinho(322, "caracolzinho.png", 1, this);
		caracolzinho1.eu = 1;
		addKeyListener(caracolzinho1);
		background.add(caracolzinho1);
		
		caracolzinho1.caracolzinho = caracolzinho2;
		caracolzinho2.caracolzinho = caracolzinho1;
		
		caracolbonus1.setSize(30, 30);
		caracolbonus1.setLocation(35, 8);
		container.add(caracolbonus1);
		
		borda1.setSize(116, 14);
		borda1.setLocation(44, 16);
		container.add(borda1);
		
		bonus1.setSize(116, 14);
		bonus1.setLocation(44, 16);
		bonus1.setValue(100);
		bonus1.setOpaque(false);
		bonus1.setForeground(Color.white);
		container.add(bonus1);
		
		caracolbonus2.setSize(30, 30);
		caracolbonus2.setLocation(211, 8);
		container.add(caracolbonus2);
		
		borda2.setSize(116, 14);
		borda2.setLocation(223, 16);
		container.add(borda2);
		
		bonus2.setSize(116, 14);
		bonus2.setLocation(223, 16);
		bonus2.setValue(100);
		bonus2.setOpaque(false);
		bonus2.setForeground(Color.white);
		container.add(bonus2);

		caracollocal1.setSize(30, 30);
		caracollocal1.setLocation(364, 7);
		container.add(caracollocal1);
		
		caracollocal2.setSize(30, 30);
		caracollocal2.setLocation(364, 7);
		container.add(caracollocal2);
		
		local.setSize(384, 13);
		local.setLocation(368, 16);
		local.setOpaque(true);
		local.setBackground(Color.white);
		container.add(local);
		
		barraS.setSize(768, 49);
		barraS.setLocation(0, 0);
		barraS.setOpaque(true);
		barraS.setBackground(new Color(234, 0, 0));
		container.add(barraS);
		
		background.setSize(2304, 430);
		background.setLocation(0, 0);
		container.add(background);
		
		//ganhou
		
		ganhou.setSize(768, 430);
		ganhou.setLocation(0, 0);
		add(ganhou);
		
		coroa.setSize(70, 70);
		coroa.setLocation(150, 100);
		branca.add(coroa);
		
		vencedor1.setSize(150, 150);
		vencedor1.setLocation(131, 130);
		branca.add(vencedor1);
		
		vencedor2.setSize(150, 150);
		vencedor2.setLocation(131, 130);
		branca.add(vencedor2);
		
		branca.setSize(413, 294);
		branca.setLocation(177, 68);
		branca.setOpaque(true);
		branca.setBackground(Color.white);
		branca.setBorder(BorderFactory.createLineBorder(new Color(234, 0, 0), 3));
		ganhou.add(branca);
		
		venceu.setSize(branca.getWidth(), 55);
		venceu.setLocation(0, 0);
		venceu.setOpaque(true);
		venceu.setBackground(new Color(234, 0, 0));
		venceu.setText("VOCÊ GANHOU");
		venceu.setForeground(Color.white);
		venceu.setFont(new Font("Bebas Neue", 0, 30));
		venceu.setHorizontalAlignment(SwingConstants.CENTER);
		branca.add(venceu);
		
		jogarN.setSize(143, 18);
		jogarN.setLocation(447, 370);
		jogarN.setText("JOGAR NOVAMENTE");
		jogarN.setFont(new Font("Bebas Neue", 0, 24));
		jogarN.setForeground(Color.white);
		jogarN.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jogarN.addMouseListener(this);
		ganhou.add(jogarN);
		
		sair.setSize(30, 30);
		sair.setLocation(720, 6);
		sair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		sair.addMouseListener(this);
		ganhou.add(sair);
		
		barraS2.setSize(768, 49);
		barraS2.setLocation(0, 0);
		barraS2.setOpaque(true);
		barraS2.setBackground(new Color(234, 0, 0));
		ganhou.add(barraS2);
		
		ganhoubg.setSize(768, 430);
		ganhoubg.setLocation(0, 0);
		ganhou.add(ganhoubg);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent clicou) {
		if(clicou.getSource().equals(jogarN)){
			dispose();
			new TelaCaracol();
		}else{
			dispose();
			new Tela();
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
