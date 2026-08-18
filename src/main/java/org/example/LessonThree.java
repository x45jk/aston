package org.example;

public class LessonThree {
    public static void main(String[] args) {
        System.out.println("===== Домашнее задание к Лекции 2.4 =====");

        // I-е задание
        System.out.println("--- Задание №1 ---");
        System.out.println("[Созданы классы Dog и Cat с наследованием от класса Animal]");

        Dog dogBobik = new Dog("Бобик");
        Cat catMurka = new Cat("Мурка");

        /*System.out.println("\n[Проверка пробежки собак]");
        dogBobik.run(-1);
        dogBobik.run(0);
        dogBobik.run(1);
        dogBobik.run(499);
        dogBobik.run(500);
        dogBobik.run(501);

        System.out.println("\n[Проверка заплыва собак]");
        dogBobik.swim(-1);
        dogBobik.swim(0);
        dogBobik.swim(1);
        dogBobik.swim(9);
        dogBobik.swim(10);
        dogBobik.swim(11);

        System.out.println("\n[Проверка пробежки кошек]");
        catMurka.run(-1);
        catMurka.run(0);
        catMurka.run(1);
        catMurka.run(199);
        catMurka.run(200);
        catMurka.run(201);

        System.out.println("\n[Проверка заплыва кошек]");
        catMurka.swim();
        catMurka.swim(1);*/

        System.out.println("\n[Добавлен подсчет количества созданных котов, собак и животных]");
        System.out.println("Общее количество животных: " + dogBobik.getNumberOfAnimals());
        System.out.println("Общее количество собак:    " + dogBobik.getNumberOfDogs());
        System.out.println("Общее количество кошек:    " + catMurka.getNumberOfCats());

        System.out.println("\n[Добавлена миска и взаимодействие с ним]");
/*        Bowl bowl15 = new Bowl(15);
        Cat catBarsik = new Cat("Барсик");
        catBarsik.eat(10, bowl15);
        bowl15.addFood(5);
        catBarsik.eat(10, bowl15);
        bowl15.addFood(5);
        catBarsik.eat(10, bowl15);
        bowl15.addFood(5);*/

        System.out.println("\n[Создан массив котов и одна миска с едой]");
        Cat[] catsArray = new Cat[5];
        catsArray[0] = new Cat("Черныш");
        catsArray[1] = new Cat("Матроскин");
        catsArray[2] = new Cat("Хвостик");
        catsArray[3] = new Cat("Царапка");
        catsArray[4] = new Cat("Беляш");
        Bowl bowl30 = new Bowl(40);
        bowl30.addFood(35);
        catsArray[0].eat(7, bowl30);
        catsArray[1].eat(15, bowl30);
        catsArray[2].eat(3, bowl30);
        catsArray[3].eat(11, bowl30);
        catsArray[4].eat(20, bowl30);
        bowl30.addFood(30);
        catsArray[3].eat(15, bowl30);
        catsArray[4].eat(25, bowl30);

        System.out.println("\nОбщее количество животных: " + dogBobik.getNumberOfAnimals());
        System.out.println("Общее количество собак:    " + dogBobik.getNumberOfDogs());
        System.out.println("Общее количество кошек:    " + catMurka.getNumberOfCats());
    }
}