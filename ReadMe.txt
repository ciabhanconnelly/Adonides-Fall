The basic GUI is functional:

-> New Game initializes a blank game state
-> Screens exist for
	-> Main Menu
	-> Gameplay
	-> Inventory
	-> Knowledge List
	-> Idea List
	-> Profile
	-> Options
	-> Help screen
-> Options are passed between states
-> Knowledge/idea choices update the inventory
	-> The Toast when a knowledge that has already been selected is
	   selected again is a debugging placeholder, will eventually be
	   a warning.
-> Gameplay buttons change text
	-> Need to debug the button that changes text opacity

Bugs:
-> Issues with help menu detecting which button was pressed
-> Changing text opacity

Current tasks:
-> Create a class that handles options/results of choices
-> Add save states
	-> update 'continue' button
	-> update 'reset game' in options