package hometasks.hometask2;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //1 задание
        int[] array1 = {2,0,1,3,5,0,2};
        countSort(array1);
        System.out.println(Arrays.toString(array1));
        //2 задание
        System.out.println(finalText("ааа", 5, false));
        //3 задание
        int[] array = {1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(newArr(array,3)));
    }

    //Доделать сортировку подсчетом с урока (если нет, реализовать) классическим способом через промежуточный
    // массив (см. последние минут 10 семинара)
    public static void countSort(int[] array) {
        final int MAX_VALUE = 1000;

        int[] count = new int[MAX_VALUE];

        for (int i = 0; i < array.length; i++) {
            count[array[i]] = count[array[i]] + 1;
        }
        int arrayIndex = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                array[arrayIndex] = i;
                arrayIndex++;
            }
        }

    }

    //Написать метод «Шифр Цезаря», с булевым параметром зашифрования и расшифрования и числовым ключом;
    public static String finalText(String oldText, int key, boolean button) {
        String res = "";
        char[] textChar = oldText.toCharArray();
        char[] lCh = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с',
                'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        char[] upCh = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
                'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х',
                'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Ь', 'Э', 'Ю', 'Я'};
        if (button == true) {
            for (int i = 0; i < textChar.length; i++) {
                int index = 0;
                boolean isNOTLetter = Character.isWhitespace(textChar[i]);
                if (!isNOTLetter) {
                    if (Character.isLowerCase(textChar[i])) {
                        while (textChar[i] != lCh[index]) index++;
                        index += key;
                        if (index > 32) {
                            index -= 33;
                        }
                        textChar[i] = lCh[index];
                    } else if (Character.isUpperCase(textChar[i])) {
                        while (textChar[i] != upCh[index]) index++;
                        index += key;
                        if (index > 32) {
                            index -= 33;
                        }
                        textChar[i] = upCh[index];
                    }
                }
            }
        }
            else{
                for (int i = 0; i < textChar.length; i++) {
                    int index = 0;
                    boolean isNOTLetter = Character.isWhitespace(textChar[i]);
                    if (!isNOTLetter) {
                        if (Character.isLowerCase(textChar[i])) {
                            while (textChar[i] != lCh[index]) index++;
                            index -= key;
                            if (index <0) {
                                index += 33;
                            }
                            textChar[i] = lCh[index];
                        } else if (Character.isUpperCase(textChar[i])) {
                            while (textChar[i] != upCh[index]) index++;
                            index -= key;
                            if (index <0) {
                                index += 33;
                            }
                            textChar[i] = upCh[index];
                        }
                    }
                }
            }
            for (char c : textChar) {
                res += c;
            }
            return res;
        }

//    Написать метод, принимающий на вход массив чисел и параметр n.
//    Метод должен осуществить циклический (последний элемент при сдвиге становится первым) сдвиг всех элементов массива на n позиций;

    public static int[] newArr(int[] oldArray, int count)
    {
        int[] newArray = new int[oldArray.length];
        for (int i= 0; i<newArray.length; i++){
            newArray[i] = oldArray[i];
        }
        for(int i=0; i<count; i++)
        {
            int temp = newArray[newArray.length - 1];
            for(int j = newArray.length-2; j>=0; j--) {
                newArray[j+1] = newArray[j];
            }
            newArray[0] = temp;
        }
        return newArray;
    }
}

