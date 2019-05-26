package core;

import commands.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Interpreter {

    // ANSII codes for printing text with color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Static separators and strings
    private static final String SEPARATOR_STRING="----------------------";
    private static final String EDITOR_HELP_STRING="Enter command ('?') for help menu";
    private static final char TERMINAL_CURSOR='$';
    // IMPLEMENT WITH HASHMAP LEATER ON
    private static final int NUMBER_OF_AVAILABLE_COMMANDS=10;
    private static final ArrayList<Command> AVAILABLE_COMMANDS=new ArrayList<>(NUMBER_OF_AVAILABLE_COMMANDS);


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

    private void initAndExecuteCommand(Command command, String[] words){
        // gets all the words in a string
        //String[] words = args.split("[^a-zA-ZaeiońÁÉÍÓUÑouÖÜaeiouÀÈÌÒÙcCiÏ·]+");
        //String[] words=args.split(" ");
        if(command.acceptsParameters()){
            // must make parse compatible with lower intial capacity
            ArrayList<String> commandParams=new ArrayList<>(words.length-1);
            for (int i=1;i<words.length;i++){
                commandParams.add(words[i]);
            }
            command.setCommandParameters(commandParams);
        }
        try {
            command.executeCommand(fileEditor);
        }catch (Exception e){
            System.err.println(e.getCause());
        }
    }

    public void start(){
        init();

        char commandOption='@';
        do {
            System.out.println(SEPARATOR_STRING);
            System.out.println(fileEditor);
            System.out.println(SEPARATOR_STRING);
            System.out.println(fileEditor.infoString());
            System.out.println(ANSI_RED+EDITOR_HELP_STRING+ANSI_RESET);

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

}
