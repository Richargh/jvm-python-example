package de.richargh.jvmpython.jython;

import javafx.beans.binding.IntegerBinding;
import org.junit.jupiter.api.Test;
import org.python.util.PythonInterpreter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

public class ScriptRunnerTest {

    @Test
    public void simple_script_should_return_5() throws IOException {
        // arrange
        File file = new File(getClass().getResource("SimpleReturn.py").getFile());
        System.out.println("File path is: "+file.getAbsolutePath() +" and it exists: "+file.exists());
        ScriptRunner scriptRunner = new ScriptRunner();

        // act
        scriptRunner.execute(file.toPath());

        // assert
        assertThat(scriptRunner.asInt("x")).isEqualTo(5);
    }
}
