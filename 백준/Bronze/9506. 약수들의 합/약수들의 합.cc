#include <iostream>
using namespace std;

int main(){

    int n;
    while(true){
        cin >> n;
        if(n == -1){
            break;
        }
        else{
            int number [100000];
            int index = 0;

            int sum = 0;
            int range = n;
            for(int i = 2 ; i < range; i ++ ){
                if(!(n % i)){
                    range = n / i;
                    sum = sum + i + range;
                    number[index++] = i;
                    number[index++] = range;
                }
            }
            if(sum == n - 1){
                cout << n << " = 1 ";
                for(int even = 0; even < index ; even = even + 2){
                    cout << "+ " << number[even]<< " ";
                }
                for(int odd = index - 1; odd > -1 ; odd = odd - 2){
                    cout << "+ " << number[odd] << " ";
                }
                cout << '\n';
            }
            else{
                cout << n << " is NOT perfect.\n";
            }
        }
    }

}