public class Main {
    public static void replace(StringBuilder newSentence, String sentence, char c1, String c2) {
        int i=0;
        while(sentence.indexOf(c1,i)!=-1) {
            newSentence.replace(sentence.indexOf(c1,i),sentence.indexOf(c1,i)+1,c2);
            i=sentence.indexOf(c1,i)+1;
        }
    }
    public static void main(String[] args) {
        String sentence = "Hello, World!";
        StringBuilder newSentence = new StringBuilder();
        newSentence.append(sentence);
        replace(newSentence,sentence,'e',"o");
        replace(newSentence,sentence,'o',"e");
        System.out.println(newSentence);
    }
}