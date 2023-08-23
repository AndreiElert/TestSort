package com.exercise.comparators;

import java.util.Comparator;

public class ComparatorObj implements Comparator<Object> {
    private boolean ascendingMode;

    public void setAscendingMode(boolean ascendingMode) {
        this.ascendingMode = ascendingMode;
    }

    @Override
    public int compare(Object o1, Object o2) {
        int result;
        if (o1 == null & o2 == null) {
            result = 0;
        } else if (o1 == null) {
            result = 1;
        } else if (o2 == null) {
            result = -1;
        } else {
            if (ascendingMode) {
                if (o1.getClass() == Integer.class) {
                    result = (Integer) o1 - (Integer) o2;
                } else {
                    result = ((String) o1).compareTo((String) o2);
                }
            } else {
                if (o1.getClass() == Integer.class) {
                    result = (Integer) o2 - (Integer) o1;
                } else {
                    result = ((String) o2).compareTo((String) o1);
                }
            }
        }
        return result;
    }
}
