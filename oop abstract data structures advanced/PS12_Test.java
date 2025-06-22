public class PS12_Test {

    public static void main(String[] args) {
        Queue<Integer> numbersQueue = new QueueAs2Stacks<>();
        numbersQueue.enqueue(3);
        numbersQueue.enqueue(4);
        System.out.println("First dequeue after entering 3 and then 4: " + numbersQueue.dequeue());
        numbersQueue.enqueue(1);
        numbersQueue.enqueue(8);
        System.out.println("second dequeue after entering 1 and 8: " + numbersQueue.dequeue());
        numbersQueue.enqueue(192);
        System.out.println("peek after entering 192: " + numbersQueue.peek());

        Queue<String> StringsQueue = new QueueAsStack<>();
        StringsQueue.enqueue("First in");
        StringsQueue.enqueue("Second");
        System.out.println("First dequeue after entering first and second: " + StringsQueue.dequeue());
        StringsQueue.enqueue("Third after dequeue");
        StringsQueue.enqueue("Fourth");
        System.out.println("Second dequeue after entering third and fourth: " + StringsQueue.dequeue());
        StringsQueue.enqueue("Sixth after dequeue");
        System.out.println("peed after entering sixth: " + StringsQueue.peek());


    }
}
