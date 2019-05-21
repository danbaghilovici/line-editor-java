import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Editor {
    private List<String> fileLines;
    private ListIterator<String> linesIterator;
    private boolean modified;
    private String fileName;

    public Editor() {
        // Initialize empty params
        this.fileLines=new ArrayList<String>();
        this.linesIterator=fileLines.listIterator();
        this.fileName="no_name";
    }

    public Editor(String filename) throws IOException {
        // Initialize the array list that will
        // contain all the file lines
        this.fileLines=new ArrayList<String>();

        // Start reading the file
        BufferedReader bufferedReader = null;
        FileReader fileReader=null;

        fileReader=new FileReader(filename);
        bufferedReader=new BufferedReader(fileReader);

        String line;
        while((line=bufferedReader.readLine())!=null){
            this.fileLines.add(line);
        }

        // Close the file pointer
        if (bufferedReader!=null)
            bufferedReader.close();

        if (fileReader!=null)
            fileReader.close();

        // Initialize the list iterator
        // and assign name to the file
        this.linesIterator=fileLines.listIterator();
        this.fileName=filename;
    }

    public void saveFile() throws IOException {
        Path pathToFile = Paths.get(this.fileName);
        BufferedWriter bufferedWriter= Files.newBufferedWriter(pathToFile);
        for (String line: this.fileLines){
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        this.modified=false;
        this.linesIterator=this.fileLines.listIterator();
    }

    public void loadFile() throws IOException {
        // Clear the contents of the old file
        this.fileLines.clear();

        Path pathToFile = Paths.get(this.fileName);
        BufferedReader bufferedReader = Files.newBufferedReader(pathToFile);
        String line ;
        while ((line = bufferedReader.readLine()) != null) {
            this.fileLines.add(line);
        }
        this.modified=false;
        this.linesIterator=this.fileLines.listIterator();

    }

    public String toString(){
        int lineCounter=1;
        StringBuilder result=new StringBuilder();
        ListIterator<String> auxIter=this.fileLines.listIterator();
        if (!auxIter.hasNext()){
            result.append("-- Empty file -- \n----------------\n");
            return result.append(lineCounter+">").toString();
        }
        while(auxIter.hasNext()){
            result.append((lineCounter++)+
                    (linesIterator.nextIndex()==auxIter.nextIndex()?">":" ")+
                    auxIter.next()+"\n");

        }
        return result.toString();
    }
}
