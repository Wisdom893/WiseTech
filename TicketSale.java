package az.ac.tut;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Wisdom
 */
public class TicketSale extends JFrame{
    
    JPanel headingPnl;
    JPanel namePnl;
    JPanel surnamePnl;
    JPanel homePnl;
    JPanel awayPnl;
    JPanel costPnl;
    JPanel numberTcksPnl;
    JPanel totalPnl;
    JPanel btnsPnl;
    JPanel mainPnl;
    JPanel customerPnl;
    JPanel ticketsPnl;
    JPanel customerAndTicketsPnl;
    
    JLabel headingLbl;
    JLabel nameLbl;
    JLabel surnameLbl;
    JLabel homeLbl;
    JLabel awayLbl;
    JLabel costLbl;
    JLabel numberTcksLbl;
    JLabel totalLbl;
        
    JTextField nameTxtFld;
    JTextField surnameTxtFld;
    JTextField homeTxtFld;
    JTextField awayTxtFld;
    JTextField costTxtFld;
    JTextField totalTxtFld;
    
    JSlider btnSld;
    JButton buyBtn;
    JButton clearBtn;
    JButton exitBtn;
    
    public void create(){
        setTitle("Ticket Sales");
        setSize(400,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Adding Heading
        headingPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        headingLbl = new JLabel("Soccer Match Tickets");
        headingLbl.setFont(new Font(Font.SERIF, Font.BOLD + Font.ITALIC,40));
        headingLbl.setForeground(Color.red);
        headingPnl.add(headingLbl);
        
        //Adding Name
        namePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameLbl = new JLabel("Name:   ");
        nameTxtFld = new JTextField(10);
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        
        //Adding Surname
        surnamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnameLbl = new JLabel("Surname: ");
        surnameTxtFld = new JTextField(10);
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        
        //Adding Home Team
        homePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        homeLbl = new JLabel("Home team: ");
        homeTxtFld = new JTextField(10);
        homePnl.add(homeLbl);
        homePnl.add(homeTxtFld);
        
        //Adding Away Team
        awayPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        awayLbl = new JLabel("Away team: ");
        awayTxtFld = new JTextField(10);
        awayPnl.add(awayLbl);
        awayPnl.add(awayTxtFld);
        
        //Adding Cost Price
        costPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        costLbl = new JLabel("Cost price:R");
        costTxtFld = new JTextField(10);
        costPnl.add(costLbl);
        costPnl.add(costTxtFld);
        
        //Number of tickets
        numberTcksPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        numberTcksLbl = new JLabel("Number of tickets required: ");
        btnSld = new JSlider(1,20);
        numberTcksPnl.add(numberTcksLbl);
        numberTcksPnl.add(btnSld);
        
        //Total amount
        totalPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalLbl = new JLabel("Total amount due:R");
        totalTxtFld = new JTextField("To be calculated later.", 30);
        totalPnl.add(totalLbl);
        totalPnl.add(totalTxtFld);
        
        //Adding buttons
        btnsPnl = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buyBtn = new JButton("Buy");
        clearBtn = new JButton("Clear");
        exitBtn = new JButton("Exit");
        btnsPnl.add(buyBtn);
        btnsPnl.add(clearBtn);
        btnsPnl.add(exitBtn);
        
        customerPnl = new JPanel(new GridLayout(3,1,1,1));
        customerPnl.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"Customer details"));
        customerPnl.add(namePnl);
        customerPnl.add(surnamePnl);
        
        ticketsPnl = new JPanel(new GridLayout(5,1,1,1));
        ticketsPnl.setBorder(new TitledBorder(new LineBorder(Color.BLUE,2),"Tickets details"));
        ticketsPnl.add(homePnl);
        ticketsPnl.add(awayPnl);
        ticketsPnl.add(costPnl);
        ticketsPnl.add(numberTcksPnl);
        ticketsPnl.add(totalPnl);
        
        customerAndTicketsPnl = new JPanel(new GridLayout(2,1));
        customerAndTicketsPnl.add(customerPnl);
        customerAndTicketsPnl.add(ticketsPnl);
        
        mainPnl = new JPanel(new BorderLayout());
        mainPnl.add(headingPnl, BorderLayout.NORTH);
        mainPnl.add(customerAndTicketsPnl, BorderLayout.CENTER);
        mainPnl.add(btnsPnl, BorderLayout.SOUTH);
        
        add(mainPnl);
        
        pack();
        setVisible(true);
    }
}
