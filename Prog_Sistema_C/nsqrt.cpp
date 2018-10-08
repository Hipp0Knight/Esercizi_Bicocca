#include "nsqrt.h"
#include <iostream>
#include <cmath>

double nsqrt(double x, double epsilon) {
	
	double s = 0.0;
	double prevS = x/2;
	
	do{
		s = ((pow(prevS, 2.0) + x) / (2 * prevS));
		prevS = s;
	} while (abs(pow(s, 2.0) - x) > epsilon);
	
	return s;
}