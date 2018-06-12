package base;

import java.util.LinkedList;

public class AlberoLF<T> {

	private NodoLF<T> root;
	private int numNodes;

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

	public int getDepth() {
		if (this.root == null) {
			return 0;
		} else {
			return branchLevel(root, 0);
		}
	}

	private int branchLevel(NodoLF<T> startnode, int currentLevel) {
		if (!startnode.has_children()) {
			return currentLevel;
		}
		int maxDepth = currentLevel;
		int tmpDepth = 0;
		for (NodoLF<T> node : startnode.getChilds()) {
			tmpDepth = branchLevel(node, currentLevel + 1);
			if (tmpDepth > maxDepth) {
				maxDepth = tmpDepth;
			}
		}
		return maxDepth;
	}

	public int getLeafs() {
		int numLeaf = 0;
		LinkedList<NodoLF<T>> nodesWithSons = new LinkedList<>();
		nodesWithSons.add(root);
		while (!nodesWithSons.isEmpty()) {
			if (nodesWithSons.get(0).has_children()) {
				nodesWithSons.addAll(nodesWithSons.get(0).getChilds());
				nodesWithSons.remove(0);
			} else {
				numLeaf++;
				nodesWithSons.remove(0);
			}
		}
		return numLeaf;
	}

	public String printTree() {
		return currentTree(root);
	}

	private String currentTree(NodoLF<T> nodo) {
		String name = nodo.getInf() + "[ ";
		for (NodoLF<T> n : nodo.getChilds()) {
			name += currentTree(n) + ",";
		}
		if (name.endsWith(",")) {
			name = name.substring(0, name.length() - 1);
		}
		return name + "]";
	}

	public LinkedList<T> visitDFS() {
		LinkedList<NodoLF<T>> stack = new LinkedList<NodoLF<T>>();
		LinkedList<T> infoList = new LinkedList<T>();
		stack.push(root);
		while (!stack.isEmpty()) {
			NodoLF<T> currentNode = stack.pop();
			infoList.add(currentNode.getInf());
			for (int i = currentNode.getChilds().size() - 1; i >= 0; i--) {
				stack.push(currentNode.getChilds().get(i));
			}
		}
		return infoList;
	}

	public LinkedList<T> visitBFS() {
		LinkedList<NodoLF<T>> queue = new LinkedList<NodoLF<T>>();
		LinkedList<T> infoList = new LinkedList<T>();
		queue.addFirst(root);
		while (!queue.isEmpty()) {
			NodoLF<T> currentNode = queue.removeLast();
			infoList.add(currentNode.getInf());
			for (int i = 0; i <= currentNode.getChilds().size() - 1; i++) {
				queue.addFirst(currentNode.getChilds().get(i));
			}
		}
		return infoList;
	}

}
