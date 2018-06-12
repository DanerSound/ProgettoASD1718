package base;

public class Main {

	public static void main(String[] args) {
		AlberoLF<String> t = new AlberoLF<>();
		NodoLF<String> r = t.setRoot("root");
		NodoLF<String> a = t.addChilds(r, "a");
		NodoLF<String> b = t.addChilds(r, "b");
		NodoLF<String> c = t.addChilds(r, "c");

		NodoLF<String> a1 = t.addChilds(a, "a1");
		NodoLF<String> a2 = t.addChilds(a, "a2");

		NodoLF<String> c1 = t.addChilds(c, "c1");

		System.out.println(" print_tree : " + t.printTree());
		
		NodoLF<String> newroot= t.setRoot("newroot");

		System.out.println(" print_tree : " + t.printTree());
		
		System.out.println(" La radice dell'albero è: "+t.getRoot());

		System.out.println(" L'altezza dell'Albero è: "+t.getDepth());
		
		System.out.println(" l'Albero ha "+ t.getNumNodes());
		
		System.out.println("il livello di c1 è "+t.searchNode(c1).getLevel());
		
		System.out.println("l'informazione di c1 è "+t.searchNode(c1).getInf());
		
		t.changeInf(c1, " newc1 ");
		
		System.out.println("la nuova info è "+t.searchNode(c1).getInf());
		
		System.out.println("il padre ci root è "+t.getFatherOf(r));
		
		System.out.println(" visita DFS :" + t.visitDFS());
		
		System.out.println(" visita BFS :" + t.visitBFS());

		System.out.println(" numero delle foglie : "+t.getLeafs());
	}

}
