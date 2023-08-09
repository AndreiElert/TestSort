package com.exercise;

import com.exercise.exceptions.DataTypeNotSetException;
import com.exercise.exceptions.InputFilesNotSetException;
import com.exercise.exceptions.OutputFileNotSetException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashSet;
import java.util.Set;

class ArgsParserTest {

    @Test
    void parseTest1() throws InputFilesNotSetException, OutputFileNotSetException, DataTypeNotSetException {
        String[] arguments = new String[] {"-i", "-a", "out.txt", "in.txt"};
        ArgsParser.parse(arguments);
        Set inputFilesExp = new LinkedHashSet<>();
        inputFilesExp.add("in.txt");
        Assertions.assertTrue(ArgsParser.isIntegerMode());
        Assertions.assertTrue(ArgsParser.isAscendingMode());
        Assertions.assertEquals("out.txt", ArgsParser.getOutputFile());
        Assertions.assertEquals(inputFilesExp, ArgsParser.getInputFiles());
    }

    @Test
    void parseTest2() throws InputFilesNotSetException, OutputFileNotSetException, DataTypeNotSetException {
        String[] arguments = new String[] {"-s", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        ArgsParser.parse(arguments);
        Set inputFilesExp = new LinkedHashSet<>();
        inputFilesExp.add("in1.txt");
        inputFilesExp.add("in2.txt");
        inputFilesExp.add("in3.txt");
        Assertions.assertFalse(ArgsParser.isIntegerMode());
        Assertions.assertTrue(ArgsParser.isAscendingMode());
        Assertions.assertEquals("out.txt", ArgsParser.getOutputFile());
        Assertions.assertEquals(inputFilesExp, ArgsParser.getInputFiles());
    }

    @Test
    void parseTest3() throws InputFilesNotSetException, OutputFileNotSetException, DataTypeNotSetException {
        String[] arguments = new String[] {"-d", "-s", "out.txt", "in1.txt", "in2.txt"};
        ArgsParser.parse(arguments);
        Set inputFilesExp = new LinkedHashSet<>();
        inputFilesExp.add("in1.txt");
        inputFilesExp.add("in2.txt");
        Assertions.assertFalse(ArgsParser.isIntegerMode());
        Assertions.assertFalse(ArgsParser.isAscendingMode());
        Assertions.assertEquals("out.txt", ArgsParser.getOutputFile());
        Assertions.assertEquals(inputFilesExp, ArgsParser.getInputFiles());
    }

    @Test
    void parseTest4() throws InputFilesNotSetException, OutputFileNotSetException, DataTypeNotSetException {
        String[] arguments = new String[] {"-s", "-d", "-i", "-d", "out.txt", "in1.txt", "-a", "in2.txt", "-s", "in2.txt", "in3.txt", "in3.txt", "in4.txt"};
        ArgsParser.parse(arguments);
        Set inputFilesExp = new LinkedHashSet<>();
        inputFilesExp.add("in1.txt");
        inputFilesExp.add("in2.txt");
        inputFilesExp.add("in3.txt");
        inputFilesExp.add("in4.txt");
        Assertions.assertFalse(ArgsParser.isIntegerMode());
        Assertions.assertTrue(ArgsParser.isAscendingMode());
        Assertions.assertEquals("out.txt", ArgsParser.getOutputFile());
        Assertions.assertEquals(inputFilesExp, ArgsParser.getInputFiles());
    }

    @Test
    void parseTest5() {
        String[] arguments = new String[] {"-a", "out.txt", "in1.txt", "in2.txt", "in3.txt"};
        Assertions.assertThrows(DataTypeNotSetException.class, () -> ArgsParser.parse(arguments));
    }

    @Test
    void parseTest6() {
        String[] arguments = new String[] {"-i", "-a"};
        Assertions.assertThrows(OutputFileNotSetException.class, () -> ArgsParser.parse(arguments));
    }

    @Test
    void parseTest7() {
        String[] arguments = new String[] {"-i", "-a", "out.txt"};
        Assertions.assertThrows(InputFilesNotSetException.class, () -> ArgsParser.parse(arguments));
    }
}