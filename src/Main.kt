
/**
* Main.kt
* Executable java code of the code.
*
* @author (Eric S Lee)
* @version (v0.0)
*/

import java.util.*

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val Test = App()

    val itemLoopable = true

    while (itemLoopable) {
        println("Welcome to command version of Things to do")
        println("1. Add") // Add a note
        println("2. Edit") // Edit a note (Content only)
        println("3. Remove") // Remove a note
        println("4. View") // View a note
        println("5. Exit") // Exit the Code
        val myObj = Scanner(System.`in`) // Create a Scanner object
        val line = myObj.nextLine()
        if (line.equals("5")) {
            break
        } else if (line.equals("1")) {
            // line is "1"
            // Add a note to the ArrayList created
            val myObj2 = Scanner(System.`in`) // Create a Scanner object
            print("Enter the Title: ")
            val userTitle = myObj.nextLine() // Read userTitle, Title of the new Note
            print("Enter the content: ")
            val userComment = myObj2.nextLine() // Read userComment, Content of the new Note
            Test.addNote(userTitle, userComment) // Add a new Note to ArrayList
        } else if (line.equals("2")) {
            // line is "2"
            // Edit the specific note to the ArrayList, based on the key/ID
            if (Test.totalLength() == 0) {
                // If the ArrayList (App class) is empty then
                // Alert user to add the new note first
                println()
                println("Enter the data before proceed")
            } else {
                // If the ArrayList has at least one note then
                // First display all the notes inside the ArrayList
                for (i in 0 until Test.totalLength()) {
                    val testItem: Array<String> = Test.viewNote(i)
                    println(i.toString() + " " + testItem[1] + " " + testItem[2])
                }
                // Then ask user to which section note to edit
                val myObj2 = Scanner(System.`in`) // Create a Scanner object
                print("Enter the number to edit: ")
                val userColumn = myObj2.nextInt() // Read userColumn in integer format
                if (userColumn < Test.totalLength() && userColumn >= 0) {
                    // If the proper range (key/ID) is selected then
                    // Display specific key of the note (Content only)
                    val testItem: Array<String> = Test.viewNote(userColumn)
                    println(userColumn.toString() + " " + testItem[2])
                    println()
                    println("Only the content can be edited")
                    // Ask user to prompt new Content
                    print("Enter the new content: ")
                    val myObj3 = Scanner(System.`in`) // Create a Scanner object
                    val newUserComment = myObj3.nextLine() // Read newUserComment
                    if (newUserComment == "") {
                        // If user give blank then
                        // Assume the note will not be edited.
                        // newUserComment = testItem[2];
                        println("No change occurs")
                    } else {
                        // If user state a new Content then
                        // Replace old Content into new Content
                        val newNote: Array<String> = Test.viewNote(userColumn)
                        Test.editNote(userColumn, newNote[1], newUserComment)
                    }
                } else {
                    // If the proper range (key/ID) is not selected then
                    // Indicate that there's no note contain in that range Key/ID
                    println()
                    println("Invalid ID number, try again!")
                }
            }
        } else if (line.equals("3")) { // line is "3"
            // Delete the specific note to the ArrayList, based on the key/ID
            if (Test.totalLength() == 0) {
                // If the ArrayList (App class) is empty then
                // Alert user to add the new note first
                println()
                println("Enter the data before proceed")
            } else {
                // If the ArrayList has at least one note then
                // First display all the notes inside the ArrayList
                for (i in 0 until Test.totalLength()) {
                    val testItem: Array<String> = Test.viewNote(i)
                    println(i.toString() + " " + testItem[1] + " " + testItem[2])
                }
                // Then ask user to which section note to remove/delete
                val myObj2 = Scanner(System.`in`) // Create a Scanner object
                print("Enter the number to delete: ")
                val userColumn = myObj2.nextInt() // Line();  // Read userColumn in Integer
                if (userColumn < Test.totalLength() && userColumn >= 0) {
                    // If the specific note is found then remove specific note from the Arraylist
                    Test.deleteNote(userColumn)
                } else {
                    // If the specific note is not existed then indicate the error
                    // That the specific note is not founded.
                    println()
                    println("Invalid ID number, try again!")
                }
            }
        } else if (line.equals("4")) { // line is "4"
            // Display all the notes inside the Arraylist
            // The note will display,
            // Location of the Arraylist, Key code, Title, then Content
            for (i in 0 until Test.totalLength()) {
                val testItem: Array<String> = Test.viewNote(i)
                println(i.toString() + " " + testItem[0] + " " + testItem[1] + " " + testItem[2])
            }
        } else {
            println("Invalid Code, try again.")
        }
        println()
    }
}