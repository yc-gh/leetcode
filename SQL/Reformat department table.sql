//https://leetcode.com/problems/reformat-department-table/

//Group By
SELECT 
    id, 
    MAX(CASE WHEN month = 'Jan' THEN revenue ELSE null END) AS Jan_Revenue,
    MAX(CASE WHEN month = 'Feb' THEN revenue ELSE null END) AS Feb_Revenue,
    MAX(CASE WHEN month = 'Mar' THEN revenue ELSE null END) AS Mar_Revenue,
    MAX(CASE WHEN month = 'Apr' THEN revenue ELSE null END) AS Apr_Revenue,
    MAX(CASE WHEN month = 'May' THEN revenue ELSE null END) AS May_Revenue,
    MAX(CASE WHEN month = 'Jun' THEN revenue ELSE null END) AS Jun_Revenue,
    MAX(CASE WHEN month = 'Jul' THEN revenue ELSE null END) AS Jul_Revenue,
    MAX(CASE WHEN month = 'Aug' THEN revenue ELSE null END) AS Aug_Revenue,
    MAX(CASE WHEN month = 'Sep' THEN revenue ELSE null END) AS Sep_Revenue,
    MAX(CASE WHEN month = 'Oct' THEN revenue ELSE null END) AS Oct_Revenue,
    MAX(CASE WHEN month = 'Nov' THEN revenue ELSE null END) AS Nov_Revenue,
    MAX(CASE WHEN month = 'Dec' THEN revenue ELSE null END) AS Dec_Revenue
FROM Department
GROUP BY id

//Pivot Table
SELECT 
    id,
    Jan AS Jan_Revenue,
    Feb AS Feb_Revenue, 
    Mar AS Mar_Revenue, 
    Apr AS Apr_Revenue,
    May AS May_Revenue,
    Jun AS Jun_Revenue,
    Jul AS Jul_Revenue,
    Aug AS Aug_Revenue,
    Sep AS Sep_Revenue,
    Oct AS Oct_Revenue,
    Nov AS Nov_Revenue,
    Dec AS Dec_Revenue
FROM Department
PIVOT 
(
    MAX(revenue)
    FOR month IN (Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec)        
) AS MonthsRevenue
