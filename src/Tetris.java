import java.util.Random;

public class Tetris {
    private int read = 20;
    private int veerud = 10;
    private char[][] laud = new char[read][veerud];

    private Kujund praeguneKujund;
    private int kujundRida;
    private int kujundVeerg;
    private int skoor;
    private int tase = 1;      // kui kunagi edasi teha läheb nagunii vaja

    public Tetris() {
        for (int i = 0; i < read; i++) {
            for (int j = 0; j < veerud; j++) {
                laud[i][j] = ' ';
            }
        }
        uusKujund();
    }

    private boolean uusKujund() {
        Random jargmine = new Random();
        int number = jargmine.nextInt(6);
        switch (number){
            case 1:
                praeguneKujund = new TKujund();
                break;
            case 2:
                praeguneKujund = new JKujund();
                break;
            case 3:
                praeguneKujund = new ZKujund();
                break;
            case 4:
                praeguneKujund = new LKujund();
                break;
            case 5:
                praeguneKujund = new IKujund();
                break;
            default:
                praeguneKujund = new  OKujund();
        }
        kujundRida = 0;
        kujundVeerg = veerud / 2 - 1;
        return saabLiikuda(kujundRida, kujundVeerg, praeguneKujund.getMaatriks());
    }

    private boolean saabLiikuda(int uusRida, int uusVeerg, char[][] maatriks) {
        for (int i = 0; i < maatriks.length; i++) {
            for (int j = 0; j < maatriks[i].length; j++) {
                if (maatriks[i][j] != ' ') {
                    int r = uusRida + i;
                    int c = uusVeerg + j;
                    if (r < 0 || r >= read || c < 0 || c >= veerud) {
                        return false;
                    }
                    if (laud[r][c] != ' ') {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void prindiLaud() {
        char[][] kuva = new char[read][veerud];
        for (int i = 0; i < read; i++) {
            for (int j = 0; j < veerud; j++) {
                kuva[i][j] = laud[i][j];
            }
        }
        if (praeguneKujund != null) {
            char[][] m = praeguneKujund.getMaatriks();
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    if (m[i][j] != ' ') {
                        int r = kujundRida + i;
                        int c = kujundVeerg + j;
                        if (r >= 0 && r < read && c >= 0 && c < veerud) {
                            kuva[r][c] = m[i][j];
                        }
                    }
                }
            }
        }
        // Column numbers header
        System.out.print("   ");
        for (int j = 0; j < veerud; j++) System.out.printf("%-2d", j);
        System.out.println();
        // Top border
        System.out.print("  +");
        for (int j = 0; j < veerud; j++) System.out.print("--");
        System.out.println("+");
        // Board rows with row numbers
        for (int i = 0; i < read; i++) {
            System.out.printf("%2d|", i);
            for (int j = 0; j < veerud; j++) {
                if (kuva[i][j] != ' ') {
                    System.out.print(kuva[i][j] + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println("|");
        }
        // Bottom border
        System.out.print("  +");
        for (int j = 0; j < veerud; j++) System.out.print("--");
        System.out.println("+");
    }

    public void liigutaVasakule() {
        if (saabLiikuda(kujundRida, kujundVeerg - 1, praeguneKujund.getMaatriks())) {
            kujundVeerg--;
        }
    }

    public void liigutaParemale() {
        if (saabLiikuda(kujundRida, kujundVeerg + 1, praeguneKujund.getMaatriks())) {
            kujundVeerg++;
        }
    }

    public void liigutaAlla() {
        if (saabLiikuda(kujundRida + 1, kujundVeerg, praeguneKujund.getMaatriks())) {
            kujundRida++;
        }
    }

    public void pööraPäripäeva() {
        praeguneKujund.poora();
        if (!saabLiikuda(kujundRida, kujundVeerg, praeguneKujund.getMaatriks())) {
            praeguneKujund.poora();
            praeguneKujund.poora();
            praeguneKujund.poora();
        }
    }

    public void pööraVastupäeva() {
        praeguneKujund.poora();
        praeguneKujund.poora();
        praeguneKujund.poora();
        if (!saabLiikuda(kujundRida, kujundVeerg, praeguneKujund.getMaatriks())) {
            praeguneKujund.poora();
        }
    }

    private void lukustaKujund() {
        char[][] m = praeguneKujund.getMaatriks();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] != ' ') {
                    int r = kujundRida + i;
                    int c = kujundVeerg + j;
                    if (r >= 0 && r < read && c >= 0 && c < veerud) {
                        laud[r][c] = m[i][j];
                    }
                }
            }
        }
    }

    private void eemaldaTaysRead() {
        int täis = 0;
        for (int i = read - 1; i >= 0; i--) {
            boolean tays = true;
            for (int j = 0; j < veerud; j++) {
                if (laud[i][j] == ' ') {
                    tays = false;
                    break;
                }
            }
            if (tays) {
                for (int k = i; k > 0; k--) {
                    for (int j = 0; j < veerud; j++) {
                        laud[k][j] = laud[k - 1][j];
                    }
                }
                // Clear top row
                for (int j = 0; j < veerud; j++) {
                    laud[0][j] = ' ';
                }
                i++;
                täis++;
            }
        }
        // Klassikaline (Nintendo/NES) punktisüsteem
        switch (täis){
            case 1:
                skoor += 40 * tase;
                break;
            case 2:
                skoor += 100 * tase;
                break;
            case 3:
                skoor += 300 * tase;
                break;
            case 4:
                skoor += 1200 * tase;
                break;
            default:
                skoor += 0;
        }
    }

    public int getSkoor() {
        return skoor;
    }

    public boolean sammEdasi() {
        // Hard drop: move piece as far down as possible
        while (saabLiikuda(kujundRida + 1, kujundVeerg, praeguneKujund.getMaatriks())) {
            kujundRida++;
        }
        lukustaKujund();
        eemaldaTaysRead();
        return uusKujund();
    }
}

