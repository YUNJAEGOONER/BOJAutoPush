#include<iostream>
#include<vector>
using namespace std;

int main() {
    int N;
    cin >> N;

    vector<int> distance;
    for(int i = 0 ; i < N - 1 ; i ++) {
        int d;
        cin >> d;
        distance.push_back(d);
    }

    vector<int> price;
    for(int i = 0 ; i < N ; i ++) {
        int p;
        cin >> p;
        price.push_back(p);
    }

    int sum = 0;
    int min_price = price[0];
    for(int i = 0 ; i < N - 1 ; i ++) {
        if(min_price > price[i]) {
            min_price = price[i];
        }
        sum = sum + min_price * distance[i];
    }

    cout << sum;
    return 0;
}