package arrays;

public class CanPlaceFlowers {
    
    public static void main(String args[]){

    }
    public boolean canPlace(int[] flowerbed, int n){
        int placed = 0;
        for(int i = 0;i<flowerbed.length;i++){
            int prev = i-1;
            if(i == -1){prev = i;}
            int next = i+1;
            if(next == flowerbed.length){next = i;}
            if(flowerbed[prev] == 0 && flowerbed[next] == 0 && flowerbed[i] == 0){
                flowerbed[i] = 1;
                placed++;
            }
        }
        return placed>=n;
    }
}
