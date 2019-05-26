package commands;

import core.Editor;
import core.Interpreter;

import java.io.IOException;
import java.util.ArrayList;

public class ShowHelpCommand extends Command implements ISpecificExecution{
    private static final char COMMAND_OPTION='?';
    private static final String COMMAND_DESCRIPTION=Command.COMMAND_STRING_HELP;
    private static final boolean COMMAND_REQUIRES_PARAMETERS =false;

    public ShowHelpCommand() {
        super(COMMAND_OPTION, null, COMMAND_DESCRIPTION, COMMAND_REQUIRES_PARAMETERS);
    }

    @Override
    public void executeCommand(Editor editor) {
        executeAndClearParameters(editor);
    }

    @Override
    public void executeAndClearParameters(Editor editor) {
        // this will do for now
        final String menuString =
                " o line	Overwrite curent line\n" +
                        " i line  	Insert before current line\n" +
                        " d  		Delete current linen\n" +
                        " g	number	Goto to line number\n" +
                        " + 		Advances to the next line\n" +
                        " - 		Goes to previous line\n" +
                        " w [n]  	Save file with name to disk\n" +
                        " l  		Load file from disk\n" +
                        " I  		Prints the word Index\n" +
                        " s	word	Advances to next line that contains word\n" +
                        " ?  		Show this help\n" +
                        " q  		Quit the editor\n";
        Interpreter.printText(menuString);
    }
}
