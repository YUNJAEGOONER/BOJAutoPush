-- 코드를 작성해주세요
SELECT COUNT(*) AS 'COUNT'
FROM ECOLI_DATA
WHERE ((GENOTYPE & (1 << 2)) = (1 << 2) OR (GENOTYPE & 1) = 1) 
    AND (GENOTYPE & (1 << 1)) = 0;