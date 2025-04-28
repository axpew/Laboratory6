package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    @Test
    void test() {
        try {
            // Crea e instancia un objeto ArrayStack para almacenar 11 personas
            ArrayStack arrayStack = new ArrayStack(15);

            // Push the Person objects
            arrayStack.push(new Person(1, "Alana", 18));
            arrayStack.push(new Person(2, "Pablo", 20));
            arrayStack.push(new Person(3, "Ana", 21));
            arrayStack.push(new Person(4, "María", 20));
            arrayStack.push(new Person(5, "Victoria", 18));
            arrayStack.push(new Person(6, "Nicole", 19));
            arrayStack.push(new Person(7, "Mateo", 18));
            arrayStack.push(new Person(8, "Nicole", 23));
            arrayStack.push(new Person(9, "Alana", 22));
            arrayStack.push(new Person(10, "Pablo", 19));
            arrayStack.push(new Person(11, "Ana", 18));

            // Muestra el contenido de la pila original
            System.out.println("Contenido original de la pila:");
            System.out.println(arrayStack);

            // Caso 1: Desapilar personas con age=18 y nombre que inicie con A
            System.out.println("\nCaso 1: Desapilando personas con age=18 y nombre que inicie con A");
            ArrayStack auxStack = new ArrayStack(15);

            while(!arrayStack.isEmpty()) {
                Person person = (Person) arrayStack.pop();

                if (person.getAge() == 18 && person.getName().startsWith("A")) {
                    System.out.println("Desapilado: " + person);
                } else {
                    auxStack.push(person);
                }
            }

            // Restaurar pila (sin elementos eliminados)
            while(!auxStack.isEmpty()) {
                arrayStack.push(auxStack.pop());
            }

            // Mostrar pila después del Caso 1
            System.out.println("\nContenido de la pila después del Caso 1:");
            System.out.println(arrayStack);

            // Caso 2: Desapilar personas con name=Nicole y age=19
            System.out.println("\nCaso 2: Desapilando personas con name=Nicole y age=19");
            auxStack = new ArrayStack(15);

            while(!arrayStack.isEmpty()) {
                Person person = (Person) arrayStack.pop();

                if (person.getName().equals("Nicole") && person.getAge() == 19) {
                    System.out.println("Desapilado: " + person);
                } else {
                    auxStack.push(person);
                }
            }

            // Restaurar pila (sin elementos eliminados)
            while(!auxStack.isEmpty()) {
                arrayStack.push(auxStack.pop());
            }

            // Mostrar pila después del Caso 2
            System.out.println("\nContenido de la pila después del Caso 2:");
            System.out.println(arrayStack);

            // Caso 3: Desapilar personas con edad entre 20 y 23
            System.out.println("\nCaso 3: Desapilando personas con edad entre 20 y 23");
            auxStack = new ArrayStack(15);

            while(!arrayStack.isEmpty()) {
                Person person = (Person) arrayStack.pop();

                if (person.getAge() >= 20 && person.getAge() <= 23) {
                    System.out.println("Desapilado: " + person);
                } else {
                    auxStack.push(person);
                }
            }

            // Restaurar pila (sin elementos eliminados)
            while(!auxStack.isEmpty()) {
                arrayStack.push(auxStack.pop());
            }

            // Mostrar pila después del Caso 3
            System.out.println("\nContenido de la pila después del Caso 3:");
            System.out.println(arrayStack);

        } catch(StackException ex) {
            System.out.println(ex.getMessage());
        }
    }
}