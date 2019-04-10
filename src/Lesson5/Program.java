package Lesson5;

public class Program {
    public static void main(String[] args) {
        System.out.println(powRec(2, 8));
    }
    //ДЗ
    //1. Написать программу по возведению числа в степень с помощью рекурсии.
    //a^n = [a * a * ... * a] * a = a^(n -1) * a;
    //f(a, n) = f(a, n - 1) * a

    public  static long powRec2(int value, int power) {
        long res;
        if (power == 0) return 1;
        else if (power % 2 == 0) {
            res = powRec2(value, power / 2);
            return res * res;
        } else return powRec(value, power);
    }
    public static long powRec(int value, int power) {
        if (power == 0) return 1;
        else if (power == 1) return value;
        else if (power % 2 == 0) return powRec2(value, power);
        else return powRec(value, power - 1) * value;
    }

    public static long pow(int value, int power) {
        long result = 1;
        for (int i = 0; i < power; i++) result *= value;
        return result;
    }



    //5. Даны два целых неотрицательных числа a и b.
    //Без использования операции умножения найти произведение чисел a и b
    //a * b = [a + a + ... + a] + a = a * (b - 1) + a
    //f(a, b) = f(a, b - 1) + a

    public static int productRec(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        else if (b == 1) {
            return a;
        }
        else if (a == 1) {
            return b;
        }
        else {
            return productRec(a, b - 1) + a;
        }
    }

    public static int product(int a, int b) {
        int sum = 0;
        if (a < b) {int tmp = a; a = b; b = tmp;}
        while (b > 0) {
            sum += a;
            b--;
        }
        return sum;
    }

    //4. Дано натуральное число n. Найти сумму цифра числа n
    //n = 7561, 7 + 5 + 6 + 1 = 19
    //f(n) - сумма цифр числа n
    //f(7561) = f(756) + 1 = f(75) + 6 + 1 = f(7) + 5 + 6 + 1
    //f(n) = f(n/10) + n % 10;

    public static int digitSumRec(int n) {
        if (n < 10) {
            return n;
        }
        else {
            return digitSumRec(n / 10) + n % 10;
        }
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        return sum;
    }

    //3. Дано натуральное число n. Найти n-ое треугольное число
    //t(n) = [1 + 2 + .. + (n - 1)] + n
    public static int triangleRec(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n + triangleRec(n - 1);
        }
    }

    public static int triangle(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n;
            n--;
        }
        return sum;
    }

    //2. Дано натуральное число n. Найти факториал числа n.
    //n! = [1*2*...*(n - 1)]*n = (n - 1)! * n
    //f(n) = n!
    //f(n) = f(n - 1) * n
    //5! = 1*2*3*4*5 = 120

    public static long factRec(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return factRec(n - 1) * n;
        }
    }

    public static long fact(int n) {
        long product = 1;
        while (n > 0) {
            product *= n;
            n--;
        }
        return product;
    }

    //1. Дано натуральное число n. Найти n-ый член последовательности Фибоначчи
    //f(0) = 0 f(1) = 1, f(2) = 1, f(n) = f(n - 1) + f(n - 2)
    //1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
    //f(n)/f(n - 1) = fi = 1.618
    //a(n) = a(n - 1) + d
    public static long phiboRec(int n) {
        System.out.print(n + " ");
        if (n == 1 || n == 2) {
            return 1;
        }
        else {
            return phiboRec(n - 1) + phiboRec(n - 2);
        }
    }

    public static long phibo(int n) {
        long current = 1;
        int currentNumber = 1;
        long previous = 0;

        while (currentNumber < n) {
            long next = current + previous;
            previous = current;
            current = next;
            currentNumber++;
        }
        return current;
    }
}