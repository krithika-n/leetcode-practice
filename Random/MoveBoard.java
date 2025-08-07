public class MoveBoard {

    int[][] grid;
    int[] index;
    Character curDir;

    MoveBoard(Character dir, int[] index, int n){
        this.grid= new int[n][n];
        this.index = index;
        this.curDir = dir;
    }

    public int[] move(String moves){
        for(Character ch: moves.toCharArray()){
            if(ch == 'F'){
                moveForward();
            } else if(ch == 'L'){
                turnLeft();
            } else if(ch == 'R'){
                turnRight();
            }
        }
        return this.index;
    }

    private boolean withinBounds(int x, int y){
        return 0 <= x && x < grid.length && 0 <= y && y < grid[0].length;
    }

    private void turnLeft(){
        switch(this.curDir){
            case 'N': this.curDir = 'W';break;
            case 'S': this.curDir = 'E';break;
            case 'E': this.curDir = 'N';break;
            case 'W': this.curDir = 'S';break;
            default: break;
        }
    }

    private void turnRight(){
        switch(this.curDir){
            case 'N': this.curDir = 'E';break;
            case 'S': this.curDir = 'W';break;
            case 'E': this.curDir = 'S';break;
            case 'W': this.curDir = 'N';break;
            default: break;
        }
    }

    private void moveForward(){
        int dx;
        int dy;
        switch(this.curDir){
            case 'N': dx = 1; dy= 0;break;
            case 'S': dx = -1; dy= 0;break;
            case 'E': dx = 0; dy= 1;break;
            case 'W': dx = 0; dy= -1;break;
            default: dx = 0; dy = 0;break;
        }
        if(withinBounds(this.index[0] + dx, this.index[1] + dy)){
            this.index[0] += dx;
            this.index[1] += dy;
        }
    }
    
}
