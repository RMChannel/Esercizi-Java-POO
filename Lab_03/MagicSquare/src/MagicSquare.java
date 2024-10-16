import java.util.Scanner;

public class MagicSquare {
    private final int[][] square;
    private final int n;

    public MagicSquare(int n) {
        this.n = n;
        square = new int[n][n];
    }

    private boolean find(int x) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isFull() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (square[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void add(int x) {
        boolean found = false;
        for(int i=0;i<n && !found;i++) {
            for(int j=0;j<n && !found;j++) {
                if(square[i][j]==0) {
                    square[i][j]=x;
                    found=true;
                }
            }
        }
    }

    public boolean isMagic() {
        int magicNumber=0, temp;
        boolean isMagic = true;
        for(int i=0;i<n;i++) magicNumber+=square[i][0];
        for(int i=1;i<n;i++) {
            temp=0;
            for(int j=0;j<n;j++) {
                temp+=square[i][j];
            }
            if(magicNumber!=temp) return false;
        }
        for(int i=1;i<n;i++) {
            temp=0;
            for(int j=0;j<n;j++) {
                temp+=square[j][i];
            }
            if(magicNumber!=temp) return false;
        }
        temp=0;
        for(int i=0;i<n;i++) {
            temp+=square[i][i];
        }
        if(magicNumber!=temp) return false;
        temp=0;
        for(int i=0, j=n-1;i<n && j>=0;i++,j--) {
            temp+=square[i][j];
        }
        if(magicNumber!=temp) return false;
        return isMagic;
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                toString.append(square[i][j]).append(" ");
            }
            toString.append("\n");
        }
        return toString.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci n --> ");
        int n = input.nextInt();
        MagicSquare square = new MagicSquare(n);

        while (!square.isFull()) {
            int x;
            do {
                System.out.print("Inserisci un numero --> ");
                x = input.nextInt();

                if (x < 1 || x > n * n) {
                    System.out.println("Devi inserire numeri compresi tra 1 e n^2!");
                } else {
                    if (square.find(x)) {
                        System.out.println("Questo numero lo avevi già inserito!");
                    }
                }
            } while (square.find(x) || x < 1 || x > n * n);
            square.add(x);
            System.out.println(square);
        }

        boolean magic = square.isMagic();

        if (magic)
            System.out.println("È un quadrato magico!");
        else
            System.out.println("Non è un quadrato magico!");
    }
}