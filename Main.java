import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;

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

		gf.addAdyacenteBi('H','I',15);

		int option = -1;

		while(option!=2){
			option = Integer.parseInt(
				JOptionPane.showInputDialog("1.Encuentra una ruta\n2.Salir"));
			if(option == 1){
				String[] data = JOptionPane.showInputDialog(
					"Ingresa los ID's de los nodos separados por una coma. \n\tEjemplo: A,H").toUpperCase().split(",");

				if(data.length>2){
					JOptionPane.showMessageDialog(null,"Ingreso incorrecto de datos");
				}else{
					if(data[0].length() == 1 && data[1].length()==1){
						char inicio = data[0].charAt(0);
						char fin = data[1].charAt(0);

						String rs = gf.aStar(inicio,fin,heuristic);

						JTextArea textArea = new JTextArea(rs);
						JScrollPane scrollPane=new JScrollPane(textArea);
						textArea.setLineWrap(true);
						scrollPane.setPreferredSize(new Dimension(400,200));
						JOptionPane.showMessageDialog(null, 
							scrollPane,
							"Ruta de "+data[0]+" a "+data[1]+" con A*",
		   					JOptionPane.YES_NO_OPTION);	

					}else{
						JOptionPane.showMessageDialog(null,"Ingreso incorrecto de datos");
					}
				}

			}else if(option == 2){
				break;
			}else{
				JOptionPane.showMessageDialog(null,"Elige una opción disponible");
			}
		}

	}

}