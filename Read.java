package lastYear;

import java.io.IOException;

public class Read {
    public static ArraysStringInput read(String fileName, FileWork fw) throws IOException, ClassNotFoundException {
        ArraysStringInput asi;
        if (fw.openInputFile(fileName)) {
            asi = new ArraysStringInput(fw.read());
            return asi;
        }
        return null;
    }
}
