package product;

public class HomeCredit extends Credit{

	public HomeCredit( byte period,double availability) {
		super("Home Credit", 6, period, availability*(6+100)/100/period, availability);
		
	}

	
}
