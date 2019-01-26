# README
This program includes graphic user interaction. When you open the program, run "mainGUI", and there will be two tabs -- "Question1" and "Question2". There will be a sample input for each question, and you can modify the inputs. After clicking "submit", the results will be shown under "result" panel on the right.
If you want to see the code for Question1 and Question2, you can go to the class "Question1" and "Question2". The methods implemented at the top are the main methods used for the pretask. The methods at the bottom are used for GUI design.
Thank you for reading.

Xinyi (Emilia)


# Instructions
1. Fork this repository
2. Complete the questions in any language of your choice
4. commit your code to the fork
3. Add a link to your forked repo in the application form
# Question 1
We say that Pattern is a most frequent k-mer in Text if it maximizes Count(Text, Pattern) among all k-mers. For example, "ACTAT" is a most frequent 5-mer in "ACAACTATGCATCACTATCGGGAACTATCCT", and "ATA" is a most frequent 3-mer of "CGATATATCCATAG".

**Find the most frequent k-mers in a string.**

**Given:** A DNA string Text and an integer k.

**Return:** All most frequent k-mers in Text (in any order).
### Sample Input
```
ACGTTGCATGTCGCATGATGCATGAGAGCT
4
```
### Sample Output
```
CATG GCAT
```
# Question 2
We say that a k-mer is shared by two genomes if either the k-mer or its reverse complement appears in each genome. In the figure below are four pairs of 3-mers that are shared by "AAACTCATC" and "TTTCAAATC".

![alt text](http://rosalind.info/media/problems/ba6e/shared_k-mers.png)

A shared k-mer can be represented by an ordered pair (x, y), where x is the starting position of the k-mer in the first genome and y is the starting position of the k-mer in the second genome. For the genomes "AAACTCATC" and "TTTCAAATC", these shared k-mers are (0,4), (0,0), (4,2), and (6,6).

**Given two strings, find all their shared k-mers.**

**Given:** An integer k and two strings.

**Return:** All k-mers shared by these strings, in the form of ordered pairs (x, y) corresponding to starting positions of these k-mers in the respective strings.
### Sample Input
```
3
AAACTCATC
TTTCAAATC
```
### Sample Output
```
(0, 4)
(0, 0)
(4, 2)
(6, 6)
```
