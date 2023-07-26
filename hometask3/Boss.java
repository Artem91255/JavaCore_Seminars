package hometasks.hometask3;
/*
2. Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты в класс руководителя,
модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем, кроме руководителей.
В основной программе создайте руководителя и поместите его в общий массив сотрудников.
Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
 */
public class Boss extends Worker{

    public Boss(String fio, String jobTitle, int number, int salary, int age) {
        super(fio, jobTitle, number, salary, age);
    }
    public static void premium(Worker[] array) {
        int premia = 5000;
        for (int i = 0; i < array.length; i++) {
            if (array[i].age > 45 && array[i].jobTitle!="Руководитель") {
                array[i].salary = array[i].salary + premia;

            }
        }
    }
}
