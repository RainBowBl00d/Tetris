// T-kujuline tetromino (3x3 maatriks)
public class TKujund implements Kujund {
    private char[][] kuju = {
            {' ', 'T', ' '},
            {'T', 'T', 'T'},
            {' ', ' ', ' '}
    };

    @Override
    public char[][] getMaatriks() {
        return kuju;
    }

    // Pöörab maatriksit 90° päripäeva: transponeerib ja peegeldab
    @Override
    public void poora() {
        int n = kuju.length;
        char[][] uus = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                uus[j][n - 1 - i] = kuju[i][j];
            }
        }
        kuju = uus;
    }

    @Override
    public char getSumbol() {
        return 'T';
    }
}