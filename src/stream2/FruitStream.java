package stream2;
import java.util.*;
import java.util.stream.Collectors;

public class FruitStream {
    public static void main(String[] args) {

        List<String> fruits = Arrays.asList("Karpuz", "Muz", "Çilek", "Elma", "Avokado");

        List<String> sortedByLength = fruits.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

        List<String> upperCaseFruits = fruits.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> startsWithA = fruits.stream()
                .filter(fruit -> fruit.toLowerCase().startsWith("a"))
                .collect(Collectors.toList());

        int totalLength = fruits.stream()
                .mapToInt(String::length)
                .sum();

        System.out.println("Kelimeleri uzunluklarına göre sıralayın: " + sortedByLength);
        System.out.println("Kelimeleri büyük harfe çevirin: " + upperCaseFruits);
        System.out.println("'A' harfi ile başlayan kelimeler: " + startsWithA);
        System.out.println("Kelimelerin uzunluklarının toplamı: " + totalLength);
    }
}