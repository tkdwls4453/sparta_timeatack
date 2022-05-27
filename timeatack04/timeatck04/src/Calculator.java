class Calculator
{
    public Calculator() {}
    // Sum of A n B
    public int intersection(int[] A, int[] B)
    {
        int result = 0;
        // todo

        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                if(A[i] == B[j]){
                    result+=A[i];
                }
            }
        }
        return result;
    }

    // Sum of A - B
    public int differenceOfSet(int[] A, int[] B)
    {
        int result = 0;
        // todo
        for(int i=0; i<A.length; i++){
            result+=A[i];
        }
        result = result - intersection(A,B);
        return result;
    }
}