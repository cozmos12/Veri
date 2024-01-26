package dobleLinkedList;

import singletonList.Node;

public class DoubleLinkedList {
    private DoubleNode head;
    public DoubleLinkedList(){
        head=null;
    }

    public void addToFront(int data){
        DoubleNode node=new DoubleNode(data);
        if(head==null){
            head=node;
        }else {
            //başa ekleme yapmak için yeni gelen elamnın sonraki elamnına head yani ilk elmanınmızı veriyoruz
            node.next=head;
            head.previous=node;// buradada head kısmının önceki elamnı olrak tutacağı değeri gelen elamnımız olrak işretliyorz
            head=node;

            // yani 4 5 6 diye gidiyor head 4 4 ün next referansı 5 şimdi bize 7 geldi 7 nin next elamnını 4  işaretliyom ve 4 ün önceki elamnı olrak ta 7 yi işretlerim yani dizi 7 4 5 6 olrak değişir
        }
    }

    public void addToLast(int data){
        DoubleNode node=new DoubleNode(data);

        if(head==null){
            head=node;
        }else{
                DoubleNode current=head;
                while (current.next!=null){
                    current=current.next;//dizinin sonuna kadar döner
                }
                current.next=node;// yeni ekleyeceğimiz elamanı dizideki son elmanın sonraki referansı olrak işretliyoz
                node.previous=current;// eklediğimiz elamanın önceki elamn referansınada dizinin son elamnının veriyoz
        }
    }


    public void addInOrder(int data){
        DoubleNode node = new DoubleNode(data);
        if(head==null){
            head=node;
        }else{
            if(head.data>data){
                node.next=head;
                head.previous=node;
                head=node;
            }else{
                DoubleNode current = head;
                while (current.next!=null&&current.next.data<data){
                    current = current.next;
                }
                node.next=current.next;
                node.previous=current;
                current.next=node;
                //gelen elamnadan daha büyüğünü bulana kadar dön bulduğunda kend,nden bir önceki elamnının nexti artık gelen elamnın nexti gelen elamnın çnceki elamn referansıda kedninde büyük elamn gelemden önceki son elaman
            }

        }
    }

    public DoubleNode find(int data){
        DoubleNode current=head;
        while (current!=null){
            if(current.data==data){
                return current;
            }
            current=current.next;
        }
        return null;
    }

    public void delete(int data){
        DoubleNode deleteData=find(data);

        DoubleNode current=head;
        DoubleNode previous=null;
        if(deleteData==head){
            head=head.next;
            head.previous=null;
        }else{
            while (current!=null&& current!=deleteData){
                previous=current;
                current=current.next;
            }
            previous.next=current.next;
            if(current.next!=null){
                current.next.previous = previous ;
            }

        }
    }

    public void display() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
