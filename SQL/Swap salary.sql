//https://leetcode.com/problems/swap-salary/

UPDATE 
    SALARY
SET 
    SEX = CASE 
            WHEN SEX = 'm' THEN 'f' ELSE 'm' END;
