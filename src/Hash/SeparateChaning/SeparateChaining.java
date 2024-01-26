package Hash.SeparateChaning;

import Hash.SeparateChaning.Node;

public class SeparateChaining {
    private int size;
    private Node[] table;

    public SeparateChaining(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);
        Node newNode = new Node(key);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void delete(int key) {
        int index = hashFunction(key);

        if (table[index] == null) {
            System.out.println("Silinecek veri bulunamadı.");
            return;
        }

        Node current = table[index];
        Node prev = null;

        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Silinecek veri bulunamadı.");
            return;
        }

        if (prev == null) {
            table[index] = current.next;
        } else {
            prev.next = current.next;
        }

        System.out.println("Veri silindi: " + key);
    }



    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            Node current = table[i];
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
