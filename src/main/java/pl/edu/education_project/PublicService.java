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




   //A child is playing with a ball on the nth floor of a tall building. The height of this floor above ground level, h, is known.
   //
   //He drops the ball out of the window. The ball bounces (for example), to two-thirds of its height (a bounce of 0.66).
   //
   //His mother looks out of a window 1.5 meters from the ground.
   //
   //How many times will the mother see the ball pass in front of her window (including when it's falling and bouncing)?
   //
   //Three conditions must be met for a valid experiment:
   //Float parameter "h" in meters must be greater than 0
   //Float parameter "bounce" must be greater than 0 and less than 1
   //Float parameter "window" must be less than h.
   //If all three conditions above are fulfilled, return a positive integer, otherwise return -1.
   //
   //Note:
   //The ball can only be seen if the height of the rebounding ball is strictly greater than the window parameter.

   public static int bouncingBall(double h, double bounce, double window) {
      if(h > 0 && bounce > 0 && bounce < 1 && window < h)
      {
         int count = 0;
         while(h > window)
         {
            h*=bounce;
            count ++;
         }
          return count * 2 - 1;
      }
      return -1;
   }


//   Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.
//     Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case


   public static int countBits(int n){
      return Integer.bitCount(n);
   }

   //chyba najprostsze co się trafiło xD



   public static String battle(String goodAmounts, String evilAmounts) {
      String goodWins = "Battle Result: Good triumphs over Evil";
      String evilWins = "Battle Result: Evil eradicates all trace of Good";
      String draw = "Battle Result: No victor on this battle field";

      int[] good = stream(goodAmounts.split(" ")).mapToInt(Integer::parseInt).toArray();
      int[] evil = stream(evilAmounts.split(" ")).mapToInt(Integer::parseInt).toArray();

      int goodPower = 1 * good[0] + 2 * good[1] + 3 * good[2] + 3 * good[3] + 4 * good[4] + 10 * good[5];
      int evilPower = 1 * evil[0] + 2 * evil[1] + 2 * evil[2] + 2 * evil[3] + 3 * evil[4] + 5 * evil[5] + 10 * evil[6];

      if (goodPower > evilPower) {
         return goodWins;
      } else if (goodPower < evilPower) {
         return evilWins;
      } else {
         return draw;
      }
   }

   public boolean check(String sentence){
      return sentence.toLowerCase().chars().filter(Character::isAlphabetic).distinct().count() == 26;
    }

   public static int[] snail(int[][] array) {
      ArrayList<Integer[]> listOfArrays = new ArrayList<>();

      // 1. [[]] - wynik puste.
      /*2. [0,0] [0,1]
           [1,0] [1,1]

*/
      /*3.
           [0,0] [0,1] [0,2]
           [1,0] [1,1] [1,2]
           [2,0] [2,1] [2,2]
      */
      /*
           [0,0] [0,1] [0,2] [0,3]
           [1,0] [1,1] [1,2] [1,3]
           [2,0] [2,1] [2,2] [2,3]
           [3,0] [3,1] [3,2] [3,3]
           x = 8
           pierwsza tablica wszystkie elementy.
           druga tablica ostatni element
           trzecia tablica ostatni element
           czwarta tablica wszystkie elementy reverse.
           trzecia tablica pierwszy element
           druga tablica od pierwszego do ostatniego, bez ostatniego.
           trzecia tablica przedostatni element i następny, bez pierwszego.

           [0,0] [0,1] [0,2] [0,3] [0,4]
           [1,0] [1,1] [1,2] [1,3] [1,4]
           [2,0] [2,1] [2,2] [2,3] [2,4]
           [3,0] [3,1] [3,2] [3,3] [3,4]
           [4,0] [4,1] [4,2] [4,3] [4,4]

           pierwsza tablica wszystkie elementy.
           druga tablica ostatni element
           trzecia tablica ostatni element
           czwarta tablica ostatni element
           piąta tablica wszystkie elementy reverse.
           czwarta tablica pierwszy element
           trzecia tablica pierwszy element
           druga tablica od pierwszego do ostatniego, bez ostatniego.
           trzecia tablica przedostatni element i następny, bez pierwszego. /// to nie zadziała w ten sposób

           dla każdej tablicy rób tak:
          tablice typu row i tablice typu columns:
          rowTables = tylko wiersze
          columnTables = tylko kolumny. posortuj odwrotnie
          usedrowTabels = 1
          usedcolumTabel = 1
          for(int b= 0; allArrays.lenght(); i++)
          {
          1.
            for(int i = 0; i <= rowTabels.lenght(); i++) {
                         if(i nieparzyste){

               rowTabels[rowTabels.lastIndex() -usedrowTabels].sortedReverse();
               columnTabel[columnTabel.firstIndex() - usedcolumTabel].sortedRevers();
               }
             rezultat.add(rowTabel[i]);
               rezultat.remove(rowTabel[].lastindex());
               rezultat.add(columntTabel[i];
               rezultat.remove(columnTabel[i].lastindex());
               countRowTabels--
               countColumnTabel--


              }
  {1,2,3}
  {4,5,6}
  {7,8,9}

  6 tablic
4 rowTabel:
  {1,2,3,4} 1,2,3,4,8,12,16,15,14,13,9,5
  {5,6,7,8}
  {9,10,11,12}
  {13,14,15,16} tera na odwrót

4 columnTabel reverse:
  {4,8,12,16}
  {3,7,11,15}
  {2,6,10,14}
  {1,5,9,13}
  tera na odwrót
*/

   }
}