package blobQuickstart.blobAzureApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

import javax.swing.*;


public class EjemploJFileChooser extends JFrame {

	private JPanel contentPane;
    private JTextField textField;
    private JTextArea textArea;
    File fichero = null;
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EjemploJFileChooser frame = new EjemploJFileChooser();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	}
	
	
	public EjemploJFileChooser() {
		 
        //Parametros asociados a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);
 
        textField = new JTextField();
        textField.setToolTipText("Inserta la ruta del fichero de audio");
        textField.setBounds(52, 26, 209, 20);
        contentPane.add(textField);
        textField.setColumns(10);
 
        JButton btnSeleccionar = new JButton("Seleccionar...");
        btnSeleccionar.setBounds(288, 25, 109, 23);
        contentPane.add(btnSeleccionar);
        
        JButton btnUpload = new JButton("Upload");
        btnUpload.setBounds(288, 55, 109, 23);
        contentPane.add(btnUpload);
 
 
        //textArea = new JTextArea();
        //textArea.setLineWrap(true);
        //textArea.setWrapStyleWord(true);
        //textArea.setBounds(52, 76, 360, 156);
 
        //JScrollPane scroll=new JScrollPane(textArea);
        //scroll.setBounds(52, 76, 360, 156);
        //contentPane.add(scroll);
 
        btnSeleccionar.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	//Creamos el objeto JFileChooser
            	JFileChooser fc=new JFileChooser();
            	 
            	//Abrimos la ventana, guardamos la opcion seleccionada por el usuario
            	int seleccion=fc.showOpenDialog(contentPane);
            	
            	if(seleccion==JFileChooser.APPROVE_OPTION){
            		 
            	    //Seleccionamos el fichero
            	   // File fichero=fc.getSelectedFile();
            	    
            	    fichero=fc.getSelectedFile();
            	    
            	  //Ecribe la ruta del fichero seleccionado en el campo de texto
            	    textField.setText(fichero.getAbsolutePath());
            	 
            	    
            	}
            }
        });
        
        btnUpload.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
            	
            	System.out.print("Ingresa al evento Upload");
            	AzureApp newAzureApp = new AzureApp(fichero);
            }
        });
 
    }
	



}
