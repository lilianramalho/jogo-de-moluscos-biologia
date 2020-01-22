import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bonus extends JLabel{
	
	Random sorteia = new Random();

	public Bonus(int y, String imagem){
		
		setSize(50, 50);
		setLocation(sorteia.nextInt(2304), y);
		setOpaque(false);
		setLayout(null);
		setIcon(new ImageIcon(getClass().getResource("imagens/caracolzinho/"+imagem)));
		setBorder(null);
		setVisible(true);
		
	}
	
}
