package lastYear;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        FileWork fw = new FileWork();
        try {
            ArraysStringInput asi = Read.read("Input1.txt", fw);
            asi.input();
            Write.writeAlph(fw, asi);
            Write.writeNumElem(fw, asi);
            Write.writeCapacity(fw, asi);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
