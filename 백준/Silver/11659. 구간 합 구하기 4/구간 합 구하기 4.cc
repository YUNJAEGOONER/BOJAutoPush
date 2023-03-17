#include <iostream>
using namespace std;
long long sum_array[100000] = {0,};

int main(){
    ios::sync_with_stdio(false);
	cin.tie(0);
    int N, M;
    cin >> N >> M;

    int index = 1;
    long long sum = 0;

    while(N --){
        int element;
        cin >> element;
        sum = sum + element;
        sum_array[index++] = sum;
    }

    while(M--){
        int i, j;
        cin >> i >> j;
        cout << sum_array[j] - sum_array[i-1] << '\n';
    }

}