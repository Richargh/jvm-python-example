package de.richargh.jvmpython.jython;

import org.junit.jupiter.api.Test;
import org.python.core.PyInteger;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class PythonInterpreterTest {

    @Test
    public void should_evaluate_simple_addition() throws IOException {
        // arrange
        PythonInterpreter interpreter = new PythonInterpreter();

        // act
        PyObject result = interpreter.eval("40 + 2");

        // assert
        assertThat(result.toString()).isEqualTo("42");
    }

    @Test
    public void should_evaluate_simple_multiplication() throws IOException {
        // arrange
        PythonInterpreter python = new PythonInterpreter();
        int x = 2;
        int y = 4;
        python.set("x", new PyInteger(x));
        python.set("y", new PyInteger(y));

        // act
        python.exec("size = x * y");

        // assert
        PyObject size = python.get("size");
        assertThat(size.toString()).isEqualTo("8");
    }

    @Test
    public void should_call_simple_function() throws IOException {
        // arrange
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("def happyBirthday(name):\n" +
                "\treturn \"Happy Birthday, dear \"+name");
        PyObject happyBirthday = interpreter.get("happyBirthday");

        // act
        PyObject greeting = happyBirthday.__call__(new PyString("Emily"));

        // assert
        String javaGreeting = (String)greeting.__tojava__(String.class);
        assertThat(javaGreeting).isEqualTo("Happy Birthday, dear Emily");
    }

}
