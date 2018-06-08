package Es1;

public class Table {
	private int contatore;
	private boolean avaible;
	private Fork[] forchette;
	
	public Table(Fork[] forchette) {
		this.contatore = 0;
		this.avaible = true;
		this.forchette = forchette;
	}
	
	public Fork setLeftFork(int identità) {
		return forchette[identità];
	}
	
	public Fork setRightFork(int identità) {
		return forchette[(identità+1)%5];
	}
	
	public void getLeftFork(Fork forchetta) {
		try{
			if (avaible = true) {
				forchetta.get();
				setContatore();
			}
		} catch (InterruptedException e) {

        } 
	}
	
	public void getRightFork(Fork forchetta) {
		
	}
	
	public void setContatore() {
		this.contatore++;
		if (this.contatore == 4)
			this.avaible = false;
	}
}
