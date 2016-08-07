package product;

public class ConsumerCredit extends Credit {

	public ConsumerCredit(byte period, double availability) {
		super("Consumer Credit", 10, period, availability*(10+100)/100/period, availability);
	}

}
