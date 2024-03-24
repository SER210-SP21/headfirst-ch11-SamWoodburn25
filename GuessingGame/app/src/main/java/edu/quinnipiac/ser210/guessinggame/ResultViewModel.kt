package edu.quinnipiac.ser210.guessinggame

/*
  * Sam Woodburn
  * 3/22/24
  * HFAD- Chapter11 Demo
  * Guessing Game
  * ResultViewModel- extends view model, checks if the game is won and displays to the screen according to the result view model
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ResultViewModel (private val finalResult: String) : ViewModel(){
    var result = finalResult
}