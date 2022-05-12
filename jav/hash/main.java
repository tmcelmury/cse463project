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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.nio.ByteBuffer;
import java.lang.Math;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;

class main {

    public static void main(String args[]) {
        try {
            // MD5 TESTS
            System.out.println("\n\nMD5 TESTS");
    
            // TEST #1: SHORT FILE/MESSAGE
    
            // get File to use as inputs
            String filePath = "../../short.txt";
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
            filePath = "../../medium.txt";
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
            filePath = "../../long.txt";
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
            filePath = "../../100M.txt";
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
            filePath = "../../short.txt";
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
            filePath = "../../medium.txt";
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
            filePath = "../../long.txt";
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
            filePath = "../../100M.txt";
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

class MD5 {
    static byte[] negI = {0, 3, 2, 1};
    static byte[] one = {1, 0, 3, 2};
    static byte[] two = {2, 1, 0, 3};
    static byte[] three = {3, 2, 1, 0};
    static int[] T;


    // algorithm courtesy of bilal-hungund on GeeksforGeeks
    // https://www.geeksforgeeks.org/md5-hash-in-java/
    public static String getMD5BuiltIn(String message) {
        try {
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
    
            // digest() method is called to calculate message digest
            //  of an input digest() return array of byte
            byte[] messageDigest = md.digest(message.getBytes());
    
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
    
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch(NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static int[] getMD5Implemented(String message) {
        int D[] = {0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476};
        
        int[] padded = pad(message);

        long numBlocks = padded.length / 64;

        for (int i = 0; i < numBlocks; i++) {
            D = pass4(Arrays.copyOfRange(padded, 64*i, 64*i+63), pass3(Arrays.copyOfRange(padded, 64*i, 64*i+63), pass2(Arrays.copyOfRange(padded, 64*i, 64*i+63),
                pass1(Arrays.copyOfRange(padded, 64*i, 64*i+63), D))));
        }
        return D;
    }

    public static int[] pad(String message) {
        byte[] msg = message.getBytes();
        
        int remainder = (msg.length * 8) % 512;    // // Find the remainder in bits after dividing total size by 512 bits
        int words = (int) Math.ceil((msg.length * 8)/512) * 16;
        long lastIndex = msg.length;    // Find the index just beyond the last, used for appending
        byte brokenSize[] = longToBytes(lastIndex);   // Break the 64 bit size into a byte array, using typecasting

        int[] padded = new int[words];

        if (remainder > 448) // There is not enough space for the 64 bit size
        {
            msg[(int) lastIndex] = (byte) 0x80;
            lastIndex++;

            int fill = (512 - remainder - 8)/8;

            for (int h = 0; h < fill; h++)    // Fill with 0's up to next multiple of 512 bits
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
            }

            for (int i = 0; i < 56; i++)    // Append 56 bytes of 0's
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                msg[(int) lastIndex] = brokenSize[j];
                lastIndex++;
            }
            
            for (int k = 0; k < words; k++)
            {
                padded[k] = fromByteArray(Arrays.copyOfRange(msg, k*4, k*4+4));
            }
            return padded;
        }
        else if (remainder == 0)    // Exactly a multiple of 512 bits
        {
            msg[(int) lastIndex] = (byte) 0x80;  // Append 0b1000_0000
            lastIndex++;

            for (int i = 0; i < 55; i++)    // Append 55 bytes of 0's
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                msg[(int) lastIndex] = brokenSize[j];
                lastIndex++;
            }
            
            for (int k = 0; k < words; k++)
            {
                padded[k] = fromByteArray(Arrays.copyOfRange(msg, k*4, k*4+4));
            }
            return padded;
        }
        else    // There is space for the 64 bit size
        {
            int fill = (remainder - 64)/8;  // Determine the number of bytes needed to fill before the 64 bit size
            
            if ( fill > 0 )  // If there is any space to fill, start with 0b1000_0000
            {
                msg[(int) lastIndex] = (byte) 0x80;
                lastIndex++;    // Increment the index for appending
                fill--;     // Decrement the number of bytes needed to fill the necessary space
            }

            while ( fill >= 0 )  // Continue filling with 0's while there is space left to fill
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
                fill--;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                msg[(int) lastIndex] = brokenSize[j];
                lastIndex++;
            }
            
            for (int k = 0; k < words; k++)
            {
                padded[k] = fromByteArray(Arrays.copyOfRange(msg, k*4, k*4+4));
            }
            return padded;
        }
    }

    public static int[] pass1(int[] m, int[] d) {
        byte[] shift = {7, 12, 17, 22};
        for (int i = 0; i < 16; i++)
        {
            d[negI[i%4]] = d[one[i%4]] + leftRotate( (d[negI[i%4]] +
                        F(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[i] + T[i]), shift[i%4]);
        }
        return d;
    }
    public static int[] pass2(int[] m, int[] d) {
        byte[] shift = {5, 9, 14, 20};
        for (int j = 0; j < 16; j++)
        {
            d[negI[j%4]] = d[one[j%4]] + leftRotate( d[negI[j%4]] +
                        G(d[one[j%4]], d[two[j%4]], d[three[j%4]]) + m[(5*j + 1)%16] + T[j + 16], shift[j%4]);
        }
        return d;
    }
    public static int[] pass3(int[] m, int[] d) {
        int shift[] = {4, 11, 16, 23};
        for (int k = 0; k < 16; k++)
        {
            d[negI[k%4]] = d[one[k%4]] + leftRotate( d[negI[k%4]] +
                        H(d[one[k%4]], d[two[k%4]], d[three[k%4]]) + m[(3*k + 5)%16] + T[k + 32], shift[k%4]);
        }
        return d;
    }
    public static int[] pass4(int m[], int d[]) {
        byte shift[] = {6, 10, 15, 21};
        for (int l = 0; l < 16; l++)
        {
            d[negI[l%4]] = d[one[l%4]] + leftRotate( d[negI[l%4]] +
                        I(d[one[l%4]], d[two[l%4]], d[three[l%4]]) + m[(7*l)%16] + T[l + 48], shift[l%4]);
        }
        return d;
    }

    public static int leftRotate(int target, int n) { return (target << n) | (target >> (32 - n)); }
    public static int F(int x, int y, int z) { return (x & y) | (~x & z); }
    public static int G(int x, int y, int z) { return (x & z) | (y & ~z); }
    public static int H(int x, int y, int z) { return x ^ y ^ z; }
    public static int I(int x, int y, int z) { return y ^ (x | ~z); }

//  Courtesy of stack overflow contributors ////////////////////////////////////
    public static int fromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }
    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }
////////////////////////////////////////////////////////////////////////////////

    public static int[] generateT() {
        int T[] = {};
        for (int i = 0; i < 64; i++) { T[i] = (int) (Math.floor(Math.pow(2, 32) * Math.abs(Math.sin(i)))); }
        return T;
    }
}




class SHA256 {
    // method invoking built-in SHA-256 functionality
    // modified version of algorithm provided by bilal-hungund on GeeksforGeeks
    // https://www.geeksforgeeks.org/sha-256-hash-in-java/
    public static String getSHABuiltIn(String text) {
        try {
            MessageDigest dig = MessageDigest.getInstance("SHA-256");
            byte[] hash = dig.digest(text.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) 
                  hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch(NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }
    }

    // method to convert message hash to string of hex characters
    public static String toHexString(byte[] messageHash) {
        BigInteger number = new BigInteger(1, messageHash);

        StringBuilder hexString = new StringBuilder(number.toString(16));

        while(hexString.length() < 64) {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    // our implementation of the SHA-256 algorithm
    public static int[] getSHAImplemented(String message) {
        // initialize hash values representing first 32 bits of
        // the fractional parts of the square roots of the first
        // 8 prime numbers (2, 3, 5, 7, 11, 13, 17, 19)
        int[] hVal = {0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19};
    
        // initialize rounded constants representing first 32 bits
        // of the fractional parts of the cube roots of the first
        // 64 prime numbers (2-311)
        int[] kVal =    {0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
                         0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
                         0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
                         0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
                         0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
                         0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
                         0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
                         0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2};

        // pad the message to multiple of 512 bits
        int[] padded = pad(message);

        long numBlocks = padded.length / 64;
        
        // Store useful constants
        int zeroWord = 0x00000000;

        // Instantiate variables for following loop
        int s0, s1, ch, temp1, temp2, maj;

        // Instantiate message queue
        int[] w = new int[64];

        // Repeat this loop for each block 
        for (int i = 0; i < numBlocks; i++)
        {
            // Fill message queue
            for (int j = 0; j < 16; j++)
            {
                if (j < 16) { w[j] = padded[j + i*16]; } // First 16 words are block
                else { w[j] = zeroWord; } // Rest are all 0's
            }

            // Find S0, S1, and absolutely merc w
            for (int k = 16; k < 64; k++)
            {
                s0 = rightRotate(w[k-15], 7) ^ rightRotate(w[k-15], 18) ^ (w[k-15]>>3);
                s1 = rightRotate(w[k-2], 17) ^ rightRotate(w[k-2], 19) ^ (w[k-2]>>10);
                w[k] = w[k-16] + s0 + w[k-7] + s1;
            }

            // Put current hash into working variables
            int a = hVal[0]; int b = hVal[1]; int c = hVal[2]; int d = hVal[3];
            int e = hVal[4]; int f = hVal[5]; int g = hVal[6]; int h = hVal[7];

            // Compression Loop
            for (int l = 0; l < 64; l++)
            {
                s1 = rightRotate(e, 6) ^ rightRotate(e, 11) ^ rightRotate(e, 25);
                ch = (e & f) ^ ((~e) & g);
                temp1 = h + s1 + ch + kVal[l] + w[l];
                s0 = rightRotate(a, 2) ^ rightRotate(a, 13) ^ rightRotate(a, 22);
                maj = (a & b) ^ (a & c) ^ (b & c);
                temp2 = s0 + maj;

                // Rearrange working variables
                h = g; g = f; f = e; e = d + temp1;
                d = c; c = b; b = a; a = temp1 + temp2;
            }

            // Modify current hash
            hVal[0] += a; hVal[1] += b; hVal[2] += c; hVal[3] += d;
            hVal[4] += e; hVal[5] += f; hVal[6] += g; hVal[7] += h;
        }
        // // separate padded message into 512-bit chunks
        // for(int i = 0; i < numBlocks; i++) {
        //     for(int j = 0; j < 64; j++) {
        //         tempChunk = (tempChunk << 16) | ((padded << 16) & bitMask);
        //     }
            
        //     messageChunks[i] = tempChunk;
        // }

        // // initialize schedule array
        // long scheduleArray[][] = {};

        // // initial values don't matter, so fill with 0s
        // for(int i = 0; i < numBlocks; i++) {
        //     for(int j = 0; j < 64; j++) {
        //         scheduleArray[i][j] = 0;
        //     }
        // }

        // // copy chunk into first 16 words of schedule array
        // for(int i = 0; i < 16; i++) {
        //     for(int j = 0; j < 64; j++) {
        //         scheduleArray[i][j] = (messageChunks[0] >> (32 * (16 - i - 1))) & 0xffffffff;
        //     }
        // }

        // // initialize temp variables
        // long s0 = 0;
        // long s1 = 0;
        // long ch = 0;
        // long maj = 0;
        // long temp1 = 0;
        // long temp2 = 0;

        // // extend first 16 words of schedule array into remaining 48 words
        // for(int i = 0; i < numBlocks; i++) {
        //     for(int j = 16; j < 64; j++) {
        //         s0 = rightRotate(scheduleArray[i][j-15], 7) ^
        //              rightRotate(scheduleArray[i][j-15], 18) ^
        //              (scheduleArray[i][j-15] >> 3);
                
        //         s1 = rightRotate(scheduleArray[i][j-2], 17) ^
        //              rightRotate(scheduleArray[i][j-2], 19) ^
        //              (scheduleArray[i][j] >> 10);
                
        //         scheduleArray[i][j] = scheduleArray[i][j-16] + s0 + scheduleArray[i][j-7] +s1;
        //     }

        //     // initialize working variables to current hash value
        //     long[] workingVars = {};
    
        //     for(int j = 0; j < 8; j++) {
        //         workingVars[j] = hVal[j];
        //     }
    
        //     // compression function
        //     for(int j = 0; j < 64; j++) {
        //         s1 = rightRotate(workingVars[4], 6) ^ rightRotate(workingVars[4], 25);
                
        //         ch = (workingVars[4] & workingVars[5]) ^
        //              (~(workingVars[4]) & workingVars[6]);
                
        //         temp1 = workingVars[7] + s1 + ch + kVal[j] + scheduleArray[i][j];
    
        //         s0 = rightRotate(workingVars[0], 2) ^
        //              rightRotate(workingVars[0], 13) ^
        //              rightRotate(workingVars[0], 22);
    
        //         maj = (workingVars[0] & workingVars[1]) ^
        //               (workingVars[0] & workingVars[2]) ^
        //               (workingVars[1] & workingVars[2]);
    
        //         temp2 = s0 + maj;
        //     }
    
        //     workingVars[7] = workingVars[6];
        //     workingVars[6] = workingVars[5];
        //     workingVars[5] = workingVars[4];
        //     workingVars[4] = workingVars[3] + temp1;
        //     workingVars[3] = workingVars[2];
        //     workingVars[2] = workingVars[1];
        //     workingVars[1] = workingVars[0];
        //     workingVars[0] = temp1 + temp2;
    
        //     // add compressed chunk to current hash value
        //     hVal[0] = hVal[0] + workingVars[0];
        //     hVal[1] = hVal[1] + workingVars[1];
        //     hVal[2] = hVal[2] + workingVars[2];
        //     hVal[3] = hVal[3] + workingVars[3];
        //     hVal[4] = hVal[4] + workingVars[4];
        //     hVal[5] = hVal[5] + workingVars[5];
        //     hVal[6] = hVal[6] + workingVars[6];
        //     hVal[7] = hVal[7] + workingVars[7];
        // }
            
        // Initialize final hash
        int[] finalHash = new int[8];

        // Append the hash
        for(int i = 0; i < 8; i++) {
            finalHash[i] = hVal[i];
        }

        return finalHash;
    }

    public static int[] pad(String message) {
        byte[] msg = message.getBytes();
        
        int remainder = (msg.length * 8) % 512;    // // Find the remainder in bits after dividing total size by 512 bits
        int words = (int) Math.ceil((msg.length * 8)/512) * 16;
        long lastIndex = msg.length;    // Find the index just beyond the last, used for appending
        byte brokenSize[] = longToBytes(lastIndex);   // Break the 64 bit size into a byte array, using typecasting

        int[] padded = new int[words];

        if (remainder > 448) // There is not enough space for the 64 bit size
        {
            msg[(int) lastIndex] = (byte) 0x80;
            lastIndex++;

            int fill = (512 - remainder - 8)/8;

            for (int hVal = 0; hVal < fill; hVal++)    // Fill with 0's up to next multiple of 512 bits
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
            }

            for (int i = 0; i < 56; i++)    // Append 56 bytes of 0's
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                msg[(int) lastIndex] = brokenSize[j];
                lastIndex++;
            }
            
            for (int k = 0; k < words; k++)
            {
                padded[k] = fromByteArray(Arrays.copyOfRange(msg, k*4, k*4+4));
            }
            return padded;
        }
        else if (remainder == 0)    // Exactly a multiple of 512 bits
        {
            msg[(int) lastIndex] = (byte) 0x80;  // Append 0b1000_0000
            lastIndex++;

            for (int i = 0; i < 55; i++)    // Append 55 bytes of 0's
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                msg[(int) lastIndex] = brokenSize[j];
                lastIndex++;
            }
            
            for (int k = 0; k < words; k++)
            {
                padded[k] = fromByteArray(Arrays.copyOfRange(msg, k*4, k*4+4));
            }
            return padded;
        }
        else    // There is space for the 64 bit size
        {
            int fill = (remainder - 64)/8;  // Determine the number of bytes needed to fill before the 64 bit size
            
            if ( fill > 0 )  // If there is any space to fill, start with 0b1000_0000
            {
                msg[(int) lastIndex] = (byte) 0x80;
                lastIndex++;    // Increment the index for appending
                fill--;     // Decrement the number of bytes needed to fill the necessary space
            }

            while ( fill >= 0 )  // Continue filling with 0's while there is space left to fill
            {
                msg[(int) lastIndex] = (byte) 0x00;
                lastIndex++;
                fill--;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                msg[(int) lastIndex] = brokenSize[j];
                lastIndex++;
            }
            
            for (int k = 0; k < words; k++)
            {
                padded[k] = fromByteArray(Arrays.copyOfRange(msg, k*4, k*4+4));
            }
            return padded;
        }
    }

    public static int rightRotate(int num, int rotateCount) {
        return (num >> rotateCount) | (num << 32 - rotateCount);
    }

// Courtesy of stack overflow contributors ///////////////////////
    public static byte[] longToBytes(long x) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.putLong(x);
        return buffer.array();
    }
    public static int fromByteArray(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }
//////////////////////////////////////////////////////////////////
    public static long appendBits(long val1, long val2) {
        return (val1 << 64) | val2;
    }
}








