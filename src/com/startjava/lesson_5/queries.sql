\echo --Выводим всю таблицу
SELECT * 
  FROM jaeger;

\echo --Отображаем только не уничтоженных роботов
SELECT * 
  FROM jaeger 
 WHERE status != 'Destroyed';

\echo --Отображаем роботов нескольких серий: Mark-1 и Mark-4
SELECT * 
  FROM jaeger 
 WHERE mark IN ('Mark-1', 'Mark-4');

\echo --Отображаем всех роботов, кроме Mark-1 и Mark-4
SELECT * 
  FROM jaeger 
 WHERE mark NOT IN ('Mark-1', 'Mark-4');

\echo --Сортируем таблицу по убыванию по столбцу mark
SELECT * 
  FROM jaeger 
 ORDER BY mark DESC;

\echo --Отображаем информацию о самом старом роботе
SELECT * 
  FROM jaeger 
 WHERE launch = (SELECT MIN(launch) 
                   FROM jaeger);

\echo --Отображаем роботов, которые уничтожили больше всех kaiju
SELECT * 
  FROM jaeger 
 ORDER BY kaiju_kill DESC LIMIT 3;

\echo --Отображаем средний вес роботов
SELECT AVG(weight) AS average_weight
  FROM jaeger;

\echo --Увеличиваем на единицу количество уничтоженных kaiju у роботов, которые до сих пор не разрушены
UPDATE jaeger 
   SET kaiju_kill = kaiju_kill + 1 
 WHERE status != 'Destroyed';

\echo --Удаляем уничтоженных роботов
DELETE 
  FROM jaeger 
 WHERE status = 'Destroyed';