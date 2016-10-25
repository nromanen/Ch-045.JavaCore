package lesson09.homework;
/* Create method div(), which calculates the dividing of two double numbers. In main method input 2 double 
 * numbers and call this method. Catch all exceptions. 
 * Write a method readNumber(int start, int end), that read from console integer number and return it, if it
 * is in the range [start...end]. 
 * If an invalid number or non-number text is read, the method should throw an exception. 
 * Using this method write a method main(), that has to enter 10 numbers: a1, a2, ..., a10, such that 1 < a1 
 * < ... < a10 < 100 
 */
public class App {
public static void main(String[] args) throws Exception {
	Util util=new Util();
	System.out.println(util.div(3, 3));
	
	int begin=1;
	int end=100;
	int[] arr = new int[10];
	System.out.println("please input int number:");
	arr[0]=util.readNumber(begin, end);
	for(int i=1; i<arr.length; i++){
		System.out.println("please input int number:");
		arr[i]=util.readNumber(arr[i-1], end);
	}
	
	for(int i=0; i<arr.length; i++){
		System.out.println(arr[i]);
	}
}
}
