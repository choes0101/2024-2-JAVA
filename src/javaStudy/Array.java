package javaStudy;

import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        String[] cars = {"hyundai","bmw","benz","toyota"};
        Arrays.sort(cars, 0,2); // ["hyundai", "toyota", "bmw", "benz"]
        for (String car : cars) {
            System.out.println(car);
        }
    }
}
