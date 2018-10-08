#include <iostream>
#include <cmath>  //std::sin

float f(float x) {
	return std::sin(x);
}

int main(void) {
	
	float a = 0.0;
	float b = M_PI; //pi-greco, è una macro
	
	int N = 0;
	
	std::cout << "inserire N: ";
	std::cin >> N;
	
	if (N>0) {
		float dx = (b-a)/N;
		
		float integral = 0.0;
		
		for(int i = 0; i < N; i++) {
			integral += ((f(a) + f(a+dx)));
			a = a + dx;
		}
		integral *= dx*0.5;
		std::cout << integral;
		
	} else {
		std::cout << "inserire un valore > 0!" << std::endl;
	}
	
	
	
	return 0;
}