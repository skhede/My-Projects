package bean;

import java.sql.Date;

public class PurchaseDetails {

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public int getPurchase_amount() {
		return purchase_amount;
	}

	public void setPurchase_amount(int purchase_amount) {
		this.purchase_amount = purchase_amount;
	}
	
	
	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	private int order_id;
	private int customer_id;
	public int item_id;
	private Date order_date;
	private Double quantity;
	private int purchase_amount;
  
  public PurchaseDetails()
  {
	  // default construct
  }

public PurchaseDetails(int orderId, int customerId, int itemId, Date orderDate, Double quantity, int purchaseAmount) {
	super();
	this.order_id = orderId;
	this.customer_id = customerId;
	this.item_id = itemId;
	this.order_date = orderDate;
	this.quantity = quantity;
	this.purchase_amount = purchaseAmount;
}

}
