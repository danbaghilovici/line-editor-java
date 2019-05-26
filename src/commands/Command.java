package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class Command{

    public static final String COMMAND_STRING_OVERWRITE="Overwrite current line";
    public static final String COMMAND_STRING_INSERT="Insert before current line";
    public static final String COMMAND_STRING_DELETE="Delete current line";
    public static final String COMMAND_STRING_GOTOLINE="Go to line number";
    public static final String COMMAND_STRING_NEXTLINE="Advances to the next line";
    public static final String COMMAND_STRING_PREVIOUSLINE="Goes to previous line";
    public static final String COMMAND_STRING_SAVE="Save file with name to disk";
    public static final String COMMAND_STRING_LOAD="Load file from disk";
    public static final String COMMAND_STRING_INDEX="Prints the word index";
    public static final String COMMAND_STRING_ADVANCE="Advances to next line that contains word";
    public static final String COMMAND_STRING_HELP="Show the help menu";
    public static final String COMMAND_STRING_QUIT="Quit the editor";

    private char commandOption;
    private ArrayList<String> commandParameters;
    private String commandDescription;
    private boolean acceptsParameters;


    public Command(char commandOption, ArrayList<String> commandParameters, String commandDescription, boolean acceptsParameters) {
        this.commandOption = commandOption;
        this.commandParameters = commandParameters;
        this.commandDescription = commandDescription;
        this.acceptsParameters = acceptsParameters;
    }

    public void clearCommandParameters(){this.commandParameters.clear();}

    public char getCommandOption() {
        return this.commandOption;
    }

    public ArrayList<String> getCommandParameters() {
        return this.commandParameters;
    }

    public void setCommandParameters(ArrayList<String> commandParameters) {
        this.commandParameters = commandParameters;
    }

    public String getCommandDescription() {
        return this.commandDescription;
    }

    public boolean acceptsParameters() {
        return this.acceptsParameters;
    }

    private boolean hasParameters(){
        return this.commandParameters!=null && this.commandParameters.size()!=0;
    }

    public boolean isCommandReady(){
        return this.acceptsParameters && this.hasParameters();
    }

    public void executeCommand(Editor editor) throws Exception {
        // Depends on the type of command
        // Im sure there is a better way
    }

    public String commandToString(){
        String r=this.commandOption+" ";
        for (int i=0;i<this.commandParameters.size();i++){
            r+=r+this.commandParameters.get(i);
        }
        return r;
    }

    public boolean equals(char option){
        return option==this.commandOption;
    }

    public static String arrayToString(ArrayList<String> arrayList){
        StringBuilder result=new StringBuilder();
        ListIterator<String> auxInter=arrayList.listIterator();
        while (auxInter.hasNext()){
            result.append(auxInter.next()+"");
        }
        return result.toString();
    }

}
