public class TicTacToeController {

    private TicTacToeGame ticTacToeGame;

    private TicTacToeGameView tacToeGameView;

    public TicTacToeController(){
        ticTacToeGame = new TicTacToeGame();
        tacToeGameView = new TicTacToeGameView(this);
    }
    
    public void handleInputFromUser(int boxNumber){
    
    ticTacToeGame.placeMarker(boxNumber);
    
    tacToeGameView.setMarker(boxNumber, ticTacToeGame.getCurrentPlayer().getMarker());
    
    if(ticTacToeGame.isGameOver()){

        if(ticTacToeGame.PlayerXWon()){
            tacToeGameView.showGameResult("Spelare X vann");
        }
        else if(ticTacToeGame.PlayerOWon()){
            tacToeGameView.showGameResult("Spelare O vann");
        }
        else{
            tacToeGameView.showGameResult("Oavgjort");

        }

    }
    else{
        ticTacToeGame.changeTurn();
        tacToeGameView.showMessage("Spelare " + ticTacToeGame.getCurrentPlayer().getMarker() + "tur");
    }
    }
}

