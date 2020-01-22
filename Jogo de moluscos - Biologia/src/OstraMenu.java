import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OstraMenu extends JLabel{	
	ImageIcon abertinha;
	ImageIcon fechadinha;

	public OstraMenu(){
		
		fechadinha = (new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/fechada.png")).getImage().getScaledInstance(70, 70, 4)));
		abertinha = (new ImageIcon(new ImageIcon(getClass().getResource("imagens/ostrinha/aberta.png")).getImage().getScaledInstance(70, 70, 4)));
	}
	
	public void aberta() {
		setIcon(abertinha);
	}
	
	public void fechada() {
		setIcon(fechadinha);
	}


}
