Word Anagram
Requirements:

    Input: a set of input characters, ranging from a-z, case-insensitive.
    Output: all the possible English words from the dictionary that could be composed of these characters, case-insensitive.
    The possible English words could be fetched from, for example,  https://raw.githubusercontent.com/lad/words/master/words which is a copy of /usr/share/dict/words.
    Ensure the main program can be run in https://coderpad.io/

 

Deliverable

    Submit your code to github.com and email us the link of your code repo, where the repo contains the following.
    One source code file for the main program.
    One runme.sh bash script to (compile and) run the program on Linux or Mac terminal.
    [Optional] one README file with additional instructions, if needed.
    [Bonus] one additional file with test cases.


How to test

    git clone git clone https://github.com/username/xyz.git
    cd xyz && ./runme.sh


OutCome:

Requirements

    Maven 3 (using mvn 4.0.0 version)
    Java 8 (using 1.8.0_171)

#How to build

In terminal run command:

    mvn clean install

How to run

   After building, run:

    ./run.sh <given string/character>

# Example:
    ./run.sh "dog"

Or calling jar directly:

    java -jar target/Anagram-1.0-SNAPSHOT-jar-with-dependencies.jar <given string/character>



    java -jar target/Anagram-1.0-SNAPSHOT-jar-with-dependencies.jar "dog"

Output:

    Given input is dog, start running.....
    The following words are anagrams of given input:
    god
