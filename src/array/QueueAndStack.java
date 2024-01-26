package array;

public class QueueAndStack {
    int queue[];
    int stack[];
    int indexBound;
    public QueueAndStack(int arrayLength) {
        queue=new int[arrayLength];
        stack=new int[arrayLength];
        indexBound=0;
    }
// burada queue ilk giren ilk çıkar mantığı ile çalııyor banka kuyruğu gibi düşünülebilir ekleme işlemi aynı ama çıkarma işlemi farklı olacak
    public void push(int value){
        if(indexBound>=queue.length){

            System.out.println(" ");
        }else {
            int i=0;
            //burad sıralama var gereksiz
            for(i=indexBound-1;i>=0&&i>value;i--){
                queue[i+1]=queue[i];
            }
            //elaman eklerken normal bir şekilde dizinin sonuna ekleme yapcaz
            queue[i+1]=value;
            indexBound++;
        }
    }
    //ilk girenin ilk çıkması için elamnı çıkardıktan sonra her elamnı bir sola kaydırmalıyız
    // [3,1,2] var ilk pop  işleminde dizinin[0] indisini alıp atıyoruz eğer kaydırma yapmasak [0,1,2] şeklinde olur ve bidahi pop işleminde hata alırız bu yüzden her popda elamanları  [1,2] olur

    public int pop(){
        int f=queue[0];
        for(int i=0;i<queue.length;i++){
            queue[i]=queue[i+1];
        }
       queue[indexBound--]=0;//burada elamları sola aydırdığımızda en sağda bir boşluk olacak biz bu boşluğu 0 yapıyoruz
        return f;
    }
//stac için son gelen ilk çıkar mantığı var normal dizi mantığı
    public void pushS(int value){
        if(indexBound>=stack.length){

            System.out.println(" ");
        }else {
            int i=0;
            stack[i+1]=value;
            indexBound++;
        }
    }

    public int popS(){
        int f=stack[0];

        stack[indexBound--]=0;
        return f;
    }



}
