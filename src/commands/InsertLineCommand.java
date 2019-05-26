package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class InsertLineCommand extends Command implements ISpecificExecution{
    private static final char COMMAND_OPTION='i';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_INSERT;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    public InsertLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public InsertLineCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor fileEditor) throws Exception {
        this.executeAndClearParameters(fileEditor);
    }


    @Override
    public void executeAndClearParameters(Editor editor){
        editor.insertLine(Command.arrayToString(super.getCommandParameters()));
        super.clearCommandParameters();
    }
}
