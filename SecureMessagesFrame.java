package za.ac.tut.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import za.ac.tut.MessageEncryptor;
import za.ac.tut.message.Message;


public class SecureMessagesFrame extends JFrame{
    
    JMenu file;
    JMenuItem opnFile;
    JMenuItem encrptMsg;
    JMenuItem saveEncrptMsg;
    JMenuItem clear;
    JMenuItem exit;
    
    JMenuBar menuBar;
    
    JPanel headingPnl;
    JPanel txtPnl1;
    JPanel txtPnl2;
    JPanel plnMsgPnl;
    JPanel encrptMsgPnl;
    JPanel plainAndEncrpt;
    JPanel mainPnl;
    
    JLabel headingLbl;
    
    JTextArea txtArea1;
    JTextArea txtArea2;
    JScrollPane scrollPane1;
    JScrollPane scrollPane2;
    
    public void create(){
        setTitle("Secure Messages");
        setSize(700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        file = new JMenu("File");
        opnFile = new JMenuItem("Open File...");
        opnFile.addActionListener(new OpenListener());
        
        encrptMsg = new JMenuItem("Encrypt message...");
        encrptMsg.addActionListener(new EncryptListener());
        
        saveEncrptMsg = new JMenuItem("Save encrypted mrssage...");
        saveEncrptMsg.addActionListener(new SaveListener());
        
        clear = new JMenuItem("Clear");
        clear.addActionListener(new ClearListener());
        
        exit = new JMenuItem("Exit");
        exit.addActionListener(new ExitListener());
        
        file.add(opnFile);
        file.add(encrptMsg);
        file.add(saveEncrptMsg);
        file.addSeparator();
        file.add(clear);
        file.add(exit);
        
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headingLbl = new JLabel("Message Encryptor");
        headingLbl.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC,40));
        headingLbl.setForeground(Color.BLUE);
        headingPnl.add(headingLbl);
        
        txtArea1 = new JTextArea(10,30);
        scrollPane1 = new JScrollPane(txtArea1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        txtPnl1 = new JPanel();
        txtPnl1.add(scrollPane1);
        
        txtArea2 = new JTextArea(10,30);
        txtArea2.setEditable(false);
        scrollPane2 = new JScrollPane(txtArea2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        txtPnl2 = new JPanel();
        txtPnl2.add(scrollPane2);
        
        plnMsgPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        plnMsgPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1),"Plain message"));
        plnMsgPnl.add(txtPnl1);
        
        encrptMsgPnl = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        encrptMsgPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1), "Encrypted message"));
        encrptMsgPnl.add(txtPnl2);
        
        plainAndEncrpt = new JPanel(new GridLayout(1,2,1,1));
        plainAndEncrpt.add(plnMsgPnl);
        plainAndEncrpt.add(encrptMsgPnl);
        
        menuBar = new JMenuBar();
        menuBar.add(file);
                
        setJMenuBar(menuBar);
        
        mainPnl = new JPanel(new BorderLayout());
        mainPnl.add(headingPnl, BorderLayout.CENTER); 
        mainPnl.add(plainAndEncrpt, BorderLayout.SOUTH);
        add(mainPnl);
        
        pack();
        
        setVisible(true);
    }
    
    private class ClearListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            txtArea1.setText("");
            txtArea2.setText("");
        }
        
    }
    
    public class EncryptListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Message mess = new Message();
            mess.setMessage(txtArea1.getText());
            
            MessageEncryptor encrptM = new MessageEncryptor(mess);
            txtArea2.setText(encrptM.encrptMessage());
        }
        
    }
    
    public class ExitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        
    }
    
    public class OpenListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String data = "", line;
            
            JFileChooser fileChooser = new JFileChooser();
            int val = fileChooser.showOpenDialog(null);
            
            if(val == JFileChooser.APPROVE_OPTION){
                
                File file = fileChooser.getSelectedFile();
                
                try {
                    FileReader fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    
                    while((line = br.readLine()) != null){
                        
                        data = data + "\n"; 
                        txtArea1.setText(data);
                    }
                    br.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
        
    }
    
    public class SaveListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String data = "", line;
            
            JFileChooser fileChooser = new JFileChooser();
            int val = fileChooser.showSaveDialog(null);
            
            if(val == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                
                try {
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    
                    data = txtArea2.getText();
                    bw.write(data);
                    bw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
        
    }
}
