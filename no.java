public class no {

    public static boolean validateRowsOliso(int[][] board) {

        int[][] biarray = new int[board.length][3];
        
        for (int i=0; i<board.length; i++) {
            for (int j = 0; j < board[i].length; j++){

                    int hundreds = board[i][j]/100;
                    //system.out.println(hundreds);
                    int tens = (board[i][j]/10)%10;
                    //System.out.println(tens);
                    int ones = board[i][j] % 10; 
                    //System.out.println(ones);

                    biarray[i][0] = hundreds;
                    //System.out.println(biarray[0][0]);
                    biarray[i][1] = tens;
                    biarray[i][2] = ones;

                    System.out.println("[" + biarray[i][0] +"]" + "[" + biarray[i][1] +"]" + "[" + biarray[i][2] +"]" );

                    
                    if (biarray[0][i] == biarray[1][i] && biarray[1][i] == biarray[2][i]){
                        return true;
                    }
                }
            }
            
            return false;
  
        }
           
    
    
  
    public static void main(String[] args) {
        int[][] board_ascending = {{807,982,108}, //winner row
                                  {623,592,481}, 
                                  {347,324,8}}; 
    
        int[][] board_none = {{227,221,503}, //
                              {443,447,670}, 
                              {70,235,200}}; 

        boolean winner = validateRowsOliso(board_ascending);

        System.out.println("Oliso allignment found? " + winner);
       
        
        
    }


    
}