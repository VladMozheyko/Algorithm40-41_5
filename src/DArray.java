public class DArray {

    private long[] theArray;  // Декларируем массив, с которым будем работать
    private int nElems;       // Декларируем счетчик элементов(указатель на текущий элемент массива)

    public DArray(int max) {            // Конструктор
        theArray = new long[max];    // Инициализируем(присваиваем) значения
        nElems = 0;
    }

    public void insert(long value){    // Создаем метод для добавления элемента в массив
        theArray[nElems] = value;      // Добавляем элемент в текущую позицию
        nElems++;                      // Увеличиваем счетчик позиции на 1, чтобы учесть добавленный элемент
    }

    public void display(){                       // Выводим массив на консоль
        for (int i = 0; i < nElems; i++) {         // Проходим по всему инициализированному массиву, переменная nElems служит счетчиком добавленых элементов,
                                                   // используем ее, чтобы не выводить все элементы, на которые выделена память
            System.out.print(theArray[i] + " ");    // Выводим элемент массива в строку и пробел
        }
        System.out.println();  // Переходим на новую строку после вывода массива, чтобы следующий вывод не совпал с массивом
    }

    public void mergeSort(){          // Метод для запуска сортировки слиянием
        long[] workSpace = new long[nElems];   // Создаем подмассив для сортировки
        recMergeSort(workSpace, 0, nElems-1);  // Создаем метод для рекурсивной сортировки, передаем в него подмасив, начальный и конечный индекс подмассива
    }

    private void recMergeSort(long[] workSpace, int lowerBound, int upperBound) {    // Метод для рекурсивной сортировки слиянием
          if(lowerBound == upperBound) {  // Если верхний и нижний индекс равны, выходим из метода
              return;
          }
          else {                          // В противном случае делаем массив пополам и вызываем метод снова.
              int mid = (lowerBound + upperBound)/2;// Само деление

              recMergeSort(workSpace, lowerBound, mid);   // Вызов рекурсии для текущего метода(на нашей картинке это разбиение)
              recMergeSort(workSpace, mid+1, upperBound);

              merge(workSpace, lowerBound, mid+1, upperBound);       // Объединяем массивы
          }

    }

    private void merge(long[] workSpace, int lowPtr, int highPtr, int upperBound){      // Метод для сортировки. Само объединение подмассивов
          int j = 0;                 // Индекс для вставки элементов
          int lowerBound = lowPtr;   // Присваиваем индекс для первого подмассива
          int mid = highPtr -1;      // Определяем индекс середины
          int n = upperBound-lowerBound+1;  // Присваиваем индекс для второго подмассива

        // Условие завершение цикла: оба подмассива дошли до своего конца
          while (lowPtr <= mid && highPtr <= upperBound){     // Главный цикл сортировки. Выполняем сортиовку подмассивов
                                                              // и встваляет отсортированный массив в конечный массив theArray
              if(theArray[lowPtr] < theArray[highPtr]) {
                  workSpace[j++] = theArray[lowPtr++];
              }
              else
              {
                  workSpace[j++] = theArray[highPtr++];
              }
              while (lowPtr <= mid ){
                  workSpace[j++] = theArray[lowPtr++];
              }

              while (highPtr <= upperBound){
                  workSpace[j++] = theArray[highPtr++];
              }

              for (int i = 0; i < n; i++) {
                 theArray[lowerBound + i] = workSpace[i];
              }
          }
    }


}
