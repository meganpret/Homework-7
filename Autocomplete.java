import java.util.Arrays;

/**
 * Author: Megan Pretorius
 * Date: 03/18/2020
 */
public class Autocomplete {
  private final Word[] words;

  /**
   * The autocomplete method initializes the data structure 
   */
  public Autocomplete(Word[] words) {
    this.words = new Word[words.length];
    for (int i = 0; i < words.length; i++) {
      if (words[i] == null) {
        throw new java.lang.IllegalArgumentException("no word input");
        this.words[i] = words[i];
      }
      Arrays.sort(this.words);
    }
  }

  /**
   * the allMatches method returns the twords that start with the parameter prefix
   * the return sorting is in descending order due to weight 
   */
  public Word[] allMatches(String prefix) {
    if (prefix.length() == 0) {
      Word[] suggested = new Word[words.length];
      for (int i = 0; i < words.length; i++) {
        suggested[i] = words[i];
      }
      Arrays.sort(suggested, Word.ReverseWeightOrder());
      return suggested;
    }
    Word p = new Word(prefix, 0);
    int first = BinarySearchDeluxe.firstIndexOf(
                words, p, Word.byPrefixOrder(prefix.length()));
    if (first < 0) {
      return new Word[] {};
    }
    int last = BinarySearchDeluxe.lastIndexOf(
               words, p, Word.byPrefixOrder(prefix.length()));
    Word[] suggested = new Word[last - first + 1];
    for (int i = first; i <= last; i++) {
      suggested[i - first] = words[i];
    }
    Arrays.sort(suggested, Word.byReverseWeightOrder());
    return suggested;
  }

  /**
   * The numberOfMatches method returns the number of words that start with the 
   * passed prefix
   */
  public int numberOfMatches(String prefix) {
    if (prefix.length() == 0) {
      return words.length;
    }
    Word p = new Word(prefix, 0);
    int first = BinarySearchDeluxe.firstIndexOf( words, p, Term.byPrefixOrder
                (prefix.length()));
    if (first < 0) {
      return 0;
    }
    int last = BinarySearchDeluxe.lastIndexOf( words, p, Word.byPrefixOrder
               (prefix.length()));
    return last - first + 1;
  }
}
