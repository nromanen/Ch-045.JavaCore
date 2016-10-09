package Maximum;

public class MaximumNumber {
	
	public static void main(String[] args) throws Exception
    {

        int maximum = 0;
        int[] array = {2, -5, 7, -4, 8, 12, -70, 100, -19, 33};
        for (int i=0;i<array.length; i++) {
            maximum = array[0];
            if (maximum <= array[i]){
                maximum = array[i];
            }
        }
        System.out.println("Maximum is " + maximum);	}
    	       
     
}

        


