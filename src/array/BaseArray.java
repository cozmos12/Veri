package array;

public class BaseArray {
  public int array[];
   public int es;
    public BaseArray(int arrayLength) {
        array=new int[arrayLength];
        es=0;
    }
// bu alanda basit bir dizi üzerinde crud işlemleri var çok anlatılacak bir bölüm yok debug koyarak kodları incelerseniz anlaşılır
    public void add(int value){
        if(es>=array.length){

            System.out.println(" ");
        }else {
            int i=0;

            //burada basit olarak gelen elamanı dizinin içerisindeki son elamanından başlayarak karşılaştırıyor ve
            //for koşulları sağlarsa dizideki her elamnı bir sağa kaydırıyor
            for(i=es-1;i>=0&&array[i]>value;i--){
                array[i+1]=array[i];
            }
            //for ile koşul sağlandıkça elamanlar bir sağa kaydırıldıktan gelen değer doğru yere yerleştirilir diğerimki 1,4,5,6dizisine 3 elamnı eklenecek  for dögüsünden dizi bu şekilde çıkar  [1,4,4,5,6] şeklinde ise dizi ve burada 1. indesin yerine gelen değer yerleştirilir
            array[i+1]=value;
            es++;



        }
    }

    public int find(int value){
        for(int i=0; i<es; i++){
            if(array[i]==value){
                return i;
            }
        }
        return -1;
    }

    public void delete(int value){
       int deleteIndex= find(value);

       for(int i=deleteIndex; i<es-1; i++){
           array[i]=array[i+1];
       }
       array[--es]=0;
    }

    public void update(int oldValue,int value){
        int oldValueIndex=find(oldValue);
        array[oldValueIndex]=value;
    }

    public void bubbleShort(){
        // bu algoritmayı anlamak için adım adım debugda incelemen daha iyi olur ana mantık dizinin her elamanı için tüm diziyi gezerek karşılaştıma yapmaktır
        //yani dizinin 0 indexsinden başlar ve bunu tüm dizi elamaları ile karşılştırı doğru yere koyar sonrasında dizinin 2. indesi için aynısını yapabilir
        boolean isSwap=true;
        for(int i=0;i<es&&isSwap;i++){
            isSwap=false;
            for(int j=0;j<es-1;j++){
                if(array[j]>array[j+1]){
                    int d=array[j+1];
                    array[j+1]=array[j];
                    array[j]=d;
                    isSwap=true;
                }

            }
        }
        //zaman karmaşılığı değşkendir ama O(N^2) genel karmaşıklığıdır
    }

