package commands;

import core.Editor;
import interfaces.ISpecificExecution;

public class AdvanceLineCommand extends Command implements ISpecificExecution {
    private static final char COMMAND_OPTION='+';
    private static final String COMMAND_DESCRIPTION="Go to next line";
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
    @Override
    public String toString() {
        return super.toString();
    }
}
