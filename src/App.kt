
/**
 * App.kt
 * Contain group of notes inside the arraylist.
 * Each note contains, one note class which has the title and the content.
 *
 * @author (Eric S Lee)
 * @version (v0.0)
 */

import java.util.ArrayList

class App {
    // instance variables
    private var x: Int = 0 // Generate ID (Key) of the code
    private var theNotes: ArrayList<Note> = ArrayList() // ArrayList of the Note class

    /**
     * Constructor for objects of class App
     */
    init {
        // initialise instance variables
        theNotes = ArrayList() // Create new empty ArrayList
        x = 0
    }

    // Create a new note inside the ArrayList
    fun addNote(newTitle: String, newContent: String) {
        theNotes.add(Note(x, newTitle, newContent))
        x += 1 // Used for generate key, once added, add one from x
    }

    // Delete-Remove a specific note inside the ArrayList
    // Based on the key (order) value
    fun deleteNote(key: Int) {
        theNotes.removeAt(key)
    }

    // Edit a specific note (except for ID/Key) inside the ArrayList
    // Based on the key (order) value
    fun editNote(key: Int, newTitle: String, newContent: String) {
        val item = theNotes[key]
        item.editNoteTitle(newTitle)
        item.editNoteContent(newContent)
    }

    // Return total number of Note inside the ArrayList
    fun totalLength(): Int {
        return theNotes.size
    }

    // Return the Key/ID of the Note inside the ArrayList
    fun viewID(key: Int): Int {
        val item = theNotes[key]
        return item.returnID()
    }

    // Return the Key/ID of the Note inside the ArrayList
    fun viewKey(id: Int): Int {
        for (i in theNotes.indices) {
            val item = theNotes[i]
            if (id == item.returnID()) {
                return id
            }
        }
        return 0
    }

    // Return the content (ID, Title, Content) of the Note inside the ArrayList
    fun viewNote(key: Int): Array<String> {
        val item = theNotes[key]
        return arrayOf(item.returnID().toString(), item.returnTitle(), item.returnContent())
    }
}