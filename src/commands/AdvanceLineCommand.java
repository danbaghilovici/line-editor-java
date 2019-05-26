package commands;

import core.Editor;

import java.util.ArrayList;

public class AdvanceLineCommand extends Command implements ISpecificExecution{
    private static final char COMMAND_OPTION='+';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_NEXTLINE;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;


    public AdvanceLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) throws Exception{
        executeAndClearParameters(editor);
    }

    @Override
    public void executeAndClearParameters(Editor editor) {
        editor.nextLine();
    }
}
