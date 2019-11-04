package sortingalgorithms;

/*
 * @author: Paul Larkin
 * @date: 05/05/2019
 * @name: RightPivotQuickSort
 *
 */

public class RightPivotQuickSort{
	
	private int[] array;
	
	private void quickSort(int[] inputArray) {
		array = inputArray;
		int length = inputArray.length;
		quickSort(array, 0, length-1);
	}
    
    private void quickSort(int[] array, int left, int right){
    	
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
    private void swap(int[] array, int one, int two){
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;
	}
    //Print array method
    private void printArray(int[] array) {
    	
    	for(int x: array) {
        	System.out.print(x+", ");
    	}
    	System.out.println();
    }
    //Generate random array method
	private void generateRandom(int[] array) {
		
		for(int i=0; i<array.length; i++) {
			int random = (int) (Math.random()*1000);
			array[i]=random;
		}
	}
    
    public static void main(String[] args){
        
        int[] myarray = new int[500];
        
        RightPivotQuickSort obj = new RightPivotQuickSort();
        
        obj.generateRandom(myarray);
        obj.array = myarray;
        
        obj.printArray(obj.array);

        obj.quickSort(obj.array);
        
        obj.printArray(obj.array);
    }
}