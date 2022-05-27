class Minesweeper
{
    public static int MAP_X = 10;
    public static int MAP_Y = 10;
    private int[][] map;
    private int numOfpick;
    public Minesweeper(int[][] map) { this.map = map; this.numOfpick = 0;}

    public int pick(int x, int y)
    {


        int numOfMine = 0;
        // todo
        if(map[x][y]==1){
            numOfMine = -1;
            return numOfMine;
        }

        try {
            if(map[x+1][y]==1 && x+1 >= 0 && x+1 <=9){
                numOfMine++;
            }else{
                map[x+1][y] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}

        try {
            if(map[x-1][y]==1 && x-1 >= 0 && x-1 <=9){
                numOfMine++;
            }else{
                map[x-1][y] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}


        try {
            if(map[x][y+1]==1 && y+1 >= 0 && y+1 <=9){
                numOfMine++;
            }else{
                map[x][y+1] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}

        try {
            if(map[x][y-1]==1 && y-1 >= 0 && y-1 <=9){
                numOfMine++;
            }else{
                map[x][y-1] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}

        try {
            if(map[x+1][y+1]==1 && x+1 >= 0 && x+1 <=9 && y+1 >= 0 && y+1 <=9){
                numOfMine++;
            }else{
                map[x+1][y+1] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}


        try {
            if(map[x-1][y-1]==1 && x-1 >= 0 && x-1 <=9 && y-1 >= 0 && y-1 <=9){
                numOfMine++;
            }else{
                map[x-1][y-1] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}

        try {
            if(map[x+1][y-1]==1 && x+1 >= 0 && x+1 <=9  && y-1 >= 0 && y-1 <=9){
                numOfMine++;
            }else{
                map[x+1][y-1] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}

        try {
            if(map[x-1][y+1]==1 && x-1 >= 0 && x-1 <=9 && y+1 >= 0 && y+1 <=9){

            }else{
                map[x-1][y+1] = 2;
            }
        } catch (ArrayIndexOutOfBoundsException e) {}


        return numOfMine;
    }

    public int getNumOfpick()
    {
        return numOfpick;
    }

    public boolean checkMap()
    {
        // todo
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public void printMap() {
        for(int i = 0; i < MAP_X; i++) {
            for(int j = 0; j < MAP_Y; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}