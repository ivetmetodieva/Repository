package product;

public class LongDeposit extends Deposit{

	public LongDeposit(double money,byte month ) {
		super("Long deposit", 5, month);
		setAvailability(money);
		// TODO Auto-generated constructor stub
	}



}
