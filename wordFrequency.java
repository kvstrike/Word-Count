
import java.io.*;
import java.util.*;

public class wordFrequency {

    public static void main(String[] args) throws IOException {
        //create a file object
        File file = new File("hello.txt");
        
        //create a scanner object to read the file
        Scanner input = new Scanner(file);

        //create a hash map to store the frequency of each word
        Map<String, Integer> freg = new HashMap<>();

        while(input.hasNext()) {
            //read next word and convert to lower case sot that "Hello" and "hello" are counted as the same word
            String word = input.next().toLowerCase();

            word = word.replaceAll("[^a-zA-Z]", ""); //remove punctuation and non-alphabetic characters

            if(word.isEmpty()) {
                continue; //skip empty words
            }

            //update the frequency of the word in the hash map
            freg.put(word, freg.getOrDefault(word, 0) + 1);
        }

        input.close();

        System.out.println("Word Frequency:");
        for(Map.Entry<String, Integer> entry : freg.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    
}
