package projekti;

public class Session {
	public static int id;
	public static String name="";
	public static String surname="";
	
	public static void setSession(int id, String name, String surname) {
		Session.id = id;
		Session.name = name;
		Session.surname = surname;
	}
	
	public static int getId() {
		return id;
	}
	
	public static String getName() {
		return name;
	}
	
	public static String getSurname() {
		return surname;
	}
	
	public static String getFullName() {
		return name + " " + surname;
	}
	
	public static void clearSession() {
		id = 0;
		name = "";
		surname = "";
	}
}
