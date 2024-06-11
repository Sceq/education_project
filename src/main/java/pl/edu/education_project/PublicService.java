package pl.edu.education_project;

import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;


// W poniżej klasie tworzę metody które są wykonywane w EducationProjectApplication.java. lub niewykonywane, ale w ramach treningu na codeWars.
@NoArgsConstructor
public class PublicService {

   public double getSum(double[] number) {
      double sum = 0;
      for (int i = 0; i < number.length; i++) {
         sum += number[i];
      }
      return sum;
   }

   public double getSumOfNumber(double[] number) {
      return stream(number).sum();
   }

   public static int[] digitize(long n) {
      return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
   }

   public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
      int sum = 0;
      for (int classPoint : classPoints) {
         sum += classPoint;
      }
      return sum / classPoints.length < yourPoints;
   }

   public static int opposite(int number) {
      return -number;
   }

   public static List<Object> otherFunction(final List<Object> list) {
      return list.stream().filter(l -> l instanceof Integer).collect(Collectors.toList());
   }

   public static boolean functionForWords(String word) {
      List<String> listOfDigits = firstLoop(word);
      for (int i = 0; i < listOfDigits.size(); i++) {
         if (!listOfDigits.get(i).equals(listOfDigits.get(listOfDigits.size() - 1 - i))) {
            return false;
         }
      }
      return true;
   }

   private static List<String> firstLoop(String word) {
      List<String> listOfDigits = new ArrayList<>();
      for (int i = 0; i < word.length(); i++) {
         listOfDigits.add(String.valueOf(word.charAt(i)));
      }
      return listOfDigits;
   }

   public static int[] functionForTraining(long n) {
      int myInt = (int) n;
      String myString = Integer.toString(myInt);
      int[] myArray = new int[myString.length()];
      for (int i = 0; i < myString.length(); i++) {
         myArray[i] = myString.charAt(i) - '0';
      }
      return myArray;
   }

   public static boolean isIsogram(String str) {
      return str.length() == str.toLowerCase().chars().distinct().count();
   }

   public static boolean getXO(String str) {
      return str.replaceAll("[^xX]", "").length() == str.replaceAll("[^oO]", "").length();
   }

   public static boolean getXOMoreEffective(String str) {
      String x = "x";
      String o = "o";
      int xCount = 0;
      int oCount = 0;
      xCount = (int) str.toLowerCase()
        .chars()
        .filter(c -> c == x.charAt(0)).count();
      oCount = (int) str.toLowerCase()
        .chars()
        .filter(c -> c == o.charAt(0)).count();
      return xCount == oCount;
   }

   //dużo wydajniejsze rozwiązanie niż powyższe. Nie operujemy na stringach, a na tablicach znaków.
   // można jeszcze zmniejszyć ilość kodu, ale wtedy trudniej zrozumieć kod.

   public static int[] countPositivesSumNegatives(int[] input) {
      if (input != null && input.length > 0) {
         int first = 0;
         int second = 0;

         for (int j : input) {
            if (j > 0) {
               first++;
            } else {
               second += j;
            }
         }
         input[0] = first;
         input[1] = second;

         return Arrays.copyOf(input, 2);
      } else {
         return new int[0];
      }
      //teoretycznie bardziej wydajne, niż niektóre rozwiązania, ale modyfikacja tablicy może być kosztowna w niektórych kontekstach. Pierwsze rozwiązanie ze strumieniami było mniej kosztowne. (brak w kodzie - jest na codeWarsach, zapomniałem wrzucić. Można by było nawet jeszcze lepiej to zrobić.
   }

   //Postaram się tutaj wrzucać najpierw w postaci komentarza zadanie, a następnie je pod komentarzem rozwiązywać.
   //Dodatkowo w planach jest dodanie klas testowych z asercjami. Obecnie testy robią się na codeWarsach.

   //// Zadanie deadfish.
//   Write a simple parser that will parse and run Deadfish.
//
//   Deadfish has 4 commands, each 1 character long:
//
//   i increments the value (initially 0)
//   d decrements the value
//   s squares the value
//   o outputs the value into the return array
//   Invalid characters should be ignored.
//
//     Deadfish.parse("iiisdoso") =- new int[] {8, 64};
   public static int[] parse(String data) {
      int value = 0;
      char[] chars = data.toCharArray();
      int[] result = new int[]{};
      for (char aChar : chars) {
         if (aChar == 'i') {
            value++;
         } else if (aChar == 'd') {
            value--;
         } else if (aChar == 's') {
            value = value * value;
         } else if (aChar == 'o') {
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = value;
         }
      }
      return result;
   }

   //Zadanie: Find The Parity Outlier

//   You are given an array (which will have a length of at least 3, but could be very large) containing integers.
//   The array is either entirely comprised of odd integers or entirely comprised of even integers except for a single integer N.
//   Write a method that takes the array as an argument and returns this "outlier" N.

   static int find(int[] integers) {
      if (integers.length < 4) {
         if (stream(integers).filter(i -> i % 2 == 0).count() < 2) {
            return stream(integers).filter(i -> i % 2 == 0).findFirst().getAsInt();
         } else {
            return stream(integers).filter(i -> i % 2 != 0).findFirst().getAsInt();
         }
      } else {
         if (stream(integers).filter(i -> i % 2 == 0).count() > 1) {
            return stream(integers).filter(i -> i % 2 != 0).findFirst().getAsInt();
         } else {
            return stream(integers).filter(i -> i % 2 == 0).findFirst().getAsInt();
         }
      }
   }
   // Rozwiązanie jest całkiem dobre, bo działa :D, ale w praktyce można by było to zrobić lepiej.
   // Warto zwrócić uwagę na to, że w przypadku, gdyby było więcej niż 3 elementy, to można by było zrobić to w jednym strumieniu.

}
