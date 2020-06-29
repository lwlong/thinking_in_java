-- https://leetcode.com/problems/duplicate-emails/
-- 182. Duplicate Emails
-- https://www.jianshu.com/p/b20231636ab4
--+----+---------+
--| Id | Email   |
--+----+---------+
--| 1  | a@b.com |
--| 2  | c@d.com |
--| 3  | a@b.com |
--+----+---------+

Select Distinct Email From Person
Where Email In
(Select Email From Person
Group By Email Having Count(*)>1);


Select Email From Person Group By Email Having Count(*)>1;


select Email from
(
  select Email, count(Email) as num
  from Person
  group by Email
) as statistic
where num > 1;


