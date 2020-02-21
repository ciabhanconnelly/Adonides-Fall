AdonidesFall: code
DesignDocs: PDFs of design docs
Art: Assets to use

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

Some assets/code are placeholders:
-> Rating bar is used for volume/textsize. Some other icon should replace this.
-> Placeholder art is used for the profile and gameplay screens. These will later be dynamic
-> Knowledges/ideas should ideally be abstracted/made dynamic in the code
-> Continue game button does nothing until save states are implimented (with SQL)
-> Help menu is a placeholder.

Bugs:
-> Issues with help menu detecting which button was pressed
-> Text opacity doesn't change with appropriate button press

Current tasks:
-> Create a class that handles options/results of choices
-> Add save states
	-> update 'continue' button
	-> update 'reset game' in options
-> Add help menu text