import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener
{
	 JFrame window;
	 
	 // Text Area
	 
	 JTextArea textArea;
	 JScrollPane scrollPane;
	 boolean  wordWrap = false; 
	 
	 // Top Menu Bar
	 
	 JMenuBar menu;
	 JMenu menuFile , menuEdit , menuFormat , menuColor;
	 
	 // Top File Menu
	 
	 JMenuItem iNew , iOpen , iSave , iSaveAs , iExit ;
	 
	 // Format Menu
	 
	 JMenuItem  iWrap , iFontArial , iFontSize8 , iFontCSMS ,iFontTNR , iFontSize12 , iFontSize16 ,  iFontSize20, iFontSize24 , iFontSize28   ;
	 JMenu menuFont , menuFontSize ;
	 
	 // Edit Menu
	 
	 JMenuItem iUndo , iRedo;
	 
	 // Color Menu
	 
	 JMenuItem color1,color2 , color3;
	 Function_Edit edit = new Function_Edit(this);
	 Function_Color color = new Function_Color(this);
	 Function_File file = new Function_File(this);
	 Function_Format format = new Function_Format(this);
	 UndoManager um = new UndoManager();
	public static void main(String[] args) {
		new  GUI();
	}
	public GUI() {
		createwindow();
		createTextArea();
		createMenu();
		createFileMenu();
		cretaeFormatMenu();  
		createColorMenu();
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		color.changeColor("White");
		createEditMenu();
		window.setVisible(true);
		 
		
	}
	public void createwindow(){
		window = new JFrame("My NotePad");
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public void createTextArea() {
		textArea = new JTextArea();
		textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
				
			}
		});
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		window.add(scrollPane);
	}
	public void createMenu() {
		menu = new JMenuBar();
		window.setJMenuBar(menu);
		menuFile = new JMenu("File");
		menuEdit = new JMenu("Edit");
		menuFormat = new JMenu("Format");
		menuColor = new JMenu("Colour");
		menu.add(menuFile);
		menu.add(menuEdit);
		menu.add(menuFormat);
		menu.add(menuColor);
		
	}
	
	public void createFileMenu() {
		iNew = new  JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new  JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new  JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new  JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("Save As");
		menuFile.add(iSaveAs);
		
		iExit = new  JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	public void createEditMenu() {
		
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	
	public void cretaeFormatMenu() {
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		
		
		 menuFontSize = new JMenu("Font Size");
		 menuFormat.add(menuFontSize);
		 
		 iFontSize8 = new JMenuItem("8");
		 iFontSize8.addActionListener(this);
		 iFontSize8.setActionCommand("size8");
		 menuFontSize.add(iFontSize8);
		 
		 iFontSize12 = new JMenuItem("12");
		 iFontSize12.addActionListener(this);
		 iFontSize12.setActionCommand("size12");
		 menuFontSize.add(iFontSize12);
		 
		 iFontSize16 = new JMenuItem("16");
		 iFontSize16.addActionListener(this);
		 iFontSize16.setActionCommand("size16");
		 menuFontSize.add(iFontSize16);
		 
		 iFontSize20 = new JMenuItem("20");
		 iFontSize20.addActionListener(this);
		 iFontSize20.setActionCommand("size20");
		 menuFontSize.add(iFontSize20);
		 
		 iFontSize24 = new JMenuItem("24");
		 iFontSize24.addActionListener(this);
		 iFontSize24.setActionCommand("size24");
		 menuFontSize.add(iFontSize24);
		 
		 iFontSize28 = new JMenuItem("28");
		 iFontSize28.addActionListener(this);
		 iFontSize28.setActionCommand("size28");
		 menuFontSize.add(iFontSize28);
}
	public void createColorMenu() {
		color1 = new JMenuItem("White");
		color1.addActionListener(this);
		color1.setActionCommand("White");
		menuColor.add(color1);
		
		color2 = new JMenuItem("Black");
		color2.addActionListener(this);
		color2.setActionCommand("Black");
		menuColor.add(color2);
		
		color3 = new JMenuItem("Pink");
		color3.addActionListener(this);
		color3.setActionCommand("Pink");
		menuColor.add(color3);
		
	}
	
	public  void actionPerformed(ActionEvent e) {
		
		String command =e.getActionCommand();
		switch(command) {
		case "New" : file.newFile(); break;
		case "Open" : file.open(); break;
		case "Save As" : file.saveAs(); break;
		case "Save" : file.save(); break;
		case "Exit" : file.exit(); break;
		case "Word Wrap" : format.wordWrap();  break;
		case "Arial" : format.setFont(command); break;
		case "Comic Sans MS" : format.setFont(command); break;
		case "Times New Roman" : format.setFont(command); break;
		case "size8" : format.createFont(8); break;
		case "size12" : format.createFont(12); break;
		case "size16" : format.createFont(16); break;
		case "size20" : format.createFont(20); break;
		case "size24" : format.createFont(24); break;
		case "size28" : format.createFont(28); break;
		case "Undo" : edit.undo();break;
		case "Redo" : edit.redo();break;
		case "White" : color.changeColor(command);break;
		case "Black" : color.changeColor(command);break;
		case "Pink" : color.changeColor(command);break;
		
		}
	}
	
	
}
