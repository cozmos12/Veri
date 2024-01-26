package huffmanCoding;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Huffman {

    private Node huffmanTreeRoot;

    public String dosyadanMetinOku(String dosyaAdi) throws IOException {
        StringBuilder metin = new StringBuilder();
        try (BufferedReader okuyucu = new BufferedReader(new FileReader(dosyaAdi))) {
            String satir;
            while ((satir = okuyucu.readLine()) != null) {
                metin.append(satir);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return metin.toString();
    }
    public Map<Character, Integer> karakterFrekanslariniHesapla(String metin) {
        Map<Character, Integer> frekanslar = new HashMap<>();
        char[] karakterler = metin.toCharArray();
        for (char karakter : karakterler) {
            frekanslar.put(karakter, frekanslar.getOrDefault(karakter, 0) + 1);
        }
        return frekanslar;
    }

    public PriorityQueue<Node> frekanslariDugumlereDonustur(Map<Character, Integer> frekanslar) {
        PriorityQueue<Node> dugumler = new PriorityQueue<>(Comparator.comparingInt(dugum -> dugum.frekans));
        for (Map.Entry<Character, Integer> entry : frekanslar.entrySet()) {
            dugumler.add(new Node(entry.getKey(), entry.getValue()));
        }
        return dugumler;
    }

    public Node huffmanAgaciOlustur(PriorityQueue<Node> dugumler) {
        while (dugumler.size() > 1) {
            Node sol = dugumler.poll();
            Node sag = dugumler.poll();
            Node ebeveyn = new Node('\0', sol.frekans + sag.frekans);
            ebeveyn.sol = sol;
            ebeveyn.sag = sag;
            dugumler.add(ebeveyn);
        }
        huffmanTreeRoot = dugumler.poll();
        return huffmanTreeRoot;
    }

    public void huffmanKodlariniOlustur(Node dugum, String kod, Map<Character, String> kodlar) {
        if (dugum.karakter != '\0') {
            kodlar.put(dugum.karakter, kod);
        } else {
            huffmanKodlariniOlustur(dugum.sol, kod + "0", kodlar);
            huffmanKodlariniOlustur(dugum.sag, kod + "1", kodlar);
        }
    }
    public   void dosyayaYaz(String dosyaAdi, String icerik) {
        try (FileOutputStream ciktiAkisi = new FileOutputStream(dosyaAdi)) {
            ciktiAkisi.write(icerik.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String huffmanKodlariniUygula(String metin, Map<Character, String> karakterlereKodlar) {
        StringBuilder sikistirilmisMetin = new StringBuilder();
        char[] karakterler = metin.toCharArray();
        for (char karakter : karakterler) {
            sikistirilmisMetin.append(karakterlereKodlar.get(karakter));
        }
        return sikistirilmisMetin.toString();
    }
    public void print() {
        printTree(huffmanTreeRoot, "", true, true, true);
    }

    private void printTree(Node node, String indent, boolean isLast, boolean isRoot, boolean isRight) {
        if (node != null) {
            System.out.print(indent);

            if (isLast) {
                System.out.print("└─");
                indent += "  ";
            } else {
                System.out.print("├─");
                indent += "│ ";
            }

            if (node.karakter != '\0') {
                System.out.println(node.frekans + " " + node.karakter);
            } else {
                System.out.println(node.frekans);
            }

            if (node.sol != null || node.sag != null) {
                printTree(node.sol, indent, false, false, true);
                printTree(node.sag, indent, true, false, false);
            }
        }
    }

    public String huffmanCoz(String sikistirilmisMetin, Node huffmanTreeRoot) {
        StringBuilder orijinalMetin = new StringBuilder();
        Node current = huffmanTreeRoot;

        for (char bit : sikistirilmisMetin.toCharArray()) {
            if (bit == '0' && current.sol != null) {
                current = current.sol;
            } else if (bit == '1' && current.sag != null) {
                current = current.sag;
            }

            if (current.karakter != '\0') {
                orijinalMetin.append(current.karakter);
                current = huffmanTreeRoot;
            }
        }

        return orijinalMetin.toString();
    }
}
