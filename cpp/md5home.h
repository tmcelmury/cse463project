#ifndef MD5HOME_H
#define MD5HOME_H

uint32_t * MD5(std::vector<char>);
uint32_t * pad(std::vector<char>);
uint32_t * pass1(uint32_t * [], uint32_t * []);
uint32_t * pass2(uint32_t * [], uint32_t * []);
uint32_t * pass3(uint32_t * [], uint32_t * []);
uint32_t * pass4(uint32_t * [], uint32_t * []);
uint32_t F(uint32_t, uint32_t, uint32_t);
uint32_t G(uint32_t, uint32_t, uint32_t);
uint32_t H(uint32_t, uint32_t, uint32_t);
uint32_t I(uint32_t, uint32_t, uint32_t);
uint32_t * generateT();

#endif