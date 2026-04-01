# Tetris – Rühmatöö 1

## Autorid
- Innar Raudsepp
- Endel Meriste

## Projekti kirjeldus
Tekstipõhine Tetris-mäng. Mängija saab iga käigu ajal
liigutada ja pöörata langevat kujundit, misjärel see kukutatakse automaatselt
nii madalale kui võimalik. 

### Kasutusjuhis
Programm käivitatakse peaklassist `Main`. Käivitamisel kuvatakse juhised.
Iga käigu ajal sisestab mängija komadega eraldatud käsud:
- `a` – liiguta vasakule
- `d` – liiguta paremale
- `e` – pööra päripäeva
- `q` – pööra vastupäeva
- `s` – liiguta alla

Näide: `a,a,e` liigutab kujundit kaks korda vasakule ja pöörab seda.

## Klasside kirjeldused

### Main
Peaklass, mis käivitab mängu ja loeb kasutaja sisendit (`Scanner`).
- `main(String[] args)` – mängutsükkel: kuvab lauda, loeb käsud, kutsub Tetris meetodeid

### Tetris
Mänguloogika klass: haldab 20×10 mängulauda, kujundite liikumist, skoori ja reegleid.
- `Tetris()` – konstruktor, loob tühja laua ja tekitab esimese kujundi
- `prindiLaud()` – kuvab mängulaua koos reanumbritega
- `liigutaVasakule()`, `liigutaParemale()`, `liigutaAlla()` – liigutab kujundit
- `pööraPäripäeva()`, `pööraVastupäeva()` – pöörab kujundit (tühistab kui ei mahu)
- `sammEdasi()` – kukutab kujundi alla, lukustab, eemaldab täis read, tekitab uue
- `getSkoor()` – tagastab skoori
- `setTase(int)` – seab raskustaseme

### Kujund (liides)
Määrab iga tetromino põhiomadused:
- `getMaatriks()` – tagastab kujundi 2D maatriksi
- `poora()` – pöörab kujundit 90° päripäeva
- `getSumbol()` – tagastab kujundi tähesümboli

### TKujund, IKujund, JKujund, LKujund, OKujund, SKujund, ZKujund
Seitse tetromino-kujundit, mis implementeerivad `Kujund` liidest. Igaühel on:
- oma kujundi maatriks (`char[][] kuju`)
- `poora()` – pöörab maatriksit 90° (v.a. OKujund, mis on sümmeetriline)
- `getSumbol()` – tagastab vastava tähe (T, I, J, L, O, S, Z)

## Protsessi kirjeldus
[Kirjeldage etappe, nt: 1. Projekti planeerimine, 2. Põhistruktuuri loomine, 
3. Kujundite implementeerimine, 4. Mänguloogika, 5. Testimine ja viimistlemine]

## Rühmaliikmete panus
- Innar: Main, Tetris, Kujundi liides, 4 tundi
- Endel: Kujundid, punktisüsteem, ajakulu 4 tundi

## Mured
Muresid polnud


## Hinnang lõpptulemusele
Mäng toimib ja on mängitav, kõik 7 kujundit töötavad. Edasi saaks arendada lisades graafilise liidese.

## Testimine
Testisime iga kujundit – kontrollisime, et pööramine annab õiged 
asendid ega liiguta alast välja. Täis ridade eemaldamist testisime käsitsi kujundeid ritta kuhjates.
Mängu lõppu testisime kujundeid üles kuhjates, kuni "MÄNG LÄBI!" ilmus.