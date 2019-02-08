package login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Observable;

import model.login.User;
import view.StatusBar;

public class LoginSystem extends Observable {

	private User currentUser;
	private final int LOGIN = 1;
	private final int REGISTER = 2;
	private File userInfo;

	public LoginSystem(StatusBar statusBar) {
		addObserver(statusBar);
		userInfo = new File("userdata.txt");
		currentUser = null;
	}

	public boolean login(String username, String password) {
		if(checkFile(username, password, LOGIN)!=null) {
			currentUser = checkFile(username, password, LOGIN);
			setChanged();
			notifyObservers(currentUser);
			return true;
		}
		return false;
	}

	public boolean register(String username, String password) {
		User temp = checkFile(username, password, REGISTER);
		if(temp!=null)
			return true;
		return false;
	}

	private	User checkFile(String username, String password, int arg) {
		if(arg == LOGIN) {
			try(BufferedReader br = new BufferedReader(new FileReader(userInfo));){
				String line;
				while((line = br.readLine())!=null) {
					if(line.split(";")[0].equals(username) && line.split(";")[1].equals(password)) {
						if(line.split(";")[2].equals("true"))
							return new User(username, password, true);
						else
							return new User(username, password, false);
					}
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		else if(arg == REGISTER) {
			try(BufferedReader br = new BufferedReader(new FileReader(userInfo));){
				String line;
				while((line = br.readLine())!=null) {
					if(line.split(";")[0].equals(username))
						return null;
				}
				User temp = new User(username, password, false);
				BufferedWriter bw = new BufferedWriter(new FileWriter(userInfo,true));
				bw.write(temp.toString());
				bw.newLine();
				bw.close();
				return temp;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}
}
