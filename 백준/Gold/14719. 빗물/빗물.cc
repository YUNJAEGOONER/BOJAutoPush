#include<vector>
#include<iostream>
using namespace std;

int main() {

    int H, W;
    cin >> H >> W;
    vector<int> vec;

    for(int i = 0 ; i < W ; i ++ ) {
        int e;
        cin >> e;
        vec.push_back(e);
    }

    int ans = 0;

    for(int i = 1 ; i < vec.size() - 1  ; i ++ ) {
        //get_left_max
        int lmax = vec[i];
        for(int j = i - 1 ; j > - 1 ; j -- ) {
            if(lmax < vec[j]) lmax = vec[j];
        }

        //get_right_max
        int rmax = vec[i];
        for(int j = i + 1 ; j < vec.size(); j ++ ) {
            if(rmax < vec[j]) rmax = vec[j];
        }

        if(rmax > lmax) ans += lmax - vec[i];
        else ans += rmax - vec[i];
    }

    cout << ans;


    return 0;
}