

uint32_t[4] MD5(uint8_t[] message);
uint32_t[] pad(uint8[]);
uint32_t[] pass1(uint32_t[]);
uint32_t[] pass2(uint32_t[]);
uint32_t[] pass3(uint32_t[]);
uint32_t[] pass4(uint32_t[]);
uint32_t F(uint32_t x, uint32_t y, uint32_t z);
uint32_t G(uint32_t x, uint32_t y, uint32_t z);
uint32_t H(uint32_t x, uint32_t y, uint32_t z);
uint32_t I(uint32_t x, uint32_t y, uint32_t z);
