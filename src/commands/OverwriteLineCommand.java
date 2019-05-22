package commands;

import core.Editor;

import java.util.ArrayList;

public class OverwriteLineCommand extends Command {
    private static final char COMMAND_OPTION='o';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_OVERWRITE;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    private ArrayList<String> commandParameters;

    public OverwriteLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public OverwriteLineCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){
        super.executeCommand(editor);
        editor.replaceLine(this.commandParameters.get(0));
    }
}
