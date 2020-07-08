-- https://leetcode.com/problems/swap-salary
-- 627. Swap Salary
-- https://www.jianshu.com/p/b20231636ab4
-- 给定一个 salary 表，如下所示，有 m = 男性 和 f = 女性 的值。
-- 交换所有的 f 和 m 值（例如，将所有 f 值更改为 m，反之亦然）。要求只使用一个更新（Update）语句，并且没有中间的临时表。
-- 注意，您必只能写一个 Update 语句，请不要编写任何 Select 语句。

-- https://blog.csdn.net/lanzhihui_10086/article/details/80786721

UPDATE salary SET sex = IF(sex='m','f','m');


UPDATE salary SET sex=(
CASE sex
    WHEN 'm' THEN 'f'
    ELSE 'm'
END
);