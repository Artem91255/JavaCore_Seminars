package hometasks.hometask4;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Customer[] customers = new Customer[2];
        customers[0] = new Customer("Иванов Иван Иванович", 34, 1234);
        customers[1] = new Customer("Петров Петр Петрович", 50, 2233);

        Product[] products = new Product[5];
        products[0] = new Product("PS5", 500);
        products[1] = new Product("PS4", 200);
        products[2] = new Product("XBox M", 600);
        products[3] = new Product("XBox S", 400);
        products[4] = new Product("Nintendo Switch", 300);

        Order[] orders = new Order[5];

        try {
            orders[0] = buyProduct(customers, products);
            orders[1] = buyProduct(customers, products);

        }
        catch (NullPointerException e) {
            System.out.println("Работа программы завершена");
        }
        for(int i=0; i< orders.length; i++){
            if(!(orders[i] ==null)){
                System.out.printf("Клиент %s купил %s в количестве %d. \n", orders[i].customer.fio, orders[i].product.name, orders[i].quantity);
            }
        }
    }


    public static Order buyProduct(Customer[] customers, Product[] products){
        Customer tempCustomer = null;
        Product tempProduct = null;
        int countOfProduct = 0;
        boolean flag = true;
        while(flag) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Введите наименование продукта: ");
                String nameOfProduct = reader.readLine();
                for (int i = 0; i < products.length; i++) {
                    if (products[i].name.equals(nameOfProduct)) {
                        tempProduct = products[i];
                        flag = false;
                        break;
                    }
                }
                if (tempProduct == null) {
                    throw new ProductException("");
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (ProductException e) {
                System.out.println("Товар с указанным именем не найден, повторите ввод.");

            }
        }
        flag = true;
        while(flag) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Введите количество товара: ");
                String s3 = reader.readLine();
                countOfProduct = Integer.parseInt(s3);
                if (countOfProduct <= 0 || countOfProduct > 100) {
                    throw new AmountException("");
                }
                flag = false;
                break;
            }catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (AmountException e) {
                System.out.println("Введено недопустимое количество товара. Количество товара установлено по умолчанию и равно единице.");
                countOfProduct = 1;

                break;
            }
        }
        flag = true;
        while(flag) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Введите ФИО покупателя: ");
                String nameOfCustomer = reader.readLine();
                for (int i = 0; i < customers.length; i++) {
                    if (customers[i].fio.equals(nameOfCustomer)) {
                        tempCustomer = customers[i];
                        flag = false;
                    }
                }
                if (tempCustomer == null) {
                    throw new CustomerException("");
                }
            }catch (IOException e) {
                System.out.println(e.getMessage());
            } catch (CustomerException e) {
                System.out.print("Покупатель с указанным именем не найден. ");
                break;
            }
        }
        Order temp = new Order(tempCustomer,tempProduct,countOfProduct);
        return temp;
    }
}
