#include<iostream>
#include <vector>
using namespace std;

vector<int> visit;

int main(){
	vector<vector<int>> paper;

	for (int i = 0; i < 101; i++) {
		vector<int> row(101);
		paper.push_back(row);
	}

	int n;
	cin >> n;

	for(int t = 0; t < n; t++) {
		int a, b;
		cin >> a >> b;
		for (int i = b; i < b + 10;  i ++ ) {
			for (int j = a; j < a + 10; j++) {
				paper[i][j] = 1;
			}
		}
	}

	int answer = 0;
	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (paper[i][j] == 1) {
				if (i - 1 >= 0 && paper[i - 1][j] == 0) answer++;
				if (i + 1 <= 100 && paper[i + 1][j] == 0) answer++;
				if (j - 1 >= 0 && paper[i][j - 1] == 0) answer++;
				if (j + 1 <= 100 && paper[i][j + 1] == 0) answer++;
			}
		}
	}
	cout << answer;

	return 0;
}