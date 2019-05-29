package commands;

import core.Editor;
import interfaces.ISpecificExecution;

import java.util.ArrayList;

public class InsertLineCommand extends Command implements ISpecificExecution {
    private static final char COMMAND_OPTION='i';
    private static final String COMMAND_DESCRIPTION="INSERT NEW LINE";
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    public InsertLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public InsertLineCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor fileEditor) {
        this.executeAndClearParameters(fileEditor);
    }


    @Override
    public void executeAndClearParameters(Editor editor){
        editor.insertLine(Command.arrayToString(super.getCommandParameters()));
        super.clearCommandParameters();
    }

}
