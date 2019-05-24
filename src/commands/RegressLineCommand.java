package commands;

import core.Editor;

import java.util.ArrayList;

public class RegressLineCommand extends Command{
    private static final char COMMAND_OPTION='-';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_PREVIOUSLINE;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;

    private ArrayList<String> commandParameters;


    public RegressLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        //this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){

    }
}
