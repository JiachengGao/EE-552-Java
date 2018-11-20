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
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.tools.*;

public class TextEditor4 extends JFrame  implements KeyListener{
    
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    String line;
    public TextEditor4() throws FileNotFoundException, IOException{
        super("Text Menus");
        setSize(1000,1000);
        Container C = getContentPane();  
        C.setBackground(Color.DARK_GRAY);
        JTextArea a = new JTextArea();
        a.addKeyListener(this);
        Font f1 = new Font("",Font.BOLD,36);
        a.setFont(f1);
        Pattern pa = Pattern.compile("([A-Z]*:+)"); 
        BufferedReader br = new BufferedReader(new FileReader("E:\\STUDY\\EE 552\\parse\\error.txt"));
        while  ((line = br.readLine()) != null) {
            Matcher m =pa.matcher(line);
            while (m.find()){
                m.end();
            }
            a.append(line+"\n");
        }
        JPanel p = new JPanel(); // 创建一个JPanel面板
        p.add(a);
        C.add(a,BorderLayout.CENTER);
        setVisible(true);
    }
        public static void main(String[] args) throws FileNotFoundException, IOException {             
            try{                                                                //get error message and output to a txt
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
                        System.out.println("ERROR: "+ diagnostic.getMessage(null));
                        String text;
                        text = diagnostic.getMessage(null).toString();
                        out1.write(text); 
                        out1.write("\r\n");
                        out1.flush();            
                    }
                }
                fileManager.close();
            } catch (IOException ex) {
                Logger.getLogger(TextEditor4.class.getName()).log(Level.SEVERE, null, ex);
            }
       new TextEditor4();
    }
    @Override
    public void keyTyped(KeyEvent e) {
            }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F4) {
            System.out.println("ERROR: "+line);
	}
    }
    @Override
    public void keyReleased(KeyEvent e) {
           }

}
