public class ArraySum {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 10, 11 };
    int sum;
    // assign sum of elements of array arr to variable sum
    sum = 0;
    for (int i : arr) {
      sum += i;
    }
    // print variable sum
    System.out.println(sum);
  }
}