package bean;

public class Order {

    private int order_id;
    private int custId;
    private int productId;
    
    public Order (){
    	//default constructor
    }
    public Order(int order_id, int custId, int productId) {
		super();
		this.order_id = order_id;
		this.custId = custId;
		this.productId = productId;
	}
    
    public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public int getProductId() {
		return productId;	}
	
	
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
    
}
