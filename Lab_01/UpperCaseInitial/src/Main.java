public class Main {
    public static void main(String[] args) {
        String[] words = {"", "a", "alice", "bob", "pippo", "pluto"};

        for (String word : words) {
            String result="";
            if(!word.isEmpty()) result=word.substring(0,1).toUpperCase()+word.substring(1);
            System.out.println(result);
        }
    }
}