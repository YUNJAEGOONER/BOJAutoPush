#include <iostream>
using namespace std;

long long dp_f[41][2] = {0,};

long long * dp_fibo(int x){
    if(x == 1){
        dp_f[1][0] = 0;
        dp_f[1][1] = 1;
        return dp_f[1];
    }
    if (x == 0){
        dp_f[0][0] = 1;
        dp_f[0][1] = 0;
        return dp_f[0];
    }
    else{
        dp_f[x][0] = dp_f[x-1][0] + dp_f[x-2][0];
        dp_f[x][1] = dp_f[x-1][1] + dp_f[x-2][1];
        return dp_f[x];
    }
}

int main(){
    int n;
    cin >> n;
    while(n--){
        int x;
        cin >> x;
        for(int i = 0; i < x ; i ++ ){
            dp_fibo(i);
        }
        cout << dp_fibo(x)[0] << " " << dp_fibo(x)[1] << '\n';
    }

}