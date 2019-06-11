package projekti;

public final class UserSession {

	private static UserSession instance;
	
	private String name;
	private String surname;
	private String id;
	
	private UserSession(String id, String name, String surname) {
		this.id = id;
	    this.name = name;
	    this.surname = surname;
	}
	
	public static UserSession getInstance(String id, String name, String surname) {
	    if(instance == null) {
	        instance = new UserSession(id, name, surname);
	    }
	    return instance;
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
	    return name;
	}
	
	public String getSurname() {
	    return surname;
	}
	
	public String getFullName() {
		return name + " " + surname;
	}
	
	public void cleanUserSession() {
	    id = "";
		name = "";
		surname = "";
	}
	
	@Override
	public String toString() {
	    return "UserSession{" +
	    		"id= '" + id + '\'' + 
	            ", name='" + name + '\'' +
	            ", surname=" + surname +
	            '}';
	}
}