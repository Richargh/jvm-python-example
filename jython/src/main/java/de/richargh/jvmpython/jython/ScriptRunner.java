package de.richargh.jvmpython.jython;

import org.python.util.PythonInterpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ScriptRunner {

    private PythonInterpreter interpreter = new PythonInterpreter();

    public void execute(Path path) throws IOException {
        interpreter.exec(new String(Files.readAllBytes(path)));
    }

    public int asInt(String key){
        return Integer.parseInt(interpreter.get(key).toString());
    }
}
