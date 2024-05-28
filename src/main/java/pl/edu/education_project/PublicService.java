package pl.edu.education_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.NoArgsConstructor;


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
      return Arrays.stream(number).sum();
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
}
