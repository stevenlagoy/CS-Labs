############################################

# USER VARIABLES:

# the population size
pop_size = 1000

# the number of simulated days
sim_time = 60

# rate of infection - how likely an infected person is to spread the disease each day
infection_rate = 45

# rate of cure each day - how likely an infected person is to be cured each day
cure_rate = 50

# rate of death - how likely an infected person is to die each day (COVID-19 = 18)
death_rate = 58

# rate of susceptibility after immunity
immune_rate = 10

# how often infected people will self-isolate
isolation_rate = 90

# maximum number of isolated people
hospital_capacity = 150

# choose what the graph will display: ('True' for true, 'False' for false)
show_susceptible = False
show_infected = True
show_immune = True
show_dead = True
show_isolated = True

############################################
sim_time += 1
death_rate = death_rate / 10

import random as rand
import math
import matplotlib.pyplot as plt

susceptible_p = pop_size - 1
infected_p = 1
isolated_p = 0
immune_p = 0
dead_p = 0
isolated_p = 0

susceptible_by_day = []
immune_by_day = []
infected_by_day = []
dead_by_day = []
isolated_by_day = []

for day in range(0, sim_time):
  if infected_p < 0:
    infected_p = 0
  #lists for graph
  susceptible_by_day.append(susceptible_p)
  infected_by_day.append(infected_p)
  immune_by_day.append(immune_p)
  dead_by_day.append(dead_p)
  isolated_by_day.append(isolated_p)
  #infected people
  for person in range(0, infected_p):
    #infection
    if susceptible_p > 0:
      if rand.randint(1,100) <= infection_rate:
        randnum = rand.randint(1,10)
        susceptible_p += -randnum
        infected_p += randnum
    #cure
    if rand.randint(1,100) <= cure_rate:
      infected_p += -1
      immune_p += 1
    #death
    if rand.randint(1,100) <= death_rate:
      if rand.randint(1,(100*death_rate)) <= death_rate:
        #* (1 + (death_rate / 100))
        infected_p += -1
        dead_p += 1
    #self-isolation
    if rand.randint(1,100) >= isolation_rate:
      if hospital_capacity > 0:
        isolated_p += 1
        infected_p += -1
        hospital_capacity += -1
  #immune people
  for person in range(0, immune_p):
    if rand.randint(1, 100) >= immune_rate:
      immune_p += -1
      susceptible_p += 1
  #isolated people
  for person in range(0, isolated_p):
    #isolated cure
    if rand.randint(1,100) <= cure_rate:
      isolated_p += -1
      immune_p += 1
      hospital_capacity += 1
    #isolated death
    if rand.randint(1,100) <= death_rate:
      isolated_p += -1
      dead_p += 1
      hospital_capacity += 1

days_list = []
for day in range(1,sim_time):
  days_list.append(day)

plt.plot(days_list, susceptible_by_day, color="black")
plt.plot(days_list, infected_by_day, color="red")
plt.plot(days_list, immune_by_day, color="blue")
plt.plot(days_list, dead_by_day, color="green")

if show_susceptible == True:
  plt.plot(days_list, susceptible_by_day)
  print(str(susceptible_by_day[-1]) + " susceptible on final day")
if show_infected == True:
  plt.plot(days_list, infected_by_day)
  print(str(infected_by_day[-1]) + " infected on final day")
if show_immune == True:
  plt.plot(days_list, immune_by_day)
  print(str(immune_by_day[-1]) + " immune on final day")
if show_dead == True:
  plt.plot(days_list, dead_by_day)
  print(str(dead_by_day[-1]) + " dead on final day")
if show_isolated == True:
  plt.plot(days_list, isolated_by_day)
  print(str(isolated_by_day[-1]) + " isolated on final day")


plt.show()
