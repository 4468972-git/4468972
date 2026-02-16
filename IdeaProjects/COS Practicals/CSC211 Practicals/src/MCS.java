//12Practical
public class MCS {
    public static int mcsOn3(int[] X){
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

    public static int mscOn2A( int[] X){
        /*
        def mcsOn2A(X):
           n = len(X)
           maxsofar = 0
           for low in range(n):             # [0,n)
               sum = 0
               for r in range(low, n):   # [low,n)
                  sum += X[r]
                  if (sum > maxsofar):
                     maxsofar = sum
           return maxsofar
         */
        int n = X.length;
        int maxsofar = 0;
        for (int low = 0; low < n; low++){
            int sum = 0;
            for (int r = low; r < n; r++){
                sum += X[r];
                if (sum > maxsofar)
                    maxsofar = sum;
            }
        }
        return maxsofar;
    }

    

    public static void main(String[] args){
        int[] X = {-5, 46, 89, 21, -9, -30, -100};
        //O(n^3)
        System.out.println(mcsOn3(X));
    }
}
