import java.util.concurrent.TimeUnit;

class CryptoTest {
	public static void main(String args[]) {
		// MD5 TESTS
		System.out.println("\n\nMD5 TESTS");

		// TEST #1: SHORT FILE/MESSAGE

		// get files to use as inputs
		String filePath = "../short.txt";
		File shortFile = new file(filePath);

		BufferedReader br = new BufferedReader(new FileReader(shortFile));
		
		String message;

		while(brShort.readLine() != null) {
			message = message + brShort.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getMD5BuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getMD5Implemented(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsedImplemented = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");



		

		// TEST #2: MEDIUM FILE/MESSAGE
		filePath = "../medium.txt";
		File mediumFile = new file(filePath);

		BufferedReader br = new BufferedReader(new FileReader(mediumFile));
		
		while(br.readLine() != null) {
			message = message + br.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getMD5BuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getMD5Implemented(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsed = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");


		

		// TEST #3: LONG FILE/MESSAGE
		filePath = "../long.txt";
		File longFile = new file(filePath);

		BufferedReader br = new BufferedReader(new FileReader(longFile));
		
		while(br.readLine() != null) {
			message = message + br.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getMD5BuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getMD5Implemented(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsed = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");




		// TEST #4: MEGA FILE/MESSAGE
		filePath = "../100M.txt";
		File megaFile = new file(filepath);

		BufferedReader br = new BufferedReader(new FileReader(megaFile));
		
		while(br.readLine() != null) {
			message = message + br.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getMD5BuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getMD5Implemented(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsed = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");




///////////////////////////////////////////////////////////////////////////////////////////////////

		


		// SHA-256 TESTS
		System.out.println("\n\nSHA-256 TESTS");

		// TEST #1: SHORT FILE/MESSAGE

		// get files to use as inputs
		String filePath = "../short.txt";
		File shortFile = new file(filePath);

		BufferedReader br = new BufferedReader(new FileReader(shortFile));
		
		String message;

		while(brShort.readLine() != null) {
			message = message + brShort.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getSHABuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getSHA256(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsedImplemented = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");



		

		// TEST #2: MEDIUM FILE/MESSAGE
		filePath = "../medium.txt";
		File mediumFile = new file(filePath);

		BufferedReader br = new BufferedReader(new FileReader(mediumFile));
		
		while(br.readLine() != null) {
			message = message + br.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getSHABuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getSHA256(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsed = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");


		

		// TEST #3: LONG FILE/MESSAGE
		filePath = "../long.txt";
		File longFile = new file(filePath);

		BufferedReader br = new BufferedReader(new FileReader(longFile));
		
		while(br.readLine() != null) {
			message = message + br.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getSHABuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getSHA256(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsed = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");




		// TEST #4: MEGA FILE/MESSAGE
		filePath = "../100M.txt";
		File megaFile = new file(filepath);

		BufferedReader br = new BufferedReader(new FileReader(megaFile));
		
		while(br.readLine() != null) {
			message = message + br.readLine;
		}

		br.close();

        // display message to be hashed
        System.out.println("\nMessage to be hashed:");
        System.out.println(message);

		// initialize time variables
        long startTime = 0;
        long endTime = 0;
        long timeElapsed = 0;

        // time the built-in hash method
        startTime = System.nanoTime();
        String hashBuiltIn = toHexString(getSHABuiltIn(message));
        endTime = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsed = endTime - startTime;

        // display results
        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsed + " ns");

        // time our implemented hash method
        startTime = System.nanoTime();
        String hashImplemented = toHexString(getSHA256(message));
        endTime = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsed = endTime - startTime;

        // display results     
        System.out.println("Hash from our implementation:");
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsed + " ns");
    }
}