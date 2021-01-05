package bkgnd.model;

public class Administrator {
 private String AID;
 private String password;
 
public Administrator() {
	super();
	// TODO Auto-generated constructor stub
}

public Administrator(String aID, String password) {
	super();
	AID = aID;
	this.password = password;
}

public String getAID() {
	return AID;
}
public void setAID(String aID) {
	AID = aID;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
 
}
