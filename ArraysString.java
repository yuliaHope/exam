package lastYear;

import java.util.ArrayList;
import java.util.List;

public class ArraysString {
    private List<ArrayComponents> list;

    public ArraysString() {
        list = new ArrayList<ArrayComponents>();
    }

    public void addElement(ArrayComponents item) {
        list.add(item);
    }

    public void sortAlphabet() {
        list.sort((a, b) -> a.getName().compareTo(b.getName()));
    }

    public void sortNumElements() {
        list.sort((a, b) -> a.getNumberEl() - b.getNumberEl());
    }

    public List<ArrayComponents> getList() {
        return list;
    }
}
