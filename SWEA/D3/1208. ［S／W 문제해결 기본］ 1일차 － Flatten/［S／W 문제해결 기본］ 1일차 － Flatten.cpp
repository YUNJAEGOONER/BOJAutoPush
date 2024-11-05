#include<iostream>
#include<map>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    for(int t = 0 ; t < 10 ; t++) {
        int n;
        cin >> n;

        map<int, int> m;
        for(int i = 0 ; i < 100 ; i ++ ){
            int e;
            cin >> e;
            m[e] ++;
        }

        for(int i = 0 ; i < n ; i ++ ) {
            auto first = m.begin();
            auto last = --m.end();

            first->second --;
            m[(first->first) + 1]++;

            last->second --;
            m[(last->first) - 1]++;

            if(first->second == 0)m.erase(first);
            if(last->second == 0)m.erase(last);
        }

        auto last = --m.end();
        cout << "#" << t + 1 << " " << last->first - m.begin()->first << endl;
    }


    return 0;
}