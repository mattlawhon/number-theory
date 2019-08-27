# number-theory

During the spring of my Freshman year at Columbia, I took [Number Theory and Cryptography](http://math.columbia.edu/~makisumi/courses/19s3020/) with Professor David Hansen.

The course was largely divided into two parts: an introduction to number theory and some particular cool examples which were given one to two lectures each. In the second portion of the course, we examined primes of the form: ![Magioladitis, 1](https://github.com/mattlawhon/number-theory/blob/master/img/statement.png)

We call *N* convenient if, for a finite set of primes *S*, there exist

![Hagedorn, 1](https://github.com/mattlawhon/number-theory/blob/master/img/convenient.png)

To our knowledge, there are between 65 and 67 convenient numbers, and all 65 known numbers are listed in the following table: ![Hagedorn, 1](https://github.com/mattlawhon/number-theory/blob/master/img/table.png)

When expounding "inconvenient" numbers, we must generalize our methods for describing primes of this form. A central theorem to this topic is as follows, articulated by Magioladitis:
![Magioladitis, 17](https://github.com/mattlawhon/number-theory/blob/master/img/theorem.png)

## The Problem
The smallest "inconvenient" number is 11. Just how inconvenient is it? Quite. Before our lecture on this topic, Professor Hansen was unable to calculate f11 by traditional means. He offered the problem of determining f11 to our class as a bonus problem. It wasn't just any bonus problem, however, because he offered 50 points on the final to any student who could calculate f11.

## The Solution
First, we have to calculate the (-11/p) (where this is the [Legendre Symbol](https://en.wikipedia.org/wiki/Legendre_symbol), not division). Applying rules of the Legendre symbol we find that (-11/p) = (p/11) = (1 if p = 1, 3, 4, 5, 9 (mod 11), 0 if p = 11, -1 otherwise). We then implement a brute force algorithm which identifies a polynomial which has an integer solution mod p for all p such that (-11/p) = 1 and no p such that (-11/p) = -1. The program, `NumberTheoryExtraCredit.java` leverages additional aspects of theorem 2.1.1. to efficiently implement this brute force algorithm to search for f11.

## Citations
- Magioladitis, Marios. (2004). Primes of the form x2+ ny2. The paper can be found in its entirety [here](https://www.researchgate.net/publication/228725885_Primes_of_the_form_x_2_ny_2).
- Hagedorn, Thomas. (2011). Primes of the form x2+ ny2 and the Geometry of (Convenient) Numbers. The paper can be found in its entirety [here](http://math.uga.edu/~pete/Hagedorn11.pdf).
