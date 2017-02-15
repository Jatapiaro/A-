import java.util.HashMap;

public class Test{
	public static void main(String[] args) {

		Grafo gf = new Grafo();

		HashMap<Character,Integer> heuristic = new HashMap<Character,Integer>();
		heuristic.put('A',42);
		heuristic.put('B',40);
		heuristic.put('C',35);
		heuristic.put('D',30);
		heuristic.put('E',50);
		heuristic.put('F',18);
		heuristic.put('G',20);
		heuristic.put('H',0);
		heuristic.put('I',15);

		//gf.setHeuristic(heuristic);

		Nodo a = new Nodo('A');
		Nodo b = new Nodo('B');
		Nodo c = new Nodo('C');
		Nodo d = new Nodo('D');
		Nodo e = new Nodo('E');
		Nodo f = new Nodo('F');
		Nodo g = new Nodo('G');
		Nodo h = new Nodo('H');
		Nodo i = new Nodo('I');

		Nodo[] nodos = {a,b,c,d,e,f,g,h,i};

		gf.addNodos(nodos);


		gf.addAdyacente('A','D',15);
		gf.addAdyacente('A','B',10);

		gf.addAdyacente('D','E',7);

		System.out.println(gf.aStar('S','G',heuristic));

	}

}