\echo --������� ��� �������
SELECT * 
  FROM jaeger;

\echo --���������� ������ �� ������������ �������
SELECT * 
  FROM jaeger 
 WHERE status != 'Destroyed';

\echo --���������� ������� ���������� �����: Mark-1 � Mark-4
SELECT * 
  FROM jaeger 
 WHERE mark IN ('Mark-1', 'Mark-4');

\echo --���������� ���� �������, ����� Mark-1 � Mark-4
SELECT * 
  FROM jaeger 
 WHERE mark NOT IN ('Mark-1', 'Mark-4');

\echo --��������� ������� �� �������� �� ������� mark
SELECT * 
  FROM jaeger 
 ORDER BY mark DESC;

\echo --���������� ���������� � ����� ������ ������
SELECT * 
  FROM jaeger 
 WHERE launch = (SELECT MIN(launch) 
                   FROM jaeger);

\echo --���������� �������, ������� ���������� ������ ���� kaiju
SELECT * 
  FROM jaeger 
 ORDER BY kaiju_kill DESC LIMIT 3;

\echo --���������� ������� ��� �������
SELECT AVG(weight) AS average_weight
  FROM jaeger;

\echo --����������� �� ������� ���������� ������������ kaiju � �������, ������� �� ��� ��� �� ���������
UPDATE jaeger 
   SET kaiju_kill = kaiju_kill + 1 
 WHERE status != 'Destroyed';

\echo --������� ������������ �������
DELETE 
  FROM jaeger 
 WHERE status = 'Destroyed';