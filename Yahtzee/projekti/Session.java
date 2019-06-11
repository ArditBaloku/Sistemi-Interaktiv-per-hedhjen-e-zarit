package projekti;

public class Session {
	private static String id;
	private static String name;
	private static String surname;
	
	public static void setSession(String id, String name, String surname) {
		Session.id = id;
		Session.name = name;
		Session.surname = surname;
	}
	
	public static String getId() {
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
		id = "";
		name = "";
		surname = "";
	}
}
