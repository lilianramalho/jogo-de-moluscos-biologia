import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Polvo extends JLabel{
	
	public boolean pausa;

	public Polvo(){
		setLayout(null);
		setSize(40, 40);
		setBackground(new Color(0, 0, 0, 0));
		setBorder(null);
		setVisible(true);
		
	}
}
