class BubbleSort<T> extends ArraySort<T> {
   boolean ascend;

   public void iSort(Integer[] inArray) {
      IntegerComparator myComp = new IntegerComparator(true);
      //System.out.println(myComp.compare(1,1));

      // Bubblesort algo
      Integer temp;
      for (int i=0;i<inArray.length;i++) {
         for (int j=0;j<inArray.length;j++) {
            if (myComp.compare(inArray[i],inArray[j]) == -1) {
               //System.out.println("Hi");
               temp = inArray[j];
               inArray[j] = inArray[i];
               inArray[i] = temp;
            }
         }
      }
      for (int p=0;p<inArray.length;p++) {
         System.out.print(inArray[p]);
      }
   }
   public BubbleSort(boolean ascend) {
      this.ascend = ascend;
   }
   public T[] oSort(T[] inArray) {

      return null; // Placeholder

   }

}

public class sortNumbers {
   public static void main(String[] args) {
      boolean ascend = true;
      System.out.println("Hello");
      BubbleSort<Integer> myBub = new BubbleSort<Integer>(ascend);
      //Integer[] myarray = new Integer[2];
      //myarray[0] = 1;
      //myarray[1] = 2;
      Integer[] myList = {5,3,2,4,1};
      //myBub.iSort(myarray);

      myBub.iSort(myList);


      // use a for loop for args
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
      boolean myvalue = ascend;
      if (ascend == true) {

      }

   }

}
