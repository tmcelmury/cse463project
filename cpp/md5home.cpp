#include "md5home.h"
#include <String.h>

#define WORD_SIZE 32

const uint8_t[4] negI = [0, 3, 2, 1];
const uint8_t[4] one = [1, 0, 3, 2];
const uint8_t[4] two = [2, 1, 0, 3];
const uint8_t[4] three = [3, 2, 1, 0];
uint32_t[64] T;

uint32_t[] pad(uint8_t[]);
uint32_t[4] pass1(uint32_t[16], uint32_t[4]);
uint32_t[4] pass2(uint32_t[16], uint32_t[4]);
uint32_t[4] pass3(uint32_t[16], uint32_t[4]);
uint32_t[4] pass4(uint32_t[16], uint32_t[4]);
uint32_t F(uint32_t x, uint32_t y, uint32_t z);
uint32_t G(uint32_t x, uint32_t y, uint32_t z);
uint32_t H(uint32_t x, uint32_t y, uint32_t z);
uint32_t I(uint32_t x, uint32_t y, uint32_t z);
uint32_t leftRotate(uint32_t target, uint8_t n);
uint32_t[64] generateT();
const uint32_t[64] T = generateT();


uint32_t[4] MD5(uint8_t[] message)
{
    uint32_t[4] D = [0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476];
    
    uint32_t[] padded = pad(message);

    const unsigned long long numBlocks = padded.sizeof()/64;

    for (int i = 0; i < numBlocks; i++)
    {
        D = pass4(padded + (64 * i), pass3(padded + (64 * i), pass2(padded + (64 * i),
            pass1(padded + (64 * i), D))));
    }
    return D;
}

uint32_t[4] pass1(uint32_t[16] m, uint32_t[4] d)
{
    const uint8_t[4] shift = [7, 12, 17, 22];
    for (int i = 0; i < 16; i++)
    {
        d[negI[i%4]] = d[one[i%4]] + leftRotate( (d[negI[i%4]] +
                    F(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[i] + T[i]), shift[i%4]);
    }
    return d;
}
uint32_t[4] pass2(uint32_t[16] m, uint32_t[4] d)
{
    const uint8_t[4] shift = [5, 9, 14, 20];
    for (int j = 0; j < 16; j++)
    {
        d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                    G(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(5*i + 1)%16] + T[i + 16], shift[i%4]);
    }
    return d;
}
uint32_t[4] pass3(uint32_t[16] m, uint32_t[4] d)
{
    const int8_t[4] shift = [4, 11, 16, 23];
    for (int k = 0; k < 16; k++)
    {
        d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                    H(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(3*i + 5)%16] + T[i + 32], shift[i%4]);
    }
}
uint32_t[4] pass4(uint32_t[16] m, uint32_t[4] d)
{
    const uint8_t[4] shift = [6, 10, 15, 21];
    for (int l = 0; l < 16; l++)
    {
        d[negI[i%4]] = d[one[i%4]] + leftRotate( d[negI[i%4]] +
                    I(d[one[i%4]], d[two[i%4]], d[three[i%4]]) + m[(7*i)%16] + T[i + 48], shift[i%4]);
    }
}

uint32_t[] pad(uint8_t[] message)
{
    unsigned long long remainder = (message.sizeof() * 8) % 512;    // // Find the remainder in bits after dividing total size by 512 bits
    unsigned long long lastIndex = message.sizeof();    // Find the index just beyond the last, used for appending
    uint8_t[8] brokenSize = uint8_t[](lastIndex);   // Break the 64 bit size into a byte array, using typecasting

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
        return uint32_t[](message);
    }
    else if (remainder == 0)
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
        return uint32_t[](message);
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
        return uint32_t[](message);
    }
}

uint32_t leftRotate(uint32_t target, uint8_t n) { return (target << n) | (x >> (WORD_SIZE - n)); }
uint32_t F(uint32_t x, uint32_t y, uint32_t z) { return (x & y) | (~x & z); }
uint32_t G(uint32_t x, uint32_t y, uint32_t z) { return (x & z) | (y & ~z); }
uint32_t H(uint32_t x, uint32_t y, uint32_t z) { return x ^ y ^ z; }
uint32_t I(uint32_t x, uint32_t y, uint32_t z) { return y ^ (x | ~z); }
uint32_t generateT()
{
    uint32_t[64] T;
    for (int i = 0; i < 64; i++) { T[i] = uint32_t(floor(2^(WORD_SIZE) * abs(sin(i)))); }
    return T;
}