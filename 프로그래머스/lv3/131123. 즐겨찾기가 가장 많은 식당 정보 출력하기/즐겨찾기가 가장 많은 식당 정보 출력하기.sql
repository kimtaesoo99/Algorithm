
SELECT I.FOOD_TYPE, I.REST_ID,I.REST_NAME, I.FAVORITES
FROM REST_INFO I INNER JOIN (SELECT MAX(FAVORITES) AS FAVORITES, FOOD_TYPE FROM 
                          REST_INFO GROUP BY FOOD_TYPE) S
ON I.FOOD_TYPE = S.FOOD_TYPE
WHERE I.FAVORITES = S.FAVORITES
ORDER BY FOOD_TYPE DESC
