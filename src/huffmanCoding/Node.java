package huffmanCoding;

public class Node {
    public char karakter;
    public int frekans;
    public Node sag;
    public Node sol;
    public Node(char karakter, int frekans) {
        this.karakter = karakter;
        this.frekans = frekans;
        this.sag=null;
        this.sol=null;
    }
}
