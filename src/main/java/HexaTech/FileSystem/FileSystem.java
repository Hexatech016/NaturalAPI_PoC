/**
 * @file FileSystem
 * @version 1.0.0
 * @type java
 * @data 2020-04-30
 * @author Eduard Serban
 * @email hexatech016@gmail.com
 * @license MIT
 */

package HexaTech.FileSystem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

/**
 * Class used to save and load documents.
 */
public class FileSystem implements FileSystemInterface {

    /**
     * Imports a document's path from disk.
     * @return string - document path. Empty string if an error occurs.
     */
    public String importPath(){
        JFrame dialog = new JFrame();
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text file", "txt", "text");
        chooser.setFileFilter(filter);
        dialog.getContentPane().add(chooser);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);
        dialog.dispose();
        int returnVal = chooser.showOpenDialog(dialog);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().getAbsolutePath();
        }else
            return "";
    }//importPath

    /**
     * Imports a BDL's path from disk.
     * @return string - BDL's path. Empty string if an error occurs.
     */
    public String importPathBDL(){
        JFrame dialog = new JFrame();
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Json file", "json");
        chooser.setFileFilter(filter);
        dialog.getContentPane().add(chooser);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);
        dialog.dispose();
        int returnVal = chooser.showOpenDialog(dialog);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().getAbsolutePath();
        }else
            return "";
    }//importPathBDL

    /**
     * Imports a Gherkin's path from disk.
     * @return string - Gherkin's path. Empty string if an error occurs.
     */
    @Override
    public String importPathGherkin(){
        JFrame dialog = new JFrame();
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Gherkin file", "scenario");
        chooser.setFileFilter(filter);
        dialog.getContentPane().add(chooser);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(false);
        dialog.dispose();
        int returnVal = chooser.showOpenDialog(dialog);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().getAbsolutePath();
        }else
            return "";
    }//importPathGherkin

    /**
     * Extrapolates content from a document.
     * @param path string - document's path.
     * @return string - document's content.
     * @throws IOException if the specified document doesn't exist.
     */
    public String getContentFromPath(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }//while
        return  sb.toString();
    }//getContentFromPath

    /**
     * Saves the specified content into a new document at the specified path.
     * @param doc string - new document's content.
     * @param path string - new document's path.
     * @throws IOException if occurs an error while creating the file or writing into it.
     */
    public void saveDoc(String doc, String path) throws IOException {
        // Open given file in append mode.
        BufferedWriter out = new BufferedWriter(
                new FileWriter(path));
        String[] rows=doc.split("\n");
        for(String riga: rows){
            out.write(riga);
            out.newLine();
        }//for
        out.close();
    }//saveDoc

    /**
     * Verifies if the specified document exists.
     * @param doc string - path to the document to be searched.
     * @return boolean - true if the document exists, false if not.
     */
    public boolean existsDoc(String doc){
        File temp=new File(doc);
        return temp.exists();
    }

    /**
     * Deletes the specified document.
     * @param doc string - path to the document to be deleted.
     */
    public boolean deleteDoc(String doc){
        File temp=new File(doc);
        return temp.delete();
    }

}//FileSystem
