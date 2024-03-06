#include <iostream>
using namespace std;
int main(){
    //int N, B;
    //cin >> N >> B;

    char number_list[1000000];

    int N;
    int B;
    cin >> N >> B ;
    
    int result;
    int index = 0;

    while(N >= B){
        result = N % B;
        if(result > 9){
            result = result + 7;
        }
        number_list[index++] = (char)result + 48;
        N = N / B;
        //cout << N << "\n";
    }
    if(N > 9){
        N = N + 7;
    }
    number_list[index++] = (char)N + 48;

    for(int j = index - 1 ; j > -1; --j ){
        cout << number_list[j];
    }

}