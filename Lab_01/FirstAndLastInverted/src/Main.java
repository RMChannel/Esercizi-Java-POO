public class Main {
    public static void main(String[] args) {
        String[] words = {"c", "ac", "pippo"};

        for (String word : words) {
            String result;

            if(word.length()<2) System.out.println("Stringa corta");
            else {
                result=word.charAt(word.length()-1)+word.substring(1,word.length()-1)+word.charAt(0);
                System.out.println(result);
            }
        }
    }
}