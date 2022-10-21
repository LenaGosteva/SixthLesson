import java.util.Scanner;

/*Ваша задача - реализовать массив для хранение элементов boolean максимально выгодным по памяти образом:
Необходимо создать массив байтов(byte[]) и логические переменные хранить в соответствующем бите
т.е. массив из 2 байтов соответсвует массиву из 16 boolean

При решении задачи стоит воспользоваться бинарными операциями:
| - для установки значения в соответствующий бит
& - для получения значения в соответствующем бите
<< - для установки необходимого значения в нужный по счету бит
К примеру, чтобы проверить, что в 5 бите переменной b лежит 1 можно следующим образом: b & (1 << 5) != 0

В результате ваша программа должна раотать как обычный массив boolean

Входные данные:
Сначала вводится число n - количество элементов массива
Далее n true или false - элементы массива

Выходные данные вывести полученный массив*/
public class BytesBool {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int size = in.nextInt(), n = size, k;
        if (size % 8 != 0) {
            size += 8 - size % 8;

        }
        k = size/8;
        byte[] bool = new byte[k];
        for (int i = 0; i < k; ++i) {
            boolean x;
            if (i<k-1){
                for (int j = 0; j < 8; j++) {
                    x = in.nextBoolean();
                    bool[i] = (byte)(bool[i] | ((x ? 1 : 0) << j));
                }
            }
            else{
                for (int j = 0; j < n%8; j++) {
                    x = in.nextBoolean();
                    bool[i] = (byte)(bool[i] | ((x ? 1 : 0) << j));
                }
            }

        }
        for (int i = 0; i < k; ++i) {
            if (i == k - 1){
                for (int j = 0; j < n%8; j++) {
                    if ((bool[i] & (1 << j)) != 0) {
                        System.out.print(true + " ");
                    } else {
                        System.out.print(false + " ");
                    }
                }
            }
            else{
            for (int j = 0; j < 8; j++) {
                if ((bool[i] & (1 << j)) != 0) {
                    System.out.print(true + " ");
                } else {
                    System.out.print(false + " ");
                }
            }
        }}
    }
}
