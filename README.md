###Line Editor-Java

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



Create `Editor` class that will represent the class in charge of editing the file from memory. The class must implement the next methods:
-(Constructor) `Editor()`: Empty constructor that creates a new empty nameless file in memory.
-(Constructor) `Editor(String filename) throws FileNotFoundException`: Loads the file filename from disk. The first line of the file will be the active line. Can also throw an exception.
- `void saveFile() throws FileNotFoundException`: Stores the data on disk. If the file has no name will throw an exception.
- `void saveFile() throws FileNotFoundException`: Loads the data from the file it has the name. The new data overrides the previous data. If it can't open the file throws an exception.
- `String getName()`: Returns the name of the current file, null if it hasn't yet been named.
-`void setName(String filename)`: Changes the name of the file to `filename`. The file isn't stored to the disk untill `saveFile()` is called.
-`void insertLine(String line)`: the method must insert a new line before the current line. If the current line is at the end of the file it inserts it as a new line. The new line becomes the new current line.
