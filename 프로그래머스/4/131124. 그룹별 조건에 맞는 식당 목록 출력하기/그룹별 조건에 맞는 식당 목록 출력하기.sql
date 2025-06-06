-- 코드를 입력하세요

# SELECT T1.MEMBER_NAME, T2.REVIEW_TEXT, DATE_FORMAT(T2.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
# FROM MEMBER_PROFILE AS T1, REST_REVIEW AS T2
# WHERE T1.MEMBER_ID = T2.MEMBER_ID
#     AND T1.MEMBER_ID IN(
#         SELECT t1.MEMBER_ID
#         FROM MEMBER_PROFILE AS t1, REST_REVIEW AS t2
#         WHERE t1.MEMBER_ID = t2.MEMBER_ID
#         GROUP BY T1.MEMBER_ID
#         HAVING COUNT(*) = (SELECT COUNT(*) AS CNT
#                             FROM REST_REVIEW AS R1
#                            GROUP BY R1.MEMBER_ID
#                             ORDER BY CNT DESC
#                             LIMIT 1)
#     )
# ORDER BY T2.REVIEW_DATE ASC, T2.REVIEW_TEXT ASC

SELECT T1.MEMBER_NAME, T2.REVIEW_TEXT, DATE_FORMAT(T2.REVIEW_DATE, '%Y-%m-%d') AS REVIEW_DATE
FROM MEMBER_PROFILE AS T1, REST_REVIEW AS T2
WHERE T1.MEMBER_ID = T2.MEMBER_ID
    AND T1.MEMBER_ID = (SELECT R1.MEMBER_ID
                        FROM REST_REVIEW AS R1
                        GROUP BY R1.MEMBER_ID
                        ORDER BY COUNT(*) DESC
                        LIMIT 1)
ORDER BY T2.REVIEW_DATE ASC, T2.REVIEW_TEXT ASC