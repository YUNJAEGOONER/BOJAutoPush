#include <iostream>
#include <vector>
#include <map>
using namespace std;
enum COMMAND {PUSH, POP, SIZE, EMPTY, FRONT, BACK};
map<string, COMMAND> cmd_map = {{"push", PUSH}, {"pop", POP}, {"size", SIZE}, {"empty", EMPTY}, {"front", FRONT}, {"back", BACK}};

//QUEUE : First In - First Out
class QUEUE{
private:
        vector<int> q;
public:

    void push(int x){
        q.push_back(x);
    }

    int pop(){
        if (q.empty()){
            return -1;
        }
        else{
            int temp = *(q.begin());
            q.erase(q.begin());
            return temp;
        }

    }

    int get_size(){
        return q.size();
    }

    int is_empty(){
        if(q.empty()){
            return 1;
        }
        return 0;
    }

    int get_front(){
        if(!is_empty()){
            return *q.begin();
        }
        return -1;
    }

    int get_back(){
        if(!is_empty()){
            return *(q.end()-1);
        }
        return -1;
    }

};

int main(){
    ios::sync_with_stdio(false);cin.tie(NULL);

    int N;
    cin >> N;
    QUEUE myqueu;

    while(N--){
        string command;
        cin >> command;
        COMMAND cmd = cmd_map[command];
        switch (cmd) {
            case PUSH:{
                int element;
                cin >> element;
                myqueu.push(element);
            }break;
            case POP:{
                cout << myqueu.pop() << '\n';
            }break;
            case SIZE:{
                cout << myqueu.get_size() << '\n';
            }break;
            case EMPTY:{
                cout << myqueu.is_empty() << '\n';
            }break;
            case FRONT:{
                cout << myqueu.get_front() << '\n';
            }break;
            case BACK:{
                cout << myqueu.get_back() << '\n';
            }
        }
    }
}