package programYapısı;

public class Soru2 {
    public int Taban18(int n, int Kalan[]) {
        int k = 0;

        while (n > 0) {
            Kalan[k++] = n % 18;
            n /= 18;
        }

        return k;
    }
}
