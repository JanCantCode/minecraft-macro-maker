# minecraft-macro-maker
A simple fabric mod with a (hopefully) intuitive api to create minecraft macros
fOr eDucAtiOnAl pUrPosEs oNly!!!


You can create a Macro using the MacroBuild or by passing an ```ArrayList<Task>``` into the Macro constructor. 
Example code can be found in the [MacroMakerClient](https://github.com/JanCantCode/minecraft-macro-maker/blob/master/src/main/java/tk/jandev/macromaker/client/MacromakerClient.java)
The MacroBuilder provides a ```.add(Task e)``` aswell as a ```.repeat(Task e, int amount)```, the later will add the provided task ```e``` ```amount``` times to the macro.

The MacroRunner code is currently unbelievably ugly, I might fix that later (?)
feel free to contribute i guess


# testing around with GUI's

whilst using the mod, in every ContainerScreen (=GUI), there will be a list of slot id and the corresponding item stacks they contain, visible. This list can only be fully seen with GUI
scale 2. If you want to create macros utilizing custom server GUI's, take the slot ids you get from there and use MoveItemTask's.
Keep in mind you should allways use a WaitTask between GUI clicks, as they often need a tick to load, depending on your ping.


# notes

For using MoveItem tasks, slotID is genually the slot which an item is taken out of / put in to, and buttonID is (usually) corresponding to mouse buttons (0 = left click, 1 = right click, 2 = middle click)
If you want to mvoe an item into another slot, slot is the source slot and button is the destination slot. This requires ```SlotActionType.SWAP```

> If you have any questions / want to fix my ugly code / make suggestions, feel free to make an issue or contact me via discord ItsJan#1214. 
