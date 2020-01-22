import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Efeito {
	
	private static Efeito efeito;
	public static Efeito getInstance(){
		if(efeito == null){
			efeito = new Efeito();
		}
		
		return efeito;
	}
	ArrayList<Point> posicao11 = new ArrayList<>();
	ArrayList<Point> posicao12 = new ArrayList<>();
	ArrayList<Point> posicao13 = new ArrayList<>();
	ArrayList<Point> posicao14 = new ArrayList<>();
	ArrayList<Point> posicao15 = new ArrayList<>();
	ArrayList<Point> posicao16 = new ArrayList<>();
	
	ArrayList<Point> posicao22 = new ArrayList<>();
	ArrayList<Point> posicao21 = new ArrayList<>();
	ArrayList<Point> posicao23 = new ArrayList<>();
	ArrayList<Point> posicao24 = new ArrayList<>();
	ArrayList<Point> posicao25 = new ArrayList<>();
	ArrayList<Point> posicao26 = new ArrayList<>();
	
	ArrayList<Point> posicao31 = new ArrayList<>();
	ArrayList<Point> posicao32 = new ArrayList<>();
	ArrayList<Point> posicao33 = new ArrayList<>();
	ArrayList<Point> posicao34 = new ArrayList<>();
	ArrayList<Point> posicao35 = new ArrayList<>();
	ArrayList<Point> posicao36 = new ArrayList<>();
	ArrayList<Point> posicao37 = new ArrayList<>();
	ArrayList<Point> posicao38 = new ArrayList<>();
	ArrayList<Point> posicao39 = new ArrayList<>();
	ArrayList<Point> posicao40 = new ArrayList<>();
	
	public Efeito(){
//		for (int i = 0; i < 3; i++) {
			posicao11.add(new Point(425 , 315));//3
			posicao11.add(new Point(269, 315));//1
			posicao11.add(new Point(348, 315));//2
			
			posicao12.add(new Point(348, 315));//2
			posicao12.add(new Point(269, 315));//1
			posicao12.add(new Point(425, 315));//3
			
			posicao13.add(new Point(425 , 315));//3
			posicao13.add(new Point(348 , 315));//2
			posicao13.add(new Point(269 , 315));//1
			
			posicao14.add(new Point(269 , 315)); //1
			posicao14.add(new Point(425 , 315)); //3
			posicao14.add(new Point(348 , 315)); //2
			
			posicao15.add(new Point(348 , 315)); //2
			posicao15.add(new Point(425 , 315)); //3
			posicao15.add(new Point(269 , 315)); //1
			
			posicao16.add(new Point(269 , 315)); //1
			posicao16.add(new Point(348 , 315)); //2
			posicao16.add(new Point(425 , 315)); //3
			
			//efeito2
			posicao22.add(new Point(392 , 315)); //3
			posicao22.add(new Point(230 , 315)); //1
			posicao22.add(new Point(473 , 315));//4
			posicao22.add(new Point(311 , 315));//2
			
			posicao21.add(new Point(473 , 315));//4
			posicao21.add(new Point(311 , 315));//2
			posicao21.add(new Point(230 , 315));//1
			posicao21.add(new Point(392 , 315));//3
			
			posicao23.add(new Point(311 , 315));//2
			posicao23.add(new Point(392 , 315));//3
			posicao23.add(new Point(230 , 315));//1
			posicao23.add(new Point(473 , 315));//4
			
			posicao24.add(new Point(230 , 315));//1
			posicao24.add(new Point(473 , 315));//4
			posicao24.add(new Point(311 , 315));//2
			posicao24.add(new Point(392 , 315));//3
			
			posicao25.add(new Point(311, 315)); //2
			posicao25.add(new Point(230, 315)); //1
			posicao25.add(new Point(392, 315)); //3
			posicao25.add(new Point(473, 315)); //4
			
			posicao26.add(new Point(392 , 315)); //3
			posicao26.add(new Point(437, 315)); //4
			posicao26.add(new Point(311, 315)); //2
			posicao26.add(new Point(230, 315)); //1
			
			//efeito 3
			
			posicao31.add(new Point(319, 315)); //3
			posicao31.add(new Point(400, 315)); //4
			posicao31.add(new Point(561, 315)); //6
			posicao31.add(new Point(238, 315)); //2
			posicao31.add(new Point(481, 315)); //5
			posicao31.add(new Point(160, 315)); //1
			
			posicao32.add(new Point(238, 315)); //2
			posicao32.add(new Point(561, 315)); //6
			posicao32.add(new Point(319, 315)); //3
			posicao32.add(new Point(400, 315)); //4
			posicao32.add(new Point(160, 315)); //1
			posicao32.add(new Point(481, 315)); //5
			
			posicao33.add(new Point(400, 315)); //4
			posicao33.add(new Point(481, 315)); //5
			posicao33.add(new Point(160, 315)); //1
			posicao33.add(new Point(238, 315)); //2
			posicao33.add(new Point(319, 315)); //3
			posicao33.add(new Point(561, 315)); //6
			
			posicao34.add(new Point(481, 315)); //5
			posicao34.add(new Point(238, 315)); //2
			posicao34.add(new Point(400, 315)); //4
			posicao34.add(new Point(319 , 315));//3
			posicao34.add(new Point(561, 315)); //6
			posicao34.add(new Point(160, 315)); //1
			
			posicao35.add(new Point(561, 315)); //6
			posicao35.add(new Point(160, 315)); //1
			posicao35.add(new Point(238, 315)); //2
			posicao35.add(new Point(481, 315)); //5
			posicao35.add(new Point(400, 315)); //4
			posicao35.add(new Point(319, 315)); //3
			
			posicao36.add(new Point(481, 315)); //5
			posicao36.add(new Point(561, 315));	//6
			posicao36.add(new Point(400, 315));	//4
			posicao36.add(new Point(319, 315));	//3
			posicao36.add(new Point(160, 315)); //1
			posicao36.add(new Point(238, 315));	//2
			
			posicao37.add(new Point(561, 315)); //5
			posicao37.add(new Point(238, 315)); //2
			posicao37.add(new Point(561, 315)); //6
			posicao37.add(new Point(160, 315));	//1
			posicao37.add(new Point(400, 315)); //4
			posicao37.add(new Point(319, 315)); //3
			
			posicao38.add(new Point(238, 315)); //2
			posicao38.add(new Point(319, 315)); //3
			posicao38.add(new Point(160, 315)); //1
			posicao38.add(new Point(400, 315));	//4
			posicao38.add(new Point(561, 315)); //6
			posicao38.add(new Point(561, 315)); //5
			
			posicao39.add(new Point(319, 315)); //3
			posicao39.add(new Point(160, 315)); //1
			posicao39.add(new Point(561, 315)); //5
			posicao39.add(new Point(238, 315)); //2
			posicao39.add(new Point(400, 315));	//4
			posicao39.add(new Point(561, 315)); //6
			
			posicao40.add(new Point(561, 315)); //6
			posicao40.add(new Point(400, 315));	//4
			posicao40.add(new Point(561, 315)); //5
			posicao40.add(new Point(160, 315)); //1
			posicao40.add(new Point(238, 315)); //2
			posicao40.add(new Point(319, 315)); //3
//		}
			

	}
	
	public void embaralha(ArrayList<Ostra> ostras){
		ArrayList<Point> posicoes = null;
		Random r = new Random();
		if(ostras.size() == 3){
			int s = r.nextInt(5);
			if(s ==  0)
				posicoes = posicao11;
			else if(s == 1)
				posicoes = posicao12;
			else if (s == 2)
				posicoes = posicao13;
			else if(s == 3)
				posicoes = posicao14;
			else if(s == 4)
				posicoes = posicao15;
			else if(s == 5)
				posicoes = posicao16;
		}
		for (int i = 0; i < ostras.size(); i++) {
			ostras.get(i).x = posicoes.get(i).x;
			ostras.get(i).y = posicoes.get(i).y;
			ostras.get(i).anda(ostras);
		}
	}
	
	public void embaralha2(ArrayList<Ostra> ostras ) {
		ArrayList<Point> position = null;
		Random l = new Random();
		if (ostras.size() == 4) {
			int w = l.nextInt(5);
			if (w == 0) 
				position = posicao22;
			else if (w == 1) 
				position = posicao21;
			else if (w == 2)
				position = posicao23;
			else if (w == 3)
				position = posicao24;
			else if (w == 4)
				position = posicao25;
			else if (w == 5)
				position = posicao26;
		}for (int j = 0; j < ostras.size(); j++) {
			ostras.get(j).x = position.get(j).x;
			ostras.get(j).y = position.get(j).y;
			ostras.get(j).anda(ostras);
			
		}
	}
	
	public void embaralha3(ArrayList<Ostra> ostras) {
		ArrayList<Point> posicao = null;
		Random q = new Random();
		if (ostras.size() == 6) {
			int a = q.nextInt(5);
			if (a == 0)
				posicao = posicao31;
			else if (a == 1)
				posicao = posicao32;
			else if (a == 2)
				 posicao = posicao33;
			else if (a == 3)
				posicao = posicao34;
			else if (a == 4)
				posicao = posicao35;
			else if (a == 5)
				posicao = posicao36;
		}for (int t = 0; t < ostras.size(); t++) {
			if(ostras.get(t)!=null && posicao!=null){
				ostras.get(t).x = posicao.get(t).x;
				ostras.get(t).y = posicao.get(t).y;
				ostras.get(t).anda(ostras);
			}
		}
	}
	

	

}
