package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Command {

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
    private boolean requireParameters;


    public Command(char commandOption, ArrayList<String> commandParameters, String commandDescription, boolean requireParameters) {
        this.commandOption = commandOption;
        this.commandParameters = commandParameters;
        this.commandDescription = commandDescription;
        this.requireParameters = requireParameters;
    }

    public void clearCommandParameters(){this.commandParameters.clear();}

    public char getCommandOption() {
        return commandOption;
    }

    public void setCommandOption(char commandOption) {
        this.commandOption = commandOption;
    }

    public ArrayList<String> getCommandParameters() {
        return commandParameters;
    }

    public void setCommandParameters(ArrayList<String> commandParameters) {
        this.commandParameters = commandParameters;
    }

    public String getCommandDescription() {
        return commandDescription;
    }

    public void setCommandDescription(String commandDescription) {
        this.commandDescription = commandDescription;
    }

    public boolean isRequireParameters() {
        return requireParameters;
    }

    public void setRequireParameters(boolean requireParameters) {
        this.requireParameters = requireParameters;
    }

    private boolean commandHasParameters(){
        return this.commandParameters.size()!=0;
    }

    public boolean isCommandReady(){
        return this.requireParameters && this.commandHasParameters();
    }

    public void executeCommand(Editor editor) throws IllegalArgumentException {
        if(!isCommandReady()){
            throw new IllegalArgumentException("Command require arguments");
        }

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


}
