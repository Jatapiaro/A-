import java.util.HashMap;

/*
*Graph with few nodes for testing
*/
public class Test{
	public static void main(String[] args) {

		Grafo gf = new Grafo();

		HashMap<Character,Integer> heuristic = new HashMap<Character,Integer>();
		heuristic.put('S',7);
		heuristic.put('A',6);
		heuristic.put('B',2);
		heuristic.put('C',1);
		heuristic.put('G',0);

		//gf.setHeuristic(heuristic);

		Nodo s = new Nodo('S');
		Nodo a = new Nodo('A');
		Nodo b = new Nodo('B');
		Nodo c = new Nodo('C');
		Nodo g = new Nodo('G');

		Nodo[] nodos = {s,a,b,c,g};

		gf.addNodos(nodos);


		gf.addAdyacenteBi('S','A',1);
		gf.addAdyacenteBi('S','B',4);
		gf.addAdyacenteBi('A','B',2);
		gf.addAdyacenteBi('A','C',5);
		gf.addAdyacenteBi('A','G',12);
		gf.addAdyacenteBi('B','C',2);
		gf.addAdyacenteBi('C','G',3);

		System.out.println(gf.aStar('S','G',heuristic));

	}

}