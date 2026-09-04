package main;

import list.*;

public class Main {
    public static void main(String[] args) {
        
        ListArray list = new ListArray(2, 2); 
        
        list.insertLast(10);
        list.insertLast(30);
        list.insertFirst(5);
        list.insertBefore(2, 20);
        
        System.out.println("Tamanho atual: " + list.size_()); 
        
       
        for (int i = 0; i < list.size_(); i++) {
            System.out.print(list.elemAtRank(i) + " ");
        }
        
        System.out.println("--index=1 => (valor 10)...");
        list.remove(1); 
        
       
        for (int i = 0; i < list.size_(); i++) {
            System.out.print(list.elemAtRank(i) + " "); 
        }
    }
}