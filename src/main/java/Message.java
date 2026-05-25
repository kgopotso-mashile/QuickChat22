/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Student
 */
public class Message {
      private String messageID;
    private int messageNumber;
    private String recipient;
    private String messageText;
    private String messageHash;
    private String sendStatus;

    public Message(String messageID, int messageNumber, String recipient, String messageText) {
        this.messageID = Objects.requireNonNull(messageID);
        this.messageNumber = messageNumber;
        this.recipient = recipient;
        this.messageText = messageText == null ? "" : messageText;
        this.messageHash = createMessageHash();
        this.sendStatus = "NEW";
    }

    public Message(int par) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getMessageID() { return messageID; }
    public int getMessageNumber() { return messageNumber; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
    public String getMessageHash() { return messageHash; }
    public String getSendStatus() { return sendStatus; }

    public void setSendStatus(String sendStatus) { this.sendStatus = sendStatus; }

    public boolean isMessageIDValid() {
        return messageID != null && messageID.length() <= 10;
    }

    public boolean isRecipientValid() {
        if (recipient == null) return false;
        return recipient.startsWith("+27") && (recipient.length() == 12 || recipient.length() == 13);
    }

    public boolean isMessageLengthOk() {
        return messageText.length() <= 250;
    }

    public String createMessageHash() {
        String idPart = messageID.length() >= 2 ? messageID.substring(0, 2) : messageID;
        String[] words = messageText.trim().split("\\s+");
        String first = words.length > 0 ? words[0] : "";
        String last = words.length > 0 ? words[words.length - 1] : "";
        return (idPart + ":" + messageNumber + ":" + first + last).toUpperCase();
    }

    public void storeMessageToFile(String path) throws IOException {
        String json = String.format("{\"messageID\":\"%s\",\"recipient\":\"%s\",\"message\":\"%s\"}",
                messageID, recipient, messageText.replace("\"", "\\\""));
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(json + System.lineSeparator());
        }
    }

    @Override
    public String toString() {
        return "ID: " + messageID + ", Number: " + messageNumber + ", To: " + recipient
                + ", Message: " + messageText + ", Hash: " + messageHash + ", Status: " + sendStatus;
    }

    public String checkMessageLength(String validText) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String sentMessage() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     *
     * @param string
     */
    public void setMessageID(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public void setMessageText(String hi_Mike_can_you_join_us_for_dinner_tonigh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setMessageNumber(int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setRecipient(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String checkRecipientCell() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static class FileWriter {

        public FileWriter() {
        }

        private FileWriter(String path, boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }

    private static class Objects {

        public Objects() {
        }
    }

    private static class IOException extends Exception {

        public IOException() {
        }
    }

   

    
}

        

