#include <iostream>
#include <vector>
using namespace std;


vector<long long> dp(102);

long long dprombelm(int n) {
    if(dp[n] != 0) {
        return dp[n];
    }
    if(n < 0) {
        return 0;
    }
    if(n <= 3) {
        return dp[n] = 1;
    }
    if(n == 4 || n == 5) {
        return dp[n] = 2;
    }
    return dp[n] = dprombelm(n - 1) + dprombelm(n - 5);

}

int main() {
    int n;
    cin >> n;

    while(n--) {
        int a;
        cin >> a;
        cout << dprombelm(a) << '\n';
    }

    return 0;
}
