def getMult(input_):
  returnString = ""
  x_loc = 0
  x_loc = input_.index("x")
  for i in range(x_loc+1,len(input_)):
    returnString += (input_[i])
  return returnString
  
def getAmnt(input_):
  pass

input_ = input()


mult = int(getMult(input_))

print(int(input())*mult)