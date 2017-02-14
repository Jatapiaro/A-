import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.*;

public class Main{
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


		gf.addAdyacente('S','A',1);
		gf.addAdyacente('S','B',4);
		gf.addAdyacente('A','B',2);
		gf.addAdyacente('A','C',5);
		gf.addAdyacente('A','G',12);
		gf.addAdyacente('B','C',2);
		gf.addAdyacente('C','G',3);

		System.out.println(gf.aStar('S','G',heuristic));

	}

	public static int getRandom(){
		Random rnd = new Random();
		return rnd.nextInt(10 - 1 + 1) + 1;
	}
}