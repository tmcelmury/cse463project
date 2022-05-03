

#define WORD_SIZE 32

class MD5 {
    const byte[4] negI = [0, 3, 2, 1];
    const byte[4] one = [1, 0, 3, 2];
    const byte[4] two = [2, 1, 0, 3];
    const byte[4] three = [3, 2, 1, 0];
    int[64] T;


    public int[4] MD5(byte[] message) {
        int[4] D = [0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476];
        
        int[] padded = pad(message);

        const unsigned long long numBlocks = padded.sizeof()/64;

        for (int i = 0; i < numBlocks; i++) {
            D = pass4(padded + (64 * i), pass3(padded + (64 * i), pass2(padded + (64 * i),
                pass1(padded + (64 * i), D))));
        }
        return D;
    }

    public int[] pad(byte[] message) {
        unsigned long long remainder = (message.sizeof() * 8) % 512;    // // Find the remainder in bits after dividing total size by 512 bits
        unsigned long long lastIndex = message.sizeof();    // Find the index just beyond the last, used for appending
        byte[8] brokenSize = byte[](lastIndex);   // Break the 64 bit size into a byte array, using typecasting

        if (remainder > 448) // There is not enough space for the 64 bit size
        {
            message[lastIndex] = 0x80;
            lastIndex++;

            unsigned int fill = (512 - remainder)/8;

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
                message[lastIndex] = brokenSize[j]
                lastIndex++;
            }
            return int[](message);
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
                message[lastIndex] = brokenSize[j]
                lastIndex++;
            }
            return int[](message);
        }
        else    // There is space for the 64 bit size
        {
            unsigned int fill = (remainder - 64)/8;  // Determine the number of bytes needed to fill before the 64 bit size
            
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
                message[lastIndex] = brokenSize[j]
                lastIndex++;
            }
            return int[](message);
        }
    }

    public int[4] pass1(int[16] m, int[4] d) {
        const byte[4] shift = [7, 12, 17, 22];
        for (int i = 0; i < 16; i++)
        {
            d[negI[i%4]] = d[one[i%4]] + leftRotate( (d[negI[i%4]] +
                        F(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[i] + T[i]), shift[i%4]);
        }
        return d;
    }
    public int[4] pass2(int[16] m, int[4] d) {
        const byte[4] shift = [5, 9, 14, 20];
        for (int j = 0; j < 16; j++)
        {
            d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                        G(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(5*i + 1)%16] + T[i + 16], shift[i%4]);
        }
        return d;
    }
    public int[4] pass3(int[16] m, int[4] d) {
        const int8_t[4] shift = [4, 11, 16, 23];
        for (int k = 0; k < 16; k++)
        {
            d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                        H(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(3*i + 5)%16] + T[i + 32], shift[i%4]);
        }
    }
    public int[4] pass4(int[16] m, int[4] d) {
        const byte[4] shift = [6, 10, 15, 21];
        for (int l = 0; l < 16; l++)
        {
            d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                        I(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(7*i)%16] + T[i + 48], shift[i%4]);
        }
    }

    public int leftRotate(int target, byte n) { return (target << n) | (x >> (WORD_SIZE - n)); }
    public int F(int x, int y, int z) { return (x & y) | (~x & z); }
    public int G(int x, int y, int z) { return (x & z) | (y & ~z); }
    public int H(int x, int y, int z) { return x ^ y ^ z; }
    public int I(int x, int y, int z) { return y ^ (x | ~z); }

    public int generateT() {
        int[64] T;
        for (int i = 0; i < 64; i++) { T[i] = int(floor(2^(WORD_SIZE) * abs(sin(i)))); }
        return T;
    }
}