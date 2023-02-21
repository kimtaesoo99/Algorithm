SELECT B.AUTHOR_ID,  AUTHOR_NAME, CATEGORY,SUM(PRICE * SALES) AS TOTAL_SALES
FROM BOOK B INNER JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
INNER JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
WHERE YEAR(SALES_DATE) = 2022 AND MONTH(SALES_DATE) =1
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY AUTHOR_ID, CATEGORY DESC

