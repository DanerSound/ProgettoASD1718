package base;

import java.util.LinkedList;

public class NodoLF<T> {

    private T inf;
    private NodoLF<T> father;
    private LinkedList<NodoLF<T>> childs;

    public NodoLF(T inf) {
        this.inf = inf;
        this.father = null;
        this.childs = new LinkedList<>();
    }

    public int getLevel() {
        int level = 0;
        NodoLF<T> current = this.getFather();
        while (current != null) {
            level++;
            current = current.getFather();
        }
        return level;
    }
//	@Override
//	public void equals() {
//		
//	}

    public T getInf() {
        return inf;
    }

    public void setInf(T inf) {
        this.inf = inf;
    }
    
    public void addChild(NodoLF<T> nodo){
        this.childs.add(nodo);
        nodo.setFather(this);
    }

    public NodoLF<T> getFather() {
        return father;
    }

    public void setFather(NodoLF<T> father) {
        this.father = father;
    }

    public LinkedList<NodoLF<T>> getChilds() {
        return childs;
    }

    public void setChilds(LinkedList<NodoLF<T>> childs) {
        this.childs = childs;
    }
    
    public boolean has_children() {
        return !this.childs.isEmpty();
    }

    @Override
    public String toString() {
        return ""+ inf;
    }
    
}
