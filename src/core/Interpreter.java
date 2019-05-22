package core;

import commands.*;
import core.Editor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Interpreter {
    private static final int NUMBER_OF_AVAILABLE_COMMANDS=10;
    private static final ArrayList<Command> AVAILABLE_COMMANDS=new ArrayList<Command>(NUMBER_OF_AVAILABLE_COMMANDS);


    public static final Command[] AVAILABLE_COMMANDS_ARRAY=
            {
                    new OverwriteLineCommand(),
                    new InsertLineCommand(),
                    new DeleteLineCommand(),
                    new GotoLineCommand(),
                    new AdvanceLineCommand(),
                    new RegressLineCommand(),
                    new SaveFileCommand(),
                    new LoadFileCommand(),
                    new ShowHelpCommand(),
                    new QuitCommand()
            };


    private Scanner inputScanner;
    private Editor fileEditor;

    private void init(){
        // FOR TESTING
        AVAILABLE_COMMANDS.addAll(List.of(AVAILABLE_COMMANDS_ARRAY));
        this.inputScanner=new Scanner(System.in);
        fileEditor=new Editor();

    }

    private Command findCommand(char commandOption){
        ListIterator<Command> auxIter=AVAILABLE_COMMANDS.listIterator();
        while(auxIter.hasNext()){
            Command availableCommand=auxIter.next();
            if (availableCommand.equals(commandOption)){
                return availableCommand;
            }
        }
        return null;
    }

    private void addParamsAndExecuteCommand(Command command,String args){
        System.out.println(args);
    }

    public void start(){
        init();

        char commandOption;
        do {
            System.out.println("----------------------");
            System.out.println(fileEditor);
            System.out.println("----------------------");
            System.out.println(fileEditor.infoString());
            System.out.println("Enter command ('?') for help menu");
            System.out.print("$ ");
            String cmd=this.inputScanner.next();
            // SURE IT CAN BE IMPROVED
            commandOption=cmd.charAt(0);
            Command commandFound=findCommand(commandOption);
            if (commandFound!=null){
                addParamsAndExecuteCommand(commandFound,cmd);
            }else{
                System.out.println("Command not found");
            }
            //System.out.println(commandOption);

        }while(commandOption!='q');

    }

}
