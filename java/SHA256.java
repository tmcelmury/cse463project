import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

class SHA256 {
    // method invoking built-in SHA-256 funcitonality
    // modified version of algorithm provided by bilal-hungund on GeeksforGeeks
    // https://www.geeksforgeeks.org/sha-256-hash-in-java/
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
    public static uint32_t getSHAImplemented(String message) {
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

        // pad the message to multiple of 512 bits
        uint32_t padded = pad(message);

        
        unsigned long long numBlocks = padded.getBytes() * 8 / 512;
        uint32_t messageChunks[numBlocks];

        // separate padded message into 512-bit chunks
        for(int i = 0; i < numBlocks; i++) {
            messageChunks[i] = (padded >> (512 * (numBlocks - i - 1))) & 0xffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff;
        }

        // initialize schedule array
        uint32_t[numBlocks][64] scheduleArray;

        // initial values don't matter, so fill with 0s
        for(int i = 0; i < numBlocks; i++) {
            for(int j = 0; j < 64; j++) {
                scheduleArray[i][j] = 0;
            }
        }

        // copy chunk into first 16 words of schedule array
        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 64; j++) {
                scheduleArray[i][j] = (messageChunk[0] >> (32 * (16 - i - 1))) & 0xffffffff;
            }
        }

        // initialize temp variables
        uint32_t s0 = 0;
        uint32_t s1 = 0;
        uint32_t ch = 0;
        uint32_t maj = 0;
        uint32_t temp1 = 0;
        uint32_t temp2 = 0

        // extend first 16 words of schedule array into remaining 48 words
        for(int i = 16; i < 64; i++) {
            s0 = rightRotate(scheduleArray[i-15], 7) ^
                 rightRotate(scheduleArray[i-15], 18) ^
                 (scheduleArray[i-15] >> 3);
            
            s1 = rightRotate(scheduleArray[i-2], 17) ^
                 rightRotate(scheduleArray[i-2], 19) ^
                 (scheduleArray[i] >> 10);
            
            scheduleArray[i] = scheduleArray[i-16] + s0 + scheduleArray[i-7] +s1;
        }

        // initialize working variables to current hash value
        uint64_t[8] workingVar;

        for(int i = 0; i < 8; i++) {
            workingVars[i] = hValues[i];
        }

        // compression function
        for(i = 0; i < 64; i++) {
            s1 = rightRotate(workingVars[4], 6) ^ rightRotate(workingVars[4], 25);
            
            ch = (workingVars[4] & workingVars[5]) ^
                 (~(workingVars[4]) & workingVars[6]);
            
            temp1 = workingVars[7] + s1 + ch + kValues[i] + scheduleArray[i];

            s0 = rightRotate(workingVars[0], 2) ^
                 rightRotate(workingVars[0], 13) ^
                 rightRotate(workingVars[0], 22);

            maj = (workingVars[0] & workingVars[1]) ^
                  (workingVars[0] & workingVars[2]) ^
                  (workingVars[1] & workingVars[2]);

            temp2 = s0 + maj;
        }

        workingVars[7] = workingVars[6];
        workingVars[6] = workingVars[5];
        workingVars[5] = workingVars[4];
        workingVars[4] = workingVars[3] + temp1;
        workingVars[3] = workingVars[2];
        workingVars[2] = workingVars[1];
        workingVars[1] = workingVars[0];
        workingVars[0] = temp1 + temp2;

        // add compressed chunk to current hash value
        hValues[0] = hValues[0] + workingVars[0];
        hValues[1] = hValues[1] + workingVars[1];
        hValues[2] = hValues[2] + workingVars[2];
        hValues[3] = hValues[3] + workingVars[3];
        hValues[4] = hValues[4] + workingVars[4];
        hValues[5] = hValues[5] + workingVars[5];
        hValues[6] = hValues[6] + workingVars[6];
        hValues[7] = hValues[7] + workingVars[7];

        // produce final hash
        int finalHash = 0;

        for(int i = 0; i < 8; i++) {
            finalHash = finalHash.appendBits(hValues[i]);
        }

        return finalHash;
    }

    public static uint32_t pad(uint8_t[] message) {
        // find the remainder in bits after dividing total size by 512 bits
        unsigned long long remainder = (message.sizeof() * 8) % 512;
        
        // find the index just beyond the last, used for appending
        unsigned long long lastIndex = message.sizeof();

        // break the 64 bit size into a byte array, using typecasting
        uint8_t[8] brokenSize = uint8_t[](lastIndex);

        if (remainder > 448) {
            // there's not enough space for the 64-bit size
            message[lastIndex] = 0x80;
            lastIndex++;

            unsigned int fill = (512 - remainder)/8;

            // fill with 0's up to next multiple of 512 bits
            for(int h = 0; h < (fill - 1); h++) {
                message[lastIndex] = 0x00;
                lastIndex++;
            }

            // append 56 bytes of 0's
            for(int i = 0; i < 56; i++) {
                message[lastIndex] = 0x00;
                lastIndex++;
            }

            // append size bytes to array
            for(int j = 0; j < 8; j++) {
                message[lastIndex] = brokenSize[j]
                lastIndex++;
            }
            
            return uint32_t[](message);

        } else if(remainder == 0) {
            // exactly a multiple of 512 bits
            // append 0b1000_0000
            message[lastIndex] = 0x80;
            lastIndex++;

            // append 55 bytes of 0's
            for(int i = 0; i < 55; i++) {
                message[lastIndex] = 0x00;
                lastIndex++;
            }

            // append size bytes to array
            for(int j = 0; j < 8; j++) {
                message[lastIndex] = brokenSize[j]
                lastIndex++;
            }

            return uint32_t[](message);
        
        } else {
            // there is space for the 64 bit size
            // determine the number of bytes needed to fill before the 64 bit size
            unsigned int fill = (remainder - 64)/8;

            // if there is any space to fill, start with 0b1000_0000
            if(fill > 0 ) {
                message[lastIndex] = 0x80;
                
                // increment the index for appending
                lastIndex++;
                
                // decrement the number of bytes needed to fill the necessary space
                fill--;
            }

            while(fill >= 0) {
                // continue filling with 0's while there is space left to fill
                message[lastIndex] = 0x00;
                lastIndex++;
                fill--;
            }

            // append size bytes to array
            for(int j = 0; j < 8; j++) {
                message[lastIndex] = brokenSize[j]
                lastIndex++;
            }

            return uint32_t[](message);
        }
    }

    public static uint32_t rightRotate(uint32_t num, int rotateCount) {
        return (num >> rotateCount) | (num << 32 - rotateCount);
    }

    public static uint64_t appendBits(uint64_t val1, uint64_t val2) {
        return (val1 << 64) | val2;
    }
}