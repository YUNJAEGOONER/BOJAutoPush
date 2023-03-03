#include <iostream>
#include <vector>
using namespace std;

int main(){
    int N, K;
    cin >> N >> K;
    vector<int> coins;

    while(N--){
        int coin;
        cin >> coin;
        coins.push_back(coin);
    }

    int sum = 0;
    for(int i = coins.size() - 1 ; i > -1 ; i -- ){
        if(K / coins[i] > 0){
            sum = sum + K / coins[i];
            K = K - (coins[i] * (K / coins[i]));
        }
    }

    cout << sum;
}
