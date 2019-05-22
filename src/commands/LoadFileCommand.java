package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;

public class LoadFileCommand extends Command{
    private static final char COMMAND_OPTION='l';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_LOAD;
    // Need to check
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;

    private ArrayList<String> commandParameters;

    public LoadFileCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public LoadFileCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        //this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){
        super.executeCommand(editor);
        try {
            editor.loadFile();
        }catch (IOException e){
            // TO DO ERROR HANDLING
        }

    }
}
