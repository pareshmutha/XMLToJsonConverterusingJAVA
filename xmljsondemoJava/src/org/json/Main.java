package org.json;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {

    public static int PRETTY_PRINT_INDENT_FACTOR = 0;
   
    public static void main(String[] args)
    {
    	Frame f=new Frame();
    	f.addWindowListener(
    		      new WindowAdapter() {
    		        public void windowClosing(WindowEvent e) {
    		          System.exit(0);
    		          }
    		        }
    		      );
    
    }
    
    
    void converJsonToXml(String path) throws Exception{
    	String str="";
    	  try {
          	File file = new File(path);
             	FileReader fr = new FileReader(file);
             	BufferedReader br=new BufferedReader(fr);
             
            //System.out.println( br.toString());
           
              String sCurrentLine=null;
              String temp="";
              
              while ((sCurrentLine = br.readLine()) != null) {
               //System.out.println(sCurrentLine);
               temp +=sCurrentLine;
              }
            
              fr.close();
              
             	
              JSONObject xmlJSONObj = XML.toJSONObject(temp);
              String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
             // System.out.println(jsonPrettyPrintString);
              //String str[]=path.split(".xml");
              str=path.replace(".xml",".json");
              FileWriter fw=new FileWriter(str);
              fw.write(jsonPrettyPrintString);
              fw.close();
              
          } catch (JSONException je) {
              System.out.println(je.toString());
              
          }
    }
    
    
    int getPath(String path) throws Exception
    {
    	   File dir = new File(path);
    	   FilenameFilter filter=null;
    	   //System.out.println(dir.isDirectory());
    	    if (dir.isDirectory()) {
    	    	 filter =  new FilenameFilter() {
    	            @Override
    	            public boolean accept(File dir, String name) {
    	                if(name.endsWith(".xml"))
    	                {
    	                	//System.out.println("name:..."+name);
    	                    return true;
    	                }
    	                return false;
    	            }
    	        };
    	        String[] list = dir.list(filter);
        	    if(list.length==0){
        	    	//JOptionPane.showMessageDialog(null,"XML File Not Found","Error!!",JOptionPane.INFORMATION_MESSAGE);
        	    	return 0;
        	    }
    	        
        	    for(int i=0;i<list.length;i++)
        	    {
        	    	
        	    	converJsonToXml(path+"/"+list[i]);
        	    }
        	    
        	    return 1;
    	    }
    	    else
    	    {
    	    	converJsonToXml(path);
    	    	return 1;
    	    }
    	   
    	
    	
    	
    }
}
