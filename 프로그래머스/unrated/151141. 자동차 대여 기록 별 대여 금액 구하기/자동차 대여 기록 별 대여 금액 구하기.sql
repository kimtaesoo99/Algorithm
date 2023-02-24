
SELECT HISTORY_ID, ROUND(DAILY_FEE * (DATEDIFF(END_DATE,START_DATE)+1) *
CASE WHEN  DATEDIFF(END_DATE,START_DATE)+1 < 7 THEN 1
WHEN  DATEDIFF(END_DATE,START_DATE)+1 < 30 THEN 0.95
WHEN  DATEDIFF(END_DATE,START_DATE)+1 < 90 THEN 0.92
ELSE 0.85 END) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
INNER JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
ON C.CAR_ID = H.CAR_ID
WHERE CAR_TYPE = '트럭'
GROUP BY HISTORY_ID
ORDER BY FEE DESC,HISTORY_ID DESC