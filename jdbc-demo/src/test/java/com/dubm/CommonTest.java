package com.dubm;

import org.junit.Test;

public class CommonTest {

    @Test
    public void test() {
        Integer[] intArr = {1, 5, 2, 3};
        Integer m = max(intArr);
        Double[] doubleArr = {1D,2.455D,4.98D};
        Double m1 = max(doubleArr);
        System.out.println(m);
        System.out.println(m1);
    }

    private <T extends Number> T max(T[] arr) {
        T t = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (t.doubleValue() < arr[i].doubleValue())
                t = arr[i];
        }
        return t;
    }

}
