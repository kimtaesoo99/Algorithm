
SELECT HOUR(DATETIME) AS  HOUR , COUNT(ANIMAL_ID) AS COUNT 
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) >=9 AND HOUR(DATETIME) <20
GROUP BY HOUR
ORDER BY HOUR