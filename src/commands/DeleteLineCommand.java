package commands;

import core.Editor;
import interfaces.ISpecificExecution;

public class DeleteLineCommand extends Command implements ISpecificExecution {
    private static final char COMMAND_OPTION='d';
    private static final String COMMAND_DESCRIPTION="Delete line";
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;

    public DeleteLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) throws Exception{
        this.executeAndClearParameters(editor);
    }

    @Override
    public void executeAndClearParameters(Editor editor) {
        editor.removeLine();
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
