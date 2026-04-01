// Liides, mis määrab ära iga Tetrise kujundi põhiomadused
public interface Kujund {
	char[][] getMaatriks(); // tagastab kujundi 2D maatriksi
	void poora();           // pöörab kujundit 90° päripäeva
	char getSumbol();       // tagastab kujundi tähesümboli
}
