package bean;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	private List<Item> item;
	public ShoppingCart() {
		item = new ArrayList<>();
	}
	
	public void addItem(Item item){
		this.item.add(item);
	}
	
	public List<Item> getAllItem(){
		return item;
	}
	
	public void removeItem(int item_id){
		for(int i=0;i<item.size();i++){
			if(item.get(i).getItem_id() == item_id){
				item.remove(i);
			}
		}
	}
}
