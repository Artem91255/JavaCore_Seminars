package hometasks.hometask3;
//– Создать класс ”Сотрудник”с полями: ФИО, должность, телефон, зарплата, возраст;
public class Worker {
    String fio;
    String jobTitle;
    int number;
    int salary;
    int age;


    public Worker(String fio, String jobTitle, int number, int salary, int age) {
        this.fio = fio;
        this.jobTitle = jobTitle;
        this.number = number;
        this.salary = salary;
        this.age = age;
    }


    //– Написать тот же метод повышения в качестве статического в классе сотрудника. Метод должен принимать в качестве параметра массив сотрудников.
//    public static void premium(Worker[] array) {
//        int premia = 5000;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i].age > 45) {
//                array[i].salary = array[i].salary + premia;
//
//            }
//        }
//    }
}
