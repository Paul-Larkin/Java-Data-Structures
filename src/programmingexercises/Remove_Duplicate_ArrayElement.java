package programmingexercises;

/*
 * @author: Paul_Larkin
 * @date: 04/11/2019
 * @description: Simple algorithm that sorts an
 * array then using one loop compares each index
 * value with the next index value.
 *
 * If a value is NOT equal to its successor then
 * it is placed into a temporary array (of
 * identical length but with default values)
 * which then has its index incremented.
 *
 * Finally the original array is re-declared with
 * a length the size of the index that the
 * temp arrays index last held.
 *
 * The sorted and most likely shorter
 * unique array is then returned.
 */

public class Remove_Duplicate_ArrayElement {

    public static void main(String[] args){
        int[] arr = new int[100];
        generateRandom(arr);
        quickSort(arr);
        arr = removeDuplicateElements(arr);
        printArray(arr);
    }

    private static int[] removeDuplicateElements(int[] arr){

        int length = arr.length;
        int[] temp = new int[length];
        int tempIndex = 0;

        for(int index = 0; index < length-1; index++) {

            //This condition fills the temp array with unique values
            if (arr[index] != arr[index + 1]) {
                temp[tempIndex] = arr[index];
                tempIndex++; //Temp index will be the length of our final unique array
            }
        }
        arr = new int[tempIndex];

        for(int index = 0; index < arr.length; index++){
            arr[index] = temp[index];
        }
        return arr;
    }

    //This is just sorting and printing code
    private static void quickSort(int[] array) {
        int length = array.length;
        quickSort(array, 0, length-1);
    }

    private static void quickSort(int[] array, int left, int right){

        //The essential variables
        int rightPointer = right-1, leftPointer = left;

        //base case
        if(left >= right) {
            return;
        }

        //This situation never occurs
        while(leftPointer < right && rightPointer >= 0){
            //If the pointers cross paths swap left side with pivot....if it is bigger
            if(leftPointer >= rightPointer){
                //Only if the arr[leftpointer] is bigger than the arr[pivot]
                if((array[leftPointer] > array[right])) {
                    swap(array, leftPointer, right);
                    break;
                }
				/*
				if((array[leftPointer+1] > array[pivot])) {
					swap(array, leftPointer, pivot);
					break;
				}*/
            }
            //If the the pointer are either larger/smaller respectivly then swap them
            if((array[leftPointer] > array[right]) && (array[rightPointer] < array[right])){
                swap(array, leftPointer, rightPointer);
                leftPointer++;
                rightPointer--;
            }
            //Else if only the left is bigger, decrement right
            else if(array[leftPointer] > array[right]) {
                rightPointer--;
            }
            //Else if only the right is smaller, increment left
            else if(array[rightPointer] < array[right]) {
                leftPointer++;
            }
            //Else increment and decrement
            else{
                leftPointer++;
                rightPointer--;
            }
        }

        //Run the recursive calls on the new smaller areas, left side first
        quickSort(array, left, rightPointer);
        quickSort(array, leftPointer+1, right);
    }
    //Swap method
    private static void swap(int[] array, int one, int two){
        int temp = array[one];
        array[one] = array[two];
        array[two] = temp;
    }
    //Print array method
    private static void printArray(int[] array) {

        for(int x: array) {
            System.out.print(x+", ");
        }
        System.out.println();
    }
    //Generate random array method
    private static void generateRandom(int[] array) {

        for(int i=0; i<array.length; i++) {
            int random = (int) (Math.random()*1000);
            array[i]=random;
        }
    }
}

