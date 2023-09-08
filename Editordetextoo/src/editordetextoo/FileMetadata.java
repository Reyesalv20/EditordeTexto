/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editordetextoo;

import java.io.File;

/**
 *
 * @author Jorge Hernandez
 */
public class FileMetadata {

    int hAllign;
    int vAllign;
    String fontName;
    int fontR;
    int fontG;
    int fontB;
    int fontSize;
    boolean bold;
    boolean italic;
    String text;
    File currentFile;

    public FileMetadata(int hAllign, int vAlling, String fontName, int fontR, int fontG, int fontB, int fontSiez, boolean bold, boolean italic, String text, File currentFile) {
        this.hAllign = hAllign;
        this.vAllign = vAlling;
        this.fontName = fontName;
        this.fontR = fontR;
        this.fontG = fontG;
        this.fontB = fontB;
        this.fontSize = fontSiez;
        this.bold = bold;
        this.italic = italic;
        this.text = text;
        this.currentFile = currentFile;
    }
    
    

}
