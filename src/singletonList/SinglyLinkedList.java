package singletonList;


public class SinglyLinkedList {
    private Node head;
    public SinglyLinkedList(){
        this.head=null;
    }

    public void add(int data){
        Node newNode=new Node(data);//burada bize gelen veriyle yeni bir node veya yeni düğüm oluştururuz
        if(head==null){
            head=newNode;
        }else{

            Node currentNode=head;
            //burada dizinin son elamanına ulmaya çalışırız
            while (currentNode.next!=null){
                currentNode=currentNode.next;
            }
            //listenin sonuna yukarıda ulaşırız ve son elamanın referans kısmına yeni elemanı ekleriz
            currentNode.next=newNode;
        }
    }

    //burada sırlaı ekleme yapılıyo çok bi olayı yok
    public void addInOrder(int data){
        Node currentNode=new Node(data);
        if(head==null){
            head=currentNode;
        }else{
            if(head.data> currentNode.data){
                currentNode.next=head;
                head=currentNode;
            }else{
                Node temp=head;
                while (temp.next!=null&&temp.next.data<data){
                    temp=temp.next;
                }
                currentNode.next=temp.next;
                temp.next=currentNode;
            }

        }
    }

    public void addToFront(int data) {
        if(head!=null){
            Node newNode = new Node(data);

            newNode.next = head;//burada elmeizdeki elamının referans kısmına bizim head yani ilk elamnımızı veriyoz head artık 2. elaman oluyor
            //burada normal dizilerdeki gibi her elamanı kaydımaya ihtiyacımız yok sadece 1 elamanın yeri değişse yeterli oluoyr
            head = newNode;//elimizdeki elamanı ilk elman olrak tanımlıyoruz
        }
    }
    public Node findNode(int data) {
        Node current = head;

        while (current != null) {
            if (current.data == data) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public void insertAfter(int afterData, int data) {

        Node previousNode = findNode(afterData);
        if (previousNode == null) {
            System.out.println("Önceki düğüm null olamaz.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
    }

    public void delete(int data) {
        //silme işlemi için bir elaman silndiğinde o elamının kendinden sonraki elamnı tutuğu referansı kendinden önceki elemanın refenrs kısmıyla değişmek gerekr
        //yani 1 2 3 var 1  2 yi 2 3 ü tutuyor referans(next)kısmında 2 yi sileceğimiz zaman 2 nin 3 ü tutuğu referansı 1 in 2 yi tutuğu referans ile değiştirmek gererk
        //yani artık 1 3 ü tutuyor
        Node nodeToDelete = findNode(data);//sileceğim,iz değer bize int olrak geliyor amöa silme işlemi yapmak için elamamnın düğüm şekline ihtiyacımız var bunu find dan alıyoruz


        Node current = head;
        Node previous = null;

        if (head == nodeToDelete) {
            head = head.next;//sileceğimiz elaman 1. ise direkt silebiliriz

            return;
        }

        while (current != null && current != nodeToDelete) {//current değeri sileceğimiz elamana eşit olana kadar dönüyoruz
            previous = current;//previous değeri  current hep bir önceki değerini tutacak yani sileceğimiz elaman 5. düğümde ise current 5 preveus 4 olacak
            current = current.next;
        }

        previous.next = current.next;// preveus 4 olmuştu yuarıda current 5 5. düğümün referansını 4. düğümün refansınının yerine koyuyoruz
    }



    public void update(int oldData,int data){
        Node current = head;
        while (current!=null&& current.data != oldData){

            current=current.next;
        }
        current.data=data;


    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}

