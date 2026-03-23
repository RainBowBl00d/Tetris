public class Tetris {
	private int read = 20;
	private int veerud = 10;
	private char[][] laud = new char[read][veerud];

	public Tetris() {
		for (int i = 0; i < read; i++) {
			for (int j = 0; j < veerud; j++) {
				laud[i][j] = ' '; // Kasutame tühikut tühja koha tähistamiseks
			}
		}
	}

	public void prindiLaud() {
		for (int i = 0; i < read; i++) {
			for (int j = 0; j < veerud; j++) {
				System.out.print(laud[i][j] + " ");
			}
			System.out.println();
		}
	}
	public void liigutaVasakule() {
	}
	public void liigutaParemale() {
	}
	public void liigutaAlla() {
	}
	public void pööraPäripäeva() {
	}
	public void pööraVastupäeva() {
	}
	public boolean sammEdasi() {
		return true;
	}
}

