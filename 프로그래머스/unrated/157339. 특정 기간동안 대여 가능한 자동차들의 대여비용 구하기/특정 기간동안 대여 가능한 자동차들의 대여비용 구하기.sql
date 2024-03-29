
SELECT CAR_ID, C.CAR_TYPE,ROUND(30*DAILY_FEE/100*(100-DISCOUNT_RATE)) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C 
INNER JOIN (SELECT CAR_TYPE, DISCOUNT_RATE FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN
           WHERE DURATION_TYPE = '30일 이상') P
ON C.CAR_TYPE = P.CAR_TYPE
WHERE C.CAR_TYPE IN('SUV','세단')
AND CAR_ID NOT IN (SELECT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                  WHERE START_DATE <='2022-11-30' AND END_DATE >='2022-11-01'
                  GROUP BY CAR_ID)
HAVING FEE>=500000 AND FEE<2000000
ORDER BY FEE DESC,CAR_TYPE,CAR_ID DESC