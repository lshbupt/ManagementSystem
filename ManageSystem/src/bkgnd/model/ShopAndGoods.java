package bkgnd.model;

public class ShopAndGoods {
    private String SGID;
    private int price;
    private int remain;
    private String shopID;
    private String GoodID;
    
	public String getSGID() {
		return SGID;
	}
	public void setSGID(String sGID) {
		SGID = sGID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public String getGoodID() {
		return GoodID;
	}
	public void setGoodID(String goodID) {
		GoodID = goodID;
	}
	public String getShopID() {
		return shopID;
	}
	public void setShopID(String shopID) {
		this.shopID = shopID;
	}
    
}
