alphabet = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
punc = '''!()-[]{};:'"\,<>./?@#$%^&*_~'''

def split(word):
    return [char for char in word]

def removePunc(input_):
  for char in input_:
    if char in punc:
      input_ = input_.replace(char, "")
  return input_

def checkLetters(input_):
  global alphabet
  returnString = ""
  local_alph = alphabet
  double_letters = []
  
  input_ = removePunc(input_)
  input_ = input_.lower()
  input_ = split(input_)
  
  for char in input_:
    if char in alphabet:
      local_alph.remove(char)
    else:
      if char in double_letters or char == " ":
        pass
      else:
        double_letters.append(char)
  if len(local_alph) == 0:
    returnString += "Pangram\n"
  else:
    returnString += "Not a pangram\n"
  double_letters.sort()
  if len(local_alph) == 0:
    for letter in double_letters:
      returnString += letter
      returnString += " "
  else:
    for letter in local_alph:
      returnString += letter
      returnString += " "
  return returnString

print(checkLetters(input()))

# The quick brown fox jumps over the lazy dog.
# The slick brown fox jumps over the lazy dog!