Description :
=============
You have a cricket team information and you need to sort them based on certain criterion. The data is given as a list of rows, where each row has the following format

Assuming that each Team name is unique, you have to foam a leader board

For example on the following data

TeamName #Wins #Losses #Draws

England 	4 	2 		3
India 		5 	2 		4
Australia 	6 	2 		3
SouthAfrica 5 	3 		4
Bangladesh 	3 	4 		2
Zimbabwe 	3 	4 		6
Ireland 	3 	4 		1

Sort Criteria:
==============
Sort the teams in descending order based on the attribute Wins. If two teams have same number of wins, then sort them in ascending order based on attribute losses and if two teams have same number of losses then sort them in descending order based on attribute draws.

input:
=================
each line of the input consists of Name of the team, No of wins, No of losses, No of draws seperated with commas.

Output
===========
print the names of the team in the leader board from first to last seperated with a comma



Sample testcase
======================

Input:
England,4,2,3
India,5,2,4
Australia,6,2,3
SouthAfrica,5,3,4
Bangladesh,3,4,2
Zimbabwe,3,4,6
Ireland,3,4,1


Output:
Australia,India,SouthAfrica,England,Zimbabwe,Bangladesh,Ireland


