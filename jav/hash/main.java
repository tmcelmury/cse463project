package hash;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.lang.*;
import java.security.MessageDigest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import hash.*;

class main {

    public static void main(String args[]) {
        try {
            // MD5 TESTS
            System.out.println("\n\nMD5 TESTS");
    
            // TEST #1: SHORT FILE/MESSAGE
    
            // get File to use as inputs
            String filePath = "../short.txt";
            File shortFile = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(shortFile));  
            
            
            String message = "";
    
            while(br.readLine() != null) {
                message = message + br.readLine();
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
            String hashBuiltIn = MD5.getMD5BuiltIn(message);
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            int[] hashImplemented = MD5.getMD5Implemented(message);
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
    
    
            
    
            // TEST #2: MEDIUM FILE/MESSAGE
    
            // update File to use as input
            filePath = "../medium.txt";
            File mediumFile = new File(filePath);
    
            br = new BufferedReader(new FileReader(mediumFile));
            
            message = "";
    
            while(br.readLine() != null) {
                message = message + br.readLine();
            }
    
            br.close();
    
            // display message to be hashed
            System.out.println("\nMessage to be hashed: ");
            System.out.println(message);
    
            // time the built-in hash method
            startTime = System.nanoTime();
            hashBuiltIn = MD5.getMD5BuiltIn(message);
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            hashImplemented = MD5.getMD5Implemented(message);
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
    
            
    
            // TEST #3: LONG FILE/MESSAGE
    
            // update File to use as input
            filePath = "../long.txt";
            File longFile = new File(filePath);
    
            br = new BufferedReader(new FileReader(longFile));
    
            message = "";
            
            while(br.readLine() != null) {
                message = message + br.readLine();
            }
    
            br.close();
    
            // display message to be hashed
            System.out.println("\nMessage to be hashed: ");
            System.out.println(message);
    
            // time the built-in hash method
            startTime = System.nanoTime();
            hashBuiltIn = MD5.getMD5BuiltIn(message);
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            hashImplemented = MD5.getMD5Implemented(message);
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
    
    
    
            // TEST #4: MEGA FILE/MESSAGE
    
            // update File to use as input
            filePath = "../100M.txt";
            File megaFile = new File(filePath);
    
            br = new BufferedReader(new FileReader(megaFile));
            
            message = "";
    
            while(br.readLine() != null) {
                message = message + br.readLine();
            }
    
            br.close();
    
            // display message to be hashed
            System.out.println("\nMessage to be hashed: ");
            System.out.println(message);
    
            // time the built-in hash method
            startTime = System.nanoTime();
            hashBuiltIn = (MD5.getMD5BuiltIn(message));
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            hashImplemented = MD5.getMD5Implemented(message);
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    
            
    
    
            // SHA-256 TESTS
            System.out.println("\n\nSHA-256 TESTS");
    
            // TEST #1: SHORT FILE/MESSAGE
    
            // get File to use as input
            filePath = "../short.txt";
            shortFile = new File(filePath);
    
            br = new BufferedReader(new FileReader(shortFile));
            
            message = "";
    
            while(br.readLine() != null) {
                message = message + br.readLine();
            }
    
            br.close();
    
            // display message to be hashed
            System.out.println("\nMessage to be hashed: ");
            System.out.println(message);
    
            // time the built-in hash method
            startTime = System.nanoTime();
            hashBuiltIn = (SHA256.getSHABuiltIn(message));
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            hashImplemented = (SHA256.getSHAImplemented(message));
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
    
    
            
    
            // TEST #2: MEDIUM FILE/MESSAGE
            
            // update File to use as input
            filePath = "../medium.txt";
            mediumFile = new File(filePath);
    
            br = new BufferedReader(new FileReader(mediumFile));
            
            message = "";
    
            while(br.readLine() != null) {
                message = message + br.readLine();
            }
    
            br.close();
    
            // display message to be hashed
            System.out.println("\nMessage to be hashed: ");
            System.out.println(message);
    
            // time the built-in hash method
            startTime = System.nanoTime();
            hashBuiltIn = (SHA256.getSHABuiltIn(message));
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            hashImplemented = (SHA256.getSHAImplemented(message));
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
    
            
    
            // TEST #3: LONG FILE/MESSAGE
            
            // update File to use as input
            filePath = "../long.txt";
            longFile = new File(filePath);
    
            br = new BufferedReader(new FileReader(longFile));
            
            message = "";
    
            while(br.readLine() != null) {
                message = message + br.readLine();
            }
    
            br.close();
    
            // display message to be hashed
            System.out.println("\nMessage to be hashed: ");
            System.out.println(message);
    
            // time the built-in hash method
            startTime = System.nanoTime();
            hashBuiltIn = (SHA256.getSHABuiltIn(message));
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            hashImplemented = (SHA256.getSHAImplemented(message));
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
    
    
    
            // TEST #4: MEGA FILE/MESSAGE
            
            // update File to use as input
            filePath = "../100M.txt";
            megaFile = new File(filePath);
    
            br = new BufferedReader(new FileReader(megaFile));
            
            message = "";
            
            while(br.readLine() != null) {
                message = message + br.readLine();
            }
    
            br.close();
    
            // display message to be hashed
            System.out.println("\nMessage to be hashed: ");
            System.out.println(message);
    
            // time the built-in hash method
            startTime = System.nanoTime();
            hashBuiltIn = (SHA256.getSHABuiltIn(message));
            endTime = System.nanoTime();
    
            // find time taken by built-in hash method
            timeElapsed = endTime - startTime;
    
            // display results
            System.out.println("Hash from built-in method: ");
            System.out.println(hashBuiltIn);
            System.out.println("Time taken: " + timeElapsed + " ns");
    
            // time our implemented hash method
            startTime = System.nanoTime();
            hashImplemented = (SHA256.getSHAImplemented(message));
            endTime = System.nanoTime();
            
            // find time taken by our implemented hash method
            timeElapsed = endTime - startTime;
    
            // display results     
            
            System.out.println("Hash from our implementation: ");
            System.out.println(hashImplemented);
            System.out.println("Time taken: " + timeElapsed + " ns");
        } catch(IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}