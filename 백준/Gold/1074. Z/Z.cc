//
// Created by Yunjae on 2025-03-21.
//
#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main() {

    int N, c, r;
    cin >> N >> r >> c;

    int size = pow(2, N);

    int num = 0;

    int idx = 0;
    int jdx = 0;

    while(size != 0) {
        int term = (size / 2) * (size / 2);
       
        //1사분면(왼상)
        if(r < idx + (size/2) && c < jdx + (size/2)){
            num += 0;
        }
        //2사분면(오상)
        else if(r < idx + (size/2) && jdx + (size/2) <= c ) {
            //cout << r << " " << idx + (size/2) << ' ';
            num += (1 * term);
            jdx += (size/2);
        }
        //3사분면(왼하)
        else if(idx + (size/2) <= r && c < jdx + (size/2)) {
            num += (2 * term);
            idx += (size/2);
        }
        //4사분면(오하)
        else{
            num += (3 * term);
            idx += (size/2);
            jdx += (size/2);
        }
        size /= 2;

        //cout << num << '\n';
    }

    cout << num;


    return 0;
}