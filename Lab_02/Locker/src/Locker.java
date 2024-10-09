public class Locker {

    private boolean isOpen;
    private String code;

    public Locker() {
        isOpen = true;
        code = "";
    }

    public void unlock(String code2) {
        if(code.equals(code2)) {
            isOpen = true;
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void lock() {
        if(!code.isEmpty()) isOpen = false;
    }

    public void newComb(String newCode) {
        if(( newCode.length() == 3) && newCode.equals(newCode.toUpperCase())) {
            char[] temp=newCode.toCharArray();
            for (char c : temp) {
                if (c >= '0' && c <= '9') return;
                System.out.println(c);
            }
            code=newCode;
        }
    }
}