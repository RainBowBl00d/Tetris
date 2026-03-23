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

	@Override
	public void poora() {
	}

	@Override
	public char getSumbol() {
		return 'T';
	}
}