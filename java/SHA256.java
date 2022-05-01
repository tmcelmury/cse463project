import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.concurrent.TimeUnit;
//import java.security.NoSuchAlgorithmException;

class SHA_256 {
    // method invoking built-in SHA-256 funcitonality
    public static byte[] getSHABuiltIn(String text) {
        MessageDigest dig = MessageDigest.getInstance("SHA-256");

        return dig.digest(text.getBytes(StandardCharsets.UTF_8));
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
    public static String getSHAImplemented(String text) {
        // initialize hash values representing first 32 bits of
        // the fractional parts of the square roots of the first
        // 8 prime numbers (2, 3, 5, 7, 11, 13, 17, 19)
        byte hValues = [0x6a09e667, 0xbb67ae85, 0x3c6ef372, 0xa54ff53a, 0x510e527f, 0x9b05688c, 0x1f83d9ab, 0x5be0cd19];

        // initialize rounded constants representing first 32 bits
        // of the fractional parts of the cube roots of the first
        // 64 prime numbers (2-311)
        byte kValues = [0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
                        0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
                        0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
                        0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
                        0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
                        0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
                        0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
                        0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2];

        // convert message text to binary/byte format
        byte[] byteText = text.getBytes(UTF_8);

        // find how many additional bits are needed to reach the next
        // multiple of 512 in the original message text
        int bitCountMod512 = text.length() * 8 mod 512;
        

        // append binary 1 followed by 0s until the bit count reaches
        // the next multiple of 512
        byteText << 1;
        
        if(bitCountMod512 > 64) {
            // pad to finish current multiple of 512, minus 64
            for(int i = 1; i < bitCountMod512 - 64; i++) {
                (byteText << 1);
            }
        } else {
            // pad to next multiple of 512, minus 64
            for(int i = 0; i < bitCountMod512 + 448; i++) {
                (byteText << 1);
            }
        }
        
        // convert byteText to bit string, append 64-bit string
        // of size bits, and convert whole thing back to byte
        int textSize = text.length() * 8;
        String sizeAppend = String.format("%64s", Integer.toBinaryString(textSize));
        String fullText = String.getBytes( (Integer.toBinaryString(byteText)).append(sizeAppend, 2);
    }

    public static void main(String args[]) {
        // initialize time variables for built-in method
        long startTimeBuiltIn = 0;
        long endTimeBuiltIn = 0;
        long timeElapsedBuiltIn = 0;

        // initialize time variables for our implementation
        long startTimeImplemented = 0;
        long endTimeImplemented = 0;
        long timeElapsedImplemented = 0;

        // string to be hashed and used as a baseline for the comparison
        String stringToHash = "This is our CSCE 463 final project";

        // time the built-in hash method
        startTimeBuiltIn = System.nanoTime();
        String hashBuiltIn = toHexString(getSHABuiltIn(stringToHash));
        endTimeBuiltIn = System.nanoTime();

        // find time taken by built-in hash method
        timeElapsedBuiltIn = endTimeBuiltIn - startTimeBuiltIn;

        // time our implemented hash method
        startTimeImplemented = System.nanoTime();
        String hashImplemented = toHexString(getSHA256(stringToHash))
        endTimeImplemented = System.nanoTime();
        
        // find time taken by our implemented hash method
        timeElapsedImplemented = endTimeImplemented - startTimeImplemented;

        // display results
        System.out.println("Message to be hashed:")
        System.out.println(stringToHash"\n")

        System.out.println("Hash from built-in method:")
        System.out.println(hashBuiltIn);
        System.out.println("Time taken: " + timeElapsedBuiltIn + " ns");

        System.out.println("Hash from our implementation:")
        System.out.println(hashImplemented);
        System.out.println("Time taken: " + timeElapsedImplemented + " ns")
    }
}