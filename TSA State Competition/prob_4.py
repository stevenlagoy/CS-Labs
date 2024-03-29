import math as math

def splitByChar(word):
    return [char for char in word]

def toMinutes(input_):
  time = 0
  hours = ""
  minutes = ""
  try:
    if input_[6].upper() == "P":
      time += 720
  except:
    pass
  init_time = splitByChar(input_)
  hours += (input_[0])
  hours += (input_[1])
  time += int(hours)*60
  minutes += (input_[3])
  minutes += (input_[4])
  time += int(minutes)
  #print(time)
  return time

def toHoursMinutes(input_):
  returnString = ""
  
  hours = 0
  minutes = 0
  isPM = False
  hours = math.floor(input_/60)
  minutes = (60*((input_/60)-math.floor(input_/60)))
  if hours > 12:
    isPM = True
    hours -= 12
  if hours < 10:
    returnString += "0"
  returnString += str(hours)
  returnString += ":"
  returnString += str(minutes)
  return returnString

init_time = input()
add_time = input()
operator = add_time[0]
add_time = add_time[1:]
init_time = (toMinutes(init_time))
add_time = (toMinutes(add_time))
if operator == "+":
  init_time += add_time
else:
  init_time -= add_time
print(toHoursMinutes(init_time))
'''
02:30 PM
+01:15
'''