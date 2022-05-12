package hash;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.nio.ByteBuffer;
import java.lang.Math;

public class MD5 {
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