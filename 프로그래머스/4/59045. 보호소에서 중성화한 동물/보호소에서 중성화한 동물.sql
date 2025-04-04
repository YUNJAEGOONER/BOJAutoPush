-- 코드를 입력하세요
SELECT T1.ANIMAL_ID, T1.ANIMAL_TYPE, T1.NAME
FROM ANIMAL_INS T1, ANIMAL_OUTS T2
WHERE T1.ANIMAL_ID = T2.ANIMAL_ID
    AND T1.SEX_UPON_INTAKE LIKE '%Intact%'
    AND (T2.SEX_UPON_OUTCOME LIKE '%Spayed%' OR T2.SEX_UPON_OUTCOME LIKE '%Neutered%')