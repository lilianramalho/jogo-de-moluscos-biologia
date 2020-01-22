import java.util.ArrayList;

public class Banco{
	
	ArrayList<Ponto> polvos = new ArrayList<Ponto>();
	ArrayList<Peixe> peixes = new ArrayList<Peixe>();
	ArrayList<Peixinho> peixinho = new ArrayList<Peixinho>();
	PolvinhoBonus polvinhobonus = new PolvinhoBonus(-50, "direita");
	
	public Banco(){
		
		polvos.add(new Ponto(244, 374, "polvo1.png"));
		polvos.add(new Ponto(704, 308, "polvo2.png"));
		polvos.add(new Ponto(55, 324, "polvo3.png"));
		polvos.add(new Ponto(440, 358, "polvo4.png"));
		polvos.add(new Ponto(116, 303, "polvo5.png"));
		polvos.add(new Ponto(373, 253, "polvo6.png"));
		polvos.add(new Ponto(511, 311, "polvo7.png"));
		
		peixes.add(new Peixe(65, 53, -200, 311, "peixe5.png", "direita", "normal"));
		peixes.add(new Peixe(90, 50, -90, 253, "peixe1.png", "direita", "rapida"));
		peixes.add(new Peixe(70, 42, -150, 303, "peixe3.png", "direita", "normal"));
		peixes.add(new Peixe(70, 39, -180, 308, "peixe6.png", "direita", "rapida"));
		peixes.add(new Peixe(68, 45, -130, 339, "peixe2.png", "direita", "rapida"));
		peixes.add(new Peixe(95, 57, -250, 374, "peixe4.png", "direita", "rapida"));
		
		peixes.add(new Peixe(83, 47, 978, 210, "peixe1e.png", "esquerda", "rapida"));
		peixes.add(new Peixe(62, 51, 858, 246, "peixe5e.png", "esquerda", "normal"));
		peixes.add(new Peixe(67, 37, 900, 292, "peixe6e.png", "esquerda", "normal"));
		peixes.add(new Peixe(95, 57, 922, 324, "peixe4e.png", "esquerda", "normal"));
		peixes.add(new Peixe(67, 40, 950, 358, "peixe3e.png", "esquerda", "rapida"));
		peixes.add(new Peixe(66, 45, 850, 390, "peixe2e.png", "esquerda", "rapida"));
		
		peixinho.add(new Peixinho(40, 22, -150, "peixe1.png", "direita"));
		peixinho.add(new Peixinho(50, 34, -60, "peixe2.png", "direita"));
		peixinho.add(new Peixinho(70, 42, -400, "peixe3.png", "direita"));
		
		peixinho.add(new Peixinho(45, 37, 1100, "peixe5e.png", "esquerda"));
		peixinho.add(new Peixinho(73, 41, 900, "peixe6e.png", "esquerda"));
		peixinho.add(new Peixinho(40, 27, 1780, "peixe2e.png", "esquerda"));
		
	}
	
	
	public ArrayList<Ponto> pegarPolvo(){
		return polvos;
	}
	
	public ArrayList<Peixe> pegarPeixe(){
		return peixes;
	}
	
	public ArrayList<Peixinho> pegarPeixinho(){
		return peixinho;
	}
	
	public PolvinhoBonus pegarPolvinho(){
		return polvinhobonus;
	}
	
}