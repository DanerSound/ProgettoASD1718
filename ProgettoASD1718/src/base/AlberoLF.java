package base;

import java.util.LinkedList;

public class AlberoLF<T> {
	private NodoLF<T> root;
	private int numNodes;
	private int arieta;

	public AlberoLF(int arieta) {
		this.arieta = arieta;
		this.root = null;
		this.numNodes = 0;
	}

	public NodoLF<T> setRoot(T inf) {
		NodoLF<T> tmpNode = new NodoLF<T>(inf);
		if (root != null) {
			root.setFather(tmpNode);
			tmpNode.setChilds(new LinkedList<>());
			tmpNode.getChilds().add(root);
			root = tmpNode;
			numNodes++;
			return root;
		} else {
			root = tmpNode;
			numNodes++;
			return root;
		}
	}

	public NodoLF<T> addChilds(NodoLF<T> father, T inf) {
		NodoLF<T> tmpChild = new NodoLF<>(inf);

		if (father.getChilds() == null) {
			father.setChilds(new LinkedList<>());
			father.getChilds().add(tmpChild);
			tmpChild.setFather(father);
			numNodes++;
			return tmpChild;
		} else {
				tmpChild.setFather(father);
				father.getChilds().add(tmpChild);
				numNodes++;			
			return tmpChild;
			}
	}

	public int numbersOfLeaf() {
		LinkedList<NodoLF<T>> leafsCounter = new LinkedList<>();
		NodoLF<T> current = root;

		while (numNodes != 1) {
			if (current.getChilds()== null) {
				leafsCounter.add(current);
				numNodes--;
			} else {
				current = current.getChilds().getFirst();
				numNodes--;
			}
		}
		return leafsCounter.size();
	}

	public String printInfo(NodoLF<T> Node) {
		NodoLF<T> tmp = searchNode(Node);
		return tmp.getInf().toString();
	}

	public NodoLF<T> searchNode(NodoLF<T> Node) {
		LinkedList<NodoLF<T>> searchList = new LinkedList<>();
		NodoLF<T> current = null;
		if (Node.equals(root)) {
			return root;
		} else {
			searchList.addAll(root.getChilds());
			while (!searchList.isEmpty()) {
				current = searchList.getFirst();
				if (Node == current) {
					return current;
				} else {
					searchList.removeFirst();
					try {
						searchList.addAll(current.getChilds());
					} catch (Exception e) {

					}
				}
			}
		}
		return current;
	}

	public String getFatherOf(NodoLF<T> Node) {
		try {
			NodoLF<T> tmp = searchNode(Node);
			return tmp.getFather().getInf().toString();
		} catch (Exception e) {
			System.out.println("Error 404:Node not found!");
			return null;
		}
	}

	public void changeInf(NodoLF<T> Node, T newInf) {
		try {
			NodoLF<T> tmp = searchNode(Node);
			tmp.setInf(newInf);
		} catch (Exception e) {
			System.out.println("Error 404:Node not found!");
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
