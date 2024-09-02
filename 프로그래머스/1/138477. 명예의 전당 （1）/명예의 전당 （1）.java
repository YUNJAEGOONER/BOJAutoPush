import java.util.PriorityQueue;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = {};
        answer = new int[score.length];
        
        //값이 작은 원소가 우선순위를 갖는다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0 ; i < score.length ; i ++ ){
            pq.add(score[i]); //우선순위 큐에 새로운 원소를 추가
            
            //명예의 전당에 들어가지 못하는(k를 넘어가는 경우) 원소 제거
            if(pq.size() > k){ 
                pq.poll();  
            }
            
            //명예의 전당의 점수 중 가장 작은 원소 가져오기
            answer[i] = pq.peek();
        }
    
        return answer;
    }
}