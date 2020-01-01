fun main (args: Array<String>) {
    val options = arrayOf("Rock", "Paper", "Scissors")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, options[gameChoice])
}

fun getGameChoice(optionsParam: Array<String>) = (Math.random() * optionsParam.size).toInt()

fun getUserChoice(optionsParam: Array<String>): String {
    //My code goes here
    var isValidChoice = false
    var userChoice = ""
    //Asking the user's choice
    while (!isValidChoice) {
        print("Please enter one of the following:")
        for(item in optionsParam) print(" $item")
        println(".")
        //Read user Input
        val userInput = readLine()?.capitalize()
        //Validate the user input
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        //If the choice is invalid
        if (!isValidChoice) println("You must enter a valid choice.")
    }
    return userChoice
}

fun printResult(userChoice: String, gameChoice: String): Unit {
    val result: String

    //Figure out the result
    if (userChoice == gameChoice) result = "Tie!"
    else if ((userChoice == "Rock" && gameChoice == "Scissors") ||
            (userChoice == "Paper" && gameChoice == "Rock") ||
            (userChoice == "Scissors" && gameChoice == "Paper"))
            result = "You win! :D"
    else result = "You lose! :("

    //Print the result
    println("You chose $userChoice and I chose $gameChoice. So, $result")
}
