package parsing_json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ElementCollection extends ArrayList<Element>{

    public Element findByAtomicNumber(int atomic_number) {
        ListIterator<Element> it = listIterator();
        System.out.println(listIterator().next());
        while (listIterator().hasNext()) {
            System.out.println(it.next());
            if (it.next().getNumber() == atomic_number) return it.next();
        }
        return null;
    }

    public Element findByName(String name) {
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        return null;
    }
}
