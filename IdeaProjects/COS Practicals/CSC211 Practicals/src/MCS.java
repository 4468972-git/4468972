//12Practical
public class MCS {
    public static int mcsOn3(int[] X){
        /*
        def mcsOn3(X):
            4 n = len(X)
            5 maxsofar = 0
            6 for low in range(n): # [0,n)
            7 for high in range(low, n): # [low,n)
            8 sum = 0
            9 for r in range(low, high): # [low,high)
            10 sum += X[r]
            11 if (sum > maxsofar):

         */
        int n = X.length;
        int maxsofar = 0;
        for (int low = 0; low < n; low++){
            for (int high = low; high < n; high++){
                int sum = 0;
                for (int r = low; r <= high;r++){
                    sum += X[r];
                    if (sum > maxsofar)
                        maxsofar = sum;
                }
            }
        }
        return maxsofar;
    }
}
