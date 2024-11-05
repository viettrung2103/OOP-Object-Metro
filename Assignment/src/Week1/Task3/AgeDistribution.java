package Week1.Task3;

public class AgeDistribution {
    public static void main(String[] args) {
        final int REITERATIONS = 1000;
        final int MAXAGE = 30;

        int agedistribution[][] = {
                {9, 18},  		// 9 %		// This line matches to random numbers 1..9,  gives age 18
                {18, 19},  		// 9 %    	// This line matches to random numbers 10...18, gives age 19
                {24, 20},		// 6 %    	// ...
                {35, 21},    	// 11 %
                {46, 22},  		// 11 %
                {52, 23}, 		// 6 %
                {66, 24},  		// 14 %
                {73, 25},		// 9 %
                {82, 26},  		// 9 %
                {88, 27},  		// 6 %
                {94, 28},  		// 6 %
                {97, 29},  		// 3 %
                {100,MAXAGE}, 	// 3 %	  	// This line matches to random numbers 99 ja 100
        };

        int generatedAges[] = new int[MAXAGE+1];

        // Generate ages according to the distribution:
        for (int i = 1; i <= REITERATIONS; i++){
            int x = (int)(Math.random()*100)+1; 	// generate a random number 1..100 -> we get the row which gives the age
            int j = 0;
            while (x > agedistribution[j][0]) j++;  // search for the correct row to get the matching age
            generatedAges[agedistribution[j][1]]++; // age founded gives an index to the generated ages count table: increment it (by one)
        }

        // Output the result of the generation:
        System.out.println("Age  count     %-share");
        for (int age = 0; age <= MAXAGE; age++) {
            if (generatedAges[age] != 0) {
                String str = "%-4d %-8d %-8.2f\n";
                System.out.printf(str, age, generatedAges[age], ((double)generatedAges[age])/REITERATIONS*100 );
            }
        }
    }
}