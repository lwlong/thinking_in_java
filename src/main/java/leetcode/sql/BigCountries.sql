-- https://leetcode.com/problems/big-countries/
-- 595. Big Countries
-- https://blog.csdn.net/lanzhihui_10086/article/details/80786721

SELECT name, population, area FROM World WHERE area > 3000000 OR population > 25000000;
