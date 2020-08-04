import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;




class Result {

    public static List<String> reemplazoString(List<String> palabras){
        for(int i =0; i<palabras.size(); i++){
                palabras.set(i, palabras.get(i).toLowerCase().replace(" ", "").replace(".", "").replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u"));            
        }
        return palabras;
    }
    
    public static List<String> ordenarStrings(List<String> palabras){
        for(int i =0; i<palabras.size(); i++){
            char[] palabra = palabras.get(i).toCharArray();
            Arrays.sort(palabra);
            palabras.set(i, new String(palabra));
        }
        return palabras;
        
    }
    
    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        List<Integer> respuesta = new ArrayList<Integer>(query.size()); 
        //dictionary = reemplazoString(dictionary);
        //query = reemplazoString(query);
        
        //dictionary = ordenarStrings(dictionary);
        //query = ordenarStrings(query);
        
        for(int i = 0; i<query.size(); i++){
            char[] palabra = query.get(i).toCharArray();
            Arrays.sort(palabra);
            query.set(i, new String(palabra));
            int contador = 0;
            for(int j = 0; j<dictionary.size(); j++){
                palabra = dictionary.get(j).toCharArray();
                Arrays.sort(palabra);
                dictionary.set(j, new String(palabra));
                if(query.get(i).equals(dictionary.get(j))){
                    contador++;
                }
            }
            respuesta.add(contador);
        }
        
        return respuesta;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int dictionaryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> dictionary = new ArrayList<>();

        for (int i = 0; i < dictionaryCount; i++) {
            String dictionaryItem = bufferedReader.readLine();
            dictionary.add(dictionaryItem);
        }

        int queryCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> query = new ArrayList<>();

        for (int i = 0; i < queryCount; i++) {
            String queryItem = bufferedReader.readLine();
            query.add(queryItem);
        }

        List<Integer> result = Result.stringAnagram(dictionary, query);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}