numberNames = ["Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"]

def splitByChar(word):
    return [char for char in word]

def getNames(input_):
  returnString = ""
  input_ = splitByChar(input_)
  #print(input_)
  for char in input_:
    #print(numberNames[int(char)])
    returnString += numberNames[int(char)]
    returnString += " "
  return returnString

print(getNames(input()))