# Welcome Students of 4156

Please follow the assignment specifications on Courseworks when completing this project.

I used PMD as my static bug finder. Instructions are:
- Download and install PMD using the quickstart instructions
- From the $HOME location, run the following command:
pmd check -d [Path-to-project-repository]/4156-Miniproject-2024-Students-Java/IndividualProject/src -R rulesets/java/quickstart.xml -f text
For example, my command was:
pmd check -d Documents/Columbia/Advanced\ Software\ Engineering/Assignments/4156-Miniproject-2024-Students-Java/IndividualProject/src -R rulesets/java/quickstart.xml -f text

Code coverage analysis was done using Jacoco with the following command from the IndividualProject folder:
mvn jacoco:report 