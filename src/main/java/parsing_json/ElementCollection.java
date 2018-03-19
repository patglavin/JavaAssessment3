package parsing_json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class ElementCollection extends ArrayList<Element>{

    public Element findByAtomicNumber(int atomic_number) {
        ListIterator<Element> it = listIterator();
        while (it.hasNext()) {
            Element tempElement = it.next();
            if (tempElement.getNumber() == atomic_number) return tempElement;
        }
        return null;
    }

    public Element findByName(String name) {
        ListIterator<Element> it = listIterator();
        while (it.hasNext()) {
            Element tempElement = it.next();
            if (tempElement.getName().equals(name)) return tempElement;
        }
        return null;
    }

    public ElementCollection where(String fieldName, Object value) throws NoSuchFieldException {
        ElementCollection subset = new ElementCollection();
        ListIterator<Element> it = listIterator();
        while (it.hasNext()) {
            Element tempElement = it.next();
            Field field = tempElement.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            Object tempValue = new Object();
            try {
                tempValue = field.get(tempElement);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (tempValue.equals(value)) {
                subset.add(tempElement);
            }
        }
        return subset;
    }
}
