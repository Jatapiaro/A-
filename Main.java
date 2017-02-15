import java.util.HashMap;

public class Main{
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


		gf.addAdyacenteBi('A','B',10);
		gf.addAdyacenteBi('A','D',15);

		gf.addAdyacenteBi('D','E',7);

		gf.addAdyacenteBi('E','B',12);
		gf.addAdyacenteBi('E','F',50);

		gf.addAdyacenteBi('B','C',10);

		gf.addAdyacenteBi('C','G',20);

		gf.addAdyacenteBi('G','F',5);

		gf.addAdyacenteBi('F','I',7);
		gf.addAdyacenteBi('F','H',18);

		gf.addAdyacenteBi('H','1',15);


		System.out.println(gf.aStar('A','H',heuristic));

	}

}