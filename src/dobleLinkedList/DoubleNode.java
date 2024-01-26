package dobleLinkedList;

public class DoubleNode {
    //burada hem dizinin sonraki elamana bağlanma kısmı hemde önceki elamana bağlantı kısmını tutuyoruz
    //tren vagonu gibi hem kenidnen sonrakine hemde öncekine bağlı
    int data;
    DoubleNode next;
    DoubleNode previous;
    public DoubleNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}
