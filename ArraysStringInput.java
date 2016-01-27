package lastYear;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysStringInput {
    private ArraysString arrays;
    private StringBuilder sb;
    private int i;

    public ArraysStringInput(String s) {
        arrays = new ArraysString();
        sb = new StringBuilder(s);
    }

    public void input() {
        int temp = i;
        i++;
        endString();
        while (i != -1) {
            String s = sb.substring(temp, ++i);
            Boolean formArray = typeArray(s);
            String[] str = mySplit(s, formArray);
            String type = str[0];
            String name = str[1];
            List<String> list = new ArrayList<String>();
            for (int j = position(formArray); j < str.length; j++) {
                list.add(str[j]);
            }
            arrays.addElement(new ArrayComponents(niceString(s), name, type, list, formArray));
            temp = i;
            endString();
        }
    }

    public int endString() {
        boolean flag = true;
        while (flag) {
            ++i;
            int temp2 = sb.indexOf(";", i);
            if (temp2 == -1 || sb.charAt(temp2 - 1) != '\'')
                flag = false;
            i = temp2++;
        }
        return i;
    }

    public int position(Boolean formArray) {
        if (formArray)
            return 4;
        else
            return 2;
    }

    public String niceString(String s) {
        return s.replaceAll(" {2,}", " ");
    }

    public Boolean typeArray(String s) {
        if (s.indexOf("{") != -1)
            return false;
        return true;
    }

    public String[] mySplit(String s, Boolean formArray) {
        if (!formArray && s.indexOf('\'') != -1)
            return charArray(s);
        return s.split("[\\s;\n\\]\\[=,]+");
    }

    public String[] charArray(String s) {
        List<String> list = new ArrayList<String>();
        String str = s.substring(0, s.indexOf('='));
        list.addAll(Arrays.asList(str.split("[\\s\\]\\[]+")));
        int i;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '\'') {
                i = j;
                if (s.charAt(s.indexOf('\'', ++i) + 1) != '\'') {
                    list.add(s.substring(j + 1, s.indexOf('\'', ++i)));
                    j = s.indexOf('\'', i);
                } else {
                    list.add(s.substring(j + 1, s.indexOf('\'', ++i) + 1));
                    j = s.indexOf('\'', ++i);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }


    public ArraysString getArrays() {
        return arrays;
    }
}
