package Heap;


public class MaxHeap {
    private int[] heapArray;
    private int capacity;
    private int size;
    private Node huffmanTreeRoot;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heapArray = new int[capacity];
        this.huffmanTreeRoot = null;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        int temp = heapArray[i];
        heapArray[i] = heapArray[j];
        heapArray[j] = temp;
    }

    private void heapifyUp(int i) {
        while (i > 0 && heapArray[parent(i)] < heapArray[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private void heapifyDown(int i) {
        int maxIndex = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heapArray[left] > heapArray[maxIndex]) {
            maxIndex = left;
        }

        if (right < size && heapArray[right] > heapArray[maxIndex]) {
            maxIndex = right;
        }

        if (i != maxIndex) {
            swap(i, maxIndex);
            heapifyDown(maxIndex);
        }
    }




    public void insert(int key) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }

        heapArray[size] = key;
        size++;

        // Max Heap özelliklerini kontrol etmeden sırasıyla düğümleri ekler
        // Her düğümü parent'ının soluna ekler.
        int currentIndex = size - 1;
        while (currentIndex > 0) {
            int parentIndex = parent(currentIndex);
            heapArray[currentIndex] = heapArray[parentIndex];
            currentIndex = parentIndex;
        }

        // Eklenen elemanı doğru konuma yerleştirir.
        heapArray[currentIndex] = key;
        // buildHuffmanTree(); // Bu satırı kaldırın
    }
        public void buildHuffmanTree() {
            // Huffman ağacını oluştururken Max Heap özelliklerini koruyarak oluşturun
            for (int i = (size - 1) / 2; i >= 0; i--) {
                heapifyDown(i);
            }
            huffmanTreeRoot = buildHuffmanTreeHelper(0);
        }

    private Node buildHuffmanTreeHelper(int index) {
        if (index < size) {
            Node newNode = new Node(heapArray[index]);
            newNode.left = buildHuffmanTreeHelper(leftChild(index));
            newNode.right = buildHuffmanTreeHelper(rightChild(index));
            return newNode;
        }
        return null;
    }

    public void printHuffmanTree() {
        printTree(huffmanTreeRoot, "", true, true, true);
    }

    private void printTree(Node node, String indent, boolean isLast, boolean isRoot, boolean isRight) {
        if (node != null) {
            System.out.print(indent);

            if (isLast) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }

            System.out.println(node.key);

            if (node.left != null || node.right != null) {
                printTree(node.left, indent, false, false, true);
                printTree(node.right, indent, true, false, false);
            }
        }
    }

    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heapArray[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(4);
        maxHeap.insert(10);
        maxHeap.insert(8);
        maxHeap.insert(5);
        maxHeap.insert(1);

        System.out.println("Max Heap:");
        maxHeap.printHeap();

        maxHeap.buildHuffmanTree();
        System.out.println("\nHuffman Tree:");
        maxHeap.printHuffmanTree();
    }
}
