##Game class
Handling player vs player mode.
####Attributes
* `player1`, `player2`
  * data_type: Player
  * players

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