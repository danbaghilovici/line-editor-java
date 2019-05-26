package commands;

import core.Editor;

import java.util.ArrayList;

public class GotoLineCommand extends Command implements ISpecificExecution{
    private static final char COMMAND_OPTION='g';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_GOTOLINE;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    public GotoLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public GotoLineCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) throws Exception{
        executeAndClearParameters(editor);


    }

    @Override
    public void executeAndClearParameters(Editor editor){
        editor.goToLine(Integer.parseInt(super.getCommandParameters().get(0)));
        super.clearCommandParameters();
    }
}
