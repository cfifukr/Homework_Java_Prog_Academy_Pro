package academy.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		UserList usersOnline =  UserList.getInstance();

		try {
			boolean check = false;
			String login = "";
			int id = 0;


			while (true) {
				if (check == false){
					id = id + 1;
					System.out.println("Enter your login: ");
					login = scanner.nextLine();
					check = true;
					if(login.toUpperCase().compareTo("ALL") != 0){
						usersOnline.add(new User(login, Status.ONLINE, id));
					}
					Thread th = new Thread(new GetThread());
					th.setDaemon(true);
					th.start();


				}


				System.out.println("\nEnter your message: ");
				System.out.println("U can use command '/logout to logout'");
				String text = scanner.nextLine();
				if("/logout".compareTo(text)==0){
					check = false;

				}else {

					System.out.println("Enter login of user u are sending to (send 'ALL'  if u want send it to everyone)");
					System.out.println("U can use command '/users to see online users'");
					String userTo = scanner.nextLine();
					if ("/users".compareTo(userTo) == 0) {
						for (User us : usersOnline) {
							if(login.compareTo(us.getName() )  == 0){
								System.out.print(us + "(YOU), ");

							}else {
								System.out.print(us + ", ");

							}
						}
						System.out.println("\nEnter login of user u are sending to (send 'ALL'  if u want send it to everyone)");
						userTo = scanner.nextLine();
					}
					if (text.isEmpty()) break;


					Message m = new Message(login, text, userTo);
					int res = m.send(Utils.getURL() + "/add");

					if (res != 200) { // 200 OK
						System.out.println("HTTP error occurred: " + res);
						return;
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}
}
