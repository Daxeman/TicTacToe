public class TicTacToeGame {

    // brädet
    private Board board;

    // spelare
    private Player playerX;
    private Player playerO;

    // aktiva spelaren
    private Player currentPlayer;


    public TicTacToeGame() {
        board = new Board();

        playerX = new Player(Board.playerXMarker);
        playerO = new Player(Board.playerOMarker);

        currentPlayer = playerX;
    }
    public boolean checkWinner(Player player){
        char playerMarker = player.getMarker();
        char board[][] = this.board.getBoard();
        
        //horisontell
        for(int i = 0; i < Board.size; i++){
            boolean horisontal = true;
            for(int j = 0; j < Board.size; j++){
                if(board[i][j] != playerMarker){
                    horisontal = false;
                    break;
                }
            }
            if(horisontal){
                return true;
            }
        }
        //vertikal
        for(int j = 0; j < Board.size; j++){
            boolean vertical = true;
            for(int i = 0; i < Board.size; i++){
                if(board[i][j] != playerMarker){
                    vertical = false;
                    break;
                }
            }
            if(vertical){
                return true;
            }
        }
        
        // vänster diagonal
        boolean leftDiagonal = true;
        for(int i = 0; i < Board.size; i++){
            if(board[i][i] != playerMarker){
                leftDiagonal = false;
                break;
            }
        }
        if(leftDiagonal){
            return true;
        }

        // höger diagonal
        boolean rightDiagonal = true;
        for(int i = 0; i < Board.size; i++){
            int j = Board.size - i - 1;
            if(board[i][j] != playerMarker){
                rightDiagonal = false;
                break;
            }
        }
        if(rightDiagonal){
            return true;
        }
        return false;
    }

    public boolean PlayerXWon(){
        return checkWinner(playerX);
    }
    public boolean PlayerOWon(){
        return checkWinner(playerO);
    }

    public boolean isGameOver(){
        return PlayerXWon() || PlayerOWon() || board.isBoardFull();
    }
    public void changeTurn(){
        currentPlayer = currentPlayer == playerX? playerO : playerX;
    }
    public void placeMarker(int boxNumber){
        board.placeMarker(boxNumber, currentPlayer.getMarker());
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
}
