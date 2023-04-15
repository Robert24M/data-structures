package main;

import main.array.ResizableArray;

public class Main {

    public static void main(String[] args) {

        ResizableArray<Integer> arr = new ResizableArray<>();

        arr.add(2);
        arr.add(13);
        arr.add(17);

        arr.delete(0);

        for (int i = 0; i < arr.getNumberOfElements(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
