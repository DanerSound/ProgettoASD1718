package base;

import java.util.LinkedList;

public class AlberoLF<T>{
	private NodoLF<T> root;
	private int numNodes;
	private int arieta;
	
	public AlberoLF(int arieta) {
		this.arieta = arieta;
		this.root =null;
		this.numNodes = 0;
	}
	
	public NodoLF<T> addRoot(T inf) {
		NodoLF<T> tmpNode = new NodoLF<T>(inf);
		if(root!=null) {
			root.setFather(tmpNode);
			tmpNode.setChilds(new LinkedList<>());
			tmpNode.getChilds().add(root);
			root=tmpNode;
			return root;
		}else {
		root=tmpNode;
		return root;
		}
	}
	
	public NodoLF<T> getRoot() {
		return root;
	}

	public void setRoot(NodoLF<T> root) {
		this.root = root;
	}

	public int getNumNodes() {
		return numNodes;
	}

	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}

	public int getArieta() {
		return arieta;
	}

	public void setArieta(int arieta) {
		this.arieta = arieta;
	}
	
	

}
