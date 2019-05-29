package commands;

import core.Editor;
import interfaces.ISpecificExecution;

import java.util.ArrayList;

public class OverwriteLineCommand extends Command implements ISpecificExecution {
    private static final char COMMAND_OPTION='o';
    private static final String COMMAND_DESCRIPTION="Overwrite line";
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    public OverwriteLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public OverwriteLineCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS); }

    @Override
    public void executeCommand(Editor editor){
        editor.replaceLine(Command.arrayToString(super.getCommandParameters()));
    }

    @Override
    public void executeAndClearParameters(Editor editor) throws Exception {
        editor.replaceLine(Command.arrayToString(super.getCommandParameters()));
        super.clearCommandParameters();

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
