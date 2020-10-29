//https://leetcode.com/problems/employees-earning-more-than-their-managers/

SELECT 
    E1.NAME AS 'Employee'
FROM 
    EMPLOYEE E1
INNER JOIN EMPLOYEE E2 
    ON E1.MANAGERID = E2.ID
    AND E1.SALARY > E2.SALARY
;
