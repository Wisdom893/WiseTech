package za.ac.tut;

import za.ac.tut.message.Message;


public class MessageEncryptor {
    
    private Message message;
    private String plain;
    private String encrptd;
    private final int SHIFT_VALUE = 3;

    public MessageEncryptor(Message message) {
        this.message = message;
    }
    
    public String encrptMessage(){
        
        plain = message.getMessage();
        plain = plain.toUpperCase();
        char convertMessage[] = new char[plain.length()];
        
        for(int i = 0; i < plain.length(); i++){
            
            char ch = plain.charAt(i);
            if(Character.isLetter(ch)){
                ch = (char)((ch-'A'+SHIFT_VALUE)% 26 + 'A');
            }
            
            convertMessage[i] = ch;
        }
        encrptd = new String(convertMessage);
        
        return encrptd;
    }
}
