package main;

import main.array.ResizableArray;

public class Main {

    public static void main(String[] args) {

        ResizableArray<Integer> arr = new ResizableArray<>();

        arr.add(2);
        System.out.println(arr.get(1));
    }
}
