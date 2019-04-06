package Lesson4;

public class Program {
    public static void main(String[] args) {
        // MyLinkedStack
        MyLinkedStack<Character> stack = new MyLinkedStack<>();
        stack.push('a');
        stack.push('c');
        stack.push('d');
        stack.push('x');
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
//        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push('g');
        System.out.println(stack.peek());
        System.out.println(stack);

        // MyLinkedQueue
        MyLinkedQueue<Character> queue = new MyLinkedQueue<>();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');
        System.out.println(queue);
        System.out.println(queue.size());
        System.out.println(queue.peekFront());
        queue.dequeue();
        System.out.println(queue.peekFront());
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
//        queue.dequeue();
        System.out.println(queue.size());
        queue.dequeue();
        queue.enqueue('f');
        queue.enqueue('g');
        queue.enqueue('h');
        System.out.println(queue);

        // MyLinkedDeque
        MyLinkedDeque<String> deque = new MyLinkedDeque<>();
        deque.insertLeft("Dear");
        deque.insertRight("hello");
        deque.insertRight("Konstantin");
        deque.insertRight(". How are you");
        deque.insertLeft("My");
        System.out.println(deque);
        System.out.println(deque.removeLeft());
        System.out.println(deque.peekLeft());
        System.out.println(deque);
        System.out.println(deque.removeLeft());
        System.out.println(deque.removeRight());
        System.out.println(deque.removeLeft());
        System.out.println(deque.peekLeft());
        System.out.println(deque.removeRight());
        System.out.println(deque);
        deque.insertLeft("My");
        deque.insertRight("Dear");
        deque.insertRight("Konstantin");
        deque.insertRight("hello");
        System.out.println(deque);

        /*MyLinkedList<Character> linkedList = new MyLinkedList<>();
        linkedList.addFirst('a');
        linkedList.addFirst('b');
        linkedList.addFirst('c');
        System.out.println(linkedList.size());
        System.out.println(linkedList);
        System.out.println(linkedList.get(1));
        linkedList.set(1, 'd');
        System.out.println(linkedList.get(1));
        linkedList.addFirst('e');
        linkedList.addLast('g');
        linkedList.add(2, 'f');
        System.out.println(linkedList);
        linkedList.removeLast();
        linkedList.removeFirst();
        System.out.println(linkedList.size());
        //System.out.println(linkedList);

        for (Character c:
                linkedList) {
            System.out.print(c + ", ");
        }*/
    }
}
