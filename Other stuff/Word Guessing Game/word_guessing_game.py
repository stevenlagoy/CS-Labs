from typing import List, Tuple

import random as rand
import math

def main() -> None:
  # create a list of all items in the words file
  wordList: List[str] = []
  wordFile = open("words.txt","r")

  for word in wordFile:
    wordList.append(word.lower())
  wordFile.close()
  wordList.sort()

  def pick_word() -> Tuple[str, int]:
    '''Returns a random item from the words list and its index.'''
    i = rand.randint(0, len(wordList))
    word = wordList[i]
    if len(word) < 4:
      return pick_word()
    elif "-" in word:
      return pick_word()
    else:
      return word, i

  # pick a word and ensure that it is not "hint"
  wordTarget, wordIndex = pick_word()
  while wordTarget == "hint":
    wordTarget, wordIndex = pick_word()

  numGuesses: int = 0
  highestWord = len(wordList) - 1
  lowestWord = 0
  solved: bool = False

  while not solved: # as long as the player has not solved the game

    # tell the player how many guesses they've taken
    print("You have taken " + str(numGuesses) + " guesses.\n")

    if lowestWord != 0: # if they have taken a lower guess
      print("Target is later than " + wordList[lowestWord])
    if highestWord != len(wordList) - 1: # if they have taken a higher guess
      print("Target is earlier than " + wordList[highestWord])
    
    # get the player's guess and standardize it
    wordGuess: str = input("Guess word: ").lower()
    wordGuess += "\n"

    if wordGuess == "give up\n": # if the player wishes to give up
      print("You gave up. The word was '" + wordTarget[0:-1] + "'.")
      numGuesses = 0
      break
    elif wordGuess == "hint\n": # if the player wants a hint
      hint_word: str = rand.choice(wordList[lowestWord+1:highestWord-1])  # ensure that a current known guess is not the hinted word
      tries: int = 0
      while hint_word == wordTarget:
        tries += 1
        hint_word = rand.choice(wordList[lowestWord+1:highestWord-1]) # ensure that the hinted word is not the target
        if tries >= 10: # if the target word is selected 10 times in a row, assume that it's the only word left
          print("There is only one word in this range- it cannot be hinted.")
      print("A hint word: " + hint_word)
    
    else: # if the player has attempted a guess
      print("Your guess: " + wordGuess)
      
      if len(wordGuess) < 4: # check that it's 3 letters or longer
        print("Your guess must contain at least 3 letters. Try again.")
      elif wordGuess in wordList: # check that it's a valid word
        if wordList.index(wordGuess) < wordIndex:
          print("Your guess is earlier in the dictionary than the target\n")
          if wordList.index(wordGuess) > lowestWord:
            lowestWord = wordList.index(wordGuess)
        elif wordList.index(wordGuess) > wordIndex:
          print("Your guess is later in the dictionary than the target\n")
          if wordList.index(wordGuess) < highestWord:
            highestWord = wordList.index(wordGuess)
        else: # if the player has found the target word
          print("You guessed it!")
          solved = True
          continue
      else: # the guess is not a real word
        print("Input a valid word")

    # increase the number of guesses
    numGuesses += 1
    print("---------------------------------------")

  if solved: # if the player found the target word
    score = math.floor(len(wordList) / numGuesses)
    print("You guessed the word! It took you " + str(numGuesses) + " guesses.")
    print("Your score was " + str(score) + " (avg words eliminated per guess)")

if __name__ == "__main__":
  main()