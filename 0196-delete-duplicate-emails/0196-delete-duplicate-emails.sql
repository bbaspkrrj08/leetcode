DELETE FROM Person
WHERE id NOT IN (
    select id from(SELECT MIN(id) as id FROM Person GROUP BY email) as temp
);