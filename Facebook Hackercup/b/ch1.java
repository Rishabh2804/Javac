package b;

import java.util.*;

public class ch1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        
        for(int t1=1;t1<=t;++t1) {
            int n = s.nextInt();
            s.nextLine();

            char[][] arr = new char[n][n];
            ArrayList<HashMap<Character,Integer>> row=new ArrayList<>();
            for(int i=0;i<n;++i){
                HashMap<Character,Integer> map=new HashMap<>();
                row.add(map);
            }
            ArrayList<HashMap<Character,Integer>> col=new ArrayList<>();
            for(int i=0;i<n;++i){
                HashMap<Character,Integer> map=new HashMap<>();
                col.add(map);
            }
            for (int i = 0; i < n; ++i) {
                String str=s.nextLine();
                for (int j = 0; j < n; ++j) {
                    
                    char c = str.charAt(j);
                    arr[i][j]=c;
                    
                    if(row.get(i).containsKey(c)){
                        row.get(i).put(c,row.get(i).get(c) + 1);
                    } else{
                        row.get(i).put(c,1);
                    }
                    
                    if(col.get(j).containsKey(c)){
                        col.get(j).put(c,col.get(j).get(c) + 1);
                    } else{
                        col.get(j).put(c,1);
                    }
                    
                }
                
            }
            
            int wins = 0, changes = Integer.MAX_VALUE;

            for(int i=0;i<n;++i){
                HashMap<Character,Integer> map=row.get(i);
                if(map.containsKey('O')){
                    continue;
                }

                int dots=0;
                if(map.containsKey('.')){
                    dots=map.get('.');
                }

                if(dots<changes){
                    wins=1;
                    changes=dots;
                }
                else if(dots==changes){
                    wins++;
                }

            }
            
            for(int i=0;i<n;++i){
                HashMap<Character,Integer> map=col.get(i);
                if(map.containsKey('O')){
                    continue;
                }

                int dots=0;
                if(map.containsKey('.')){
                    dots=map.get('.');
                }

                if(dots<changes){
                    wins=1;
                    changes=dots;
                }
                else if(dots==changes){
                    wins++;
                }
                
            }

            for(int i=0;i<n;++i){
                for(int j=0;j<n;++j){
                    if(arr[i][j]=='.'){
                        HashMap<Character,Integer> rmap=row.get(i);
                        HashMap<Character,Integer> cmap=col.get(j);

                        
                        if(rmap.containsKey('X') && rmap.get('X')==n-1 && cmap.containsKey('X') && cmap.get('X')==n-1){
                            wins--;
                        }
                        
                    }
                }
            }

            String out=changes + " " + wins;
            if(wins==0)
                out="Impossible";

            System.out.println("Case #" + t1 + ": " + out);


        }

        s.close();
    }

}
