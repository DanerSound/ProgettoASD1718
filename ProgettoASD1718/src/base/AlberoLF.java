package base;

import java.util.LinkedList;

public class AlberoLF<T> {

	private NodoLF<T> root;
	private int numNodes;

	public AlberoLF() {
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
		father.addChild(tmpChild);
		this.numNodes++;
		return tmpChild;
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
			System.out.println("Error getFatherOf:Node not found!");
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

	private int _branch_depth(NodoLF<T> startnode, int n) {
		if (!startnode.has_children()) {
			return n;
		}
		int max_depth = n;
		int tmp_depth = 0;
		for (NodoLF<T> node : startnode.getChilds()) {
			tmp_depth = this._branch_depth(node, n + 1);
			if (tmp_depth > max_depth) {
				max_depth = tmp_depth;
			}
		}
		return max_depth;
	}

	public int getDepth() {
		if (this.root == null) {
			return 0;
		} else {
			return this._branch_depth(this.root, 0);
		}
	}

	public int getLeafs() {
		int numLeaf = 0;
		LinkedList<NodoLF<T>> tmp = new LinkedList<>();
		tmp.add(root);
		while (!tmp.isEmpty()) {
			if (tmp.get(0).has_children()) {
				tmp.addAll(tmp.get(0).getChilds());
				tmp.remove(0);
			} else {
				numLeaf++;
				tmp.remove(0);
			}
		}
		return numLeaf;
	}

	public String _print_tree(NodoLF<T> nodo) {
		String name = nodo.getInf() + "[";
		for (NodoLF<T> n : nodo.getChilds()) {
			name += this._print_tree(n) + ",";
		}
		if (name.endsWith(",")) {
			name = name.substring(0, name.length() - 1);
		}
		return name + "]";
	}

	public String print_tree() {
		return "" + this._print_tree(this.root);
	}

	public LinkedList<T> visitaDFS() {
		LinkedList<NodoLF<T>> stack = new LinkedList<NodoLF<T>>();
		LinkedList<T> infoList = new LinkedList<T>();
		stack.push(root);
		while (!stack.isEmpty()) {
			NodoLF<T> temp = stack.pop();
			infoList.add(temp.getInf());
			for (int i = temp.getChilds().size() - 1; i >= 0; i--) {
				stack.push(temp.getChilds().get(i));
			}
		}
		return infoList;
	}

	public LinkedList<T> visitaBFS() {
		LinkedList<NodoLF<T>> stack = new LinkedList<NodoLF<T>>();
		LinkedList<T> infoList = new LinkedList<T>();
		stack.addFirst(root);
		while (!stack.isEmpty()) {
			NodoLF<T> temp = stack.removeLast();
			infoList.add(temp.getInf());
			for (int i = 0; i <= temp.getChilds().size() - 1; i++) {
				stack.addFirst(temp.getChilds().get(i));
			}
		}
		return infoList;
	}
}
