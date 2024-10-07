public class Main {
    public static void main(String[] args) {
        String[] words = {"pippo", "pluto", "alice", "bob"};

        for (String word : words) {
            String middleChar;
            middleChar = word.charAt(word.length()/2) + "";
            System.out.println(middleChar);
        }
    }
}