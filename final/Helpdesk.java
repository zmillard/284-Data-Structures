/*
*Zoe Millard
*
*Main method
*"I pledge my honor that I have abided by the Stevens Honor System" -ZM
*
*/

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Helpdesk{
	
	public static void main (String[]args){
 		String fileName = "messages.txt";
 		MaxHeap listing = new MaxHeap();
 		MessageList temp = new MessageList(100);
 		System.out.println("Please input your data in the format USERNAME|HOSTNAME|PROBLEM|LEVEL\n");

		try{
          	FileReader inputFile = new FileReader(fileName);
          	BufferedReader bufferReader = new BufferedReader(inputFile);
          	String message;
          	while ((message = bufferReader.readLine()) != null){
					Message m = new Message(message);
					listing.add(m);
         	}
          	
          	bufferReader.close(); 
        }catch(Exception e){
        	System.out.println("Error while reading file line by line:" + e.getMessage());    
            e.printStackTrace();                  
        }		
      	listing.showList();
      	System.out.println("");
      	System.out.println("Begin removal process:\n");
      	int s = listing.size();
      	for(int i = 0; i < s; i++){
      		Message look = listing.removeMax();	
      		temp.add(look);
      	}
      	listing.showList();
      	temp.print();
	}
}