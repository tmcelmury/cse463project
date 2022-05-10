#ifndef SHA256_H
#define SHA256_H

uint32_t* SHA256(std::vector<char>);

uint32_t* pad(std::vector<char>);

uint32_t rightRotate(uint32_t, unsigned int);

uint64_t append(uint64_t, uint64_t);

#endif