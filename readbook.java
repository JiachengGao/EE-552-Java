package parse;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.*;
/**
 *
 * @author Jiacheng Gao, Jiawei Wang
 */
public class readbook {
    public static void main(String[]args) throws Exception{
            BufferedReader br1 = new BufferedReader(new FileReader("E:\\STUDY\\EE 552\\parse\\Frankenstein.txt"));
            String line1;
            File writename1 = new File("E:\\STUDY\\EE 552\\parse\\output.txt"); 
            writename1.createNewFile(); // 创建新文件
            BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
            while  ((line1 = br1.readLine()) != null) {
            line1 =  br1.readLine();
            Pattern pattern = Pattern.compile("([A-Z]*[a-z]*[0-9]*)\\'*\\w+");
            Matcher matcher = pattern.matcher(line1);
            while (matcher.find()) {
			out1.write(matcher.group()); 
                        out1.write("\r\n");
			out1.flush(); // 把缓存区内容压入文件
            }
            }   out1.close();
            
            FileReader fr2 = new FileReader("E:\\STUDY\\EE 552\\parse\\shortwords.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            HashMap<String,Integer> shortwords = new HashMap<>();
            String line;
            while((line=br2.readLine())!=null){
            int i = 0;
            shortwords.put(line,i);
            i++;
            } 
            // send same words to compare.txt
            FileReader fr3 = new FileReader("E:\\STUDY\\EE 552\\parse\\output.txt");
            BufferedReader br3 = new BufferedReader(fr3);
            String line3;
            while  ((line3 = br3.readLine()) != null) {
            line3 =  br3.readLine();
            if(shortwords.containsKey(line3)==true){
                File writename2 = new File("E:\\STUDY\\EE 552\\parse\\compare.txt"); 
                writename1.createNewFile();
                BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));
             }
            else{
                System.out.print("mis-spelled word"+"\n");
        }
            
    }
}
}