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
	
	public Fork setLeftFork(int identit�) {
		return forchette[identit�];
	}
	
	public Fork setRightFork(int identit�) {
		return forchette[(identit�+1)%5];
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
