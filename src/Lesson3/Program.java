package Lesson3;

//import java.util.ArrayDeque;
////// standart ArrayDeque
////        ArrayDeque<String> tmp = new ArrayDeque<>();
////        tmp.add("Hello");
////        tmp.addLast("Konstantin");
////        tmp.addFirst("Dear");
////        tmp.addFirst("My");
//System.out.println(tmp);

public class Program {
    public static void main(String[] args) {
        System.out.println("Переворот символов в предложении");
        // Переворот строки 1
        String str = "Hello, world";
        System.out.println(str);

        // при помощи стека
        MyArrayStack<Character> revertString = new MyArrayStack<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            revertString.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!revertString.isEmpty()) {
            Character c = revertString.pop();
            sb.append(c);
        }
        System.out.println(sb);

        // при помощи дека
        MyArrayDeque<Character> revertStringD = new MyArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            revertStringD.insertRight(c);
        }
        StringBuilder sbD = new StringBuilder();
        while (!revertStringD.isEmpty()) {
            Character c = revertStringD.removeRight();
            sbD.append(c);
        }
        System.out.println(sbD);

        System.out.println("Переворот слов в предложении");
        // Переворот строки 2
        String str2 = "My Dear Konstantin How are you";
        System.out.println(str2);
        String[] tmp_arr = str2.split(" ");

        // при помощи стека
        MyArrayStack<String> revertString2 = new MyArrayStack<>();
        for (int i = 0; i < tmp_arr.length; i++) {
            String s = tmp_arr[i];
            revertString2.push(s);
        }
        StringBuilder sb2 = new StringBuilder();
        while (!revertString2.isEmpty()) {
            String s = revertString2.pop();
            sb2.append(s+" ");
        }
        System.out.println(sb2);

        // при помощи дека
        MyArrayDeque<String> revertStringD2 = new MyArrayDeque<>();
        for (int i = 0; i < tmp_arr.length; i++) {
            String s = tmp_arr[i];
            revertStringD2.insertRight(s);
        }
        StringBuilder sbD2 = new StringBuilder();
        while (!revertStringD2.isEmpty()) {
            String s = revertStringD2.removeRight();
            sbD2.append(s+" ");
        }
        System.out.println(sbD2);

        System.out.println("MyArrayDeque");
        // MyArrayDeque
        MyArrayDeque<String> deque = new MyArrayDeque<>();
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

//        deque.removeLeft();
//        MyArrayStack<Character> stack = new MyArrayStack<>();
//        stack.push('a');
//        stack.push('c');
//        stack.push('d');
//        stack.push('x');
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
////        System.out.println(stack.pop());
//        System.out.println(stack.peek());
//        stack.push('g');
//        System.out.println(stack.peek());
//        System.out.println(stack);

        //(a + 4) * [(b - 7) / {a - 5 * (c + 8)}]
//        Expression e = new Expression("(a + 4) * {[(b - 7) / {a - 5 * (c + 8)}]");
//        System.out.println(e.checkBrackets());
//
//        MyArrayQueue<Character> queue = new MyArrayQueue<>();
//        queue.enqueue('a');
//        queue.enqueue('b');
//        queue.enqueue('c');
//        queue.enqueue('d');
//        queue.enqueue('e');
//        System.out.println(queue);
//        System.out.println(queue.size());
//        System.out.println(queue.peekFront());
//        queue.dequeue();
//        System.out.println(queue.peekFront());
//        queue.dequeue();
//        queue.dequeue();
//        queue.dequeue();
////        queue.dequeue();
//        System.out.println(queue.size());
//        queue.dequeue();
//        queue.enqueue('f');
//        queue.enqueue('g');
//        queue.enqueue('h');
//        System.out.println(queue);

        //4 + 5 - инфиксная
        //   1    2
        //(4 + 5) * 2
        //    *
        //  +   2
        //4   5
        //Левое поддерево - правое поддерево - корень
        //4 5 + 2 * = 9 2 * = 18
        //4 5
        //корень - Левое поддерево - правое поддерево
        //* + 4 5 2 = * 9 2 = 18
        //+ 4 5 - префиксная, польская нотация
        //4 5 + - постфиксная, обратная польская нотация
//        PostfixExpression expr = new PostfixExpression("4 5 + 2 *");
//        System.out.println(expr.calculate());
    }
}