package lastYear;

import java.io.IOException;

public class Write {
    public static void writeAlph(FileWork fw, ArraysStringInput asi)throws IOException{
        if(fw.openOutputFile("Bytes1.out")){
            fw.outputSortAlph(asi.getArrays());
            fw.closeOutputFile();
        }
    }
    public static void writeNumElem(FileWork fw, ArraysStringInput asi)throws IOException{
        if(fw.openOutputFile("Bytes2.out")){
            fw.outputSortNumElem(asi.getArrays());
            fw.closeOutputFile();
        }
    }
    public static void writeCapacity(FileWork fw, ArraysStringInput asi)throws IOException{
        if(fw.openOutputFile("Bytes3.out")){
            fw.outputCapacity(asi.getArrays());
            fw.closeOutputFile();
        }
    }
}
