public class OKujund implements Kujund{
    private char[][] kuju = {
            {'O', 'O'},
            {'O', 'O'},
    };

    @Override
    public char[][] getMaatriks() {
        return kuju;
    }

    @Override
    public void poora() {
    }

    @Override
    public char getSumbol() {
        return 'O';
    }
}
