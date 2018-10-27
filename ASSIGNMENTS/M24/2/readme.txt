Given the data in the form of comma separated values, you have to lookup (Search) for the data in the given range in average logarithmic time complexity.

Following is the student data format:
roll_number,student_name,total_marks
Note: total marks is double

Types of Queries:
Find the names of the students who got the total marks between M1 and M2 (both inclusive)
Find the total number of students who got >=M1 marks.
Find the total number of students who got <=M1 marks.

Query data formats:
BE 70.32 60.0
LE 32.3
GE 85.5

Explanation
for "BE 70.32 60.0" you need to print the name of all the student who got marks >=70.32 and <=60.0
for "LE 32.3" you need to print the names of all the student who got marks <=32.3
for "GE 85.5" you need to print the names of all the students who got marks >=85.5

Input format:
First line of input is an Integer N, represents no.of student data records
from second line to N lines represent student data
Next line contains an integer M, represents no.of queries
following M lines represents queries data

Output format:
Print the names of the students based on the query.

Note: each test case carry 1 mark.
