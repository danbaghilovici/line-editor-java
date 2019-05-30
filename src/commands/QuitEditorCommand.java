package commands;

import core.Editor;
import interfaces.ISpecificExecution;

public class QuitEditorCommand extends Command implements ISpecificExecution {
    public static final char COMMAND_OPTION='q';
    private static final String COMMAND_DESCRIPTION="Quit editor";
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;


    public QuitEditorCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) throws Exception{
        executeAndClearParameters(editor);

    }

    @Override
    public void executeAndClearParameters(Editor editor) {
        // TO DO
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
