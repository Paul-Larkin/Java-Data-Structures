/*
 * @author: Paul Larkin
 * @date: 13/03/2019
 * @name: Queue
 *
 * @description: A java implementation
 * of a Queue Data Structure
 *
 */

public class Queue {

    private int maxSize;//To set the max size available
    private int front;//To pick array index for the first entry
    private int rear;//The rear which holds the last entry
    private int[] queueArray;//Array[] integer to create structure
    public int nItems;//Holds number of items

    Queue(int size){//Queue constructor
        maxSize=size;//Takes size from the input
        queueArray = new int [maxSize];//The previous array now has a size
        front=0;//Front starts at 0
        rear=-1;//Rear starts at -1
        nItems=0;//No items at the beginning
    }

    public boolean isEmpty() {//Is the queue empty
        return (nItems==0);//Boolean to check nItem equals 0 (t/f)
    }

    public boolean isFull() {//Is the queue full
        return (nItems==maxSize);//Boolean to check nItems equals maxSize (t/f)
    }

    public int size() {//What amount of items are in the queue
        return nItems;//Return the nItems
    }

    public int peekFront() {//What value is front of the queue
        return queueArray[front];//Return queueArray front
    }

    public int peekRear() {//What value is last in the queue
        return queueArray[rear];//return queueArray rear
    }

    public boolean insert(int input) {//Insert a value into the queue

        if(isFull()) {//If the queue is full, print message
            System.out.println(input + " not inserted queue already full");
            return false;//Return as an exit
        }

        if(rear==maxSize-1) {//if the rear is about to burst the max parameter
            rear=-1;//Reset the rear to -1, print message
            System.out.println("Performing a wraparound");
        }
        rear++;//Rear goes up in value
        queueArray[rear]=input;//The rear of the queue takes the input
        nItems++;//Number of items increases, print message
        System.out.println("Inserted "+ input+" into index: "+rear);
        return true;//Return to exit
    }

    public int remove(){//Remove items from the queue
        if(nItems==0) {//If the queue is empty, print message
            System.out.println("Removed nothing queue empty");
            return -1;//Return to exit
        }
        int temp = queueArray[front];//Int temp takes the value of the front
        System.out.println("Removed " + temp+ " from index: "+front);//Print message
        front++;//Increment the front to next index

        if(front == maxSize) {//If the front is at the max
            front=0;//Then return the front to zero
        }
        nItems--;//Number of items becomes less

        if(nItems==0) {//If the queue is empty of values
            front=0;//Front becomes zero
            rear=-1;//Rear becomes -1
        }
        return temp;//Return to exit
    }

    public static void main(String[] args) {

        int size = 5;
        Queue myQueue = new Queue(size);

        for(int i=0; i<size; i++) {
            System.out.println(myQueue.peekFront());
        }
    }
}
