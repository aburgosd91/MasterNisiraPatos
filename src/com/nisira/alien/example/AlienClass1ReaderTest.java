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
import com.alien.enterpriseRFID.tags.*;

/**
 * Connects to a Reader on COM port #1 and asks it to read tags.
 *
 * @version 1.2 Feb 2004
 * @author David Krull
 */
public class AlienClass1ReaderTest {

/**
 * Constructor
 * @throws InterruptedException 
 */
public AlienClass1ReaderTest() throws AlienReaderException, InterruptedException {

  AlienClass1Reader reader = new AlienClass1Reader();
  reader.setConnection("COM3");
  reader.open();
//  reader.programTag("E1 00 9A 50 80 03 0A F0 00 00 41 53"); 
// To connect to a networked reader instead, use the following:

//  reader.setConnection("10.1.60.107", 23);
//  reader.setUsername("alien");
//  reader.setPassword("password");
 
  // Open a connection to the reader
  
  /*******************PROGRAMANDO**************************/
  //reader.setAntennaSequence("0,1");
  /********************************************************/
//  reader.open();
  Tag tagList[] = reader.getTagList();
  Tag tag=null;
  if (tagList == null) {
	    System.out.println("No Tags Found");
  } else {
    System.out.println("Tag(s) found:");
    for (int i=0; i<tagList.length; i++) {
      tag = tagList[i];
      System.out.println("ID:" + tag.getTagID() +
                         ", Discovered:" + tag.getDiscoverTime() +
                         ", Last Seen:" + tag.getRenewTime() +
                         ", Antenna:" + tag.getAntenna() +
                         ", Reads:" + tag.getRenewCount()
                         );
    }
  }
  /*ESCRITURA*/
//  if(tag!=null){
//	  System.out.println("Entre ...");
//	  tag.setTagID("E2009A5080030AF000004153");
//	  System.out.println("Sali ...");
//  }
//  reader.close();

//  boolean t=true;
//  do{
//	  reader.open();
//	  Tag tagList[] = reader.getTagList();
//	  if (tagList == null) {
//	    System.out.println("No Tags Found");
//	  } else {
//	    System.out.println("Tag(s) found:");
//	    for (int i=0; i<tagList.length; i++) {
//	      Tag tag = tagList[i];
//	      System.out.println("ID:" + tag.getTagID() +
//	                         ", Discovered:" + tag.getDiscoverTime() +
//	                         ", Last Seen:" + tag.getRenewTime() +
//	                         ", Antenna:" + tag.getAntenna() +
//	                         ", Reads:" + tag.getRenewCount()
//	                         );
//	    }
//	  }
//	  Thread.sleep(1000);
	  reader.close();
//  }while(t);
  // Ask the reader to read tags and print them
  System.out.println("\nGoodbye.");
  // Close the connection
  // Data : E200 9A50 8003 0AF0 0000 4152
}

/**
 * Main
 * @throws InterruptedException 
 */
public static final void main(String args[]) throws InterruptedException{
  try {
    new AlienClass1ReaderTest();
  } catch(AlienReaderException e) {
    System.out.println("Error: " + e.toString());
  }
}

} // End of class AlienClass1ReaderTest