package texteditor3;

/**
 *
 * @author Jiacheng
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowListener;
import java.io.*;
import java.util.Arrays;
import java.util.EventListener;
import java.util.List;
import java.util.logging.Level;
//import java.lang.System.Logger;
import java.util.logging.Logger;

import javax.swing.*;
import javax.tools.*;

public class TextEditor3 extends JFrame  implements KeyListener{

    public JTextPane textPane = new JTextPane();  
    public JFileChooser filechooser = new JFileChooser();
    //public int x;
    public String text;
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    
    public TextEditor3() throws FileNotFoundException, IOException{
        super("Text Menus");
        setSize(1000,1000);
        Container C = getContentPane();   
        C.setBackground(Color.DARK_GRAY);
        JTextArea a = new JTextArea();
        Font f1 = new Font("",Font.BOLD,36);
        a.setFont(f1);
        BufferedReader br = new BufferedReader(new FileReader("E:\\STUDY\\EE 552\\parse\\error.txt"));
        String line;
        while  ((line = br.readLine()) != null) {
            a.append(line+"\n");
        }
        JPanel p = new JPanel(); // 创建一个JPanel面板
        p.add(a);
        C.add(a,BorderLayout.CENTER);
        setVisible(true);
    }
        public static void main(String[] args) throws FileNotFoundException, IOException {             
            try{
                String fileName = "C:\\Users\\Jiacheng\\Desktop\\test.java";
                JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
                StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
                Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays.asList(fileName));
                JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, compilationUnits);
                boolean success = task.call();            
                File writename1 = new File("C:\\Users\\Jiacheng\\Desktop\\ERROR.txt"); 
                writename1.createNewFile(); // 创建新文件
                BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
                if (!success) {
                    List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
                    for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics) {
                        //System.out.println("ERROR: "+ diagnostic.getMessage(null));
                        String text;
                        text = diagnostic.getMessage(null).toString();
                        out1.write(text); 
                        out1.write("\r\n");
                        out1.flush(); // 把缓存区内容压入文件                 
                    }
                }
                fileManager.close();
            } catch (IOException ex) {
                Logger.getLogger(TextEditor3.class.getName()).log(Level.SEVERE, null, ex);
            }
       new TextEditor3();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
