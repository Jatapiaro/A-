import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nodo implements Comparable<Nodo>{
	
	private char id;
	private int g,h,gh;
	private HashMap<Character,Integer> adyacentes;
	private List<Character> camino;
	private List<String> caminoPesos;

	public Nodo(char id){
		this.id = id;
		this.g = this.h = 0;
		adyacentes = new HashMap<Character,Integer>();
		camino = new ArrayList<Character>();
		caminoPesos = new ArrayList<String>();
		this.gh = g+h;
	}

	public void reset(){
		this.g = this.h = 0;
		camino = new ArrayList<Character>();
	}

	public void setAdyacentes(HashMap<Character,Integer> adyacentes){
		this.adyacentes = adyacentes;
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


	public List<String> getCaminoPesos(){
		return this.caminoPesos;
	}

	public void setCaminoPesos(List<String> caminoPesos){
		this.caminoPesos = caminoPesos;
	}

	public void addCaminoPeso(String s){
		this.caminoPesos.add(s);
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
		return this.id+"/"+this.getGh();
	}

	public String resultado(){
		StringBuilder sb = new StringBuilder("Camino: ");
		for(int i=0;i<this.caminoPesos.size();i++){
			if(i==this.camino.size()-1){
				sb.append(caminoPesos.get(i));
			}else{
				sb.append(caminoPesos.get(i)+"->");
			}
		}
		return sb.toString();
	}

}