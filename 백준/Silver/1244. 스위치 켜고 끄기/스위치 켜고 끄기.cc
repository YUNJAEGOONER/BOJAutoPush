#include <iostream>
#include <vector>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> vec;
    for(int i = 0 ; i < n ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    int p;
    cin >> p;
    while(p--) {
        int sex, num;
        cin >> sex >> num;
        if(sex == 1){
            int m = 1;
            while((m * num - 1) < vec.size()) {
                if(vec[m * num - 1]) vec[m * num - 1] = 0;
                else vec[m * num - 1] = 1;
                m = m + 1;
            }
        }
        else {
            if(vec[num - 1]) vec[num - 1] = 0;
            else vec[num - 1] = 1;
            int m = 1;
            while((num - 1) - m >= 0 && (num - 1) + m < vec.size()) {
                if(vec[(num -1) - m] == vec[(num - 1) + m]) {
                    if(vec[(num -1) - m]) {
                        vec[(num -1) - m] = 0;
                        vec[(num -1) + m] = 0;
                    }
                    else {
                        vec[(num -1) - m] = 1;
                        vec[(num -1) + m] = 1;
                    }
                }
                else {
                    break;
                }
                m ++;
            }
        }
    }
    for(int i = 1 ; i < vec.size() + 1 ; i ++ ) {
        cout << vec[i - 1] << " ";
        if(i != 0 && i  % 20 == 0) cout << '\n';
    }
    return 0;
}