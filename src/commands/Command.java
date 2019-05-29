package commands;

import core.Editor;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Objects;

public class Command{

    private char commandOption;
    private ArrayList<String> commandParameters;
    private String commandDescription;
    private boolean acceptsParameters,containsParameters;


    public Command(char commandOption, ArrayList<String> commandParameters, String commandDescription, boolean acceptsParameters) {
        this.commandOption = commandOption;
        this.commandParameters = commandParameters;
        this.commandDescription = commandDescription;
        this.acceptsParameters = acceptsParameters;
        if (this.acceptsParameters){
            if (isCommandParametersValid()){
                this.containsParameters=true;
            }
        }
    }

    public void clearCommandParameters(){
        if (!isCommandParametersValid())
            return;
        commandParameters.clear();
        containsParameters=false;
    }

    public char getCommandOption() {
        return commandOption;
    }

    public ArrayList<String> getCommandParameters() {
        return commandParameters;
    }

    public void setCommandParameters(ArrayList<String> commandParameters) {
        this.commandParameters = commandParameters;
        if (isCommandParametersValid())
            containsParameters=true;

    }

    public String getCommandDescription() {
        return this.commandDescription;
    }

    public boolean doesCommandAcceptsParameters() {
        return acceptsParameters;
    }

    public boolean doesCommandContainsParameters() {
        return containsParameters;
    }

    public void executeCommand(Editor editor) throws Exception {
        // Depends on the type of command
        // Im sure there is a better way
        System.err.println("Base Command method executed!");
    }
    @Override
    public String toString(){
        return commandOption+" "+commandDescription+(isCommandParametersValid()?arrayToString(commandParameters):"")+" accepts Parameters: "+acceptsParameters+", "+"contains Parameters:"+containsParameters;
    }


    public static String arrayToString(ArrayList<String> arrayList){
        StringBuilder result=new StringBuilder();
        ListIterator<String> auxInter=arrayList.listIterator();
        while (auxInter.hasNext()){
            result.append(auxInter.next()+" ");
        }
        return result.toString();
    }

    private boolean isCommandParametersNull(){
        return commandParameters==null;
    }

    private boolean isCommandParametersEmpty(){
        return commandParameters.size()==0;
    }

    private boolean isCommandParametersValid(){
        return !isCommandParametersNull() && !isCommandParametersEmpty();
    }

    public String getCommandInfo(){
        // add arguments
        // TO DO LATER
        return commandOption+" "+(acceptsParameters?" param ":"")+commandDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Command)) return false;
        Command command = (Command) o;
        return commandOption == command.commandOption;
    }

    public boolean equalChars(char c){
        return commandOption==c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commandOption);
    }
}
