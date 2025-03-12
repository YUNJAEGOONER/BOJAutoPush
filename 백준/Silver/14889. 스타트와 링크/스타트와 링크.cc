//
// Created by Yunjae on 2025-03-12.
//
#include<iostream>
#include<vector>
using namespace std;

vector<int> peoples;
vector<vector<int>> score;
vector<int> tempvec;

int ssum = 0;
int smin = 0;

void make_team(int start, int depth) {

    if(depth == score.size()/2) {
        int tempscore1 = 0;
        int tempscore2 = 0;
        for(int i = 0 ; i < peoples.size() ; i ++) {
            for(int j = 0 ; j < peoples.size() ; j ++) {
                if(!peoples[i] && !peoples[j] && (i != j)) {
                    tempscore1 += score[i][j];
                }

                if(peoples[i] && peoples[j] && (i != j)) {
                    tempscore2 += score[i][j];
                }
            }
        }

        if(abs(tempscore2 - tempscore1) < smin) {
            smin = abs(tempscore2 - tempscore1);
        }

        return;
    }

    for(int i = start ; i < peoples.size() ; i ++ ) {
        if(peoples[i] == 0) {
            peoples[i] = 1;
            make_team(i + 1, depth + 1);
            peoples[i] = 0;
        }
    }

}

int main() {
    int n;
    cin >> n;

    for(int i = 0 ; i < n ; i ++){
        vector<int> temp;
        for(int j = 0 ; j < n ; j ++ ) {
            int e;
            cin >> e;
            temp.push_back(e);
            ssum += e;
        }
        peoples.push_back(0);
        score.push_back(temp);
    }

    smin = ssum;

    tempvec.push_back(1);
    peoples[0] = 1;
    make_team(0, 1);

    cout << smin << '\n';

    return 0;
}