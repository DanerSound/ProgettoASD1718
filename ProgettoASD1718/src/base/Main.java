package base;

public class Main {

	public static void main(String[] args) {
		AlberoLF<String> t= new AlberoLF<>(3);
		NodoLF<String> r=t.setRoot("root");
		NodoLF<String> a=t.addChilds(r, "a");
		NodoLF<String> b=t.addChilds(r, "b");
		NodoLF<String> c=t.addChilds(r, "c");
		
		System.out.println(" il madre di c è " +t.getFatherOf(c));
	}

}
