import core.Editor;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        Editor ed=new Editor("test.txt");
        System.out.println(ed.toString());
        System.out.println(ed.getCurrentLine());




    }
}
