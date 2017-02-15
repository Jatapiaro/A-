import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.List;
import java.util.*;

public class Grafo{
	
	private HashMap<Character,Nodo> nodos;
	private HashMap<Character,Integer> heuristic;

	public Grafo(){
		nodos = new HashMap<Character,Nodo>(); 
		heuristic = new HashMap<Character,Integer>();
	}

	public void addNodos(Nodo[] nodes){
		for(Nodo n : nodes){
			this.addNodo(n);
		}
	}

	public void addNodo(Nodo n){
		if(!this.nodos.containsKey(n.getId())){
			this.nodos.put(n.getId(),n);
		}
	}

	public void addAdyacente(char origen,char destino,int peso){
		if(nodos.containsKey(origen) && nodos.containsKey(destino)){
			nodos.get(origen).addAdyacente(destino,peso);
		}
	}

	public String aStar(char inicio, char fin, HashMap<Character,Integer> heuristic){
		this.heuristic = heuristic;
		if(!nodos.containsKey(inicio) || !nodos.containsKey(fin)){
			return "Los nodos que ingresaste no están en el grafo";
		}else if(inicio == fin && nodos.containsKey(inicio) && nodos.containsKey(fin)){
			return "Camino: "+inicio+" / 0";
		}else{
			implementHeuristic();
			return aStar(inicio,fin);
		}
	}

	public String aStar(char inicio, char fin){

		List<Character> visitados = new ArrayList<Character>();
		Queue<Nodo> frontera = new PriorityQueue<Nodo>();

		Nodo incial = nodos.get(inicio);
		//System.out.println("Nodo incio: "+incial.getId()+"\n------");
		Nodo solucion;
		incial.addCamino(inicio);
		//System.out.println("Camino: "+incial.getCamino());
		frontera.add(incial);

		while(true){
			if(frontera.size() == 0){
				return "No es posible llegar de "+inicio+" a "+fin;
			}else{

				Nodo aux = frontera.poll();

				if(aux.getId() == fin){
					solucion = aux;
					break;
				}else{

					Iterator it = aux.getAdyacentes().entrySet().iterator();
					/*
					* Sacamos los adyacentes
					*/
					while (it.hasNext()) {

					    Map.Entry pair = (Map.Entry)it.next();
					    Nodo hijo = nodos.get(pair.getKey());

					    /*
					    *Si no está visitado, se añade a la fila
					    */
					    if(!visitados.contains(hijo.getId())){

					    	/*
					    	* Creamos un nuevo nodo
					    	* que utilizaremos para comparar y actualizar
					    	* en caso de que ya este dentro de frontera
					    	*/
					    	Nodo aux2 = new Nodo(hijo.getId());

					    	/*
					    	*Tomamos el camino que llevamos desde g y le añadimos
					    	* el peso para llegar a dicho adyacente
					    	* Se crea otra instancia de nodo para no modificar la instancia original
					    	*/
					    	int newG = aux.getG()+(int)pair.getValue();
					    	aux2.setG(newG);
					    	aux2.setH(hijo.getH());

					    	/*
					    	*Si la nueva forma de llegar es menor
					    	*a la ya establecida, se actualizan los datos
					    	*/
					    	if(frontera.contains(hijo)){
					    		if(hijo.getGh()>aux2.getGh()){
					    			hijo.setG(newG);
					    			hijo.setCamino(copyOfPath(aux.getCamino()));
					    			hijo.addCamino(hijo.getId());
					    		}
					    	}else{
					    		hijo.setG(newG);
					    		List<Character> l = new ArrayList<Character>();
					    		hijo.setCamino(copyOfPath(aux.getCamino()));
					    		hijo.addCamino(hijo.getId());
					    		frontera.add(hijo);
					    	}
					    	//System.out.println("Insertando: "+hijo.getId());
					    	
					    }

					}
					visitados.add(aux.getId());

				}

			}
		}

		return solucion.toString();
	}

	private void implementHeuristic(){
		Iterator it = heuristic.entrySet().iterator();
		while (it.hasNext()) {
			/*
			* Seteamos el valor de h
			* para cada nodo
			*/
			Map.Entry pair = (Map.Entry)it.next();
			nodos.get(pair.getKey()).setH((int)pair.getValue());
		}
	}

	public void setHeuristic(HashMap<Character,Integer> heuristic){
		this.heuristic = heuristic;
	}

	/*
	*Crea una nueva instancia del camino actual
	*Si no lo hacemos, con modificar una lista en otro objeto,
	* se apuntara a la misma lista y estaremos modificando un solo
	* objeto en lugar de dos diferentes
	*/

	public List<Character> copyOfPath(List<Character> path){
		List<Character> l = new ArrayList<Character>();
		for(char c : path){
			l.add(c);
		}
		return l;
	}


}