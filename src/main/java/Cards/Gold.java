package Cards;

public class Gold implements LoyaltyCardDiscount{
	
	 private static Gold instance = new Gold();
	 
	 private Gold() {}
	 
	@Override
	public double discount(double amount) {
		// TODO Auto-generated method stub
		amount = amount/2;
		return amount;
	}
	
	 //Get the only object available
	   public static Gold getInstance(){
	      return instance;
	   }
	


}
