package sentences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SentenceTransformer {
    private void isValidSentence(String sentence){
        char[] charArray=sentence.toCharArray();
        if(!isUpperCase(charArray[0])){
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        if(!isFinishedWithProperEndingCharacter(charArray[charArray.length-1])){
            throw new IllegalArgumentException("Must end with . ! or ?");
        }
    }

    private boolean isFinishedWithProperEndingCharacter(char c) {
        List<Character> validCharacters= Arrays.asList('.','!','?');
        return(validCharacters.contains(c));
    }

    private boolean isUpperCase(char c) {
        return Character.isUpperCase(c);
    }

    public String shortenSentence(String sentence){
        isValidSentence(sentence);
        String output=transformSentence(sentence);
        return output;
    }

    private String transformSentence(String sentence) {
        String[] wordsArray;
        wordsArray=sentence.split(" ");
        if(wordsArray.length<5){
            return sentence;
        }
        StringBuilder sb=new StringBuilder();
        sb.append(wordsArray[0]);
        sb.append(" ... ");
        sb.append(wordsArray[wordsArray.length-1]);
        return sb.toString();
    }
}
