#include<iostream>
#include<vector>
#include<stack>
using namespace std;

int main() {
    int n;
    cin >> n;

    vector<int> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    vector<char> result;

    stack <int> s;
    s.push(0);

    int idx = 0;
    int cur = 0;

    bool bystack = true;

    //현재 == stacktop
    while(true) {

        if(vec[idx] == s.top()) {
            result.push_back('-');
            s.pop();
            idx ++;
            if(idx == n) {
                break;
            }
        }

        //현재 > stacktop -> push
        else if(vec[idx] > s.top()) {
            result.push_back('+');
            s.push(++cur);
        }

        else if(vec[idx] < s.top()) {
            bystack = false;
            break;
        }

    }


    if(bystack) {
        for(int i = 0 ; i < result.size() - 1 ; i ++ ) {
            cout << result[i] << '\n';
        }
        cout << result[result.size() - 1];
    }
    else {
        cout << "NO";
    }
    return 0;
}