package com.exercise;

import com.exercise.comparators.ComparatorObj;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sorter {
    private static int countDataLoss;
    private static ComparatorObj comparatorObj = new ComparatorObj(ArgsParser.isAscendingMode());

    public static int getCountDataLoss() {
        return countDataLoss;
    }

    public static void sortObjects(List<Scanner> scanners, FileWriter writer, boolean isIntegerMode) throws IOException {
        countDataLoss = 0;
        comparatorObj.setAscendingMode(ArgsParser.isAscendingMode());
        List<Object> buffer = new ArrayList<>(scanners.size());
        for (int i = 0; i < scanners.size(); i++) {
            if (scanners.get(i).hasNextInt() & isIntegerMode) {
                buffer.add(scanners.get(i).nextInt());
            } else if (scanners.get(i).hasNextLine() & !isIntegerMode) {
                buffer.add(scanners.get(i).nextLine());
                while (((String) buffer.get(i)).contains(" ")) {
                    countDataLoss++;
                    if (scanners.get(i).hasNextLine()) {
                        buffer.set(i, scanners.get(i).nextLine());
                    } else {
                        buffer.set(i, null);
                        break;
                    }
                }
            } else {
                buffer.add(null);
            }
        }
        Object desiredValue;
        int desiredIndex;
        while (buffer.stream().anyMatch(x -> x != null)) {
            desiredValue = buffer.stream().min(comparatorObj).get();
            desiredIndex = buffer.indexOf(desiredValue);
            writer.write(String.valueOf(desiredValue) + "\n");
            if ((scanners.get(desiredIndex).hasNextInt() & isIntegerMode)) {
                buffer.set(desiredIndex, scanners.get(desiredIndex).nextInt());
                checkMessyDataInt(desiredValue, desiredIndex, scanners, buffer);
            } else if (scanners.get(desiredIndex).hasNextLine() & !isIntegerMode) {
                buffer.set(desiredIndex, scanners.get(desiredIndex).nextLine());
                checkMessyDataStr(desiredValue, desiredIndex, scanners, buffer);
            } else {
                buffer.set(desiredIndex, null);
            }
        }
    }

    public static void checkMessyDataInt(Object desiredValue, int desiredIndex, List<Scanner> scanners, List buffer) {
        while (comparatorObj.compare(desiredValue, buffer.get(desiredIndex)) > 0) {
            countDataLoss++;
            if (scanners.get(desiredIndex).hasNextInt()) {
                buffer.set(desiredIndex, scanners.get(desiredIndex).nextInt());
            } else {
                buffer.set(desiredIndex, null);
                break;
            }
        }
    }

    public static void checkMessyDataStr(Object desiredValue, int desiredIndex, List<Scanner> scanners, List buffer) {
        while ((comparatorObj.compare(desiredValue, buffer.get(desiredIndex)) > 0) | ((String) buffer.get(desiredIndex)).contains(" ")) {
            countDataLoss++;
            if (scanners.get(desiredIndex).hasNextLine()) {
                buffer.set(desiredIndex, scanners.get(desiredIndex).nextLine());
            } else {
                buffer.set(desiredIndex, null);
                break;
            }
        }
    }
}