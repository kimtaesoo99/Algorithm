
SELECT PRODUCT_CODE, SUM(PRICE*SALES_AMOUNT) AS SALES
FROM PRODUCT P INNER JOIN OFFLINE_SALE S
ON P.PRODUCT_ID = S.PRODUCT_ID
GROUP BY P.PRODUCT_ID
ORDER BY SALES DESC, PRODUCT_CODE
