#ifndef SHA256_H
#define SHA256_H

uint32_t[4] SHA256(uint8_t[] message);

uint32_t[] pad(uint8_t[] message);

uint32_t rightRotate(uint32_t num, unsigned int rotateCount);

uint64_t append(uint64_t val1, uint64_t val2);

#endif