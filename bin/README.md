# T9BattleShip

Team 9
Andrew Yu ,Ebadullah Wardak, Justin Barragan, Kevin Chang

GitHub: https://github.com/yingzhengyu/T9BattleShip

Design Pattern: Observer Pattern 

Implemented a Message Interface which BoatMessage and TiltMessage implements message interface. BoatMessage and TiltMessage are found in controller package. Implemented a DemoBoard class that utilizes our current business logic and observer design pattern in order to simulate different actions on a game board using the command line. The BoardController utilizes a View class that represents the view, and a Board class that represents the model. The BoardController is responsible for calling the methods contained within the model and the view in order to update the data of the model after each turn and print a new game board at each iteration. 
