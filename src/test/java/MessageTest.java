 
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