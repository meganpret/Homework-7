
import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {
    /**
     * fistIndexOf method returns the index of the first key in the array that matches 
     * the search key
     */
  public static <Key> int firstIndexOf(Key[] words, Key key, Comparator<Key> comparator) {
    int low = 0;
    int high = words.length - 1;
    while (low <= high) {
      int middle = low + (high - low) / 2;
      if (comparator.compare(words[middle], key) > 0) {
        high = middle - 1;
      }
      else if (comparator.compare(words[middle], key) < 0) {
        low = middle + 1;
      }
      else {
      while (middle >= 0 && comparator.compare(words[middle], key) == 0) {
        middle--;
      }
      return middle + 1;
     }
    }
    return -1;
  }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
  public static <Key> int lastIndexOf(Key[] words, Key key, Comparator<Key> comparator) {
    int low = 0;
    int high = words.length - 1;
    while (low <= high) {
      int middle = low + (high - low) / 2;
      if (comparator.compare(words[middle], key) > 0) {
        high = middle - 1;
      }
      else if (comparator.compare(words[middle], key) < 0) {
        low = middle + 1;
      }
      else {
        while (middle < words.length && comparator.compare(words[middle], key) == 0) {
          middle++;
        }
        return middle - 1;
      }
    }
    return -1;
  }
}