import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;

public class NaiveMaxElementStack<E> implements IMaxElementStack<E> {

    ArrayDeque<E> stack;
    ArrayDeque<E> maxElt;//декларирование
    Comparator<E> comparator;

    public NaiveMaxElementStack() {
        comparator = new Comparator<E>() {
            @Override
            public int compare(E o1, E o2) {
                Comparable<E> comparable = (Comparable) o1;
                return comparable.compareTo(o2);
            }
        };

        stack = new ArrayDeque<>();
        maxElt = new ArrayDeque<>();//создаю!!(снова забыла)
    }

    public NaiveMaxElementStack(Comparator<E> comparator) {
        this.comparator = comparator;
        stack = new ArrayDeque<>();
    }

    // O(1)
    @Override
    public void addLast(E elt) {
        stack.addLast(elt);

        if (stack.size()>1){
            if (comparator.compare(elt,getMax())>0){
                maxElt.addLast(elt);
            }else{//<0 && ==
                maxElt.addLast(getMax());
            }
        } else{//size ==1
            maxElt.addLast(elt);
        }
    }

    // O(1)
    @Override
    public E getLast() {
        return stack.getLast();
    }

    // O(1)
    @Override
    public E removeLast() {
        maxElt.removeLast();
        return stack.removeLast();
    }

    // O(n) need O(1)
    @Override
    public E getMax() {
        return maxElt.getLast();
        //return Collections.max(stack, comparator);
    }

    // O(1)
    @Override
    public int size() {
        return stack.size();
    }
}