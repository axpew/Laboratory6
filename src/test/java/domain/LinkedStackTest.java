package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    @Test
    void test() {
        LinkedStack linkedStack = new LinkedStack();
        try {
            for (int i = 0; i < 10; i++) {
                int value = util.Utility.random(30);
                System.out.println("Value [" + value + "] pushed");
                linkedStack.push(value);
            }
            System.out.println(linkedStack);
            System.out.println(linkedStack); // Call toString again
        } catch(StackException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void test2() {
        try {
            // Prueba de isBalanced
            System.out.println("isBalanced(\"({[]})\") → " + isBalanced("({[]})"));
            System.out.println("isBalanced(\"([])\") → " + isBalanced("([])"));
            System.out.println("isBalanced(\"([)]\") → " + isBalanced("([)]"));
            System.out.println("isBalanced(\"((()))\") → " + isBalanced("((()))"));
            System.out.println("isBalanced(\"{[}\") → " + isBalanced("{[}"));
            System.out.println("isBalanced(\"]\") → " + isBalanced("]"));
            System.out.println("isBalanced(\"\") → " + isBalanced(""));

            // Prueba de decimalToBinary
            int[] numbers = {0, 3, 4, 5, 6, 7, 9, 10, 15, 17, 23, 32, 255, 1023, 1025, 4192, 8586};
            for (int value : numbers)
                System.out.println("Decimal: " + value + " → Binary: " + decimalToBinary(value));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    // Implementación de isBalanced
    private boolean isBalanced(String expression) {
        LinkedStack stack = new LinkedStack();

        try {
            for (char c : expression.toCharArray()) {
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}') {
                    if (stack.isEmpty()) {
                        return false;
                    }

                    char top = (char) stack.pop();
                    if ((c == ')' && top != '(') ||
                            (c == ']' && top != '[') ||
                            (c == '}' && top != '{')) {
                        return false;
                    }
                }
            }

            return stack.isEmpty();
        } catch (StackException e) {
            return false;
        }
    }

    // Implementación de decimalToBinary
    private String decimalToBinary(int number) throws StackException {
        // Caso especial: si number es cero
        if (number == 0) {
            return "0";
        }

        LinkedStack stack = new LinkedStack();

        // Mientras sea posible dividir number entre 2
        while (number > 0) {
            // Agregar el residuo a la pila
            stack.push(number % 2);
            // Dividir entre 2
            number = number / 2;
        }

        // Construir el resultado concatenando los elementos de la pila
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    @Test
    void infixToPosfixTest() {
        try {
            System.out.println("infix: ((a-b)*(a+c)) to postfix: "
                    + util.Utility.infixToPostfixConverter("((a-b)*(a+c))"));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void postfixToInfixTest() {
        try {
            System.out.println("postfix: ab-ac+* to infix: "
                    + util.Utility.postfixToInfixConverter("ab-ac+*"));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void infixToPrefixTest() {
        try {
            System.out.println("infix: ((a-b)*(a+c)) to prefix: "
                    + util.Utility.infixToPrefixConverter("((a-b)*(a+c))"));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void prefixToInfixTest() {
        try {
            System.out.println("prefix: *-ab+ac to infix: "
                    + util.Utility.prefixToInfixConverter("*-ab+ac"));
        } catch (StackException e) {
            throw new RuntimeException(e);
        }
    }
}