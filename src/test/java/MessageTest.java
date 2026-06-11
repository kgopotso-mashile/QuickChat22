 
import com.mycompany.quickchat.Message;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

         


public class MessageTest {
    
}
   
    
  
            //***************************************************************************************
    
            //============================Message Length Tests=======================================
    
            //****************************************************************************************
   @Test
public void testMessageLengthValid() {

    Message msg = new Message(3);

    String validText = "Hi Mike, can you join us for dinner tonight?";

    String result = msg.checkMessageLength(validText);

    assertEquals("Message ready to send.", result);
}

@Test
public void testMessageLengthInvalid() {

    Message msg = new Message(3);

    String invalidText = "A".repeat(251);

    String result = msg.checkMessageLength(invalidText);

    assertEquals(
        "Message exceeds 250 characters by 1, please reduce the number of your characters.",
        result
    );
}

//******************************************************************************************
//=============================Recipient Number Test=========================================
//********************************************************************************************

@Test
public void testRecipientNumberCorrectFormat() {

    Message msg = new Message(3);

    msg.setRecipient("+27718693002");

    String result = msg.checkRecipientCell();

    assertEquals("Cell phone number successfully captured", result);
}

@Test
public void testRecipientNumberIncorrectFormat() {

    Message msg = new Message(3);

    msg.setRecipient("08575975889");

    String result = msg.checkRecipientCell();

    assertEquals(
        "Cell phone number is incorrectly formatted or does not contain an International code, please try again",
        result
    );
}

//********************************************************************************************
//                             Message Hash Test
//********************************************************************************************

@Test
public void testMessageHashCorrectHash() {

    Message msg = new Message(3);

    msg.setMessageNumber(0);

    msg.setMessageText("HI Mike, can you join us for dinner tonight?");

    msg.setMessageID("0012345678");

    String hash = msg.createMessageHash();

    assertEquals("00:0:HITONIGHT", hash);
}

@Test
public void testMessageHashLoopTest() {

    String[] messages = {
        "Hi Mike can you join us for dinner tonight?",
        "Hi friend, are you still coming on Sunday?"
    };

    String[] expectedHashes = {
        "00:0:HITONIGHT",
        "01:1:HISUNDAY"
    };

    for (int i = 0; i < messages.length; i++) {

        Message msg = new Message(3);

        msg.setMessageNumber(i);

        msg.setMessageText(messages[i]);

        msg.setMessageID("0" + i + "12345678");

        String hash = msg.createMessageHash();

        assertEquals("Failed on message " + i, expectedHashes[i], hash);
    }
}

//********************************************************************************************
//                      Message ID Test
//********************************************************************************************

@Test
public void testMessageID() {

    Message msg = new Message(3);

    String messageID = msg.getMessageID();

    String result = "Message ID generated: " + messageID;

    assertTrue(result.startsWith("Message ID generated: "));

    assertNotNull(messageID);

    assertEquals(10, messageID.length());
}

//********************************************************************************************
//                      Message Test
//********************************************************************************************

@Test
public void testSentMessageSuccess() {

    Message msg = new Message(3);

    String result = msg.sentMessage();

    assertEquals("Message sent successfully", result);
}

@Test
public void testSentMessageDisregard() {

    Message msg = new Message(2);

    String result = msg.sentMessage();

    assertEquals("Quit", result);
}

@Test
public void testMessageStoreOption() {

    Message msg = new Message(3);

    String result = msg.sentMessage();

    assertEquals("Message stored successfully", result);
}

//-----------------------------------------------------MESSAGE TEST--------------------------------------------------------------------------------------
      
    @Test
    public void testMessageLengthSuccess() { 
    //Checks if the message is no more than 250 charecters in length
    //The expected results is: message is ready to send 
        assertEquals("Message is ready to send", message.checkMessageLength("HI!"));
       }  
    
    @Test
    public void testMessageLengthFail() { 
    //Checks if the message is more than 250 charecters in length
    String longMessage = "A". repeat(251);
    String result = message.checkMessageLength(longMessage);
        assertTrue(result.contains("251"), result);
    }
    
//----------------------------------------------RECIPIENT NUMBER TEST-------------------------------------------------------------------
    
    
    @Test
    public void testValidRecipientNumber() { 
        //this checks if the recipient number is valid
        //Expected results are: Message Sucess
        assertEquals("Cell phone number successfully added.", message.checkRecipientCell("+27838967986")); 
     
    }
    
    @Test
    public void testInvalidRecipientNumber() { 
        //Checks if the recipient number is incorrect
        //Expected results is: a failure message
         assertEquals("Cellphone number is incorrectly formatted", message.checkRecipientCell("0823344556"));
    }
    
    
