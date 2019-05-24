package commands;

import core.Editor;

import java.util.ArrayList;

public class GotoLineCommand extends Command{
    private static final char COMMAND_OPTION='g';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_GOTOLINE;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =true;

    private ArrayList<String> commandParameters;


    public GotoLineCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    public GotoLineCommand(ArrayList<String> commandParameters) {
        super(COMMAND_OPTION, commandParameters, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
        this.commandParameters = commandParameters;
    }

    @Override
    public void executeCommand(Editor editor){
        //super.executeCommand(editor);
        //editor.goToLine(Integer.parseInt(this.commandParameters.get(0)));
    }
}
