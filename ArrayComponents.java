package lastYear;

import java.util.List;

public class ArrayComponents {
    private String proclamation;
    private String name;
    private List<String> elements;
    private int numberElements;
    private int capacity;
    private boolean formArray;
    private String type;

    public ArrayComponents(String proclamation, String name, String type, List<String> elements, boolean formArray) {
        this.proclamation = proclamation;
        this.name = new String(name);
        this.type = new String(type);
        this.elements = elements;
        this.formArray = formArray;
        numberElements(formArray);
        capacity(formArray);
    }

    public void capacityFirstMethod() {
        final int mandatoryBytes = 8 + 16 + 4;
        int sum = 0;
        int i = 1;
        for (String item : elements) {
            if (i == 1) {
                sum += mandatoryBytes + Integer.parseInt(item) * bytesType();
                sum = rounding(sum);
                ++i;
            } else {
                int temp = Integer.parseInt(item) * sum;
                sum = temp + mandatoryBytes;
                sum = rounding(sum);
            }
        }
        capacity = sum;
    }

    public void capacitySecondMethod() {
        final int mandatoryBytes = 8 + 16 + 4;
        int sum = mandatoryBytes + (elements.size() * bytesType());
        capacity = rounding(sum);
    }

    public void capacity(boolean formArray) {
        if (formArray) {
            capacityFirstMethod();
        } else
            capacitySecondMethod();
    }

    public void numberElements(boolean formArray) {
        if (formArray) {
            numberFirstMethod();
        } else
            numberSecondMethod();
    }

    public void numberFirstMethod() {
        numberElements = 1;
        for (String item : elements) {
            numberElements *= Integer.parseInt(item);
        }
    }

    public void numberSecondMethod() {
        numberElements = elements.size();
    }

    public int bytesType() {
        if (type.matches("int|float")) {
            return 4;
        }
        if (type.matches("short|char")) {
            return 2;
        }
        if (type.matches("double|long|")) {
            return 8;
        }
        return 1;
    }

    public int rounding(int number) {
        if (number % 8 != 0) {
            int temp = number / 8;
            temp = (temp * 8) - number;
            return number + (8 + temp);
        }
        return number;
    }

    public String getName() {
        return name;
    }

    public int getNumberEl() {
        return numberElements;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(proclamation).append(" - ").append(capacity);
        return sb.toString();
    }
}
