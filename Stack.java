public class Stack {

    private int size;
    private int top;
    private int[] stackArray;

    Stack(int size){
        this.size = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    public boolean isFull() {
        return (size-1==top);
    }

    public boolean isEmpty() {
        return (top==-1);
    }

    public int push(int input) {
        if(!isFull()) {
            top++;
            stackArray[top]=input;
            return input;
        }else {
            return -1;
        }
    }

    public int pop() {
        if(!isEmpty()) {
            stackArray[top]=-1;
            return stackArray[top--];
        }else {
            return -1;
        }
    }

    public int peek() {
        if(top>=0) {
            return stackArray[top];
        }else {
            return -1;
        }
    }

    public void printStack() {
        if(top>=0) {
            int i = 0;
            int t = top;
            while(t>=i) {
                System.out.println(stackArray[t]);
                t--;
            }
            System.out.println("  ");
        }else {
            System.out.println("The Stack is empty");
        }
    }

    public static void main(String[] args) {

        Stack myStack = new Stack (25);
        myStack.push(9);
        myStack.push(5);
        myStack.push(7);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        myStack.pop();

        myStack.printStack();
    }

}
