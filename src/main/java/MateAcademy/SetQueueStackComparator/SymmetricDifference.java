package MateAcademy.SetQueueStackComparator;

import java.util.HashSet;
import java.util.Set;


public class SymmetricDifference<T> {
  public Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {


//    public static <T> Set<T> diff(final Set<? extends T> s1, final Set<? extends T> s2) {
    Set<T> symmetricDiff = new HashSet<T>(set1);
    symmetricDiff.addAll(set2);
    Set<T> tmp = new HashSet<T>(set1);
    tmp.retainAll(set2);
    symmetricDiff.removeAll(tmp);
    return symmetricDiff;



//    return null;
  }
}
