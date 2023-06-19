--Выводим всю таблицу
SELECT * 
  FROM jaeger;

--Отображаем только не уничтоженных роботов
SELECT * 
  FROM jaeger 
 WHERE NOT status = 'Destroyed';

--Отображаем роботов нескольких серий: Mark-1 и Mark-4
SELECT * 
  FROM jaeger 
 WHERE mark IN ('Mark-1', 'Mark-4');

--Отображаем всех роботов, кроме Mark-1 и Mark-4
SELECT * 
  FROM jaeger 
 WHERE NOT mark IN ('Mark-1', 'Mark-4');

--Сортируем таблицу по убыванию по столбцу mark
SELECT * 
  FROM jaeger 
 ORDER BY mark DESC;

--Отображаем информацию о самом старом роботе
SELECT * 
  FROM jaeger 
 WHERE launch = (SELECT MIN(launch) 
                   FROM jaeger);

--Отображаем роботов, которые уничтожили больше всех kaiju
SELECT * 
  FROM jaeger 
 ORDER BY kaiju_kill DESC LIMIT 3;

--Отображаем средний вес роботов
SELECT AVG(weight) AS  average_weight
  FROM jaeger;

--Увеличиваем на единицу количество уничтоженных kaiju у роботов, которые до сих пор не разрушены
UPDATE jaeger 
   SET kaiju_kill = kaiju_kill + 1 
 WHERE NOT status = 'Destroyed';

--Удаляем уничтоженных роботов
DELETE 
  FROM jaeger 
 WHERE status = 'Destroyed';