package syncopate;

public class Counter {
public int counter =0;
public int mod = 1;
public Counter(Integer mod){
	this.mod=mod;
}
public Integer next() {
	return new Integer((counter++))%mod;
}

}
