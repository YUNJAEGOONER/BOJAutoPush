#include<iostream>
#include<map>
using namespace std;

int main(){
    
     ios::sync_with_stdio(false);
     cin.tie(0);
     
    int N;
     cin >> N;
     map<int, int> mmap;
     while(N--) {
          int n;
          cin >> n;
          mmap[n]++;
     }

     int M;
     cin >> M;
     while(M--) {
          int n;
          cin >> n;
          cout << mmap[n] << ' ';
     }
     return 0;
}