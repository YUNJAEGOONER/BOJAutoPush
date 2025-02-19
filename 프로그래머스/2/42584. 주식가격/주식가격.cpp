#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> prices) {
    
    vector<int> answer(prices.size());
    
    //vector를 활용한 stack
    //push_back(e), pop_back()을 활용하기
    //stack에는 index가 저장됨
    vector<int> mstack;

    for(int i = 0 ; i < prices.size() ; i ++ ){
        //pop이 일어나는 경우를 고려
        //현재 주가 < 이전 주가 (즉, 가격이 떨어진 경우)
        //prices[i] : 현재 주가 - prices[mstack.back()] : 이전 주가
        
        //stack이 비어있지 않고, 현재 주가 < 이전 주가를 만족시키는 경우
        while(mstack.size() && prices[i] < prices[mstack.back()]){   
            //idx를 활용한 거리 계산 
            answer[mstack.back()] = i - mstack.back();  
            mstack.pop_back();
        }
        
        //stack의 top에는 가장 최근에 살펴보았던 index가 저장되어있음
        //즉, 바로 이전에 살펴보았던 주식 가격의 idx가 저장되어있음
        mstack.push_back(i);
    }
    
    
    while(mstack.size()){
        answer[mstack.back()] = prices.size() - mstack.back() - 1;
        mstack.pop_back();
    }
    
    return answer;
}