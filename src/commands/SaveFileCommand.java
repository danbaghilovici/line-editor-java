package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;

public class SaveFileCommand extends Command{
    private static final char COMMAND_OPTION='w';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_SAVE;
    // Need to check
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    private ArrayList<String> commandParameters;

    public SaveFileCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);

    }

    public SaveFileCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){

    }
}
