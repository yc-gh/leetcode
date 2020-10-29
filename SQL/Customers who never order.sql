//https://leetcode.com/problems/customers-who-never-order/

SELECT 
    NAME AS 'Customers'
FROM 
    CUSTOMERS
WHERE 
    CUSTOMERS.ID 
NOT IN (
    SELECT 
        CUSTOMERID
    FROM ORDERS
);
