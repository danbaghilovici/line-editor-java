##Line Editor-Java

From **[wikipedia](https://en.wikipedia.org/wiki/Line_editor)**:

"*In computing, a line editor is a text editor in which each editing 
command applies to one or more complete lines of text designated 
by the user. Line editors predate screen-based text editors and 
originated in an era when a computer operator typically interacted 
with a teleprinter (essentially a printer with a keyboard), with no 
video display, and no ability to move a cursor interactively within 
a document. Line editors were also a feature of many home computers, 
avoiding the need for a more memory-intensive full-screen editor.*

*Line editors are limited to typewriter keyboard text-oriented input
 and output methods. Most edits are a line-at-a-time. Typing, editing,
 and document display do not occur simultaneously. Typically, typing 
  does not enter text directly into the document. Instead, users modify 
  the document text by entering these commands on a text-only terminal. 
  Commands and text, and corresponding output from the editor, will 
  scroll up from the bottom of the screen in the order that they are 
  entered or printed to the screen. Although the commands typically 
  indicate the line(s) they modify, displaying the edited text within 
  the context of larger portions of the document requires a separate command.*
  
*Line editors keep a reference to the 'current line' to which the entered 
commands usually are applied. In contrast, modern screen based editors allow
the user to interactively and directly navigate, select, and modify portions
of the document. Generally line numbers or a search based context (especially
when making changes within lines) are used to specify which part of the 
document is to be edited or displayed.*

*Line editors are still used non-interactively in shell scripts, and when 
dealing with failing operating systems. Update systems such as patch (Unix)
 traditionally used diff data converted into a script of ed commands. 
 They are also used in many MUD systems, though many people edit text on 
 their own computer using MUD's download & upload features.*"


##Implementation:

The editor consists of two main classes: `Editor` and `Interpreter?`.


The `Interpreter?` class is responsible for managing commands given 
from the user and outputting the results on the screen.


The `Editor` class is the one in charge of executing the commands
received from the `Interpreter?` class.

### `Editor` class

The `Editor` class's task is to load a text file from disk into memory, apply
 the commands given by the `Interpreter?` class and then if the command
 is issued, save the now modified file back to disk. All the changes will 
 happen in memory and will not be saved into the disk until the command is given.  
To load the file into memory, the `Editor` will read a file line by line and 
store each line into an array, so that in the end it will resolve into just
an array of `String`, where each position `i` will represent the `i`nt line 
in the file.

The class has the next methods:
##### Constructors, read & write:
- (Constructor) `Editor()`: Empty constructor that creates a new empty 
nameless file in memory.

- (Constructor) `Editor(String filename) throws FileNotFoundException`: Loads 
the file `filename` from disk. The first line of the file will be the current line.
 Can also throw an exception.
 
- `void saveFile() throws FileNotFoundException`: Stores the data on disk. 
If the file has no name will throw an exception.

- `void loadFile() throws FileNotFoundException`: Loads the data from the file 
it has the name. The new data overrides the previous data. If it can't open 
the file throws an exception.

- `String getName()`: Returns the name of the current file, null if 
it has not yet been named.

- `void setName(String filename)`: Changes the name of the file to `filename`.
 The file isn't stored to the disk until `saveFile()` is called.
 
 ##### Line modification:
- `void insertLine(String newline)`: Inserts a new line before 
the current line. If the current line is at the end of the file then
it's just adds it at the end of the file. 
The new line becomes the new current line.

- `void removeLine()`: Deletes the current line. The new current line 
will be the next line after the deleted one. If the current line is at 
the end of the file, it does nothing.

- `void replaceLine(String newLine)`: Replaces the current line with `newLine`.
If the current line is at the end of the file, it appends `newLine` to the file.
The current line moves to the last line of the file.

- `String getCurrentLine()`: Returns the text from the current line, or `null`
the file is at the end of the file.

- `void nextLine()`: Moves the current line to the next line, unless the current
line is already at the end of the file.

- `void previousLine()`: Moves the current line to the previous line, unless 
the current line is already at the start of the file.

- `void goToLine(int lineNumber)`: Moves the current line to the position 
`lineNumber`. If `lineNumer`<=1, it moves to the the start of the file, if
`lineNumber` >= number of lines of the file, it gets to the end. 

##### File state

- `boolean getState()`: Returns a boolean with the current state of the file.

- `void clearState()`: Changes the state to not modified. To save the changes
the editor must call the `saveFile()` method.


###### Data visualisation

- `void toString()`: Returns a string showing:
    
    - the line number.
    - the cursor (>) indicating if the line is the current line.
    - the entire line of the file.
    
    Example:
    
        1 This is a line.
        2>This is another line.
        3 This is yet another.
        .
        .
        .
    
- `String infoString()`: Returns a string showing all the information about the
current file.

##### Word Searching

- `String indexString()`: Returns a string showing all the words that appear 
in the file, as well as how many times the word appears.

- `boolean advanceWord(String word)`: Moves the current line to the first line
that contains the word `word`. Returns `true` if has found a line with that word
or `false` if not (in this case the current line doesn't change).

### `Interpreter?` class

The `Interpreter` class's task is to show the user a well defined set of 
commands, accept and interpret the user's input and execute the command given. 

//TO COMPLETE


