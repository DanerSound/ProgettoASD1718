package base;

public class Main {

    public static void main(String[] args) {
        AlberoLF<String> t = new AlberoLF<>();
        NodoLF<String> r = t.setRoot("root");
        NodoLF<String> a = t.addChilds(r, "a");
        NodoLF<String> b = t.addChilds(r, "b");
        NodoLF<String> c = t.addChilds(r, "c");
        
        NodoLF<String> d = t.addChilds(b, "d");
        NodoLF<String> e = t.addChilds(d, "e");

        System.out.println(" il madre di c è " + t.getFatherOf(c));
        System.out.println(" depth = " + t.getDepth());
        System.out.println(" r.has_child = " + r.has_children());
        System.out.println(" print_tree" + t.print_tree());
        
    }

}
