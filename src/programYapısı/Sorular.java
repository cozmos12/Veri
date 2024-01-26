package programYapısı;

public class Sorular {




        public  void dondur(int[] arr, int k) {
            int n = arr.length;//dizinin boyutu al

            // burayı kendime göre yazdım hiç kullamdanda k yı aynı değer olrakta alabilirsin
            k = k % n;

            //her kaydırma işleminde 1 eleman boşa çıkacak kaydırma işlemi sayısı kadar ilerleyerek dizinin ilk elamanın dan başlayarak başka dizye atarız kaybetmemek için
            int[] temp = new int[k];
            for (int i = 0; i < k; i++) {
                temp[i] = arr[i];
            }

            // sonrasında kaydırma sayısından sonraki elamları ilk elamlar ile yerlerini değiş
            for (int i = k; i < n; i++) {
                arr[i - k] = arr[i];
            }

            // burada kaybetmemek için tutuğumuz temp dizisindeki değerleri kaydıma işlemi yaptığımız dizinin sonuna ekleriz
            for (int i = 0; i < k; i++) {
                arr[n - k + i] = temp[i];
            }
        }


}
