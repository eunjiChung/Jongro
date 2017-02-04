#include <fstream>
#include <iostream>
#include <math.h>
using namespace std;

bool insideCircle(int x, int y) {
	if(pow(x-50,2) + pow(y-50,2) <= 2500) return true;
	else return false;
}

bool isBlack(int p, int x, int y) {
	double theta = M_PI*p/50;
	if(!insideCircle(x,y)) return false;
	else if(p<=25) {
		if(x<50 || y<50) return false;
		else if(y-50 >= (x-50)/tan(theta)) return true;
		else return false;
	} else if(p<=50) {
		if(x<50) return false;
		else if(y-50 >= (x-50)/tan(theta)) return true;
		else return false;
	} else if(p<=75) {
		if(x<50 && y>50) return false;
		else if(x>=50) return true;
		else if(y-50 <= (x-50)/tan(theta)) return true;
		else return false;
	} else { //75이상 100이하 
		if(x>=50 || y<=50) return true;
		else if(y-50 <= (x-50)/tan(theta)) return true;
		else return false;
	}
}

int main() {
	int T, P, X, Y;
	ifstream file("progress_pie.txt");
	ofstream outFile("progress_pie_output.txt");
	file >> T; //cin >> T;
	for(int i=1; i<=T; i++) {
		file >> P >> X >> Y; //cin >> P >> X >> Y;
		if(isBlack(P,X,Y)) outFile << "Case #" << i << ": black" << "\n";
		else outFile << "Case #" << i << ": white" << "\n";
		//outFile << "Case #" << i << ": white" << "\n";
	}
}
