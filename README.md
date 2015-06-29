PROGETTO PR2	2015

GRUPPO 32
membri:
		48292 - Annis Pier Paolo
		48289 - Sainas Manolo 
		48305 - Pes Nicola
		
OBIETTIVO 
L'obiettivo del progetto è quello di implementare delle funzioni di libre office tramite java, attraverso OBBA.
Creare 3 funzioni:
	-SEMPLICE:
			implementa la funzione ARROTONDA.MULTIPLO
	-COMPLESSA:
			implementa la funzione SOMMA.SERIE
	- CUSTOM :
			implementa una funzione che in libre office non esiste tramite l'utilizzo della libreria esterna API DropBox
			
FUNZIONE SEMPLICE (ARROTONDA.MULTIPLO)
sintassi libre office
	=ARROTONDA.MULTIPLO(Numero; Multiplo)
sintassi java
	=OBGET(OBCALL("result";OBMAKE("oggetto";"it.unica.pr2.progetto2015.g48292_48289_48305.Semplice");"execute";OBMAKE("a";"Double";numero);OBMAKE("b";"Double";multiplo)))
	
Restituisce il Numero arrotondato al più vicino multiplo di Multiplo.

Esempio:
=ARROTONDA.MULTIPLO(15,5;3) restituisce 15, poiché 15,5 è più vicino a 15 (= 3*5) che a 18 (= 3*6).
=ARROTONDA.MULTIPLO(1,4;0,5) restituisce 1,5 (= 0,5*3).


	
FUNZIONE COMPLESSA (SOMMA.SERIE)

Sintassi libre office
	=SOMMA.SERIE(X; N; M; Coefficienti)
Sintassi java
	=OBGET(OBCALL("result_complessa";OBMAKE("oggetto1";"it.unica.pr2.progetto2015.g48292_48289_48305.Complessa");"execute";OBMAKE("fad";"Double[]";X,N,M,Coefficienti)))

X: il valore da immettere per la serie di potenze.
N esprime la potenza iniziale
M e' l'incremento da aggiungere a N
Coefficienti è una serie di coefficienti. Per ciascun coefficiente la somma della serie è estesa di una sezione.


FUNZIONE CUSTOM
La classe Custom implementa una funzione non presente in LibreOffice, utilizza la libreria esterna Dropbox Java API

questa Classe genera un accessToken per poter accedere all'applicazione
in base a un tipo di estensione restituisce i file presenti su dropBox che hanno tale estensione
ad esempio .pdf restituirà il numero di file di tipo pdf

nota: Solo gli utenti registrati su DropBox possono usufruire dei servizi offerti da questa classe

per poter usufruire del servizio bisogna avere un account DropBox e seguire i seguenti passi 			
1	andare sul seguente link 	-> https://www.dropbox.com/1/oauth2/authorize?locale=en_US&client_id=4orqwyvkflkfo8j&response_type=code
2	digitare “allow” o “permettere”
3	copiare nella cella C10 il codice
4	scrivere il tipo di file da contare nella cella D10
5	aggiornare la pagina con CTRL+Shift+F9 solo se non si aggiorna in automatico


attenzione!! 
	1 . se si aggiorna la pagina più di una volta il codice inserito non sarà più valido			
	2 .	se si vuole contare un nuovo tipo di file:  scrivere la nuova estensione in D10 senza aggiornare la pagina			



STRUTTURA DELLA CLASSE
la classe si suddivide in due parti principali
- AccessToken:
	in base al codice inserito dall'utente in una cella restituisce un accessToken, in modo tale che l'utente una volta connesso non debba di volta in volta inserire un codice.
- Execute:
	Una volta autenticato l'utente tramite accessToken, si può iniziare a contare i file, con una certa estensione, che l'utente ha sul proprio DropBox.
	In ingresso quindi prende l'estensione e l'accessToken e restituisce il numero di file con quel tipo di estensione.
	
Abbiamo deciso di suddividere in due parti tale classe per comodità per l'utente, ora l'utente deve inserire solo una volta il codice.
Se fosse stata un unica funzione l'utente doveva inserire di volta in volta sia il nuovo codice d'accessso e sia il tipo di file da contare,
abbiamo deciso dunque di suddividere tale classe in due funzioni principali, in modo tale che il codice venisse richiamato solo la prima volta, 
e per contare i vari tipi di file basta solo modificare la cella appropriata senza aggiornare la pagina.


sintassi "Execute"
	=OBGET(OBCALL("result_custom1";OBMAKE("oggettoCustom";"it.unica.pr2.progetto2015.g48292_48289_48305.Custom");"execute";OBMAKE("a";"String";accessToken);OBMAKE("b";"String";file estensione)))
	ritorna il valore dell'accessToken
sintassi AccessToken
	{=OBGET(OBCALL("AccessToken";OBMAKE("oggettoCustom";"it.unica.pr2.progetto2015.g48292_48289_48305.Custom");"getAccessToken";OBMAKE("a";"String";codice ricevuto da DropBox)))}
	ritorna il nome account di dropBox e il numero di file presenti con quel tipo di estensione


	

 

