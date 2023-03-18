#include <iostream>
using namespace std;

long long trees[1000001];

int main(){
    long long N, M;
    cin >> N >> M;

    long long index = 0;
    long long max = 0;
    while(N -- ){
        long long element;
        cin >> element;
        trees[index ++ ] = element;
        if(max < element){
            max = element;
        }
    }

    long long mid;
    long long start = 0;
    long long end = max;

    long long sum = 0;
    long long min = max;

    while(start <= end){
        sum  = 0;
        mid = (start + end) / 2;
        for(int i = 0 ; i < index; i ++ ){
            if (mid < trees[i]){
                sum = sum + (trees[i] - mid);
            }
        }
        if(sum == M){
            break;
        }
        //too_much -> high
        else if(sum > M){
            min = mid;
            start = mid + 1;
        }
        //too_small -> low
        else{
            end = mid - 1;
        }
    }

    if(sum == M){
        cout << mid;
    }
    else{
        cout << min;
    }

}