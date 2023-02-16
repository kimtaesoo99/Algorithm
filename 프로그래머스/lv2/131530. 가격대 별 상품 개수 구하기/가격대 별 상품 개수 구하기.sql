SELECT DISTINCT FLOOR(price/10000)*10000 AS PRICE_GROUP
, COUNT(PRODUCT_ID) AS PRODUCTS
FROM PRODUCT
GROUP BY FLOOR(price/10000)
ORDER BY FLOOR(price/10000)

