package co.edu.unbosque.controller;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente extends Thread{

    private Socket socket;
    private ServerSocket server; 
    private Scanner sn;
    private DataOutputStream out;
    private DataInputStream in; 
    private String direccion;
    private int puerto;
  
    
    public Cliente(String direccion, int puerto){ 
    	
        this.socket= null;
        this.server=null;
        this.sn=new Scanner(System.in);
        this.out= null;
        this.direccion=direccion;
        this.puerto=puerto;
        
        
      
    }
    
    @Override
    public void run() {
    	
    	
        String line = ""; 
  
    	
        while (!line.equals("Over")) 
        { 
        	 
        	try
            { 
        		this.socket = new Socket(this.direccion, this.puerto); 
                System.out.println("Connected"); 
            
                
                this.out = new DataOutputStream(socket.getOutputStream()); 
        		
        		
                line=sn.next();
                this.out.writeUTF(line);
                this.out.close(); 
                this.socket.close(); 
                
                this.server = new ServerSocket(this.puerto+1);
    	        this.socket = server.accept(); 
    	        System.out.println("Received message:"); 
    	        
    	        this.in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                
                System.out.println(in.readUTF());
                this.in.close();
                this.server.close();
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
       
        try
        { 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    	
    }    	
    } 
    
