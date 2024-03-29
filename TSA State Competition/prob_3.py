def getFactors(input_):
  hasNoFactors = True
  for i in range(2,int(int(input_)/2)):
    #print(i)
    #print("Modulo: " + str(int(input_) % i))
    if int(input_) % i == 0:
      #print("Factor: " + str(i))
      hasNoFactors = False
  if hasNoFactors == True:
    return("Prime")
  else:
    return("Not a prime")

''' test runs
primesList = []
for i in range(0,100):
  if getFactors(i) == True:
    primesList.append(i)
print(primesList)
'''

print(getFactors(input()))
