## Prime Factor

Write a class named “PrimeFactors” that has one static method: generate.

The generate method takes an integer argument and returns a List. That list contains the prime factors in numerical sequence.

For example:

    100 should return 2, 2, 5, 5
    2 should return 2
    Smaller than 2 should return an empty list

### Additional Functionality

After you are done, update solution to print the prime factor decomposition in the following format:

`(p1**n1)(p2**n2)...(pk**nk)`

where `a ** b` means a to the power of b

with the p(i) in increasing order and n(i) empty if n(i) is 1.

Example: `n = 86240` should return `(2**5)(5)(7**2)(11)`
