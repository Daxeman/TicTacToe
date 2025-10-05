public class Board {

    public static final int size = 3;
    public static final char playerXMarker = 'X';
    public static final char playerOMarker = 'O';
    
    public char board[][];
    
    public Board(){
        board = new char[size][size];

        //Numrera boxarna
        int boxNumber = 0;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){

                board[i][j] = (char)('0' + boxNumber++);
            }
        }
    }
    public boolean isBoardFull(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(Character.isDigit(board[i][j])){
                    return false;
                }
            }
        }
        return true;
}
public char [][] getBoard() {
    char[][] boardCopy = new char[size][size];

    for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                boardCopy[i][j] = board[i][j];
            }
        }
        return boardCopy;
    }
    public boolean isValidBoxNumber(int boxNumber){
        return boxNumber >= 0 && boxNumber < (size * size);
    }
    public boolean isBoxNumberEmpty(int boxNumber){
        int i = boxNumber/size;
        int j = boxNumber%size;
        
        if(board[i][j] == playerXMarker || board[i][j] == playerOMarker){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean placeMarker(int boxNumber, char marker){
        if( !isBoxNumberEmpty(boxNumber)){
            return false;
        }
        int i = boxNumber/size;
        int j = boxNumber%size;

        board[i][j] = marker;
        return true;
    }
}
