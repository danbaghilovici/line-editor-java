package commands;

import core.Editor;

import java.util.ArrayList;

public class InsertLineCommand extends Command {
    private static final char COMMAND_OPTION='i';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_INSERT;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    private ArrayList<String> commandParameters;

    public InsertLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public InsertLineCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){
        super.executeCommand(editor);
        editor.insertLine(this.commandParameters.get(0));

    }


}
