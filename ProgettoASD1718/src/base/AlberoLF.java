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
        int tmp = father.getChilds().size();
        if (tmp != this.arieta) {
            father.addChild(tmpChild);
            this.numNodes++;
        } else {
            System.out.println("Error: Not enought space: " + tmpChild.getInf().toString());
        }
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

    public int getArieta() {
        return arieta;
    }

    public void setArieta(int arieta) {
        this.arieta = arieta;
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
            return this._branch_depth(this.root, 1);
        }
    }

    public String _print_tree(NodoLF<T> nodo) {
        String name = nodo.getInf() + "[";
        for (NodoLF<T> n : nodo.getChilds()) {
            name += this._print_tree(n) + ",";
        }
        return name + "]";
    }

    public String print_tree() {
        return "" + this.root.toString() + this._print_tree(this.root);
    }

}
