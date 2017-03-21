/**
 * Copyright 2006 Alien Technology Corporation. All rights reserved.
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * <p>
 * 1)	Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * <p>
 * 2)	Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * <p>
 * 3)	Neither the name of Alien Technology Corporation nor the names of any
 * contributors may be used to endorse or promote products derived from this
 * software without specific prior written permission.
 * <p>
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL ALIEN TECHNOLOGY CORPORATION OR ITS CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 * GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * <p>
 * For further information, contact :
 * <p>
 * Alien Technology
 * 18220 Butterfield Blvd.
 * Morgan Hill, CA 95037
 */

package com.nisira.alien.example;

import com.alien.enterpriseRFID.reader.*;
import com.alien.enterpriseRFID.tags.Tag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;

import javax.comm.*;

/**
 * Connects to a Reader on COM port #1 and begins an interactive session. Enter
 * "q" to quit the session.
 *
 * @version 1.1 Feb 2004
 * @author David Krull
 */
public class AlienPrueba {

/**
 * Constructor
 */
public AlienPrueba() throws Exception {

  AlienClass1Reader reader = new AlienClass1Reader("COM4"); // Create reader object
  reader.setAntennaSequence("(0,1)");
  reader.open(); // Open the reader connection
  // Use stdin for user input
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  String dataConsole="";
  StringTokenizer tokens;
  List listTag=new ArrayList();
  do {
//    System.out.print("\nAlien>"); // Show prompt
//    String line = in.readLine(); // Grab user input
    String line = "t"; // Grab user input-> Comando para leer codigo
    if (line.equals("q")) break; // Quit when "q" is pressed
    dataConsole=reader.doReaderCommand(line);
//    System.out.println(dataConsole); // Send command, print result
    /****************************CONFIGURACIÓN TAG******************************/
    listTag.clear();
    if(dataConsole!=null){
    	tokens = new StringTokenizer(dataConsole,"\n");
    	while(tokens.hasMoreTokens()){
    		listTag.add(new Tag(dataConsole));
    		tokens.nextToken();
//    		System.out.println(tokens.nextToken());
    	}
    	if(listTag.size()>0){
    		response(listTag);
    		System.out.println("Antena N°"+reader.getAntennaSequence());
    	}
    }
    /***************************************************************************/
    System.out.println("\n*********************************************************************************************");
    Thread.sleep(500);
  } while (true); // Repeat indefinitely
  System.out.println("\nGoodbye.");
  reader.close(); // Close the reader connection
}

public void response(List result){
	System.out.println("\nTotal Tag: "+result.size());
	for(int i=0;i<result.size();i++){
		System.out.println("N°"+(i+1)+" Tag: "+((Tag)result.get(i)).getTagID());
		
	}
}
/**
 * Main
 */
	public static final void main(String args[]){
	  try {
	    new AlienPrueba();
	  } catch(Exception e) {
	    System.out.println("Error: " + e.toString());
	  }
	}
} // End of class AlienClass1Communicator