Given the student data in the form of comma separated values, you have to lookup (Search) for the data in average constant time complexity.

Following is the student data format:
roll_number,student_name,total_marks
Note: total marks is double

Types of Queries:
Find the name of the student for the given roll number.
Find the total marks of the student for the given roll number.

Query data formats:
get roll_number 1
get roll_number 2

Explanation
for "get roll_number 1" you need to print the name of student for the given roll number
for "get roll_number 2" you need to print the marks of the student for the given roll number

Input format:
First line of input is an Integer N, represents no.of student data records
from second line to N lines represent student data
Next line contains an integer M, represents no.of queries
following M lines represents queries data

Output format:
Print the respective values for each query

Note: each test case carry 1 mark.
