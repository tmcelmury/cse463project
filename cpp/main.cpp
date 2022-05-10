#include <iostream>
#include <iomanip>
#include <fstream>
#include "md5home.cpp">
using namespace std::chrono;

int main() {
	// MD5 TESTS
	cout << "MD5 TESTS\n" << endl

	// TEST #1: SHORT FILE/MESSAGE

	// get file to use as input
	ifstream shortFile;
	shortFile.open("../short.txt");
	if(!shortFile) {
		cout << "Unable to open file";
		exit(1);
	}

	string message = "";
	string line = "";
	
	while(getLine(shortFile, line)) {
		message << message + line;
	}

	shortFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// initialize time variables
	auto startTime;
	auto stopTime;
	auto duration;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;




	// TEST #2: MEDIUM FILE/MESSAGE

	// get file to use as input
	ifstream mediumFile;
	mediumFile.open("../medium.txt");
	if(!mediumFile) {
		cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getLine(mediumFile, line)) {
		message << message + line;
	}

	mediumFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;




	// TEST #3: LONG FILE/MESSAGE

	// get file to use as input
	ifstream longFile;
	longFile.open("../long.txt");
	if(!longFile) {
		cout << "Unable to open file";
		exit(1);
	}

	message = "";
	line = "";
	
	while(getLine(longFile, line)) {
		message << message + line;
	}

	longFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;




	// TEST #4: MEGA FILE/MESSAGE

	// get file to use as input
	ifstream megaFile;
	megaFile.open("../100M.txt");
	if(!megaFile) {
		cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getLine(megaFile, line)) {
		message << message + line;
	}

	megaFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = MD5(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;




///////////////////////////////////////////////////////////////////////////////////////////////////




	// SHA-256 TESTS
	cout << "SHA-256 TESTS:\n" << endl;

	// TEST #1: SHORT FILE/MESSAGE

	// get file to use as input
	ifstream shortFile;
	shortFile.open("../short.txt");
	if(!shortFile) {
		cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getLine(shortFile, line)) {
		message << message + line;
	}

	shortFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;




	// TEST #2: MEDIUM FILE/MESSAGE

	// get file to use as input
	ifstream mediumFile;
	mediumFile.open("../medium.txt");
	if(!mediumFile) {
		cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getLine(mediumFile, line)) {
		message << message + line;
	}

	mediumFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;




	// TEST #3: LONG FILE/MESSAGE

	// get file to use as input
	ifstream longFile;
	longFile.open("../long.txt");
	if(!longFile) {
		cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getLine(longFile, line)) {
		message << message + line;
	}

	longFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;




	// TEST #4: MEGA FILE/MESSAGE

	// get file to use as input
	ifstream megaFile;
	megaFile.open("../long.txt");
	if(!megaFile) {
		cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getLine(megaFile, line)) {
		message << message + line;
	}

	megaFile.close();

	// display message to be hashed
	cout << "Message to be hashed: \n" + message << endl;

	// time the built-in hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	cout << "Hash from built-in method: \n" + duration.count() + " ns" << endl;

	// time our implemented hash method
	startTime = high_resolution_clock::now();
	uint32_t hashBuiltIn = SHA256(message);
	stop = high_resolution_clock::now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	cout << "Hash from our implementation: \n" + duration.count() + " ns" << endl;
}