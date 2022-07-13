
//Створити довільний клас , описати його. Створити в мейн його екземпляр, дослідити всю інформацію про нього :

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Person person = new Person("Mike",45);
        Class<? extends Person> personClass = person.getClass();

        //- отримати всі методи (private в тому числі);
        Method[] meths = personClass.getDeclaredMethods();
        Arrays.stream(meths).forEach(System.out::println);
        System.out.println("=====================================");

        //- отримати поля класу (private в тому числі);
        Field[] fields = personClass.getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);
        System.out.println("=====================================");

        //- отримати всі конструктори;
        Constructor[] constructors = personClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
        System.out.println("=====================================");

        //- створити екземпляр класу з двох різних конструкторів;
        //- викликати 2 методи (один - з параметрами, другий - без параметрів).
        Person person1 = (Person) Person.class.getConstructors()[0].newInstance();
        person1.setName("Anya");
        System.out.println(person1.getName());

        Person person2 = (Person) Person.class.getConstructors()[1].newInstance("Serega",33);
        System.out.println(person2.getName());


    }
}
