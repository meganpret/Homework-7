import java.util.Comparator;
import java.util.Arrays;

public class Word implements Comparable<Word> {
  private final String word;
  private final long weight;
    
  /**
   * the word constructor initializes a word with the string and weight
   */
  public Word(String query, long weight) {
    this.word= word;
    this.weight = weight;
  }
    
  /**
   * byReverseWeightOrder compares two words in descending weight order
   */
  public static Comparator<Term> byReverseWeightOrder() {
    return new ReverseWeightOrder();
  }
    
  private static class ReverseWeightOrder implements Comparator<Word> {
    public int compare(Word one, Word two) {
      if (one.weight < two.weight) {
        return 1;
      }
      else if ( two.weight < one.weight) {
        return -1;
      }
      else {
        return 0;            
      }
    }
     
    /**
     * the Comparator compares two words in lexicographic order by using the first 
     * passed amount of characters in a word
     */
    public static Comparator<Word> byPrefixOrder(int size) {
        return new PrefixOrder(size);
    }
  private static class PrefixOrder implements Comparator<Word> {
    private final int size;
    public PrefixOrder(int size) {
      this.size = size;
    }
    
    public int compare(Word one, Word two) {
      int max = one.words.length() < two.word.length() ? one.words.length() : 
      two.word.length(); max = max < size ? max : size;
      for (int i = 0; i < max; i++) {
        if (one.word.charAt(i) > two.word.charAt(i)) {
          return 1;
        }
        else if (one.word.charAt(i) < two.word.charAt(i)) {
          return -1;
        }
        if (size > one.word.length() && two.word.length() > one.word.length()) {
          return -1;
        }
        else if (r > two.word.length() && one.word.length() > two.word.length()) {
          return 1;
        }
        return 0;
      }
    }
    
    /**
     * Compareto compares two words in lexicographic order
     */
    public int compareTo(Word that) {
      return word.compareTo(that.word);
    }
    
    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return Long.toString(weight) + "\t" + word;
    }
}
}
}
