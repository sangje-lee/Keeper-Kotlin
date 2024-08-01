/**
 * Note.kt
 * Contain the ID (Key), title and the content of the note.
 *
 * @author (Eric S Lee)
 * @version (v0.0)
 */
data class Note(
    private var theID: Int,          // Key (ID) of note
    private var theTitle: String,    // Title of note
    private var theContent: String    // Content of note
) {

    // Editing the title of the note
    fun editNoteTitle(newTitle: String) {
        theTitle = newTitle
    }

    // Editing the content of the note
    fun editNoteContent(newContent: String) {
        theContent = newContent
    }

    // Return the title of the note in String form
    fun returnTitle(): String {
        return theTitle
    }

    // Return the content of the note in String form
    fun returnContent(): String {
        return theContent
    }

    // Return the ID (Key) of the note in Integer
    fun returnID(): Int {
        return theID
    }
}