 public List<Integer> grayCode(int n) {
        ArrayList<Integer>list=new ArrayList<>();
        list.add(0);
        list.add(1);
        
        for(int i=2;i<=n;i++)
        {
            int mask=1<<(i-1);
            for(int j=list.size()-1;j>=0;j--)
            {
                int val=(mask|list.get(j));
                list.add(val);
            }
        }
        return list;
    }
