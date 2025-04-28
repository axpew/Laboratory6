package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest {

    void test(){

            LinkedStack linkedStack = new LinkedStack();
        try{
            for (int i = 0; i < 10; i++){
                int value = util.Utility.random(30);
                System.out.println("Value ["+value+"] pushed");

                linkedStack.push(value);

            }
            System.out.println(linkedStack);

            System.out.println(linkedStack); //llamo de nuevo al toString

        }catch(StackException ex){
            System.out.println(ex.getMessage());

        }

    }

   // @Test
    void test2(){

        try {
            //Prueba de isBalanced
            System.out.println("isBalanced(\"({[]})\") → " + util.Utility.isBalanced("({[]})"));
            System.out.println("isBalanced(\"([])\") → " + util.Utility.isBalanced("([])"));
            System.out.println("isBalanced(\"([)]\") → " + util.Utility.isBalanced("([)]"));
            System.out.println("isBalanced(\"((()))\") → " + util.Utility.isBalanced("((()))"));
            System.out.println("isBalanced(\"{[}\") → " + util.Utility.isBalanced("{[}"));
            System.out.println("isBalanced(\"]\") → " + util.Utility.isBalanced("]"));
            System.out.println("isBalanced(\"\") → " + util.Utility.isBalanced(""));

            //prueba de decimalToBinary
            int[] numbers = {0, 3, 4, 5, 6, 7, 9, 10, 15, 17, 23, 32, 255, 1023, 1025, 4192, 8586};
            for (int value : numbers)
                System.out.println("Decimal: " + value + " → Binary: " + decimalToBinary(value));

        }catch (StackException e){throw new RuntimeException();}


    }//Test 2

    private String decimalToBinary(int number) throws StackException {
        return "";
    }


    // ----------------------------------- TEST DE PREFIX, INFIX , POSTFIX CONVERTERS -----------------------------------------------------
    //@Test
    void infixToPosfixTest(){

        try {

            System.out.println("infix: ((a-b)*(a+c)) to postfix: "
            + util.Utility.infixToPostfixConverter("((a-b)*(a+c))"));

        } catch (StackException e) {throw new RuntimeException(e);}

    }

   // @Test
    void postfixToInfixTest(){

        try {

            System.out.println("postfix: ab-ac+* to infix: "
                    + util.Utility.postfixToInfixConverter("ab-ac+*"));

        } catch (StackException e) {throw new RuntimeException(e);}

    }

    //@Test
    void infixToPrefixTest(){

        try {

            System.out.println("infix: ((a-b)*(a+c)) to prefix: "
                    + util.Utility.infixToPrefixConverter("((a-b)*(a+c))"));

        } catch (StackException e) {throw new RuntimeException(e);}

    }

    //@Test
    void prefixToInfixTest(){

        try {

            System.out.println("prefix: *-ab+ac to infix: "
                    + util.Utility.prefixToInfixConverter("*-ab+ac"));

        } catch (StackException e) {throw new RuntimeException(e);}

    }
//------------------------------------------------------------------------------------------------------------------------------------------

}//END TEST