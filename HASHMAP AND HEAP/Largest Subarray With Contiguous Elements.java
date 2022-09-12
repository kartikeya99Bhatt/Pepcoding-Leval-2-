/*
1. Duplicate will never generate Answer
*/
	  public static int solution(int[] arr) {
		// write your code here
        int ansLength=0;
            for(int i=0;i<arr.length;i++){
                HashSet<Integer>set=new HashSet<>();
                 int max=arr[i];int min=arr[i];int tempAns=0;
                for(int j=i;j<arr.length;j++)
                {
                    if(set.contains(arr[j])){break;}
                    if(arr[j]>max){
                        max=arr[j];
                    }
                    else if(arr[j]<min){
                        min=arr[j];
                    }
                    set.add(arr[j]);
                    if(max-min==j-i){
                        tempAns=Math.max(tempAns,j-i+1);
                    }
                }
                ansLength=Math.max(ansLength,tempAns);
            }
        return ansLength;
	}
