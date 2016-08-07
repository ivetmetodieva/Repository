package product;

public abstract  class BankProduct {

	private String name;
	private int annualInterest;
	private byte period;
	
	public BankProduct(String name, int annualInterest, byte period) {
		if(!name.isEmpty()&&name!=null){
			this.name = name;
		}
		if(annualInterest>0){
			this.annualInterest = annualInterest;
		}else{
			this.annualInterest = 1;
		}
		if(period>0&&period<=60){
			this.setPeriod(period);
		}else{
			this.setPeriod((byte) 1);
		}
		
	}
	public abstract double getMonthlyPayment();
	public int getAnnualInterest(){
		return this.annualInterest;
	}
	public abstract double getAvailability();

	public byte getPeriod() {
		return period;
	}

	public void setPeriod(byte period) {
		this.period = period;
	}
	
	
}
