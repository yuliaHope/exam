package lastYear;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWork {
    private BufferedReader br;
    private PrintWriter pw;

    public boolean openInputFile(String fileName) {
        try {
            br = new BufferedReader(new FileReader(fileName));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean openOutputFile(String fileName) {
        try {
            pw = new PrintWriter(fileName);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void closeOutputFile() {
        pw.close();
    }

    public String read() throws IOException, ClassNotFoundException {
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {
            sb.append(s);
        }
        return sb.toString();
    }


    public void outputSortAlph(ArraysString arrays) throws IOException {
        arrays.sortAlphabet();
        for (ArrayComponents item : arrays.getList()) {
            pw.println(item.getName());
        }
    }

    public void outputSortNumElem(ArraysString arrays) throws IOException {
        arrays.sortNumElements();
        for (ArrayComponents item : arrays.getList()) {
            pw.println(item.getName() + " " + item.getNumberEl());
        }
    }

    public void outputCapacity(ArraysString arrays) throws IOException {
        for (ArrayComponents item : arrays.getList()) {
            pw.println(item);
        }
    }
}
