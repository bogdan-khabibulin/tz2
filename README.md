<h1 align="center"> ТЗ2 </h1>
<hr>

![auto_tests](https://github.com/bogdan-khabibulin/tz2/actions/workflows/auto_tests.yml/badge.svg)
![manual_tests](https://github.com/bogdan-khabibulin/tz2/actions/workflows/manual_tests.yml/badge.svg)
<hr>
        <p> Файл 'input.txt' располагается в директории src. </p>
        <p> Целые числа в файле записаны в одной строке, друг от друга отделены пробелами. 
            В файле есть минимум одно число. Максимально возможное количество чисел в файле - 1 млн. </p>

1. `_min` - функция принимает на вход файл, содержащий массив целых чисел и возвращает один элемент целое число - минмиальное значение этого массива
2. `_max` - функция принимает на вход файл, содержащий массив целых чисел и возвращает один элемент целое число -  максимальное значение этого массива
3. `_sum` - функция принимает на вход файл, содержащий массив целых чисел и возвращает один элемент целое число -  сумму всех элементов этого массива 
4. `_mult` - функция принимает на вход файл, содержащий массив целых чисел и возвращает один элемент целое число -  произведение всех элементов этого массива

<p>MainTest.java - тесты</p>
<p>NumberProcessorTest.java - построение графика времени работы программы от кол-ва чисел во входном файле</p>

<p>Github Actions - CI система. Программа проходит тесты при каждом push, есть возможность
ручного запуска тестов. Результат каждого теста отправляется в телеграмм чат.</p>

![](image.jpg)
