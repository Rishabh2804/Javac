package loot_houses;

public class Solution {

	public static int maxMoneyLooted(int[] houses) {
        if(houses.length==0)
            return 0;

		if(houses.length==1 || houses.length==2)
            return houses[houses.length-1];

        if(houses.length==3)
            return houses[2] + houses[0];

        int[] loot=new int[houses.length];
        loot[0]=houses[0];
        loot[1]=houses[1];
        loot[2]=houses[2] + houses[0];

        for(int i=3;i<houses.length;++i){
            loot[i]=houses[i] + Math.max(loot[i-2], loot[i-3]);
        }

        return Math.max(loot[houses.length-1],loot[houses.length-2]);
	}

}