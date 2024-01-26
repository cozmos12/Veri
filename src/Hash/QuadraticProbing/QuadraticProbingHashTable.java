package Hash.QuadraticProbing;

public class QuadraticProbingHashTable {
    private int size;
    private int[] table;
    private boolean[] occupied;

    public QuadraticProbingHashTable(int size) {
        this.size = size;
        this.table = new int[size];
        this.occupied = new boolean[size];
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunction(key);

        if (!occupied[index]) {
            table[index] = key;
            occupied[index] = true;
        } else {
            int i = 1;
            while (occupied[(index + i * i) % size]) {
                i++;
            }

            table[(index + i * i) % size] = key;
            occupied[(index + i * i) % size] = true;
        }
    }

    public void delete(int key) {
        int index = hashFunction(key);

        if (occupied[index] && table[index] == key) {
            occupied[index] = false;
            table[index]=0;
        } else {
            int i = 1;
            while (occupied[(index + i * i) % size] && table[(index + i * i) % size] != key) {
                i++;
            }

            if (occupied[(index + i * i) % size]) {
                occupied[(index + i * i) % size] = false;
                table[(index+i*i)%size]= 0;
            } else {
                System.out.println("Silinecek veri bulunamadı.");
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index"+i+":"+table[i]);
        }
    }

}
