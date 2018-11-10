package regex;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.*;
/**
 *
 * @author Jiacheng
 */
public class Regex {
    public static void main(String[]args){
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("E:\\STUDY\\EE 552\\parse\\Frankenstein.txt"));
            String line1;
            File writename = new File("E:\\STUDY\\EE 552\\parse\\output.txt"); 
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename));
            while  ((line1 = br1.readLine()) != null) {
            line1 =  br1.readLine();
            Pattern pattern = Pattern.compile("([A-Z]*[a-z]*[0-9]*)\\'*\\w+");
            Matcher matcher = pattern.matcher(line1);
            while (matcher.find()) {
            // System.out.println(matcher.group());
			out.write(matcher.group()); 
                        out.write("\r\n");
			out.flush(); // 把缓存区内容压入文件
            }
            }   out.close();
        } catch(Exception e) {
            System.out.println("Sorry, can't do it!");
            e.printStackTrace();    
        } 
        
        try{
            BufferedReader br2 = new BufferedReader(new FileReader("E:\\STUDY\\EE 552\\parse\\output.txt"));
            Map<String,Integer> map = new HashMap<>();
            String line2;
             while((line2 = br2.readLine())!=null){
             int i =0;
             map.put(line2,i);
             i++;
            }
             
            BufferedReader br3 = new BufferedReader(new FileReader("E:\\STUDY\\EE 552\\parse\\shortwords.txt"));           
            String line3;
             while((line3 = br3.readLine())!=null){
                line3 = br3.readLine();
                if(map.containsKey(line3)==true){
                System.out.print("Your word: "+line3+"\n");
                }
                else{
                }             
            }
        }
        catch(Exception e) {
            System.out.println("Sorry, can't do it!");
            e.printStackTrace();    
        } 
    }
}