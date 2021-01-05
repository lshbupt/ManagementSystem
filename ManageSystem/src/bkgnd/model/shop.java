package bkgnd.model;

public class shop {
   private String ShopID;
   public String getShopID() {
	return ShopID;
}
public void setShopID(String shopID) {
	ShopID = shopID;
}
private String Shopname;
   public String getShopname() {
	return Shopname;
}
public void setShopname(String shopname) {
	Shopname = shopname;
}
private String Account;
   private String password;
   
public shop(String account, String password) {
	super();
	Account = account;
	this.password = password;
}
public shop() {
	super();
	// TODO Auto-generated constructor stub
}
public void setAccount(String account) {
	Account = account;
}

public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAccount() {
	return Account;
}
   
   
}
