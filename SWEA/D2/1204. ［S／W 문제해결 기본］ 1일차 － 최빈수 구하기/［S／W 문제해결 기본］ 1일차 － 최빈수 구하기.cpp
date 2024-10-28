#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;

bool cmp(pair<int, int> &a, pair<int, int> &b){
    if(a.second==b.second) return a.first > b.first;
	return a.second > b.second;
}

int main(){
    int n;
    cin >> n;
    
    for(int i = 0 ; i < n ; i ++ ){
        int test_num;
        cin >> test_num;
        map<int, int> scores;
        for(int i = 0 ; i < 1000; i ++){
        	int score;
            cin >> score;
            scores[score] ++;
        }
        vector<pair<int, int>>vec(scores.begin(), scores.end());
        sort(vec.begin(), vec.end(), cmp);
        cout << '#' << test_num << ' '<< vec[0].first << '\n';
        
    }
}