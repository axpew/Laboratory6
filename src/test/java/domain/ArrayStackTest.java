package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void test(){

        ArrayStack arrayStack = new ArrayStack(10);
        try{
            for (int i = 0; i < 10; i++){
                int value = util.Utility.random(30);
                System.out.println("Value ["+value+"] pushed");

                arrayStack.push(value);

            }
            System.out.println(arrayStack);

            System.out.println(arrayStack); //llamo de nuevo al toString

        }catch(StackException ex){
            System.out.println(ex.getMessage());

        }




    }

}//END TEST