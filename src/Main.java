import java.util.Scanner;

// Peaklass: käivitab mängu ja loeb kasutaja sisendi
public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Tetris mang = new Tetris();
		boolean mangKaib = true;

		System.out.println("Tere tulemast Tetrisse!");
		System.out.println("Kasuta komadega eraldatud käske: a (vasakule), d (paremale), e (pööra), s (alla).");

		while (mangKaib) {
			// 1. Kuva seis
			mang.prindiLaud();
			System.out.println("Skoor: " + mang.getSkoor());
			System.out.print("Sisesta käsud (nt d,d,e): ");

			// 2. Loe sisend
			String sisend = scanner.nextLine();
			String[] kasud = sisend.split(",");

			// 3. Töötle iga käsk eraldi
			for (String kask : kasud) {
				kask = kask.trim().toLowerCase();

				switch (kask) {
					case "a":
						mang.liigutaVasakule();
						break;
					case "d":
						mang.liigutaParemale();
						break;
					case "e":
						mang.pööraPäripäeva();
						break;
					case "q":
						mang.pööraVastupäeva();
						break;
					case "s":
						mang.liigutaAlla();
						break;
					default:
						System.out.println("Tundmatu käsk: " + kask);
				}
			}

			if (!mang.sammEdasi()) {
				System.out.println("MÄNG LÄBI!");
				mangKaib = false;
			}
		}
		scanner.close();
	}
}