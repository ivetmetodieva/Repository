package product;

public abstract class Credit extends BankProduct {
	private double monthlyPayment;
	private double availability;
	public Credit(String name, int annualInterest, byte period, double monthlyPayment, double availability) {
		super(name, annualInterest, period);
		if(monthlyPayment>0)
		this.monthlyPayment = monthlyPayment;
		this.availability = availability;
	}
	public double getAvailability() {
		return this.availability;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public  void setAvailability(double av){
		this.availability=av;
	}
	
}
