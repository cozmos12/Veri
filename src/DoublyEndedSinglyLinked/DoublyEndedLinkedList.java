package DoublyEndedSinglyLinked;

public class DoublyEndedLinkedList {
    // bu tek yönlü gibi ama hem head ilk elmanı hemde tail listen,n son elamnını tutuyoruz burada
    private DoubleEndedNode head;
    private DoubleEndedNode tail;

    public DoublyEndedLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int data){
        DoubleEndedNode node = new DoubleEndedNode(data);
        if(head==null){
            head=node;
            tail=node;
            //elaman yoksa hem ilk elaman hem son elaman head yani ilk elamanı gösterir başka elaman gelirse aşağıda tail kısmı onu gösterir
        }else{
            // burada gelen elamanı başa lamak için gelen elamnın nextini referansını head gösteriyouz yani head 3 diyelim dizi 345 diyegidiyor
            //yeni elaman 6 geldi 6 nin refeansını tututğu elaman artık 3 olacak 6345 diye gidecek dizi
            node.next=head;
            head=node;// burada 6 yı head olrak işaretliyoz
        }
    }

    public void addLast(int data){
        DoubleEndedNode node = new DoubleEndedNode(data);
        if(head==null){
            head=node;
            tail=node;
        }else{
            tail.next=node;//burada sona ekleme yapmak için mesela son elaman 456 dan 6 tail olrak görünüyor 6 nın refans kısmı boş burada yeni gelen elam yani 7  diyelim 6 nın nextine 7 yi atarız
            tail=node;//burada 7 yi tail olarak işaretleriz
        }
    }

    public void deleteFirst(){
        if(head!=null){
            if(head==tail){
                head=null;
                tail=null;
            }else{
                head=head.next;//ilk elamandan silme yapmak için headın yerini değişmek yeter head 3 dizi 34 diye gidiyo
                // headı 4 yaparsan 3 silinir zaten
            }
        }
    }

    public void deleteLast(){
        if(head!=null){
            if(head==tail){
                head=null;
                tail=null;
            }else{

                DoubleEndedNode node=head;
                while (node.next!=tail){// bu dongüde silincek elamndan bir önceki elamana ulaşıtız
                    node=node.next;
                }
                node.next=null;// silecek elaman 7 diyelim dizi 567 diye gidiyo biz yukarıda 6 ya ulaşıtız 6 ı 7 nin referansını tuutyor bu referansı silersen 7 silinir
                tail=node;// 6 yı tail olrak işaretliyoruz

            }
        }
    }
}
