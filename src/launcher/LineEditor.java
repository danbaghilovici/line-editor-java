package launcher;

import java.util.ArrayList;
import java.util.List;

import commands.*;

import core.Interpreter;

public class LineEditor {
	
	private static final int NUMBER_OF_AVAILABLE_COMMANDS=10;
    private static final ArrayList<Command> AVAILABLE_COMMANDS=new ArrayList<>(NUMBER_OF_AVAILABLE_COMMANDS);
    private static final Command[] AVAILABLE_COMMANDS_ARRAY=
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
    private static Interpreter commandInterpreter;



    public static void main(String[] args) {
    	if (initCommandsArray()){
            System.err.println("Init done!");
            commandInterpreter.start();
        }else {
            System.err.println("Could not init");
        }

    }

    private static boolean initCommandsArray(){
        AVAILABLE_COMMANDS.addAll(List.of(AVAILABLE_COMMANDS_ARRAY));
        try {
            commandInterpreter=new Interpreter(AVAILABLE_COMMANDS);
        }catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }
        return true;
    }



    public static ArrayList<Command> getAvailableCommands() {
        return AVAILABLE_COMMANDS;
    }
}
