/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package editordetextoo;

/**
 *
 * @author Jorge Hernandez
 */
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SwingPrueba {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(2, 1));
        JButton openBtn = new JButton("Seleccionar Archivo");
        JButton createBtn = new JButton("Crear Archivo");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        } catch (Exception e) {
            e.printStackTrace();
        }
        MouseAdapter selectFileMouse = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse clicked");
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto (.txt)", "TXT");
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(filter);
                fileChooser.showOpenDialog(frame);

                /*
                try {

                    System.out.println(fileChooser.getSelectedFile().getCanonicalPath());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 */
            }
        };

        MouseAdapter createFileMouse = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Texto (.txt)", "TXT");
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(filter);
                fileChooser.showSaveDialog(fileChooser);
                System.out.println(fileChooser.getSelectedFile());

                try {

                    File archivoCreado = fileChooser.getSelectedFile();
                    if (archivoCreado == null) return;
                    
                    if (!archivoCreado.getName().endsWith(".txt")) {
                        archivoCreado = new File(archivoCreado.getCanonicalFile() + ".txt");  
                    } 
                    
                    if (archivoCreado.exists()) {
                        int op = JOptionPane.showConfirmDialog(null, archivoCreado.getName() + " ya existe. Desea reemplazarlo?");
                        if (op != 0) {
                            mouseClicked(null);
                            return;
                        }
                    }
                    
                    archivoCreado.delete();
                    Logica.createTextFile(archivoCreado.getCanonicalPath());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        };

        createBtn.addMouseListener(createFileMouse);
        frame.add(createBtn);
        openBtn.addMouseListener(selectFileMouse);
        frame.add(openBtn);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
