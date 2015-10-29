class BubbleSort<T> extends ArraySort<T> {

   public void iSort(T[] inArray) {
      IntegerComparator myComp = new IntegerComparator(true);
      System.out.println(myComp.compare(1,1));

   }
   public T[] oSort(T[] inArray) {

      return null; // Placeholder

   }

}

public class sortNumbers {
   public static void main(String[] args) {
      System.out.println("Hello");
      BubbleSort<Integer> myBub = new BubbleSort<Integer>();
      Integer[] myarray = new Integer[2];
      myarray[0] = 1;
      myarray[1] = 2;
      myBub.iSort(myarray);
   }

}

class IntegerComparator implements Comparator<Integer> {

   public int compare(Integer a, Integer b) {

      if (a < b) {
         return -1;
      }
      
      if (a > b) {
         return 1;
      }
      else return 0;

   }

   public IntegerComparator(boolean ascend) {
      if (ascend == true) {

      }

   }

}