    public void SelectionShort(){
        //buradkai amaç dizinin 0.indesinden başlar dizinin min elamanını bulur ve min değeri başladığı index ile yer değişir
        //mesela 0. indexten başladın ve dizin en küçük indesi 4. de bulunuyor 0 la 4 dün yeri değişir
        //asıl fark ise 0. indexle karşılaştırmaya başladık sonraki turda 0. index dahil edilmeden 1.indexten karşılaştıraya başlanır iç döngü her turda 1 eksik döner
        //yani her turda 1 elaman daha az dönecek döngümü yukarıdaki bubleshort her elaman için sabit sayıda dönerdi yani dış döngünün durumu iç döngüyü etkilemezdi
        //6 elemanlı bir dizi için başta 6 sonra 5 sonra 4  sonra 3 kere şeklinde iç döngü dönecek  bunu j=i+1 bu kod ile sağlıyoruz
        int min;
        int temp=0;
        for(int i=0;i<array.length;i++){
           min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }


          if(min!=i){
              temp=array[min];
              array[min]=array[i];
              array[i]=temp;
          }
        }
        //iç döngü her turda daha az çalışsa bile  zaman karmaşıklığı gine O(n^2)
    }

    public void insertionShort(){
        //bu algoritmada temlede SelectionShort gibi her turda iç döngü 1 adım daha az çalışır
        //farkı ise swap yerine kaydırma işlemi kullanmasıdır yani karşılaştırma sonucu karşılaştırılanelamnı 1 sola kaydırıyor
        //buradaki kaydırma her elmanı kaydırarak olmuyor mesela 3 le 2 karşılaştırılıyor 3 ü alıp 2 nin yerine de yazıyor yani 3,3 şeklinde oluyor
        for(int i =0;i<array.length;i++){
            int t=array[i];
            int j=0;
            for(j=i;j>0&&array[j-1]>t;j--){
                array[j]=array[j-1];// burada dizinin 3.indisi 3 olsun dizinin 4. indisi 2 olsun biz 2 değerini zaten t de tutuyoruz bu yüzden
                //2 değerinin değişmesi bize sorun yaratmaz bu yüzden 4.indisteki değerin yerine 3.indis teki değeri yerleştiriyoruz
                //yani dizi 3,2 yerine 3,3 oluyor bu şekilde devam ediyor algoritma
            }
            //for dongüsünden çıktığı yer karşılaştırılan değerin yani diğerlim 5.indis 4 bu karşlışatırılarak
            //her seferinde bir indis kaydırldı ver indisi 2 oldu eğer 2.indis 1.indisten büyükse fordan çıkar ve 2 . indisteki değer yerine
            //t değeri geri yazılır
            array[j]=t;

        }
        //bu algoritmanın da zaman karmaşıklığı O(N^2) dir
    }

    public void shellShort(){
        //bu algoritma insertionShort geliştirilmiş halidir insertionShort da her elamnı 1 adım farkla geziyorduk
        //burada karşılaştırma adımını artırmak istiyoruz ilk for hariç insertionShort dan farkı yoktur
        int i=0;
        int j=0;
        int gap=0;
        for(gap=array.length/2;gap>0;gap=gap/2){
            for(i=gap;i<array.length;i+=gap){

                int t=array[i];
                for(j=i; j>0&& array[j-gap]> t;j-=gap){

                    array[j]=array[j-gap];
                }
                array[j]=t;
            }
        }
        //zaman karmaşıklığı gine O(n^2) dir
    }

    public void mergeShort(int l,int r){
        //bu ve bundan sonraki algoritmalar recursive fonskisyonlar olacak
        //merge shorta temel amaç diziyi önce en kğçük parçalraına kadar parçalar ve bu en küçük parçaları kendi aralarında karşılaştırarak birleştirir
        if(l<r){
            int m=l+(r-l)/2;            //burada m değeri dizinin ortanca elamnı olur
            //1.
             mergeShort(l ,m);// burada fonksiyonu sağ değerine aynı değeri sol değer olarak m yani dizinin orta değeri gönderilir ve dizi 2 parçaya bölünür

            //2.
             mergeShort(m+1,r);//if()koşulu doğru olduğu sürece 1. fonksiyonun tekrar çağırır bu sayade en sağ taraf 1 elaman kadar düşene kadar süreer
            //if()false geldiği zaman 1. fonksiyonu atlarak 2. fonksiyonu çalıştırı ve 1. çalışmadan sonra if tekrar false gelir

            merge(m,l,r);//if bidaha flase geldiğinde 2. aşamayı atlayarak burayı çağırır
        }
    }

    public void merge(int m,int l,int r){
// buraya karşılaştımak için 2 parça gelir aslında 2 dizi gelmiş gibi düşün!!!
        int i=l;//1. dizinin 1. elamnı olur ve bu dizinin son elemanı m olur
        int j=m+1;//j değeri 2. gelen dizinin 1. elamnıymış gibi olur bu dizininde son elamnı r olur
        int[] t=new int[r-l+1];// geçici bir dizi oluşturulur
        int k=0;// bunu t dizisine atama yapmak için t dizisinin indisini tumak için kullanıyom
        while (i<=m&&j<=r){//burada 2 dizide son elamana gelene kadar dönsün üstiyoruz

            if(array[i]<array[j]){//burada 1. diziyle 2. dizi karşılaştırılır küçük olan yeni oluşturduğumuz t dizisne atılır
                t[k]=array[i];
                i++;//i yi t ye atadıktan sonra 2. diziyle tekrar karşılaştıma yapmak için i saysı artırılı
                //mesela 1. dizi 123 2. sizi 567 5>1 1 t dizisine atılır ve bidahaki while dongüsünde 1.sizinin 2 değerini 2. dizinin 5 değeri ile karşılaştıma yapmaya çalışırız
            }else{
                t[k]=array[j];
                j++;
            }
            k++;
        }
        //buradaki amaç mesle 1. dizi 123 2. dizi 567 olsun yukarıdaki koşulda 1. dizinin tamamamı t ye atılır hiç else girmediği için yani t dizisi 123 halinde kalır bu dögüler ile 567 değerlerini sırasıyla t dizisine atarız
        // j değeri artmaz bu yüzden j tarafını da t dizsine atmak için bu while döngülerini kullanırız
        //buradaki kontorl 1. dizi son elamanı olan m değerine kadar işlenmi işkenmdeiyse kalan değerleri t dizisine sırasıyla ekleriz
        while (i<=m){
            t[k]=array[i];
            i++;
            k++;
        }
        //bu da aynı döngü
        while (j<=r){
            t[k]=array[j];
            j++;
            k++;
        }
        //burada t dizisini orjinal diziye geri eklemey çalışırız

        for( i=0;i<t.length;i++){
            //l kullanmamızın nedini orjinal dizinin ilk bölündüğü noktadan sonrasına ekleme yapmak
            //yani şimdi 3 4 geldi bunları kontoorl ettik 34 olrak ekledik sonrasında 34 78 geldi bunları da1278 şekline getirdik
            //şimdi 6 elamnlı dizi önce 2 ye bölündü  3 3 olarak sonra bu üç lük parça 1 ve 2  olarak ayrıldı 1. parçayı karşıltırdık ve yazdık 2 elamlı parça burada karşılaştılıp birleştirlir
            //ama 2 elamanlı parça yı 1. parçadan sonrasına eklememiz gerekiyor bu yüzden 2 4lamanlı parçanın başlaması gereken yer yani l tarfından ekleme yapılır ;) baya karmaşık analttım ama inş anlarsın
            array[l++]=t[i];
        }
    }


    public void quickSort(int l,int r){
        //bu algoritmanın amacı bir pivot tumak yani dizide rasgele bir indisi alır ve bu nu kendinden önceki elemanlar ile karşılaştıararak
        //pivot doğru yerine koyulur ve sonrasında başka pivotta yanı işlem yapılır
        if(l<r){
            int pi=partition(l,r);//burada her pivotta bir pivottan öncesi ve sonrası gönderilir ve bu pivot doğru yere yerleştirilir sonra yeni pivot döner
            quickSort(l,pi-1);//burada merge sort gibi 2 parça oluşturuyoz ama sürekli parçalamıyoruz her pivotta bir kere parçalanır pivottan öncesi ve sonrası şeklinde
            quickSort(pi+1,r);// burası pivaatan sonraki kısım yani 123456 dizisinde 4 ü pivot seçtik 56 kısmı burada tutulur
        }

    }

    public int partition(int l,int r){
        int pi=r;
        int i=l;
        int j=r-1;
        do{
            //burada dizinin en solundan başlanır ve pivottan daha büyük bir elman aranır
            while (array[i]<array[pi]&&i<r){
                i++;
            }
            //burada dizinin sağından başalanarak pivootan daha küçük eleman aranır
            while (array[j]>array[pi]&&j>0){
                j--;
            }
            //bulunduğunda j indisi i indisinde3n daha büyükse eğer j ve i yer değişir
            if(i<j){
                swap(i,j);
            }

        }while (i<j);

        //yok i indisi j indisiden daha büyükse i indisi pivotla yer değişir
        swap(i,pi);
        return i;
    }
    public void swap(int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;

    }


    public void Write(){
        for(int i=0;i<es;i++){
            System.out.println(array[i]);
        }
    }
}
