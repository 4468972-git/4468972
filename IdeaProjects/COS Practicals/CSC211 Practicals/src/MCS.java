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

    public static int mcsOn2A( int[] X){
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

    public static int mcsOn2B(int [] X){
        /*
        def mcsOn2B(X):
           n = len(X)
           sumTo = [0]*(n+1)
           for i in range(n):               # [0,n)
              sumTo[i] = sumTo[i-1] + X[i]
           maxsofar = 0
           for low in range(n):             # [0,n)
               for high in range(low, n):   # [low,n)
                  sum = sumTo[high] - sumTo[low-1]
                  # sum of all elements in X[low..high)
                  if (sum > maxsofar):
                     maxsofar = sum
           return maxsofar
         */
        int n = X.length;
        int[] sumTo = new int[n];
        for (int i = 0; i < n; i++)
            sumTo[i] = sumTo[i-1] + X[i];
        int maxsofar = 0;
        for (int low = 0; low < n; low++){
            for (int high = low; high < n; high++){
                int sum = sumTo[high] - sumTo[low-1];
                if (sum > maxsofar)
                    maxsofar = sum;
            }
        }
        return maxsofar;
    }



    public static void main(String[] args){
        int[] X = {-5, 46, 89, 21, -9, -30, -100};
        System.out.println("Order n^3 output: ");
        System.out.println(mcsOn3(X));
        System.out.printf("Order n^2 A output: %d", mcsOn2B(X));
    }
}
