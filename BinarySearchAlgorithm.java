import java.util.*;

public class BinarySearchAlgo {
  public static int[] ArrayInput(int n) {
    Scanner sc = new Scanner(System.in);
    System.out.println(" enter the " + n + " numbers you want ");
    int[] Array = new int[n];
    for (int i = 0; i < n; i++) {
      Array[i] = sc.nextInt();
    }
    return Array;
  }

  public static int[] SortedArray(int[] Array) {
    int[] sortedArray = new int[Array.length];
   sortedArray=Array.clone();
    Arrays.sort(sortedArray);
    return sortedArray;
  }

  public static void Display(int[] sorted_arraay) {
    for (int i = 0; i < sorted_arraay.length; i++) {
      System.out.print(sorted_arraay[i] + " ");
    }
    System.out.println();
  }

  public static int WhereIsElement(int[] OrigonalArray, int Target) {
    int temp = -1;
    for (int i = 0; i < OrigonalArray.length && temp==-1; i++) {
      if (OrigonalArray[i] == Target) {
        temp = i;
      }
    }

    System.out.println("Element is at index " + temp + " of original array");
    return temp;
  }

  public static int BinarySearch(int[] Array, int Target, int[] OrigonalArray) {
    Arrays.sort(Array);
    int start = 0, mid = 0, end = Array.length;
    boolean IsPresent = true;
    for (int counter = 0; counter < Array.length; counter++) {
      mid = (start + end) / 2;
      if (Target > Array[mid]) {
        start = mid;
      } else if (Target == Array[mid]) {
        IsPresent = true;
        break;
      } else {
        end = mid;
      }
    }
    if (Target != Array[mid]) {
      IsPresent = false;
    }
    if (IsPresent) {
      System.out.println("Element is present at index " + mid + " of sorted array");
      return WhereIsElement(OrigonalArray, Target);
    } else {
      System.out.println("Element is not present ");
      return -1;
    }
  }

  public static void AllForOne(int num) {
    Scanner sc = new Scanner(System.in);
    int[] abc = ArrayInput(num);
    System.out.println(" is this array correct? (y/n)");
    String str = sc.next();
    if ("y".equals(str.toLowerCase())) {
      int sorted_array2[] = SortedArray(abc);
      System.out.println();
      System.out.print("The sorted array is : ");
      Display(sorted_array2);
      System.out.println();
      System.out.println("Enter the Target element");
      int Target1 = sc.nextInt();
      BinarySearch(sorted_array2, Target1, abc);
    } else if ("n".equals(str.toLowerCase())) {
      AllForOne(num);
    } else {
      System.out.println(" Exception in thread \"main\" java.util.InvalidCharacterFound\r\n");
      AllForOne(num);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   while (true) {
    System.out.println(" enter the length of array");
    int num = sc.nextInt();
    AllForOne(num);
     System.out.println(" \n \n Do you want to continue for next array ? (y/n)");
     String str = sc.next();
     if ("n".equals(str.toLowerCase())){
       break;
  }
  }
    }
}
