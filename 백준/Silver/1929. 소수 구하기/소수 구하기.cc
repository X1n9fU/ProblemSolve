#include <iostream>
using namespace std;

int main() {
	int M, N;
	cin >> M >> N;
	int* number = new int[N+1];

	for (int i = 2; i <= N; i++) {
		number[i] = i;
	}

	for (int i = 2; i <= N; i++) {
		if (number[i] == 0) continue;
		for (int j = i + i; j <= N; j += i) number[j] = 0;
	}

	for (int i = M; i <= N; i++) {
		if (number[i] != 0) cout << number[i] << '\n';
	}
}