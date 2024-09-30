//Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса
// в файл.
//
//Задание 2: Используя JPA, создайте базу данных для хранения объектов класса Person.
//Реализуйте методы для добавления, обновления и удаления объектов Person.

package org.example.hw;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Person person = new Person("Pavel", 42);
        try (FileOutputStream fileOutputStream = new FileOutputStream("data.bin")) {

            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

                objectOutputStream.writeObject(person);
                System.out.println("Объект успешно сериализован.");

            }
        }

        try (FileInputStream fileInputStream = new FileInputStream("data.bin")) {

            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

                person = (Person)objectInputStream.readObject();
                System.out.println("Объект успешно десериализован.");

            }
        }
        System.out.println("Имя: " + person.getName());
        System.out.println("Возраст: " + person.getAge());


    }
}
