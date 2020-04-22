package Cards;

public class Standard implements LoyaltyCardDiscount {

	private static Standard instance = new Standard();
	
	@Override
	public double discount(double amount) {
		// TODO Auto-generated method stub
		amount = amount /4;
		return amount;
	}
	
	//Get the only object available
	   public static Standard getInstance(){
	      return instance;
	   }

}
