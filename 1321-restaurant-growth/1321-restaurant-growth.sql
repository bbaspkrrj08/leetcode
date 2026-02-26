SELECT c1.visited_on,
       SUM(c2.amount) AS amount,
       ROUND(SUM(c2.amount) / 7, 2) AS average_amount
FROM customer c1
JOIN customer c2
  ON c2.visited_on BETWEEN DATE_SUB(c1.visited_on, INTERVAL 6 DAY)
                       AND c1.visited_on
GROUP BY c1.visited_on
HAVING c1.visited_on >= (
    SELECT DATE_ADD(MIN(visited_on), INTERVAL 6 DAY)
    FROM customer
)
ORDER BY c1.visited_on;