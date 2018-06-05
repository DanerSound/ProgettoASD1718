package base;

import java.util.LinkedList;

public class NodoLF<T> {
	private T inf;
	private NodoLF<T> father;
	private LinkedList<NodoLF<T>> childs;

	public NodoLF(T inf) {
		this.inf = inf;
		this.father = null;
		this.childs = null;
	}

	public T getInf() {
		return inf;
	}

	public void setInf(T inf) {
		this.inf = inf;
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

}