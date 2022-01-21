package capeLauncher;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {
	
	static File hosts = new File(System.getenv("SystemDrive") + "\\Windows\\System32\\drivers\\etc\\hosts");
	
	public static boolean checkifalreadyinstalled() {
		boolean isin = false;
		try {
		    Scanner scanner = new Scanner(hosts);
		    while (scanner.hasNextLine()) {
		        if(scanner.nextLine().contains("s.optifine.net")) {
		        	isin = true;
		        }
		    }
		    scanner.close();
		} catch(Exception ex) { 
			JOptionPane.showMessageDialog(null, "Unexpected error", "Unexpected error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return isin;
	}
	
	public static void addhost() {
	    try {
	        FileWriter writer = new FileWriter(hosts);
	        writer.write("51.83.180.192 s.optifine.net");
	        writer.close();
	        JOptionPane.showMessageDialog(null, "Custom capes successfully installed!", "Installed!", JOptionPane.INFORMATION_MESSAGE);
	        System.exit(1);
	    } catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Unexpected error", "Unexpected error", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    }
	}
	
	public static void remove() {
		try {
			PrintWriter writer = new PrintWriter(hosts);
			writer.print("");
			writer.close();
		} catch (Exception e) {
	    	JOptionPane.showMessageDialog(null, "Unexpected error", "Unexpected error", JOptionPane.ERROR_MESSAGE);
	    	System.exit(0);
	    }
	}
	
	public static void main(String[] args) {
		int decision = JOptionPane.showConfirmDialog(null, "Press YES to install\nPress NO to uninstall", "Custom capes", JOptionPane.YES_NO_OPTION);
		if(decision == 1) {
			if(checkifalreadyinstalled()) {
				remove();
				JOptionPane.showMessageDialog(null, "You succesfully removed custom capes!", "Succes", JOptionPane.INFORMATION_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(null, "You dont have custom capes installed!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if(decision == 0) {
			if(!checkifalreadyinstalled())
				addhost();
			else
				JOptionPane.showMessageDialog(null, "You have already installed custom capes!", "Error", JOptionPane.ERROR_MESSAGE);
		}		
	}
}
