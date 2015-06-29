/*La classe Custom implementa una funzione non presente in LibreOffice, utilizza la libreria esterna 
* Dropbox Java API
* 
*questa Classe genera un accessToken per poter accedere all'applicazione
in base a un tipo di estensione restituisce i file presenti su dropBox che hanno tale estensione
ad esempio .pdf restituirà il numero di file di tipo pdf

nota: Solo gli utenti registrati su DropBox possono usufruire dei servizi offerti da questa classe
*/

package it.unica.pr2.progetto2015.g48292_48289_48305;
import com.dropbox.core.*;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Custom implements it.unica.pr2.progetto2015.interfacce.SheetFunction {
    	
    /*Ritorna l'AccessToken di un utente */
    public String getAccessToken(String code) throws DbxException{
        code = code.replace(" ", "");
        return accessToken(code);
       
    }
    
    /*restituisce l'AccessToken per un utente per poter accedere all'applicazione*/
    private static String accessToken(String code) throws DbxException{
        final String APP_KEY = "4orqwyvkflkfo8j";
        final String APP_SECRET = "klx9ekt6y5bknv6";

        DbxAppInfo appInfo = new DbxAppInfo(APP_KEY, APP_SECRET);
        DbxWebAuthNoRedirect webAuth = new DbxWebAuthNoRedirect(returnConfig(), appInfo);
        String authorizeUrl = webAuth.start();
        DbxAuthFinish authFinish = webAuth.finish(code);
        return authFinish.accessToken;
    }
   
    
  
    @Override
    public Object execute(Object... args) {
        Integer c= 0;
        String accessTk = (String)args[0];
        String type = (String)args[1];
        Object[] result = new Object[2];
        
        
        String path = "/";
        DbxClient client;
        accessTk = accessTk.replace(" ", "");
        type = type.replaceAll(" ", "");
        client = new DbxClient(returnConfig(), accessTk);
        
        try {
            result[0] = client.getAccountInfo().displayName;
        } catch (DbxException ex) {
            Logger.getLogger(Custom.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        if (!(type.startsWith(".")))
            result[1]= "estensione file non valida";       
        else{
        try {
           c = returnNumberOfFiles(client,path, type);
        } catch (DbxException ex) {
            Logger.getLogger(Custom.class.getName()).log(Level.SEVERE, null, ex);
        }
        result[1] = c;
        }
        
      
        
        
        return result;
    }
    

    /* ritorna il numero di file di un certo tipo di estensione */
    private static int returnNumberOfFiles(DbxClient client, String path, String type) throws DbxException{
        DbxEntry.WithChildren listing = client.getMetadataWithChildren(path);
        int cont=0;
        for (DbxEntry child : listing.children) {
            if (child.isFolder()){
                path = child.path;
                cont = cont + returnNumberOfFiles(client, path, type);
            }
            else{
                DbxEntry.File file = (DbxEntry.File)child;
                String tmp = file.name.substring(file.name.lastIndexOf(".")); 
                if (tmp.equalsIgnoreCase(type))
                     cont ++;
            }        
        }
        return cont;
  
    }
      
     private static DbxRequestConfig returnConfig(){
            return new DbxRequestConfig("progetto", Locale.getDefault().toString());
     }


    /** 
    Restituisce la categoria LibreOffice;
    Vedere: https://help.libreoffice.org/Calc/Functions_by_Category/it
    ad esempio, si puo' restituire "Data&Orario" oppure "Foglio elettronico"
     * @return 
    */
    @Override
    public final String getCategory() {
		return "Other";
	}

    /** Informazioni di aiuto
     * @return  */
    @Override
    public final String getHelp() {
		return "torna il numero di file di una certa estensione presenti su dropbox";
	} 

    /** 
    Nome della funzione.
    vedere: https://help.libreoffice.org/Calc/Functions_by_Category/it
    ad es. "VAL.DISPARI" 
     * @return 
    */         
    @Override
    public final String getName() {
		return "Custom";
	}

}