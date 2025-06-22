import java.util.NoSuchElementException;

public class QueueAs2Stacks<T> implements Queue<T> {

    private Stack<T> stack1;
    private Stack<T> stack2;

    public QueueAs2Stacks() {
        stack1 = new StackAsDynamicArray<>();
        stack2 = new StackAsDynamicArray<>();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
    public void enqueue(T element) {
        if(element == null)
            throw new IllegalArgumentException();
        moveStack1ToStack2();
        stack1.push(element);
        moveStack2ToStack1();
    }
    public T dequeue() {
        if(isEmpty())
            throw new NoSuchElementException();
        return stack1.pop();
    }
    public T peek() {
        if(isEmpty())
            throw new NoSuchElementException();
        return stack1.peek();
    }
    private void moveStack1ToStack2(){
        while(!stack1.isEmpty())
            stack2.push(stack1.pop());
    }
    private void moveStack2ToStack1(){
        while(!stack2.isEmpty())
            stack1.push(stack2.pop());
    }

}
