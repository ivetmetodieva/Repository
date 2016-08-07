package bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import person.Client;
import product.BankProduct;
import product.Credit;
import product.Deposit;
import product.LongDeposit;
import product.ShortDeposit;

public class Demo {
	public static void main(String[] args) throws InvalidBankReservException {
		
//		Random r = new Random();
//		int coin = r.nextInt(2);
//		switch(coin){
//		case 0: System.out.println("0");break;
//		case 1: System.out.println("1");break;
//		default:System.out.println("can't make the deposit.");
//		}
		Deposit shortDep=new ShortDeposit(200, (byte) 2);//400	
		Deposit longDep=new LongDeposit(100,(byte) 5);//500
		
		LinkedList<BankProduct> products = new LinkedList<>();
		products.add(longDep);
		products.add(shortDep);
		
		try{
		Bank obb=new Bank("OBB", "Sofia", products,1000000 );
		System.out.println(obb.toString());
		ArrayList<Client> clients = new ArrayList<>();
		clients.add(new Client("Mariq", "Sofia", 100, 20, obb));
		clients.add(new Client("Ivet", "Sofia", 500, 221, obb));
		clients.add(new Client("Ivan", "Sofia", 0, 200, obb));
		Random r = new Random();
		for(Iterator<Client> it = clients.iterator();it.hasNext();){
			int put=r.nextInt(100-80)+80;
			put/=100;
			Client x=it.next();
			x.makeDeposit(x.getPaycheckForMonth()*put,(byte) 1  );
		}
		System.out.println(obb.toString());
		}
		catch(InvalidBankReservException e){
			System.out.println("Invalid reserv");
		}
		//perioda se opredelq ot klienta
//		BankProduct homeCredit = new Credit("homeCredit", 6, period);
//		BankProduct consumerCredit = new Credit("Consumer Credit", 10, period);
	}
	
}
