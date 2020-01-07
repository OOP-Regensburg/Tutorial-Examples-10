package Demo;

import java.util.ArrayList;

public class ArrayListDemo {

  public static void main(String[] args) {
      ArrayList<String> words = new ArrayList<String>();
      words.add("Hello");
      words.add("World!");
      words.add("Java");
      words.add("ist");
      words.add("toll.");
      printListContent(words);
  }

  private static void printListContent(ArrayList<String> list) {
      for(String token: list) {
          System.out.println(token);
      }
  }

}
