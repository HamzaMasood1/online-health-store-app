package Cards;

public class Silver implements LoyaltyCardDiscount {
	
	 private static Silver instance = new Silver();

	  
	//Get the only object available
	   public static Silver getInstance(){
	      return instance;
	   }

	@Override
	public double discount(double amount) {
		// TODO Auto-generated method stub
		
		amount = amount/3;
		return amount;
	}
	
	
	
}
