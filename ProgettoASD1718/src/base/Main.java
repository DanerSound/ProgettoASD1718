package base;

public class Main {

	public static void main(String[] args) {
		AlberoLF<String> t = new AlberoLF<>(2);
		NodoLF<String>root =t.setRoot("root");
		
		NodoLF<String>A=t.addChilds(root, "A");
		NodoLF<String>B=t.addChilds(root, "B");
		NodoLF<String>C=t.addChilds(root, "C");
		
		System.out.println(t.getFatherOf(B));
		
	}

}
