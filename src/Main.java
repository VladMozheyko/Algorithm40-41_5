import java.util.ArrayList;

public class Main {

    /*
    Теория

    Сортировка - один из основных алгоритмов используемых в информатике, кроме назначения по упорядочиванию данных для
    пользователя, она широка применяется как вспомогательный метод при решении задач, например, бинарный поиск

    У каждого алгоритма имеется сложность - количество шагов за которые может быть выполнен алгоритм

    Сортировка слиянием - разбивает массив на подмассивы затем, когда каждый подмассив отсортирован, они объединяются
    в остортированный подмассив, пока не будет получен конечный отсортированый массив, сложность данного алгоритма
    линейно-логарифмическая - O(n*log n). Данный алгоритм подразумевает дополнительные затраты памяти


     */

    /*
    Заметки
    Методы(подпрограмма) могут быть двух видов: void и типизированный
    void - процедура, такой метод ничего не возвращает
    типизированный метод должен вернуть значение этого типа
    Также следует упомянуть об особом виде методов - конструкторе, которые создаю объект класса
     */

    /*
    Задача
    Реализовать алгоритм сортировки слиянием(делать будем по книге Роберта Лафоре "Структуры данных и алгоритмы java"
    стр. 270. Ссылка на книгу в чате
    Пояснение из листинга 6.6 на стр. 275 мы переименуем класс MergeSortApp в Main
     */

    public static void main(String[] args) {
   //     long[] arr = new long[200000000];     Вышли за размеры кучи, т.е программа не будет работать, т.к. ей не
        //     хватит памяти. Первое замечание про необходимость экономии памяти. Второе замечание чрезмерный расход памяти
        // может серьезно замедлить работу приложения
//        ArrayList<Integer> integers = new ArrayList<>(); класс DArray аналог класса ArrayList. Делаем методы, которые обеспечат нас таким эе функционалом
//        integers.add(1);

        DArray array = new DArray(10);
        array.insert(5);

        array.insert(10);
        array.insert(4);
        array.insert(3);
        array.insert(18);
        array.insert(7);





        System.out.println("Массив до сортировки: ");
        array.display();

        array.mergeSort();
        System.out.println("Массив после сортировки: ");
        array.display();





    }
}