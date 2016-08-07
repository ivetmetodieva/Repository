package bank;

import java.util.LinkedList;
import java.util.Random;

import person.Client;
import product.BankProduct;
import product.ConsumerCredit;
import product.Credit;
import product.Deposit;
import product.HomeCredit;

public class Bank {
	private String name;
	private String address;
	private LinkedList<BankProduct> products = new LinkedList<>();
	private double money;//
	private double reserve;
//	enum creditType{HOMECREDIT,CONSUMERCREDIT};
//	enum depositType{SHORTDEPOSIT,LONGDEPOSIT};
	
	public Bank(String name, String address, LinkedList<BankProduct> products, double money) throws InvalidBankReservException {
		if(!(name.isEmpty()&&address.isEmpty()&&products.isEmpty())||name!=null&&address!=null){
			this.name = name;
			this.address = address;
			this.products = products;
		}
		this.reserve=uponCreationReserv(products);
		if(money<reserve)throw new InvalidBankReservException();
		this.money = money;
	}




	private double uponCreationReserv(LinkedList<BankProduct> products){
		double money=0;
		for(BankProduct x:products){
			if(x instanceof Deposit){
				money+=x.getAvailability();
			}
		}
		return money*0.1;//10% ot vsichki 
	}
	public void takeDeposit(Deposit d){
		System.out.println("Acception deposit for "+d.getAvailability());
		this.money+=d.getAvailability();
		this.reserve+=(90/d.getAvailability())*100;
	}

	public void chashOut(){
		for(BankProduct x:products){
			if(x instanceof Deposit){
				((Deposit) x).setAvailability(((Deposit) x).calculateInterest()*((Deposit) x).getMonthlyPayment());
			}
		}
	}
	
	@Override
	public String toString() {
		return  name +" money=" + money;
	}




	private boolean checkEligibility(Client x){
		double toPay=0;
		for(BankProduct b:x.getCreditsAndDeposits()){
			if(b instanceof Credit)
			toPay+=b.getMonthlyPayment();
		}
		if(toPay<x.getPaycheckForMonth()*0.5){
			return true;
		}
		return false;
	}
	
	public Credit giveCredit(Client x,double actualSum,byte months){
		if(checkEligibility(x)){
			System.out.println("client is eligible ");
			if(this.reserve>actualSum){
				Random r = new Random();
				int coin = r.nextInt(2);
				switch(coin){
				case 0:this.money-=actualSum;
					return new HomeCredit(months, actualSum);
				case 1:this.money-=actualSum;
					return new ConsumerCredit(months, actualSum);
				default:System.out.println("Not a type of credit");
				}
			}
		}
		System.out.println("Can't give credit.");
		return null;
		
	}
}
