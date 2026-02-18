# Write your MySQL query statement below
select employee_id, IF(employee_id % 2 = 0 || name like 'm%',0,salary) as bonus
from employees
order by employee_id

 

