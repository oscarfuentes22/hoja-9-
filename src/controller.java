import structure5.Structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class controller {
    private static Structure arbol;
    private static ArrayList<String> textos;


    public static void leerArchivo(String fileName) {
        String fpath = ".\\src\\" + fileName + ".txt";
        ArrayList<String> items = new ArrayList<String>();
        try {
            File myObj = new File(fpath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String[] dataLine = myReader.nextLine().split(" ");

                Palabra word = new Palabra(dataLine[0], dataLine[1], dataLine[2]);

                if (fileName.equals("Spanish")) {
                    arbol.add(word);
                } else if (fileName.equals("Texto")) {
                    textos.addAll(Arrays.asList(dataLine));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");

        }

    }

    public static void setArbol(String tipoArbol) {
        arbol = factory.tipoArbol(tipoArbol);
    }

    public static String sustiticion(String palabra, ArrayList<String> textos) {
        String oracionTraducida = "";
        for (String texto : textos) {
            Palabra pal = arbol.get(new Palabra(texto));
            if (palabra != null) {
                oracionTraducida += pal.getPalabraEsp() + " ";
            } else {
                oracionTraducida += texto + " ";
            }
            return oracionTraducida;
        }

    return oracionTraducida;
    }
}




