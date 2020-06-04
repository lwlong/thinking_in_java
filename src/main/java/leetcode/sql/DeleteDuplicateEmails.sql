/*
https://leetcode.com/problems/delete-duplicate-emails/
196. Delete Duplicate Emails
+----+------------------+
| Id | Email            |
+----+------------------+
| 1  | john@example.com |
| 2  | bob@example.com  |
| 3  | john@example.com |
+----+------------------+
*/
DELETE p1 FROM Person p1,
    Person p2
WHERE
    p1.Email = p2.Email AND p1.Id > p2.Id;


DELETE FROM Person WHERE Id NOT IN
(SELECT * FROM(
    SELECT MIN(Id) FROM Person GROUP BY Email) as p);



