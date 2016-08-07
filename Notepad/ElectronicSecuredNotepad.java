
public class ElectronicSecuredNotepad extends SecuredNotepad implements IElectronicDevice{
	private boolean power;
	
	public ElectronicSecuredNotepad() throws DeviceNotOnException, InvalidPasswordException {
		super();
		start();//if this function is not called an exception will be thrown
		if(!isStarted()){
			throw new  DeviceNotOnException();
		}
		System.out.println("Device is ON.");
		
	}

	
	@Override
	public void start() {
		this.power=true;
	}

	@Override
	public void stop() {
		this.power=false;
	}
	
	@Override
	public boolean isStarted() {
		return this.power;
	}
	
	
}
