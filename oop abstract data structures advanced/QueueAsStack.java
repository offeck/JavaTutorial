import java.util.NoSuchElementException;

public class QueueAsStack<T> implements Queue<T>{

    private Stack<T> stack;
    public QueueAsStack() {
        stack = new StackAsDynamicArray<>();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public void enqueue(T element) {
        if(element == null)
            throw new IllegalArgumentException();
        if(stack.isEmpty())
            stack.push(element);
        else {
            T elementInStack = stack.pop();
            enqueue(element);
            stack.push(elementInStack);
        }
    }
    public T dequeue() {
        if(stack.isEmpty())
            throw new NoSuchElementException();
        return stack.pop();
    }

    public T peek() {
        if(stack.isEmpty())
            throw new NoSuchElementException();
        return stack.peek();
    }

}
