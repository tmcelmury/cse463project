#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
#include <chrono>
#include <vector>
#include "md5home.h"
#include "sha256.h"
using namespace std;

int main() {
	std::chrono::high_resolution_clock clk;

	// MD5 TESTS
	std::cout << "MD5 TESTS\n" << std::endl;

	// TEST #1: SHORT FILE/MESSAGE

	// get file to use as input
	std::ifstream shortFile;
	shortFile.open("../short.txt", std::ios::binary);
	if(!shortFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}

	std::string message = "";
	std::string line = "";
	
	while(getline(shortFile, line)) {
		message = message + line;
	}

	shortFile.close();

	std::vector<char> vecMessage;
	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}


	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// initialize time variables
	std::chrono::time_point<std::chrono::high_resolution_clock> startTime;
	std::chrono::time_point<std::chrono::high_resolution_clock> stopTime;
	std::chrono::time_point<std::chrono::high_resolution_clock> duration;

	// time the built-in hash method
	startTime = clk.now();
	uint32_t* hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;




	// TEST #2: MEDIUM FILE/MESSAGE

	// get file to use as input
	std::ifstream mediumFile;
	mediumFile.open("../medium.txt", std::ios::binary);
	if(!mediumFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(mediumFile, line)) {
		message = message + line;
	}
	
	mediumFile.close();

	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;




	// TEST #3: LONG FILE/MESSAGE

	// get file to use as input
	std::ifstream longFile;
	longFile.open("..long.txt", std::ios::binary);
	if(!longFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}

	message = "";
	line = "";
	
	while(getline(longFile, line)) {
		message = message + line;
	}
	
	longFile.close();

	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;




	// TEST #4: MEGA FILE/MESSAGE

	// get file to use as input
	std::ifstream megaFile;
	megaFile.open("../100M.txt", std::ios::binary);
	if(!megaFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(megaFile, line)) {
		message = message + line;
	}
	
	megaFile.close();

	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = MD5(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;




///////////////////////////////////////////////////////////////////////////////////////////////////




	// SHA-256 TESTS
	std::cout << "SHA-256 TESTS:\n" << std::endl;

	// TEST #1: SHORT FILE/MESSAGE

	// get file to use as input
	shortFile.open("../short.txt", std::ios::binary);
	if(!shortFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(shortFile, line)) {
		message = message + line;
	}
	
	shortFile.close();

	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;




	// TEST #2: MEDIUM FILE/MESSAGE

	// get file to use as input
	mediumFile.open("../medium.txt", std::ios::binary);
	if(!mediumFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(mediumFile, line)) {
		message = message + line;
	}
	
	mediumFile.close();


	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;




	// TEST #3: LONG FILE/MESSAGE

	// get file to use as input
	longFile.open("../long.txt", std::ios::binary);
	if(!longFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(longFile, line)) {
		message = message + line;
	}
	
	longFile.close();

	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;




	// TEST #4: MEGA FILE/MESSAGE

	// get file to use as input
	megaFile.open("../100M.txt", std::ios::binary);
	if(!megaFile.is_open()) {
		std::cout << "Unable to open file";
		exit(1);
	}
	
	message = "";
	line = "";

	while(getline(megaFile, line)) {
		message = message + line;
	}
	
	megaFile.close();

	for(int i = 0; i < message.length(); i++){
		vecMessage[i] = message.at(i);
	}

	// display message to be hashed
	std::cout << "Message to be hashed: \n" + message << std::endl;

	// time the built-in hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	
	
	// display results
	std::cout << "Hash from built-in method: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;

	// time our implemented hash method
	startTime = clk.now();
	hashBuiltIn = SHA256(vecMessage);
	stopTime = clk.now();
	

	// display results
	std::cout << "Hash from our implementation: \n" << std::chrono::duration_cast<std::chrono::nanoseconds>(stopTime-startTime).count() << " ns" << std::endl;
}