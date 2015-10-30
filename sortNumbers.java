class BubbleSort<T> extends ArraySort<T> {
   boolean ascend;
   Comparator<T> myComp;
   //IntegerComparator myComp = new IntegerComparator(ascend);
   //Comparator<Integer> myComp = new IntegerComparator(ascend);
   public void iSort(T[] inArray) {
      //Comparator<T> myComp = new IntegerComparator(ascend);

      //IntegerComparator myComp = new IntegerComparator(ascend);
      //setComparator(myComp);
      //System.out.println(myComp.compare(1,2));


      // Bubblesort algo
      T temp;
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
   public void setComparator(Comparator<T> comparator) {
      System.out.println("Calling setComparator ");

      //myComp = new IntegerComparator(ascend);

   }

}

public class sortNumbers {
   public static void main(String[] args) {
      boolean ascend = true;
      System.out.println("Hello");
      BubbleSort<Integer> myBub = new BubbleSort<Integer>(ascend);
      myBub.myComp = new IntegerComparator(ascend); // This works
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
   boolean ascend;

   public int compare(Integer a, Integer b) {
      if (ascend == true) {
         //System.out.println("Ascend is true");
         if (a < b) {
            return -1;
         }

         if (a > b) {
            return 1;
         }
         else return 0;

      }
      else {
         //System.out.println("Ascend is false");
         if (a < b) {
            return 1;
         }

         if (a > b) {
            return -1;
         }
         else return 0;
      }

   }

   public IntegerComparator(boolean ascend) {
      this.ascend = ascend;


   }

}
