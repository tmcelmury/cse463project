#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <chrono>
#include "md5home.h"
#include "sha256.h"
using namespace std::chrono;

int main() {
	high_resolution_clock clk;

	// MD5 TESTS
	std::cout << "MD5 TESTS\n" << std::endl

	// TEST #1: SHORT FILE/MESSAGE

	// get file to use as input
	std::ifstream shortFile("../short.txt");
	shortFile.open();
	if(!shortFile) {
		std::cout << "Unable to open file";
		exit(1);
	}

	std::string message = "";
	std::string line = "";
	
	while(getline(shortFile, line)) {
		message << message + line;
	}

	shortFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// initialize time variables
	auto startTime;
	auto stopTime;
	auto duration;

	// time the built-in hash method
	startTime = clk.now();
	uint32_t hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;




	// TEST #2: MEDIUM FILE/MESSAGE

	// get file to use as input
	std::std::ifstream mediumFile;
	mediumFile.open("../medium.txt");
	if(!mediumFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(mediumFile, line)) {
		message << message + line;
	}

	mediumFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;




	// TEST #3: LONG FILE/MESSAGE

	// get file to use as input
	std::ifstream longFile;
	longFile.open("../long.txt");
	if(!longFile) {
		std::cout << "Unable to open file";
		exit(1);
	}

	message = "";
	line = "";
	
	while(getline(longFile, line)) {
		message << message + line;
	}

	longFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;




	// TEST #4: MEGA FILE/MESSAGE

	// get file to use as input
	std::ifstream megaFile;
	megaFile.open("../100M.txt");
	if(!megaFile) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(megaFile, line)) {
		message << message + line;
	}

	megaFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;




///////////////////////////////////////////////////////////////////////////////////////////////////




	// SHA-256 TESTS
	std::cout << "SHA-256 TESTS:\n" << std::endl;

	// TEST #1: SHORT FILE/MESSAGE

	// get file to use as input
	std::ifstream shortFile;
	shortFile.open("../short.txt");
	if(!shortFile) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(shortFile, line)) {
		message << message + line;
	}

	shortFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;




	// TEST #2: MEDIUM FILE/MESSAGE

	// get file to use as input
	std::ifstream mediumFile;
	mediumFile.open("../medium.txt");
	if(!mediumFile) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(mediumFile, line)) {
		message << message + line;
	}

	mediumFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;




	// TEST #3: LONG FILE/MESSAGE

	// get file to use as input
	std::ifstream longFile;
	longFile.open("../long.txt");
	if(!longFile) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(longFile, line)) {
		message << message + line;
	}

	longFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;




	// TEST #4: MEGA FILE/MESSAGE

	// get file to use as input
	std::ifstream megaFile;
	megaFile.open("../long.txt");
	if(!megaFile) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(megaFile, line)) {
		message << message + line;
	}

	megaFile.close();

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);
	
	// display results
	std::cout << "Hash from built-in method: \n" + duration.count() + " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(message);
	stop = clk.now();
	duration = duration_cast<nanoseconds>(stop-start);

	// display results
	std::cout << "Hash from our implementation: \n" + duration.count() + " ns" << std::endl;
}