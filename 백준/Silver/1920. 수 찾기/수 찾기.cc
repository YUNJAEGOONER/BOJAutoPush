#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> myvec;

int bsearch(int start, int end, int key){
    while(start <= end){
        int mid = (start + end)/2;
        if(key == myvec[mid]){
            return 1;
        }
        else if(key < myvec[mid]){
            end = mid - 1;
        }
        else{
            start = mid + 1;
        }
    }
    return 0;
}


int main(){

    ios::sync_with_stdio(false);
    cin.tie(0);
    
    int n;
    cin >> n;


    while(n--){
        int element;
        cin >> element;
        myvec.push_back(element);
    }
    std::sort(myvec.begin(), myvec.end());

    int m;
    cin >> m;
    while(m--){
        int element;
        cin >> element;
        cout << bsearch(0, myvec.size() - 1,element) << '\n';
    }

}