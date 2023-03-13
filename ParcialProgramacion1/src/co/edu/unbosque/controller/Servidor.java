package co.edu.unbosque.controller;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread{
    private Socket puertoS; 
    private Socket puertoP;
    private Socket servidor; 
    private DataInputStream entrada;
    private DataOutputStream salida;
    private int	puerto;
    private String direccionCliente;
	private Object socket;
  
   
    public Servidor(int port){ 
    	this.puertoS=null;
    	this.puertoP=null;
    	this.servidor=null; 
    	this.entrada=null;
    	this.salida=null;
    	this.puerto=port;
    	this.direccionCliente=direccionCliente;
     
    }
    
    public void run(){

        String line = ""; 
        BufferedInputStream socket = null;
		while (!line.equals("Over")) 
        { 
            try
            { 
            	this.servidor = new Socket();
    			System.out.println("Servidor iniciado"); 
    	        System.out.println("Esperando el cliente ..."); 
    	        ServerSocket server = null;
				this.servidor = server.accept(); 
    	        System.out.println("Cliente aceptado"); 
    	        this.entrada = new DataInputStream(new BufferedInputStream(socket.nullInputStream()));       	
            	line = entrada.readUTF(); 
                System.out.println(line);
            	this.puertoP=new Socket(((ServerSocket) this.socket).getInetAddress(), this.puerto+1);
                this.salida = new DataOutputStream(servidor.getOutputStream()); 
                this.salida.writeUTF("You send this: "+line+" :D");
                this.salida.close();
                this.servidor.close();
                
                this.entrada.close();
                this.servidor.close();
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
        System.out.println("Closing connection"); 

        try {
			socket.close();
			entrada.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
    } 
    
    }
    	