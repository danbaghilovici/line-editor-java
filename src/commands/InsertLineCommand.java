package commands;

import core.Editor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class InsertLineCommand extends Command implements ISpecificExecution{
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
    public void executeCommand(Editor fileEditor) throws Exception {
        super.executeCommand(fileEditor); // Doesn't really matter what you pass
        this.executeAndClearParameters(fileEditor);
    }

    private String arrayToString(ArrayList<String> arrayList){
        StringBuilder result=new StringBuilder();
        ListIterator<String> auxInter=arrayList.listIterator();
        while (auxInter.hasNext()){
            result.append(auxInter.next()+"");
        }
        return result.toString();
    }


    @Override
    public void executeAndClearParameters(Editor editor){
        editor.insertLine(arrayToString(super.getCommandParameters()));
        super.clearCommandParameters();
    }
}
