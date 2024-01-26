package singletonList;

public class Node{
    //Tek yönlü bağlı listeyi 2 aracın birbilerini arada bir ip ile  çektiğini düşün
    int data;
    Node next;// burası iki aracın arsındaki ip veya her gelen veri önceki veriyi kabetmemek için önceki veri bir sonraki verinin referansını tutar

    public Node(int data){
        this.data=data;
       this.next=null;
    }

}
