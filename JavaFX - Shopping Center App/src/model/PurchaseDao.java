package model;

import java.sql.Date;
import java.util.List;

import bean.PurchaseDetails;

public interface PurchaseDao {

	public List<PurchaseDetails> getAllPurchase();
	public boolean addPurchase(int customerId,  double purchaseAmount);
	public boolean deletePurchase(int tId);
	

}
