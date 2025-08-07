public class printPattern {

    enum colour {
        BLACK(0),
        WHITE(255);

        private int value;

        colour(int val) {
            value = val;
        }

        public int getValue() {
            return value;
        }
    }

    public static void printPattern(int n, int m) {
        int[][] matrix = new int[n][n];

        colour currentColour = colour.BLACK;
        int bandCount = 0;

        for(int col = 0; col < n; col++){
            if(bandCount == m){
                currentColour = switchColour(currentColour);
                bandCount = 0;
            }
            bandCount++;
            for(int row = 0; row < n; row++){
                matrix[row][col] = currentColour.getValue();
            }
        }

        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static colour switchColour(colour currentColour) {
        if (currentColour == colour.BLACK) {
            return colour.WHITE;
        } else {
            return colour.BLACK;
        }
    }

    public static void main(String[] args) {
        printPattern(7, 2);
    }
}
