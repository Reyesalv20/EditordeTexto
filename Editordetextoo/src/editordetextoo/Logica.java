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

    /*
    Formato:
    
    Horizontal allign: izquierda (0 | default) centro (1) derecha (2)
    Vertical allign: arriba (0) centro (1 | default) abajo (2)
    Fuente: NOMBRE DE LA FUENTE (String | default "Calibri")s
    Color: Guardar RGB (3 int | default 0, 0 , 0)
    size: int (default | 12)
    bold: boolean (default | false)
    italic: boolean (default | false)
    String text (default | "")
    EOF
     */
    
    static FileMetadata createTextFile(String path) {
        //crea el directorio en caso de que no exista, y si exista, va de un solo al try catch
        File file = new File(path);
        try {
            file.createNewFile();

            System.out.println("[createTextFile] Se creo el directorio: " + file.getName());
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.writeInt(0); // h allign izquierda
            raf.writeInt(1); // v allign centro
            raf.writeUTF("Calibri");
            raf.writeInt(0); // R
            raf.writeInt(0); // G
            raf.writeInt(0); // B
            raf.writeInt(12); // font size
            raf.writeBoolean(false); // bold
            raf.writeBoolean(false); // italic
            raf.writeUTF("");;
            raf.close();

            return loadTextDataFromFile(path);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void saveFile(String path, FileMetadata data) {
        try {
            
            File f = new File(path);
            f.delete();
            System.out.println("Guardando data en " + path);
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.seek(0);
            raf.writeInt(data.hAllign);
            raf.writeInt(data.vAllign);
            raf.writeUTF(data.fontName);
            raf.writeInt(data.fontR);
            raf.writeInt(data.fontG);
            raf.writeInt(data.fontB);
            raf.writeInt(data.fontSize);
            raf.writeBoolean(data.bold);
            raf.writeBoolean(data.italic);
            System.out.println(data.text);
            raf.writeUTF(data.text);
            raf.close();
            
            System.out.println("Guardado en " + path);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    static FileMetadata loadTextDataFromFile(String path) throws IOException {
        //el puntero se posiciona en la posicion 0
        System.out.println(path);
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rw");
            raf.seek(0);
            // Skipear allings
            int hAllign = raf.readInt();
            int vAlling= raf.readInt();
            String fontName = raf.readUTF();
            int fontR = raf.readInt();
            int fontG = raf.readInt();
            int fontB = raf.readInt();
            int fontSize = raf.readInt();
            boolean bold = raf.readBoolean();
            boolean italic = raf.readBoolean();
            String text = raf.readUTF();
            File currentFile = new File(path);

            FileMetadata fileData = new FileMetadata(hAllign, vAlling, fontName, fontR, fontG, fontB, fontSize, bold, italic, text, currentFile);
            return fileData;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
