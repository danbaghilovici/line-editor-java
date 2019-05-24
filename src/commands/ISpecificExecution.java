package commands;

import core.Editor;

import java.io.IOException;

public interface ISpecificExecution {
    void executeAndClearParameters(Editor editor) throws Exception;
}
