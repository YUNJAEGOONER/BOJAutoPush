#include <iostream>
#include <vector>
using namespace std;

typedef struct documnet{
    int index;
    int importance;
}doc;


int main(){
    int test;
    cin >> test;
    while(test--){
        int N, M;
        cin >> N >> M;

        vector<doc> documents;
        int import[9] = {0,};
        int i = 0;
        int ranks[N];

        while(N--){
            int importance;
            cin >> importance;
            ++import[importance-1];
            doc document;
            ranks[i] = 0;
            document.index = i;
            document.importance = importance;
            documents.push_back(document);
            i++;
        }

        int rank = 1;

        for(int i = 8 ; i > -1 ; i -- ){
            if(import[i] != 0){
                while(import[i] != 0){
                    if(documents.begin()->importance == (i + 1)){
                        ranks[documents.begin()->index] = rank;
                        documents.erase(documents.begin());
                        --import[i];
                        rank ++;
                    }
                    else{
                        doc temp = *documents.begin();
                        documents.erase(documents.begin());
                        documents.push_back(temp);
                    }
                }
            }
        }

        cout << ranks[M] << endl;
    }

}
