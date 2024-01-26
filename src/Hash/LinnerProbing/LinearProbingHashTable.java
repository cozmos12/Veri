package Hash.LinnerProbing;

public class LinearProbingHashTable {
    private int size;
    private int[] table;
    private boolean[] occupied;

    public LinearProbingHashTable(int size) {
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
            int i = (index + 1) % size;
            while (i != index && occupied[i]) {
                i = (i + 1) % size;
            }

            if (i != index) {
                table[i] = key;
                occupied[i] = true;
            } else {
                System.out.println("Hash tablosu dolu, ekleme yapılamıyor.");
            }
        }
    }

    public void delete(int key) {
        int index = hashFunction(key);

        if (occupied[index] && table[index] == key) {
            table[index]=0;
            occupied[index] = false;
        } else {
            int i = (index + 1) % size;
            while (i != index && (!occupied[i] || table[i] != key)) {
                i = (i + 1) % size;
            }

            if (i != index) {
                table[i]=0;
                occupied[i] = false;
            } else {
                System.out.println("Silinecek veri bulunamadı.");
            }
        }
    }



    public void printTable() {
        for (int i = 0; i < size; i++) {
           // System.out.println("Index " + i + ": " + (occupied[i] ? table[i] : "Boş"));
            System.out.println("Index"+i+":"+table[i]);
        }
    }
}