//-----------------------------------------------MESSAGE HASH TEST------------------------------------------------------------------------------
    
    @Test
    public void testCorrectMessageHash() { 
        //Checks if the message hash is correct
        //Expected results is: "00:0:HITONIGHT" for test data1
         assertEquals("00:0:HITONIGHT", message.createMessageHash(0, "Hi tonight")); 
    }

    
//-----------------------------------------------MESSAGE ID TEST-------------------------------------------------------------------
        @Test
    public void testMessageIDCreated() { 
        //Checks if the message ID is created and is the correct length
        String messageID = message.createMessageID();
        assertNotNull(messageID);
        assertEquals(10, messageID.length());
    }
    
//--------------------------------------------SENT MESSAGES TEST-----------------------------------------------------------
    
        @Test
        public void testSentMessages() { 
        //Checks if the message is successfully sent when "Send" is chosen as an option
        //Expected results is: Message is successfully sent
         assertEquals("Message successfully sent.", message.sentMessage (1, "Hi tonight","+27838967986" ));
        }

        @Test
        public void testDisregardMessage() { 
        //Checks if the message is disregarded when "Disregard" is chosen as an option
        //Expected results is: Press 0 to delete
         assertEquals("Press 0 to delete the message.", message.sentMessage (2, "Hi tonight", "+27838697689"));
        }
        
        @Test
        public void testStoredMessage() { 
        //Checks if the message is sucessfully stored when "Store" is chosen as an option
        //Expected results is: Message sucessfully stored
         assertEquals("Message sucessfully stored.", message.sentMessage (3, "Hi tonight", "+27838697689"));
        }

//====================================================================================================================================
//                                                         PART3 TESTS
//====================================================================================================================================


    @Test 
    public void testSentMessageArray_correctlyPopulated() { 
        //This checks if the sentMessage array contains only messages flagged as sent 
        //Expected results: "Did you get the cake?" and "It is dinner time"are present 
            assertTrue(manager.getSentMessages().contains("Did you get the cake?") && manager.getSentMessages().contains("It is dinner time!")); 
    }


    //----------------------------------------------LONGEST MESSAGE TEST---------------------------------------------------------------------------
        
        @Test 
    public void testDisplayLongestMessage_returnsCorrectMessages() { 
        //This checks if dispaly longest message displays the longest message 
        //Expected results: "Where are you? You are late! I have asked you to be on time." 
            assertEquals("Where are you? You are so late! I have asked you to be on time", manager.displayLongestMessage());
    } 

        @Test 
    public void testSearchByMessageID_returnCorrectMessage() { 
        //This checks if searching by messsage 4s ID returns the correct message
        //Expected results: "It is dinner time"
            assertEquals("It is dinner time!", manager.searchByMessageID("0838884567"));
    }
    
//-----------------------------------------------------SEARCH BY RECIPIENT TEST------------------------------------------------------------------------------
    

    @Test
    public void testSearchByRecipient_returnsAllMatchingMessages() { 
        //This checks if the recipient "+278388845667" returns all matching messages
        String results = manager.searchByRecipient("+27838884567"); 
                assertTrue(results.contains("Where are you? You are late! I have asked you to be on time") && results.contains("Ok, I amleaving without you."));
    }
    
//--------------------------------------------------------DEPLETE BY HASH TEST-------------------------------------------------------------
    

    @Test
    public void testDepleteByHash_removeCorrectMessages() { 
        //Checks if deleting messages by 2 removes the correct messages
        assertEquals("Messsage: Where are you? You are late! I have asked ypu to be on time successfully deleted.", manager.dleteByHash(message.getMessageHash()));
    }

    
    @Test
    public void testDisplayReport_containsRequiredFields() { 
        //This checks if the report contains the hash, the recipient and a messsage sent for all messages
        //Expected message is: the report string contains the hash, recipient and message text for messages 1 and 4. 
        String report = manager.displayReport(); 
            assertTrue(report.contains(message.getMessageHash()) && report.contains("+27838884567") && report.contains("Did you get the cake?") && report.contains(message.getMessageHash())
&& report.contains("0838884567") && report.contains("It is dinner time!"));                     
       
}
}
