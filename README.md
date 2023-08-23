# Программа сортировки слиянием файлов
> Программа написана по тестовому заданию для курса JAVA от "ЦФТ ШИФТ"
> 
> Автор программы: Элерт Андрей  
> Электронная почта: revenant@211.ru

## Используемое ПО
* Операционная система
  * Ubuntu 22.04.2 LTS
* Версия Java
  * openjdk version "11.0.20"
* Версия сборщика
  * Apache Maven 3.6.3
* Тестирование
  * JUnit 5
* Дополнительные библиотеки
  * Apache Maven JAR Plugin v.3.3.0
  * Apache Commons IO v.2.13
  * The Up To Date Maven Plugin v.0.2.0

Зависимости для всех используемых в проекте библиотек указаны в файле pom.xml.

## Инструкция по запуску

В терминале Linux программа запускается в следующем формате:
```
java -jar TestSort-1.0-SNAPSHOT.jar <Тип Данных> [Направление сортировки] <Выходной файл> <Исходный файл 1> [Исходный файл 2] ...
```
* __java -jar__ - обязательные команды для запуска программы на Java-машине.
* __TestSort-1.0-SNAPSHOT.jar__ - название файла программы по умолчанию, можно переименовать на любое другое.
* __<Тип данных>__ - обязательный параметр, может принимать следующие значения:
  * __-i__ - сортировка целых чисел;
  * __-s__ - сортировка строк. Если заданы оба параметра, то -s имеет приоритет.
* __[Направление сортировки]__ - необязательный параметр, может принимать следующие значения:
  * __-a__ - сортировка по возрастанию, используется по умолчанию, имеет приоритет;
  * __-d__ - сортировка по убыванию.
* __<Выходной файл>__ - обязательный параметр, имя файла в формате "имя.txt", в который сохраняется итоговый отсортированный список. Обратите внимание, что если файл с указанным именем уже существует - он будет удалён и заменён новым с выводом соответствующего информационного сообщения в консоль.
* __<Исходный файл 1>__ - обязательный параметр, имя файла в формате "имя.txt", из которого будут браться данные для сортировки.
* __[Исходный файл 2]__ - необязательный параметр, имя дополнительного файла в формате "имя.txt", из которого будут браться данные для сортировки. Можно задать любое количество дополнительных исходных файлов.

## Особенности реализации

* В командной строке можно задавать параметры выполнения программы в любой последовательности, за исключением выходного файла - за имя выходного файла берётся первое имя файла из последовательности параметров.
* Допускается дублирование параметров, при исполнении дубликаты автоматически удаляются, благодаря сохранению в коллекции LinkedHashSet.
* Должен быть задан как минимум один входной файл, иначе выполнение программы прерывается.
* Если программа не может найти один или несколько входных файлов, эти файлы из обработки исключаются, при этом в консоль выводится сообщение об отсутствующих файлах.
* Программа завершится корректно, даже если не найдёт ни одного исходного файла. При этом результатом работы будет пустой файл с заданным именем.
* Если в командной строке пропустить один из обязательных параметров - программа прервёт своё выполнение с уведомлением в консоли.
* Если в исходных файлах будет нарушен заданный порядок - часть данных будет утеряна в выходном файле. При этом в консоли отобразится уведомление о количестве утерянных элементов.
* Если в режиме сортировки строк будут попадаться строки с пробелами - они так же не попадут в выходной файл. При этом такие строки так же учитываются в счётчике утерянных элементов.
* Сборка осуществляется стандартной командой Maven:
```
mvn package
```
* в директории testFiles находятся файлы, используемые для автотестов: начинающиеся на in* - для симуляции входных данных, начинающиеся на outTest* - ожидаемый результат (Expect) для сравнения.
---
09.08.23