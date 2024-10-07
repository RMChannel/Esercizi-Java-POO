public class Main {
    public static void main(String[] args) {
        String[] words = {"", "a", "sasso", "pippo", "test"};

        for (String word : words) {
            int position = -1;
            if(word.length()>1) {
                String temp = word.substring(1);
                position=temp.indexOf(word.charAt(0))+1;
            }
            System.out.println(position);
        }
    }
}