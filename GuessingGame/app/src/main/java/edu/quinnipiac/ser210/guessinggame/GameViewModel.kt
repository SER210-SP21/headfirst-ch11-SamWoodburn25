package edu.quinnipiac.ser210.guessinggame
/*
  * Sam Woodburn
  * 3/22/24
  * HFAD- Chapter11 Demo
  * Guessing Game
  * GameViewModel- extends view model, checks for the correct guess and updates the screen accordingly
 */

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    val words = listOf("Android", "Activity", "Fragment")
    val secretword = words.random().uppercase()
    var secretWordDisplay = ""
    var correctGuesses = ""
    var incorrectGuesses = ""
    var livesLeft = 8

    init {
        secretWordDisplay = deriveSecretWordDisply()
    }

    fun deriveSecretWordDisply(): String {
        var disply = ""
        secretword.forEach {
            disply += checkLetter(it.toString())
        }
        return disply
    }

    fun checkLetter(str: String) = when (correctGuesses.contains(str)){
        true -> str
        false -> "_"
    }

    fun makeGuess(guess: String) {
        if(guess.length == 1) {
            if (secretword.contains(guess)) {
                correctGuesses += guess
                secretWordDisplay = deriveSecretWordDisply()
            } else {
                incorrectGuesses += "$guess"
                livesLeft--
            }
        }
    }

    fun isWon() = secretword.equals(secretWordDisplay, true)
    fun isLost() = livesLeft <= 0

    fun wonLostMessage() : String {
        var message = ""
        if (isWon()) message = "you won!"
        else if (isLost()) message = "you lost!"
        message += "The words was $secretword."
        return message
    }
}