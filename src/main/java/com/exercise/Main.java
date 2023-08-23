package com.exercise;

import com.exercise.exceptions.DataTypeNotSetException;
import com.exercise.exceptions.InputFilesNotSetException;
import com.exercise.exceptions.OutputFileNotSetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            ArgsParser.getArgsParser().parse(args);
            List<Scanner> scanners = new ArrayList<>();
            for (Object el: ArgsParser.getArgsParser().getInputFiles()) {
                try {
                    scanners.add(new Scanner(new File(String.valueOf(el))));
                } catch (FileNotFoundException e) {
                    System.out.println("# Предупреждение. Исходный файл <" + el + "> не найден!");
                }
            }
            File outputFile = new File(ArgsParser.getArgsParser().getOutputFile());
            if(outputFile.exists() && !outputFile.isDirectory()) {
                if (outputFile.delete()) {
                    System.out.println("# Предупреждение. Выходной файл <" + ArgsParser.getArgsParser().getOutputFile() + "> был заменён.");
                }
            }
            try {
                FileWriter writer = new FileWriter(outputFile, true);
                Sorter.sortObjects(scanners, writer, ArgsParser.getArgsParser().isIntegerMode());
                writer.flush();
                System.out.println("# ОБРАБОТКА ЗАВЕРШЕНА.");
                if (Sorter.getCountDataLoss() != 0) {
                    System.out.println("# Предупреждение. Из-за ошибок в исходных файлах было утеряно <" + Sorter.getCountDataLoss() + "> элементов!");
                }
            } catch (IOException e ) {
                System.out.println("# Обшибка записи в файл <" + outputFile + ">!");
            } finally {
                for (Scanner el: scanners) {
                    el.close();
                }
            }
        } catch (DataTypeNotSetException e) {
            System.out.println("# Ошибка! Не задан тип обрабатываемых данных!");
        } catch (OutputFileNotSetException e) {
            System.out.println("# Ошибка! Не задан выходной файл!");
        } catch (InputFilesNotSetException e) {
            System.out.println("# Ошибка! Не заданы входные файлы!");
        }
    }
}
