package com.exercise;

import com.exercise.exceptions.DataTypeNotSetException;
import com.exercise.exceptions.OutputFileNotSetException;
import com.exercise.exceptions.InputFilesNotSetException;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

// Singleton pattern
public class ArgsParser {
    private static ArgsParser argsParser;
    private static boolean ascendingMode;
    private static boolean stringMode;
    private static boolean integerMode;
    private static String outputFile = new String();
    private static Set inputFiles = new LinkedHashSet<>();

    public static synchronized ArgsParser getArgsParser() {
        if (argsParser == null) {
            argsParser = new ArgsParser();
        }
        return argsParser;
    }

    public static boolean isAscendingMode() {
        return ascendingMode;
    }

    public static boolean isIntegerMode() {
        return integerMode;
    }

    public static String getOutputFile() {
        return outputFile;
    }

    public static Set getInputFiles() {
        return inputFiles;
    }

    public static void parse(String[] args) throws DataTypeNotSetException, OutputFileNotSetException, InputFilesNotSetException {
        ascendingMode = true;
        stringMode = false;
        integerMode = false;
        outputFile = "";
        inputFiles.clear();
        Set argsSet = new LinkedHashSet<>(Arrays.asList(args));
        if (!argsSet.contains("-a") & !argsSet.contains("-d")) {
            ascendingMode = true;
        }
        if (argsSet.contains("-d")) {
            ascendingMode = false;
            argsSet.remove("-d");
        }
        if (argsSet.contains("-a")) {
            ascendingMode = true;
            argsSet.remove("-a");
        }
        if (argsSet.contains("-i")) {
            integerMode = true;
            stringMode = false;
            argsSet.remove("-i");
        }
        if (argsSet.contains("-s")) {
            integerMode = false;
            stringMode = true;
            argsSet.remove("-s");
        }
        for (Object el: argsSet) {
            outputFile = String.valueOf(el);
            argsSet.remove(el);
            break;
        }
        inputFiles = argsSet;
        if (!integerMode & !stringMode) {
            throw new DataTypeNotSetException();
        } else if (outputFile.length() == 0) {
            throw new OutputFileNotSetException();
        } else if (inputFiles.size() == 0) {
            throw new InputFilesNotSetException();
        }
    }
}
