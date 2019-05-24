package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;

public class ShowHelpCommand extends Command{
    private static final char COMMAND_OPTION='?';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_HELP;
    // Need to check
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;

    private ArrayList<String> commandParameters;


    public ShowHelpCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        //this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){
        //super.executeCommand(editor);
        //TO DO

    }
}
