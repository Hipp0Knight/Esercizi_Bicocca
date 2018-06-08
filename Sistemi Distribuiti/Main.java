package Es1;

public class Main{
    public static void main(String args[]){
        Fork forks[] = new Fork[5];
        Philosopher phils[] = new Philosopher[5];
        for(int c=0; c<5; forks[c] = new Fork(c), c++);
        Table tavolo = new Table(forks);
        for(int c=0; c<5; c++)
            phils[c] = new Philosopher(c, tavolo);
        for(int c=0; c<5; phils[c].start(), c++);
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {}
        for(int c=0; c<5; phils[c].stopRequested(),c++);
        System.out.println("finito");
    }
}
