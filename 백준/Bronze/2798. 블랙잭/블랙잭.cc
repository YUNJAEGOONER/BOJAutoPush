#include <iostream>
#include <vector>
using namespace std;
vector<int> cards;
int black_jack;
int mins, goal;

void combination(vector<int> myvec, vector<int> my_visit){
    if(myvec.size() == 3){
        int sum = cards[myvec[0]] + cards[myvec[1]] + cards[myvec[2]];
        if(sum <= goal and mins > (goal - sum)){
            mins = goal - sum;
            black_jack = sum;
        }
        return;

    }
    else{
        for(int i = 0; i < cards.size(); i ++ ){
            if(my_visit[i] != 1){
                my_visit[i] = 1;
                myvec.push_back(i);
                combination(myvec, my_visit);
                myvec.erase(myvec.end()-1);
            }
        }
    }
}



int main(){
    int n;
    cin >> n >> goal;

    vector<int> my_visit;
    vector<int> myvec;
    mins = goal;

    while(n--){
        int card;
        cin >> card;
        cards.push_back(card);
        my_visit.push_back(0);
    }


    combination(myvec,my_visit);

    cout << black_jack;
}