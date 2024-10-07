public class Main {
    public static void main(String[] args) {
        String[] words = {"c", "ac", "ciao", "pippo"};

        for (String word : words) {
            String result;
            if(word.length()<2) System.out.println("Stringa corta");
            else {
                result=word.substring(word.length()/2)+word.substring(0,word.length()/2);
                System.out.println(result);
            }
        }
    }
}