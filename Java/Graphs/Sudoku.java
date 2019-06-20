

class Board{
    final int SIZE = 4;
    final int F = 2;
    Integer[][] arr = new Integer[SIZE][SIZE];

    void fill(){
        for(int i = 0 ; i <SIZE ; i++)
            for(int j = 0 ;j <SIZE; j++) {
                arr[i][j] = 0;
            }


        arr[1][1] = 2;
        arr[2][2] = 2;
        arr[2][0] = 4;
        arr[1][3] = 1;
    }




    boolean isvalid(int row, int col, int v) {
        for(int i = 0 ;i < SIZE; i ++){
            if(arr[row][i] == v ) {
                return false;
            }

            if(arr[i][col] == v){
                return false;
            }
        }

        int dim1 = (row/F) * F;
        int dim2 = (col/F) * F;

        for(int i = dim1; i < (dim1 + F) ; i++) {
            for(int j = dim2; j < (dim2+F) ; j++) {
                if(arr[i][j] == v ) {
                    return false;
                }
            }
        }

        arr[row][col] = v;
        return true;
    }



    boolean solve() {

        boolean rem  = false;

        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if(arr[row][col] == 0){
                    rem  = true;
                for (int i = 1; i <= SIZE; i++) {
                    if (isvalid(row, col, i)) {
                        arr[row][col] = i;
                        //print();
                        if (solve()) {
                            return true;
                        } else {
                            //System.out.println("\nreset\n");
                            arr[row][col] = 0;
                        }

                    }
                }
                }
            }
    }


        if(rem) {
            return false;
        }
        else {
            return true;
        }

    }



    void print() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(arr[i][j]);
        }
            System.out.println();
    }
    }
}

/*
0000
0201
4020
0000


----------------


1432
3241
4123
2314
* */


public class Sudoku {
    public static void main(String args[]){
        Board b = new Board();
        b.fill();
        b.print();
        b.solve();
        System.out.println("\n\n----------------\n\n");
        b.print();
    }
}
