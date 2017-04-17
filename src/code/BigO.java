package code;


import java.util.function.LongUnaryOperator;

public class BigO {
	
public static void main(String [] args){
	long [] bounds = {1000,6000,6000*60,6000*60*24,6000*60*24*30,6000*60*24*52,6000*60*24*52*100};
	long [] n_s = new long [bounds.length];
	for(int i = 0; i<bounds.length;i++){
		long n = findBiggestN((x)->Function.sqrt (x),997,bounds[i]);
		puts(n);
		n_s[i] = n;
	}
	//puts(Function.sqrt(656099999999l));
	puts(bounds ,n_s);
}
	
public static void puts(long n){
	System.out.println(n);
}
public static void puts(long [] bs, long [] n){
	for(int i = 0;i<n.length;i++){
		System.out.println(bs[i]+": " +n[i]);
	}
	
}

public static long findBiggestN (LongUnaryOperator operator, long lower, long upper){
	long n=lower;
	long increment = lower;
	while(increment<upper){
		n=n++;
		increment = operator.applyAsLong(n*n);
		//puts(increment);
	}
	return n-1;
}
static class Function{
	static long lg( long n){
		return (long)Math.log(n);
	}
	static long sqrt(long n){
		return (long)Math.sqrt(n);
	}
	static long n (long n){
		return n;
	}
	static long nlogn (long n){
		return (long)Math.log(n)*n;
	}
	static long square(long n){
		return n*n;
	}
	static long cube(long n){
		return n*n*n;
	}
	static long exp (long n){
		return (long)Math.pow(2,n);
	}
	static long factorial(long n){
		return (n==0)?1:n*factorial(n-1);
	}
}
}
