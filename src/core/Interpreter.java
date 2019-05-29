package core;

import commands.*;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Interpreter {
    // Static
    // separators and strings
    private static final String SEPARATOR_STRING="----------------------";
    private static final String EDITOR_HELP_STRING="Enter command ('?') for help menu";
    private static final char TERMINAL_CURSOR='$';
    private static ArrayList<Command> AVAILABLE_COMMANDS;

    private Scanner inputScanner;
    private Editor fileEditor;

    public Interpreter(ArrayList<Command> availableCommands) {
        this.inputScanner=new Scanner(System.in);
        this.fileEditor=new Editor();
        AVAILABLE_COMMANDS=availableCommands;
    }

    public Interpreter(ArrayList<Command> availableCommands,String filename) throws IOException {
        this.inputScanner=new Scanner(System.in);
        this.fileEditor=new Editor(filename);
        AVAILABLE_COMMANDS=availableCommands;
    }

    private Command findCommand(char commandOption){
        ListIterator<Command> auxIter=AVAILABLE_COMMANDS.listIterator();
        while(auxIter.hasNext()){
            Command availableCommand=auxIter.next();
            if (availableCommand.equalChars(commandOption)){
                return availableCommand;
            }
        }
        return null;
    }

    private void initAndExecuteCommand(Command command, String[] words){
        // gets all the words in a string
        //String[] words = args.split("[^a-zA-ZaeionÌ�AÌ�EÌ�IÌ�OÌ�UNÌƒouOÌˆUÌˆaeiouAÌ€EÌ€IÌ€OÌ€UÌ€cCiIÌˆÂ·]+");
        //String[] words=args.split(" ");
        if(command.doesCommandAcceptsParameters()){
            // must make parse compatible with lower intial capacity
            ArrayList<String> commandParams=new ArrayList<>(words.length-1);
            for (int i=1;i<words.length;i++){
                commandParams.add(words[i]);
            }
            command.setCommandParameters(commandParams);
        }
        try {
            command.executeCommand(fileEditor);
            // must get exact Exception
        }catch (IOException e){
            System.err.println("FILE COULD NOT BE OPENED/SAVED");
            System.err.println(e.toString());
        }catch (Exception e){
            System.err.println(e.getLocalizedMessage());
        }
    }

    public void start(){
        char commandOption='@';
        do {
            System.out.println(SEPARATOR_STRING);
            System.out.println(fileEditor);
            System.out.println(SEPARATOR_STRING);
            System.out.println(fileEditor.infoString());
            System.out.println(EDITOR_HELP_STRING);

            // Splitting the string into words this way will remove the intended spaces between the words
            // for example "hello___there" will convert into "hello_there"
            // needs fix
            boolean correctFormat=false;
            Command command;
            do {
                System.out.print(TERMINAL_CURSOR+" ");
                String userInput=this.inputScanner.nextLine();
                String[] words = userInput.stripLeading().split(" ");
                if (words[0].length()>1){
                    System.err.println("Command '"+userInput+"' not found");
                }else{
                    if (words[0].length()==1){
                        correctFormat=true;
                    }
                }
                if (correctFormat){
                    commandOption=words[0].charAt(0);
                    if ((command=findCommand(commandOption))!=null){
                        initAndExecuteCommand(command,words);
                    }else {
                        System.err.println("Command '"+userInput+"' not found");
                    }
                }
            }while(!correctFormat);
        }while(commandOption!=QuitCommand.COMMAND_OPTION);

    }

    public static void printText(String s){
        System.out.println(s);
    }

    public static ArrayList<Command> getAvailableCommands() {
        return AVAILABLE_COMMANDS;
    }
}
