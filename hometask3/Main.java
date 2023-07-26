package hometasks.hometask3;

public class Main {
    public static void main(String[] args) {

        //– Создать массив из 5 сотрудников
        Worker[] array = new Worker[6];
        array[0] = new Worker("Иванов Иван Иванович", "Кладовщик", 3322, 25000, 50);
        array[1] = new Worker("Петров Петр Петрович", "Токарь", 3545, 35000, 44);
        array[2] = new Worker("Сидорова Виктория Сергеевна", "Бухгалтер", 1234, 30000, 25);
        array[3] = new Worker("Кузнецова Елена Викторовна", "Кузнец", 6554, 50000, 35);
        array[4] = new Worker("Самсонов Петр Львович", "Охранник", 9008, 35000, 55);
        array[5] = new Worker("Бугров Босс Боссович", "Руководитель", 0001, 100000, 50);
        //printInfo(array[0].fio, array[0].jobTitle, array[0].number, array[0].salary, array[0].age);
//        int premia = 5000;
//        System.out.println(array[0].salary);
//        for(int i = 0; i<array.length; i++){
//            array[i].salary = premium(array[i].salary, array[i].age, premia);
//            System.out.println(array[i].salary);
//        }

        //Worker.premium(array);
        Boss.premium(array);
        for(int i = 0; i<array.length; i++){
        System.out.printf("Зарплата работника с именем %s составляет %d рублей %n", array[i].fio, array[i].salary);}

        System.out.println("Средний возраст "+averageAge(array));
        System.out.println("Средняя зарплата "+averageSalary(array));

    }
    //– Написать метод выводящую всю доступную информацию об объекте с использованием форматирования строк.
    public static void printInfo(String fio, String jobTitle, int number, int salary, int age){
        System.out.printf("Работник: %s, Должность: %s, Внутренник номер:  %d, Зарплата: %d, Возраст: %d", fio, jobTitle, number, salary, age);
    }
    //– Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000. Возраст и размер повышения должны быть параметрами метода.
    public static int premium(int salary, int age, int prem){
        if(age>45){
            salary += prem;
            return salary;
        }
        return salary;

    }
//– Написать методы (принимающие на вход массив сотрудников),
// вычисляющие средний возраст и среднюю зарплату сотрудников, вывести результаты работы в консоль.
    public static int averageAge(Worker[] array){
        int avgAge = 0;
        for (int i = 0; i < array.length; i++) {
            avgAge = avgAge+array[i].age;
            }
        avgAge = avgAge/ array.length;
        return avgAge;
    }
    public static int averageSalary(Worker[] array){
        int avgSalary = 0;
        for (int i = 0; i < array.length; i++) {
            avgSalary = avgSalary+array[i].salary;
        }
        avgSalary = avgSalary/ array.length;
        return avgSalary;
    }


}
