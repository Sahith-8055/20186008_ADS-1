Input format:
first line contains an int(N) represents no.of students qualified
Second line contains an int represent no.of vacancies
Thirst line contains an int represent no.of unreserved category vacancies
Fourth line contains an int represents no.of BC category vacancies
Fifth line contains an int represents no.of SC category vacancies
Sixth line contains an int represents no.of ST category vacancies
Following N lines represents student information

each line of Student information representation:
Student Name, Date of birth, subject1 marks, subject2 marks, subject3 marks, Total marks, Reservation category
All the student information seperated with commas respectively


Output format:
Print student name, total marks, Reservation category of the student object in Descending merit order in given format
print an empty line
print list of all the students who filled the vacancies in Descending merit order in given format.


merit order:
student who got more total marks will be given the priority
if total marks are equal then student who got more marks in subject 3 will be given the priority. 
if subject 3 marks are equal then student who got more marks in subject 2 will be given the priority. 
if subject 2 marks are equal then younger student will be given priority.

Reservation criteria:
All applicants are eligible for un reserved category seats
Un reserved category seats should be filled with descending merit order
reserved seats should be filled with reserved students in descending merit order
if any of the reserved seats are left with out reserved candidates then fill the seats with descending merit order 