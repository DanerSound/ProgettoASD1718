package base;

public class Main {

	public static void main(String[] args) {
		AlberoLF<String>t=new AlberoLF<>(3);
		NodoLF<String>root=t.setRoot("root");
		NodoLF<String>A=t.addChilds2(root, "A");
		NodoLF<String>B=t.addChilds2(root, "B");
		NodoLF<String>C=t.addChilds2(root, "C");
		
		NodoLF<String>D=t.addChilds2(root, "D");
		NodoLF<String>E=t.addChilds2(root, "E");
		

	}

}
