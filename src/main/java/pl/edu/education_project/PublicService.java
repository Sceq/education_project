package pl.edu.education_project;

import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
         sum +=classPoint;
      }
      return sum / classPoints.length < yourPoints;
   }

   public static int opposite(int number)
   {
      return -number;
   }

   public static List<Object> otherFunction(final List<Object> list)
   {
      return list.stream().filter(l -> l instanceof Integer).collect(Collectors.toList());
   }

   public static boolean functionForWords(String word)
   {
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
      for(int i = 0; i < word.length(); i++)
      {
         listOfDigits.add(String.valueOf(word.charAt(i)));
      }
      return listOfDigits;
   }

   public static int[] functionForTraining(long n)
   {
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

   public static boolean getXO (String str) {
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
      return  xCount == oCount;
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
}
