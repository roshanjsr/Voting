# Voting
Java project to solve a voting problem using map red

What this project does: In an unusual democracy, everyone is not equal. The vote count is a function of worth of the voter. Though everyone is voting for
each other. As example, if A with a worth of 5 and B with a worth of 1 are voting for C, the vote count of C would be 6.
You are given a list of people with their value of vote. You are also given another list describing who voted for who all.

List1
Voter Votee
A     C
B     C
C     F
A     B

List2
Person Worth
A     5
B     1
C     11

Output: 
Person VoteCount
A     0
B     5
C     6
F     11

How to run it: Import the project in eclipse and create a JAR. Copy the jar file onto the local machine with Hadoop and use the hadoop streaming command similar to what's given below to execute it:

"$ hadoop jar package_name.driver_class_name input_file_location_on_HDFS interim_output_location_on_HDFS output_location_on_HDFS"

Note: The interim output file in the above example serves as the input for the second mapper reducer.

You can visit www.knowbigdata.com for more details and courses on Hadoop and Hadoop related technologies.
