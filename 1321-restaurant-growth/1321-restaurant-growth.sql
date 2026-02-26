select visited_on,
    (
        select sum(amount)
        from customer
        where visited_on between DATE_SUB(c.visited_on, interval 6 day) and c.visited_on
    ) as amount,
    ROUND(
        (
            select sum(amount) / 7
            from customer
            where visited_on between DATE_SUB(c.visited_on, interval 6 day) and c.visited_on
        ),
        2
    ) as average_amount
from customer c
where visited_on >= (
        select DATE_ADD(MIN(visited_on), interval 6 day)
        from customer
    )
group by visited_on;