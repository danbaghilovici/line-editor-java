package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;

public class SaveFileCommand extends Command implements ISpecificExecution{
    private static final char COMMAND_OPTION='w';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_SAVE;
    // Need to check
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    public SaveFileCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);

    }

    public SaveFileCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) throws Exception {
        executeAndClearParameters(editor);
    }

    @Override
    public void executeAndClearParameters(Editor editor) throws Exception {
        if (super.getCommandParameters().size()!=0){
            editor.setFileName(super.getCommandParameters().get(0));
        }
        editor.saveFile();
        super.clearCommandParameters();
    }
}
