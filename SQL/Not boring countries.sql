//https://leetcode.com/problems/not-boring-movies/

SELECT 
    *
FROM 
    CINEMA
WHERE
    DESCRIPTION NOT LIKE '%boring%'
    AND ID % 2 = 1
ORDER BY
    RATING DESC;
