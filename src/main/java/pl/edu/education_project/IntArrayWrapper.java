package pl.edu.education_project;

import java.util.Arrays;

public class IntArrayWrapper {
    private int[] array;

    public IntArrayWrapper(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}