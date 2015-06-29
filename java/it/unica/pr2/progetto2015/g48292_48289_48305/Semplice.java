/*
 
    Sintassi
ARROTONDA.MULTIPLO(Numero; Multiplo)

Restituisce il Numero arrotondato al più vicino multiplo di Multiplo.

Un'implementazione alternativa potrebbe essere Multiplo * ARROTONDA(Numero/Multiplo).

Esempio
=ARROTONDA.MULTIPLO(15,5;3) restituisce 15, poiché 15,5 è più vicino a 15 (= 3*5) che a 18 (= 3*6).

=ARROTONDA.MULTIPLO(1,4;0,5) restituisce 1,5 (= 0,5*3).
    
*/
package it.unica.pr2.progetto2015.g48292_48289_48305;

public class Semplice implements it.unica.pr2.progetto2015.interfacce.SheetFunction {

    /** 
    Argomenti in input ed output possono essere solo: String, Integer, Long, Double, Character, Boolean e array di questi tipi.
    Ad esempio a runtime si puo' avere, come elementi di args, un Integer ed un Long[], e restituire un Double[];
     * @param args
     * @return 
    */
    @Override
    public Object execute(Object... args) {
        Double numero = (Double)args[0]; 
        Double multiplo = (Double) args[1];      
        Double x = multiplo;
        Double y =0.00; 
        while (x<numero){
            y = x;
            x = x + multiplo;
        }
        if ((numero - y)<(x - numero))
            return y;
        else
            return x;   
    }


    /** 
    Restituisce la categoria LibreOffice;
    */
    @Override
    public final String getCategory() {
		return "Matematica";
	}

    /** Informazioni di aiuto */
    @Override
    public final String getHelp() {
		return "arrotonda un numero al multiplo piu' vicino";
	} 

    /** 
    Nome della funzione.
    */         
    @Override
    public final String getName() {
		return "ARROTONDA.MULTIPLO";
	}   
}
