public class IKujund implements Kujund{
    private char[][] kuju = {
            {'I', ' ', ' ', ' '},
            {'I', ' ', ' ', ' '},
            {'I', ' ', ' ', ' '},
            {'I', ' ', ' ', ' '}
    };

    @Override
    public char[][] getMaatriks() {
        return kuju;
    }

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
        return 'I';
    }
}
