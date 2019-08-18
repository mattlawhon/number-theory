# number-theory

During the spring of my Freshman year at Columbia, I took [Number Theory and Cryptography](http://math.columbia.edu/~makisumi/courses/19s3020/) with Professor David Hansen.

The course was largely divided into two parts: an introduction to number theory and some particular cool examples which were given one to two lectures each. In the second portion of the course, we examined primes of the form: ![Magioladitis, 1](https://github.com/mattlawhon/number-theory/blob/master/img/statement.png)

Prime numbers of this form have been studied extensively. A central theorem to describing them is as follows, articulated by Magioladitis:
![Magioladitis, 17](https://github.com/mattlawhon/number-theory/blob/master/img/theorem.png)

## The Problem

It turns out, one of the most complicated cases for these prime numbers occurs when n=11. Specifically, it is very difficult to calculate the monic irreducible polynomial f11. In fact, before our lecture on this topic Dr. Hansen spent hours trying to calculate f11, but he was unable to. He offered the problem to our class as a bonus problem. It wasn't just any bonus problem, however, because he offered 50 points on the final to any student who could calculate f11.

This is precisely what the program, `NumberTheoryExtraCredit.java` does. It runs a brute force algorithm which has been exhaustively optimised to identify the appropriate polynomial in a reasonable period of time. 


Citation - Magioladitis, Marios. (2004). Primes of the form x 2+ ny 2. The paper can be found in its entirety [here](https://www.researchgate.net/publication/228725885_Primes_of_the_form_x_2_ny_2).
