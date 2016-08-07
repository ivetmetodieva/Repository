package product;

public class ShortDeposit extends Deposit{


	public ShortDeposit(double money ,byte month) {
		super("Short deposit", 3, month);
		//System.out.println("created short deposit witn  initial vnoska =" + money);
		setAvailability(money);//tuka trea da se opraavi 
		// TODO Auto-generated constructor stub
	}

}
