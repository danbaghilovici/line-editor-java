package commands;

import core.Editor;
import core.Interpreter;
import interfaces.ISpecificExecution;
import launcher.LineEditor;


import java.util.ListIterator;

public class ShowHelpCommand extends Command implements ISpecificExecution {
    private static final char COMMAND_OPTION='?';
    private static final String COMMAND_DESCRIPTION="Show help menu";
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;

    public ShowHelpCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) {
        executeAndClearParameters(editor);
    }

    @Override
    public void executeAndClearParameters(Editor editor) {
        StringBuilder stringBuilder=new StringBuilder();
        ListIterator<Command> commandsListIterator= LineEditor.getAvailableCommands().listIterator();
        while (commandsListIterator.hasNext()){
            stringBuilder.append(commandsListIterator.next().getCommandInfo());
            stringBuilder.append("\n");
        }
        Interpreter.printText(stringBuilder.toString());

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
