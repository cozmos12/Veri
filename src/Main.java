import BinaryTree.BinaryTree;
import Hash.LinnerProbing.LinearProbingHashTable;
import Hash.QuadraticProbing.QuadraticProbingHashTable;
import Hash.SeparateChaning.SeparateChaining;
import Heap.MaxHeap;
import huffmanCoding.Huffman;
import huffmanCoding.Node;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {

        Factory f=new Factory();
        Pay p= f.create("Master");
        String results=  p.show(10);
        System.out.println(results);
        p=f.create("Paypal");
      String result=  p.show(20);
        System.out.println(result);






        /*
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(5);
        maxHeap.insert(1);
        maxHeap.insert(11);
        maxHeap.insert(12);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        maxHeap.buildHuffmanTree();
        System.out.println("\nHuffman Tree:");
        maxHeap.printHuffmanTree();
 */

/*

        LinearProbingHashTable hashTable=new LinearProbingHashTable(10);

        hashTable.insert(10);
        hashTable.insert(20);
        hashTable.insert(15);
        hashTable.insert(25);
        hashTable.insert(35);
        hashTable.insert(5);
        hashTable.insert(7);
        hashTable.insert(17);
        hashTable.insert(27);
        hashTable.insert(37);

        hashTable.printTable();
        System.out.println("   ");
        hashTable.delete(10);
        hashTable.printTable();
        System.out.println("   ");
        hashTable.insert(30);
        hashTable.printTable();
 */



/*

      //  SeparateChaining hashTable = new SeparateChaining(10);
        QuadraticProbingHashTable hashTable=new QuadraticProbingHashTable(10);

        hashTable.insert(10);
        hashTable.insert(20);
        hashTable.insert(30);
        hashTable.insert(40);
        hashTable.insert(35);
        hashTable.insert(13);
        hashTable.insert(12);
        hashTable.insert(16);
        hashTable.insert(18);
        hashTable.insert(28);

        hashTable.printTable();
        hashTable.delete(16);
        System.out.println("////////////");
        hashTable.printTable();
 */










       /*
        BinaryTree binaryTree=new BinaryTree();
        binaryTree.add(10);
        binaryTree.add(20);
        binaryTree.add(38);
        binaryTree.add(13);
        binaryTree.add(9);
        binaryTree.add(6);
        binaryTree.add(12);
        binaryTree.add(11);
        binaryTree.add(7);
        binaryTree.print();
        binaryTree.delete(13);
        binaryTree.print();
        */





        /*
        System.out.println("Hello world!");
        SinglyLinkedList s=new SinglyLinkedList();

        s.add(10);
        s.addToFront(3);
        s.add(13);
        s.add(5);
        s.add(40);
        s.add(12);
        s.findNode(13);
        Node nodeToInsertAfter = s.findNode(13);
        s.insertAfter(13, 1);
        s.display();
        s.display();
        s.update(10,100);
        s.display();



        SinglyLinkedList s2=new SinglyLinkedList();

        s2.addInOrder(3);
        s2.addInOrder(1);
        s2.addInOrder(10);
        s2.addInOrder(5);
        s2.addInOrder(40);
        s2.addInOrder(12);
        s2.addInOrder(13);


        s2.display();
        s2.delete(40);
        s2.display();


        DoubleLinkedList d=new DoubleLinkedList();
        d.addToLast(10);
        d.addToLast(13);

        d.addToLast(12);

        d.addToLast(5);

        d.addToLast(2);
        d.display();
        DoubleLinkedList d2=new DoubleLinkedList();
        d2.addInOrder(10);
        d2.addInOrder(13);
        d2.addInOrder(12);
        d2.addInOrder(5);
        d2.addInOrder(2);
        d2.display();
        d2.delete(13);
        d2.display();

         */
/*
        int arrayLength=5;
        BaseArray b=new BaseArray(5);
        b.add(10);
        b.add(13);
        b.add(4);
        b.add(3);
        b.add(8);
        b.Write();
        System.out.println("es"+b.es);
        System.out.println("*********");

 */
        // b.bubbleShort();
        //  b.SelectionShort();
        // b.insertionShort();
        //  b.shellShort();
        // b.mergeShort(0,b.array.length-1);
        //  b.quickSort(0,b.array.length-1);
        //b.Write();





        /*

          int[] array = {1, 2, 3, 4, 5, 6};
        int k = 2;

        Sorular s=new Sorular();
        Soru2 s2=new Soru2();
        s.dondur(array, k);


        for (int num : array) {
            System.out.print(num + " ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bir sayı giriniz: ");
        int n = scanner.nextInt();

        int[] Kalan = new int[100];

        int kalanSayisi = s2.Taban18(n, Kalan);

        System.out.print("Sonuç: ");
        for (int i = kalanSayisi - 1; i >= 0; i--) {
            if (Kalan[i] < 10) {
                System.out.print(Kalan[i]);
            } else {
                // 10'dan büyük rakamları A, B, C, ... şeklinde yazdır
                char ch = (char) ('A' + (Kalan[i] - 10));
                System.out.print(ch);
            }
        }

        scanner.close();
         */


    }
}








