import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nodo implements Comparable<Nodo>{
	
	private char id;
	private int g,h,gh;
	private HashMap<Character,Integer> adyacentes;
	private List<Character> camino;

	public Nodo(char id){
		this.id = id;
		this.g = this.h = 0;
		adyacentes = new HashMap<Character,Integer>();
		camino = new ArrayList<Character>();
		this.gh = g+h;
	}

	public void reset(){
		this.g = this.h = 0;
		camino = new ArrayList<Character>();
	}


	public void addAdyacente(char id,int peso){
		if(!this.adyacentes.containsKey(id)){
			adyacentes.put(id,peso);
		}
	}

	public void addPathNode(char id){
		this.camino.add(id);
	}

	public char getId(){
		return this.id;
	}

	public void setG(int g){
		this.g = g;
	}

	public int getG(){
		return this.g;
	}

	public void setH(int h){
		this.h = h;
	}

	public int getH(){
		return this.h;
	}

	public int getGh(){
		return this.h+this.g;
	}

	public HashMap<Character,Integer> getAdyacentes(){
		return this.adyacentes;
	}

	public List<Character> getCamino(){
		return this.camino;
	}

	public void setCamino(List<Character> camino){
		this.camino = camino;
	}

	public void addCamino(char c){
		this.camino.add(c);
	}


	@Override
	public int compareTo(Nodo other){

		if(other.getGh() == this.getGh()){
			if(other.getId()>this.id){
				return -1;
			}else{
				return 1;
			}
		}else if(other.getGh() > this.getGh()){
			return -1;
		}else{
			return 1;
		}

	}

	@Override
	public boolean equals(Object other){
		return (((Nodo)other).getId() == this.id)? true:false;
	}

	@Override
	public String toString(){
		/*StringBuilder sb = new StringBuilder();
		for(char c : camino){
			sb.append(c+"->");
		}
		sb.append(" : "+this.getGh());
		return sb.toString();*/
		return ""+this.id+"/"+this.getGh();
	}

}