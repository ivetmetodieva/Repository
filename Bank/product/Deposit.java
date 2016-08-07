package product;

public abstract class Deposit extends BankProduct{

	private double monthlyPayment;
	private double availability;
	public Deposit(String name, int annualInterest, byte period, double monthlyPayment, double availability) {
		super(name, annualInterest, period);
		this.monthlyPayment = monthlyPayment;
		if(availability>0)
		this.availability = availability;
	}

	
	public Deposit(String name, int annualInterest, byte period) {
		super(name, annualInterest, period);
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getAvailability() {
		// TODO Auto-generated method stub
		return this.availability;
	}
	public void setAvailability(double availability) {
		if(availability>0)
		this.availability = availability;
		
	}
	public double calculateInterest(){
		return (this.availability*getPeriod()*getAnnualInterest())/100;
	}
	
}
