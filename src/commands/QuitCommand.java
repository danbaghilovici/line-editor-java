package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;

public class QuitCommand extends Command{
    public static final char COMMAND_OPTION='q';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_QUIT;
    // Need to check
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;

    private ArrayList<String> commandParameters;



    public QuitCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }
    // FOR FUTURE IMPROVEMENTS
    public QuitCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        //this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){
        //super.executeCommand(editor);


    }


}
