package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;

public class QuitCommand extends Command implements ISpecificExecution{
    public static final char COMMAND_OPTION='q';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_QUIT;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;


    public QuitCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) throws Exception{
        executeAndClearParameters(editor);

    }

    @Override
    public void executeAndClearParameters(Editor editor) {
        // TO DO
    }
}
