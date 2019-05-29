package commands;

import core.Editor;
import interfaces.ISpecificExecution;

import java.io.IOException;
import java.util.ArrayList;

public class LoadFileCommand extends Command implements ISpecificExecution {
    private static final char COMMAND_OPTION='l';
    private static final String COMMAND_DESCRIPTION="Load file";
    // Need to check
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    public LoadFileCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public LoadFileCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) throws IOException,IllegalArgumentException {

        executeAndClearParameters(editor);
    }

    @Override
    public void executeAndClearParameters(Editor editor) throws IOException,IllegalArgumentException {
        /*if (super.getCommandParameters()==null || super.getCommandParameters().size()==0){
            throw new IllegalArgumentException("No file argument provided");
        }*/
        editor.loadFile(super.getCommandParameters().get(0));
        super.clearCommandParameters();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
