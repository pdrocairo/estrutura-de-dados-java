package main;

import vector.*;

public class Main {

    public static void main(String[] args) {
        VectorArray array = new VectorArray(9, 0);

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(6);
        array.add(7);
        array.add(7);
        array.add(7);
        array.add(7);

//        for (int i = 0; i < array.size_(); i++) {
//            int num = array.getAt(i);
//            System.out.println(num);
//        }

//        System.out.println(array.getAt(3));
        array.setAt(3, 1);
//        System.out.println(array.getAt(3));
        array.removeAt(3);

//        for (int i = 0; i < array.size_(); i++) {
//            int num = array.getAt(i);
//            System.out.println(num);
//        }
        
        System.out.println(array.size_());
        
    }
} 