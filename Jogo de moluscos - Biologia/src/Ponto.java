
import javax.swing.ImageIcon;

public class Ponto {
	
	int x, y;
	ImageIcon imagemPolvo;
	
	public Ponto(int x, int y, String ImagemPolvo){
		this.x = x;
		this.y = y;
		this.imagemPolvo = new ImageIcon(getClass().getResource("imagens/polvinho/"+ImagemPolvo));
	}
}
