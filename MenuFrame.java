package az.ac.tut;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Wisdom
 */
public class MenuFrame extends JFrame{
    
    JMenu file;
    JMenu edit;
    JMenu view;
    JMenu editors;
    JMenu split;
    
    JMenuItem newPrjct;
    JMenuItem newfl;
    JMenuItem openPrjct;
    JMenuItem openRecPj;
    JMenuItem closePj;
    JMenuItem undo;
    JMenuItem redo;
    JMenuItem cut;
    JMenuItem copy;
    JMenuItem paste;
    JMenuItem sourc;
    JMenuItem horiz;
    JMenuItem vertic;
    JMenuItem clear;
    
    JMenuBar menuBar;
    
    public void create(){
        
        setTitle("Menu Frame");
        setSize(400,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //Adding File Items
        file = new JMenu("File");
        newPrjct = new JMenuItem("New Project...");
        newfl = new JMenuItem("New File...");
        openPrjct = new JMenuItem("Open Project...");
        openRecPj = new JMenuItem("Open Recent Project");
        closePj = new JMenuItem("Close All Projects");
        file.add(newPrjct);
        file.add(newfl);
        file.add(openPrjct);
        file.add(openRecPj);
        file.add(closePj);
        
        //Adding Edit Items
        edit = new JMenu("Edit");
        undo = new JMenuItem("Undo");
        redo = new JMenuItem("Redo");
        cut = new JMenuItem("Cut", new ImageIcon("images/cut.png"));
        copy = new JMenuItem("Copy", new ImageIcon("images/copy.png"));
        paste = new JMenuItem("Paste", new ImageIcon("images/paste.png"));
        edit.add(edit);
        edit.add(redo);
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        
        //Adding View Items
        view = new JMenu("View");
        editors = new JMenu("Editors");
        split = new JMenu("Split");
        sourc = new JMenuItem("Source");
        editors.add(sourc);
        view.add(editors);
        horiz = new JMenuItem("Horizontally");
        vertic = new JMenuItem("Vertically");
        clear = new JMenuItem("Clear");
        split.add(horiz);
        split.add(vertic);
        split.add(clear);
        view.add(split);
        
        menuBar = new JMenuBar();
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(view);
        
        setJMenuBar(menuBar);
        
        setVisible(true);
    }
}
