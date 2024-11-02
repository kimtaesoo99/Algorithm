-- 코드를 작성해주세요
select e.EMP_NO, em.EMP_NAME, e.GRADE,
case
when e.GRADE = 'S' then em.SAL * 0.2
when e.GRADE = 'A' then em.SAL * 0.15
when e.GRADE = 'B' then em.SAL * 0.1
else 0
end as BONUS
from
(select EMP_NO,
case 
when AVG(SCORE) >= 96 then 'S'
when AVG(SCORE) >= 90 then 'A'
when AVG(SCORE) >= 80 then 'B'
else 'C'
end as GRADE
from HR_GRADE
group by EMP_NO) e
join HR_EMPLOYEES em on e.EMP_NO = em.EMP_NO
order by e.EMP_NO
