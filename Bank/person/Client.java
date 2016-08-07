package person;

import java.util.LinkedList;
import java.util.Random;

import bank.Bank;
import product.BankProduct;
import product.Credit;
import product.Deposit;
import product.LongDeposit;
import product.ShortDeposit;

public class Client {
	private String name;
	private String address;
	private double currentMoney;
	private double paycheckForMonth;
	private LinkedList<BankProduct> creditsAndDeposits;
	private Bank bank;
	
	public Client(String name, String address, double currentMoney, double paycheckForMonth,Bank bank) {
		if(!name.isEmpty()&&!address.isEmpty()&&currentMoney>0&&paycheckForMonth>0&&name!=null&&address!=null&&bank!=null){
			this.name = name;
			this.address = address;
			this.currentMoney = currentMoney;
			this.bank=bank;
			this.paycheckForMonth = paycheckForMonth;
		}
		
		this.creditsAndDeposits = new LinkedList<>();
	}
//	void addProduct(BankProduct b){
//		creditsAndDeposits.add(b);
//	}
	public double getPaycheckForMonth() {
		return paycheckForMonth;
	}
	
	@Override
	public String toString() {
		return  name +  ", currentMoney=" + currentMoney
				+ ", paycheckForMonth=" + paycheckForMonth + ", creditsAndDeposits=" + creditsAndDeposits + ", bank="
				+ bank + "]";
	}
	public LinkedList<BankProduct> getCreditsAndDeposits() {
		return creditsAndDeposits;
	}
	public void makeDeposit(double money,byte months){
		if(money<currentMoney){
			System.out.println("Making deposit");
			currentMoney-=money;
			Deposit d=null;
			Random r = new Random();
			int coin = r.nextInt(2);
			switch(coin){
			case 0: d=new ShortDeposit(money,months);break;
			case 1:d=new LongDeposit(money, months);break;
			default:System.out.println("can't make the deposit.");break;
			}
			d.setAvailability(money);//TODO tuka
			System.out.println("Created "+d.getClass().getName()+ "with initial vnoska"+d.getAvailability());
			bank.takeDeposit(d);
			creditsAndDeposits.add(d);
			
		}
	}
	public void getCredit(double money,byte months){
		bank.giveCredit(this, money, months);
		this.currentMoney+=money;
	}
	public void payCredits(){
		for(BankProduct c : creditsAndDeposits){
			if(c instanceof Credit){//ne sum sig dali e taka
				if(currentMoney>c.getMonthlyPayment()&&c.getAvailability()<0)
				((Credit) c).setAvailability(c.getAvailability()-c.getMonthlyPayment());
				this.currentMoney-=c.getMonthlyPayment();
			}
		}
	}
	
	
}
