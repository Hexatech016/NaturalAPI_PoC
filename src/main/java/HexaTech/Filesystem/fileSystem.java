package HexaTech.Filesystem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class fileSystem implements iFileSystem{

    public String importPath(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File di testo", "txt", "text");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().getAbsolutePath();
        }else
            return "";
    }

    public String importPathOfBDL(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File Json", "json");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().getAbsolutePath();
        }else
            return "";
    }

    @Override
    public String importPathOfGherkin(){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("File Gherkin", "scenario");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION){
            return chooser.getSelectedFile().getAbsolutePath();
        }else
            return "";
    }

    public  String getContenutoFromPath(String path) throws IOException {
            File file = new File(path);

            BufferedReader br = new BufferedReader(new FileReader(file));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return  sb.toString();
    }
    public void saveDoc(String doc, String path) throws IOException {
        try {
            // Open given file in append mode.
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(path));
            //throw new IOException("File not found");
            String[] righe=doc.split("\n");
            for(String riga: righe){
                out.write(riga);
                out.newLine();
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println("exception occured " + e);
        }

    }
    public boolean esisteDoc(String doc){
        File temp=new File(doc);
        return temp.exists();
    }
    public boolean eliminaDoc(String doc){
        File temp=new File(doc);
        return temp.delete();
    }
    public void createjSon(){

    }
}
