package editordetextoo;


import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author AdminColeexz
 */
public class Logica {
    
    static RandomAccessFile raf;
    static String texto,fuente,color;
    static int size;
    
    static void createUsersFile(String nombre) {
        //crea el directorio en caso de que no exista, y si exista, va de un solo al try catch
        File directory = new File("Archivos");
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Se creo el directorio: " + directory.getName());
            } else {
                System.out.println("Error. No se pudo crear el directorio");
            }
        } else {
            System.out.println("El directorio ya existe");
        }             
        
        try {
            //crea el archvio con el nombre que se recibe de parametro
            raf = new RandomAccessFile("Archivos/"+nombre+".txt", "rw");
        } catch (IOException e) {
            System.err.println("Error. No se pudo crear el archivo");
        }
    }
    
    static void loadTextFromFile(String nombrearchivo) throws IOException{
        //el puntero se posiciona en la posicion 0
        raf.seek(0);
        try{
            //mientras el puntero no llegue al final del archivo, cada palabra que este en el archivo sera cargada en el acumulador de texto = texto
            while(raf.getFilePointer()<raf.length()){
                texto+=raf.readUTF();
            }
        } catch (IOException e){
            System.out.println("no se pudieron cargar los archivos");
        }
    }

    //borra el archivo para poder despues ingresar el texto tras ser modificado en el swing
    static void deleteFile(String filepath){
        File file = new File(filepath);
        if(file.exists()){
            file.delete();
        }
    }
    
    static void ingresarInfo (String texto) throws IOException{
        raf.writeUTF(texto);
    }
    
    static Font changeFont(String fuente){
        Font font = new Font(fuente, Font.BOLD, size);
        return font;
    }
    
    //recibe de parametro el size para cambiarlo en el font
    public static void setSize(int size) {
        Logica.size = size;
    }
   
    //
    static void changeColor(String color){
        Logica.color = color;
    }
    
    
}
