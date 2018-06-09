package base;

public class Main {

	public static void main(String[] args) {
		AlberoLF<String> t=new AlberoLF<>(3);
		NodoLF<String>root=t.setRoot("root");
		NodoLF<String>A=t.addChilds(root, "A");
		NodoLF<String>B=t.addChilds(root, "B");
		NodoLF<String>C=t.addChilds(root, "C");
		
		NodoLF<String>A1=t.addChilds(A, "A1");
		NodoLF<String>A2=t.addChilds(A, "A2");
		
		NodoLF<String>B1=t.addChilds(B, "B1");
		NodoLF<String>B2=t.addChilds(B, "B2");
		NodoLF<String>B3=t.addChilds(B, "B3");
		NodoLF<String>B4=t.addChilds(B, "B4");
		
		NodoLF<String>C1=t.addChilds(C, "C1");
		System.out.println(t.numbersOfLeaf());
	}

}
