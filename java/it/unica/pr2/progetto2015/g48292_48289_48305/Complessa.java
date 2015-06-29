/*SOMMA.SERIE
Somma i primi termini di una serie di potenze.

SOMMA.SERIE(x;n;m;coefficienti) = coefficiente_1*x^n + coefficiente_2*x^(n+m) + coefficiente_3*x^(n+2m) +...+ coefficiente_i*x^(n+(i-1)m)

Sintassi
SOMMA.SERIE(X; N; M; Coefficienti)

X: il valore da immettere per la serie di potenze.

N esprime la potenza iniziale

M e' l'incremento da aggiungere a N

Coefficienti � una serie di coefficienti. Per ciascun coefficiente la somma della serie � estesa di una sezione.

*/

package it.unica.pr2.progetto2015.g48292_48289_48305;
public class Complessa implements it.unica.pr2.progetto2015.interfacce.SheetFunction {

	
    /** 
    Argomenti in input ed output possono essere solo: String, Integer, Long, Double, Character, Boolean e array di questi tipi.
    Ad esempio a runtime si puo' avere, come elementi di args, un Integer ed un Long[], e restituire un Double[];
     * @param args
     * @return 
    */
    @Override
    public Object execute(Object... args) {
		Double[] c = (Double[])args;
		Double x = c[0];
		Double n = c[1];
		Double m = c[2];
		Double result = 0.00;
		int cont=0;
		for(int i=3; i< c.length; i++ ) {
		//coefficiente_1*x^n + coefficiente_2*x^(n+m) + coefficiente_3*x^(n+2m) +...+ coefficiente_i*x^(n+(i-1)m)
			result = result + (c[i]*Math.pow(x,n+cont*m)); 
			cont++;
		}
		return result;
	}


    /** 
    Restituisce la categoria LibreOffice;
    Vedere: https://help.libreoffice.org/Calc/Functions_by_Category/it
    ad esempio, si puo' restituire "Data&Orario" oppure "Foglio elettronico"
    
     * @return 
     * */
    @Override
    public final String getCategory() {
		return "Matematica";
	}

    /** Informazioni di aiuto */
    @Override
    public final String getHelp() {
		return "Calcola il risultato di una serie";
	} 

    /** 
    Nome della funzione.
    vedere: https://help.libreoffice.org/Calc/Functions_by_Category/it
    ad es. "VAL.DISPARI" 
    */         
    @Override
    public final String getName() {
		return "SOMMA.SERIE";
	}

}