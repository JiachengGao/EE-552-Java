package texteditor;
/**
 * @author Jiacheng Gao, Jiawei Wang
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Method;
import javax.swing.*;
import javax.swing.text.*; 
import java.net.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.*;
import javax.tools.*;

public class TextEditor2 extends JFrame{
    public JTextPane textPane = new JTextPane();  
    public JFileChooser filechooser = new JFileChooser();
    public int x;
    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
   // DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
    StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
    String filename = "C:\\Users\\Jiacheng\\Desktop\\test.java";
   
    public TextEditor2(){
        super("Text Menus");
        setSize(1000,1000);
        Container C = getContentPane();
        C.setBackground(Color.DARK_GRAY);
        JTextField t = new JTextField();
        JMenu m1 = new JMenu("File");
        JMenu m2 = new JMenu("Build");
        JMenuBar b = new JMenuBar();
        b.add(m1);
        b.add(m2);
        setJMenuBar(b);
        C.add(t,BorderLayout.CENTER);
        Font f1 = new Font("",Font.BOLD,36);
        Font f2 = new Font("",Font.BOLD,28);
        JMenuItem mi1 = new JMenuItem ("New");
        JMenuItem mi2 = new JMenuItem ("Open");
        JMenuItem mi3 = new JMenuItem ("Save");
        JMenuItem mi4 = new JMenuItem ("Quit");
        JMenuItem mi5 = new JMenuItem ("Compile Run");
        m1.setFont(f1);
        m2.setFont(f1);
        mi1.setFont(f2);
        mi2.setFont(f2);
        mi3.setFont(f2);
        mi4.setFont(f2);
        mi5.setFont(f2);
        t.setFont(f2);
        m1.add(mi1);
        m1.add(mi2);
        m1.add(mi3);
        m1.add(mi4);
        m2.add(mi5);
        mi1.addActionListener(new MyListener1());
        mi2.addActionListener(new MyListener2());
        mi3.addActionListener(new MyListener3());
        mi4.addActionListener(new MyListener4());
        mi5.addActionListener(new MyListener5());
        
        setVisible(true);
    }
    public static void main(String[] args) {
       new TextEditor2();
    }
    
    class MyListener1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            clearArea(); 
        }

        private void clearArea() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    class MyListener2 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            int i = filechooser.showOpenDialog(TextEditor2.this);        
            if(i == JFileChooser.APPROVE_OPTION){  
                File f = filechooser.getSelectedFile();   
                try{  
                    InputStream a = new FileInputStream(f);  
                    textPane.read(a, "d");  
                }  
                catch(Exception ex){  
                    ex.printStackTrace();  
                }  
            }
        }
    }
    class MyListener3 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            x=1;
        }
    }
    class MyListener4 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(x==1){
                System.exit(0);
            }
                else{
                Component TextEditor = null;
                int y = JOptionPane.showConfirmDialog(TextEditor,"Do you want to save it before quiting?","Warning",JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_OPTION);
                    if(y==0){
                        x=1;
                    }
                    else{
                    x=0;     
                     }
                }
            }
    }
    class MyListener5 implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(x==1){                
                try {
                    String fileName = "C:\\Users\\Jiacheng\\Desktop\\test.java";
                    JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                    DiagnosticCollector<JavaFileObject> diagnosticsCollector = new DiagnosticCollector<JavaFileObject>();
                    StandardJavaFileManager fileManager = compiler.getStandardFileManager(diagnosticsCollector, null, null);
                     Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromStrings(Arrays.asList(fileName));
                    JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, diagnosticsCollector, null, null, compilationUnits);
                    boolean success = task.call();
                    if (!success) {
                        List<Diagnostic<? extends JavaFileObject>> diagnostics = diagnosticsCollector.getDiagnostics();
                        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics) {
      
                         System.out.println(diagnostic.getMessage(null));
                        }
                    }
                    fileManager.close();
                    System.out.println("Success: " + success);
               
//                    Runtime r = Runtime.getRuntime();
//                    Process p = r.exec("javac "+filename);
//                    BufferedReader isr = new BufferedReader (new InputStreamReader(p.getErrorStream()) );
//                    StringBuilder sb = new StringBuilder();
//                    String line;
//                    while((line = isr.readLine())!=null)
//                        sb.append(line+"\n");
//                    int status = p.exitValue();
//                    System.out.println("Process ran with result:"+ status);
//                    System.out.println(sb);
//                    
                    //Iterable < ?extends JavaFileObject> compilationUnits1 = fileManager.getJavaFileObjectsFromFiles(Arrays.asList(filename));
                    //compiler.getTask(null,fileManager,null,null,null,compilationUnits1).call();
                    //System.out.println(System.getProperty("user.dir"));
//                for (Diagnostic diagnostic : diagnostics.getDiagnostics())
//                 System.out.format("Error on line %d in %s%n",
//                             diagnostic.getLineNumber());
                } catch (IOException ex) {
                    Logger.getLogger(TextEditor2.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
                else{
                Component TextEditor = null;
                int y = JOptionPane.showConfirmDialog(TextEditor,"Do you want to save it before compiling?","Warning",JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_OPTION);
                    if(y==0){
                        x=1;
                    }
                    else{
                    x=0;     
                     }
                }
        }
    }
}

