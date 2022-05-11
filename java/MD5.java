package hash;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public static class MD5 {
    byte[] negI = {0, 3, 2, 1};
    byte[] one = {1, 0, 3, 2};
    byte[] two = {2, 1, 0, 3};
    byte[] three = {3, 2, 1, 0};
    int[] T;


    // algorithm courtesy of bilal-hungund on GeeksforGeeks
    // https://www.geeksforgeeks.org/md5-hash-in-java/
    public static String getMD5BuiltIn(String message) {
        // Static getInstance method is called with hashing MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // digest() method is called to calculate message digest
        //  of an input digest() return array of byte
        byte[] messageDigest = md.digest(input.getBytes());

        // Convert byte array into signum representation
        BigInteger no = new BigInteger(1, messageDigest);

        // Convert message digest into hex value
        String hashtext = no.toString(16);
        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }
        return hashtext;
    }

    public static int[] getMD5Implemented(byte[] message) {
        int[] D = {0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476};
        
        int[] padded = pad(message);

        long numBlocks = padded.sizeof()/64;

        for (int i = 0; i < numBlocks; i++) {
            D = pass4(padded + (64 * i), pass3(padded + (64 * i), pass2(padded + (64 * i),
                pass1(padded + (64 * i), D))));
        }
        return D;
    }

    public static int[] pad(byte[] message) {
        long remainder = (message.sizeof() * 8) % 512;    // // Find the remainder in bits after dividing total size by 512 bits
        long lastIndex = message.sizeof();    // Find the index just beyond the last, used for appending
        byte[] brokenSize = (lastIndex);   // Break the 64 bit size into a byte array, using typecasting

        if (remainder > 448) // There is not enough space for the 64 bit size
        {
            message[lastIndex] = 0x80;
            lastIndex++;

            int fill = (512 - remainder)/8;

            for (int h = 0; h < (fill - 1); h++)    // Fill with 0's up to next multiple of 512 bits
            {
                message[lastIndex] = 0x00;
                lastIndex++;
            }

            for (int i = 0; i < 56; i++)    // Append 56 bytes of 0's
            {
                message[lastIndex] = 0x00;
                lastIndex++;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                message[lastIndex] = brokenSize[j];
                lastIndex++;
            }
            return Byte.toUnsignedInt(message);
        }
        else if (remainder == 0)    // Exactly a multiple of 512 bits
        {
            message[lastIndex] = 0x80;  // Append 0b1000_0000
            lastIndex++;

            for (int i = 0; i < 55; i++)    // Append 55 bytes of 0's
            {
                message[lastIndex] = 0x00;
                lastIndex++;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                message[lastIndex] = brokenSize[j];
                lastIndex++;
            }
            return Byte.toUnsignedInt(message);
        }
        else    // There is space for the 64 bit size
        {
            int fill = (remainder - 64)/8;  // Determine the number of bytes needed to fill before the 64 bit size
            
            if (fill > 0 )  // If there is any space to fill, start with 0b1000_0000
            {
                message[lastIndex] = 0x80;
                lastIndex++;    // Increment the index for appending
                fill--;     // Decrement the number of bytes needed to fill the necessary space
            }

            while ( fill >= 0)  // Continue filling with 0's while there is space left to fill
            {
                message[lastIndex] = 0x00;
                lastIndex++;
                fill--;
            }

            for (int j = 0; j < 8; j++) // Append size bytes to array
            {
                message[lastIndex] = brokenSize[j];
                lastIndex++;
            }
            return Byte.toUnsignedInt(message);
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
            d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                        G(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(5*i + 1)%16] + T[i + 16], shift[i%4]);
        }
        return d;
    }
    public static int[] pass3(int[] m, int[] d) {
        int8_t[] shift = {4, 11, 16, 23};
        for (int k = 0; k < 16; k++)
        {
            d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                        H(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(3*i + 5)%16] + T[i + 32], shift[i%4]);
        }
    }
    public static int[] pass4(int[] m, int[] d) {
        byte[] shift = {6, 10, 15, 21};
        for (int l = 0; l < 16; l++)
        {
            d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                        I(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(7*i)%16] + T[i + 48], shift[i%4]);
        }
    }

    public static int leftRotate(int target, byte n) { return (target << n) | (x >> (32 - n)); }
    public static int F(int x, int y, int z) { return (x & y) | (~x & z); }
    public static int G(int x, int y, int z) { return (x & z) | (y & ~z); }
    public static int H(int x, int y, int z) { return x ^ y ^ z; }
    public static int I(int x, int y, int z) { return y ^ (x | ~z); }

    public static int generateT() {
        int[] T;
        for (int i = 0; i < 64; i++) { T[i] = Double.toUnsignedInt(floor(2^(32) * abs(sin(i)))); }
        return T;
    }
}