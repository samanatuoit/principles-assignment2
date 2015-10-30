import java.util.Random;

class BubbleSort<T> extends ArraySort<T> {
   //boolean ascend;
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
      System.out.println("Sort complete. Printing :");
      for (int p=0;p<inArray.length;p++) {
         System.out.print(inArray[p] + " ");
      }
   }
   /*public BubbleSort(boolean ascend) {
      this.ascend = ascend;
   }*/
   public T[] oSort(T[] inArray) {

      T temp;
      T[] newArray = inArray;
      for (int i=0;i<newArray.length;i++) {
         for (int j=0;j<newArray.length;j++) {
            if (myComp.compare(newArray[i],newArray[j]) == -1) {
               //System.out.println("Hi");
               temp = newArray[j];
               newArray[j] = newArray[i];
               newArray[i] = temp;
            }
         }
      }

      return newArray; // Placeholder

   }
   public void setComparator(Comparator<T> comparator) {
      System.out.println("Calling setComparator ");

      //myComp = new IntegerComparator(ascend);
      myComp = comparator;

   }

}

public class sortNumbers {
   public static void main(String[] args) {
      boolean ascend = true;
      Random rand = new Random();
      int myArrLength = Integer.parseInt(args[0]);
      String mySortMethod = args[1];

      Integer[] myArray = new Integer[myArrLength];
      switch(mySortMethod) {
         case "bubble":
         BubbleSort<Integer> myBub = new BubbleSort<Integer>();
         Comparator<Integer> myNewComp = new IntegerComparator(ascend);
         myBub.setComparator(myNewComp);
         for (int i=0;i<myArrLength;i++) {
            myArray[i] = rand.nextInt(101);

         }

         myBub.iSort(myArray);
         Integer[] mySortedArray = myBub.oSort(myArray);
         break;
      }

      String sortDirection;/*

      if (args.length <= 2) {
         int myArrLength = Integer.parseInt(args[0]);
         String mySortMethod = args[1];
         int[] myArray = new int[myArrLength];
      }
      else if (args.length <= 3) {
         int myArrLength = Integer.parseInt(args[0]);
         String mySortMethod = args[1];
         sortDirection = args[2];

         int[] myArray = new int[myArrLength];

         if (sortDirection == "ascend") {
            ascend = true;
         }
         else if (sortDirection == "descend") {
            ascend = false;
         }
      }*/


      //  Testing block
      /*BubbleSort<Integer> myBub = new BubbleSort<Integer>(); // Works
      //myBub.myComp = new IntegerComparator(ascend); // This works
      Comparator<Integer> myNewComp = new IntegerComparator(ascend); // Also works
      myBub.setComparator(myNewComp); // Works

      Integer[] myList = {5,3,2,4,1}; // Test list


      myBub.iSort(myList);*/

      /* Ignore float, other types for now
      Float[] myFloatList = {5.1f,3.2f,2.4f,4.1f,1.8f};
      System.out.println("Floatlist made");
      BubbleSort<Float> myFloatBub = new BubbleSort<Float>();
      System.out.println("FloatBub made");
      Comparator<Float> myFloatComp = new FloatComparator(ascend);
      System.out.println("floatComp made");
      System.out.println("Beginning sort");
      myFloatBub.iSort(myFloatList);
      */




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

class FloatComparator implements Comparator<Float> {
   boolean ascend;

   public int compare(Float a, Float b) {
      int floatcomp = Float.compare(a,b);
      System.out.println("floatcomp = " + floatcomp);

      if (ascend == true) {
         //System.out.println("Ascend is true");
         if (floatcomp < 0) {
            return -1;
         }

         if (floatcomp > 0) {
            return 1;
         }
         else return 0;

      }
      else {
         //System.out.println("Ascend is false");
         if (floatcomp < 0) {
            return 1;
         }

         if (floatcomp > 0) {
            return -1;
         }
         else return 0;
      }

   }

   public FloatComparator(boolean ascend) {
      this.ascend = ascend;
   }

}
