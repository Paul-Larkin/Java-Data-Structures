package datastructures;/*
 * @author: Paul Larkin
 * @date: 18/03/2019
 * @name: Stack
 *
 * @description: A java implementation
 * of a Stack Data Structure
 *
 */

public class Stack {

    private int size; //Used to size of the stack
    private int top; //Used to keep track of the top element in the stack
    private int[] stackArray; //Array to hold the stack

    Stack(int size){ //Stack constructor
        this.size = size; //The size set as per the passed value
        this.stackArray = new int[size]; //The array created will be of this size
        this.top = -1; //Initially the top element will be -1
    }

    //Check the status of the stack
    public boolean isFull() {
        return (size-1==top); //True if full
    }

    //Check the status of the stack
    public boolean isEmpty() {
        return (top == -1); //True is empty
    }

    //Push element into the stack
    public int push(int input) {
        if(!isFull()) { //If not full
            top++; //Increment top
            stackArray[top]=input; //Top element assigned value of input
            return input; //Returning the input if needed to print
        }else {
            return -1; //Else return -1
        }
    }

    //Pop element from the stack
    public int pop() {
        if(!isEmpty()) { //If not empty
            stackArray[top]=-1; //Top element takes value of -1
            return stackArray[top--]; // Decrement the top
        }else {
            return -1; //Return -1
        }
    }

    //View top element
    public int peek() {
        if(!isEmpty()) { //If not empty
            return stackArray[top]; //Top element
        }else {
            return -1; //Reteurn -1
        }
    }

    //Print all elements of the stack
    public void printStack() {
        if(!isEmpty()) { //If stack is not empty
            int t = top; //T is assigned the value of the top element index
            while(t>=0) { //While t (top) is >= the [0] element
                System.out.println(stackArray[t]); //Print the t (top) element
                t--; //Decrement t
            }
        }else {
            System.out.println("The Stack is empty"); //Empty stack message
        }
    }

    //Main method
    public static void main(String[] args) {

        Stack myStack = new Stack (25);
        myStack.push(100);
        myStack.push(100);
        myStack.peek();
        myStack.printStack();
    }//End of main
}//End of class