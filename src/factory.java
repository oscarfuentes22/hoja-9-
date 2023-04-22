import structure5.AbstractStructure;
import structure5.RedBlackSearchTree;
import structure5.SplayTree;
import structure5.Structure;
import java.util.Iterator;

public class factory extends AbstractStructure {
    public static Structure tipoArbol(String tipoArbol){
        switch (tipoArbol){
            case " Splay Tree":
                return new SplayTree<>();
            case "Red BlackTree":
                return new RedBlackSearchTree<>();
            case "AVL Tree":
                return new AVLTree<>();
            default:
                return null;
        }
    }

    @Override
    public void add() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(Object value) {

    }

    @Override
    public Object remove(Object value) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Palabra get(Palabra palabra) {
        return null;
    }
}
