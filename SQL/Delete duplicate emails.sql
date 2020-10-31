//https://leetcode.com/problems/delete-duplicate-emails/

DELETE P1
FROM
    PERSON P1, PERSON P2
WHERE
    P1.EMAIL = P2.EMAIL
    AND
        P1.ID > P2.ID;
