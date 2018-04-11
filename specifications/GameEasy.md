##GameEasy class
Handling player vs computer easy mode.
####Attributes
* `player1`
  * data_type: Player
  * Human player

* `player2`
  * data_type: EasyAI;
  * Computer player

* `board1`, `board2`
  * data_type: Board
  * Boards to shoot

* `disp`
  * data_type: Display
  * Display class with methods to represent information

* `is_game`
  * data_type: boolean
  * Boolean is there any ships on both board

* `players`
  * data_type: ArrayList<Player>
  * List of Players

* `boards`
  * data_type: ArrayList<Board>
  * List of Boards


###Methods
`Game()` - constructor of Game Object

`handleGame()` - handling game

`handleRound()` - handling each round of game

`prepareGame()` - handling ship placement

`checkGameStatus()` - set `is_game` variable