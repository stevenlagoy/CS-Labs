############################################

# USER VARIABLES:

# the population size (integer)
pop_size = 20000

# the number of simulated days (integer)
sim_time = 180

# rate of infection - how likely an infected person is to spread the disease each day
infection_rate = 12

# rate of cure each day - how likely an infected person is to be cured each day
cure_rate = 7

# rate of death - how likely an infected person is to die each day (COVID-19 = 18)
death_rate = 3

# rate of susceptibility after immunity
immune_rate = 65

# how often infected people will self-isolate
isolation_rate = 90

# maximum number of isolated people
hospital_capacity = 200

# choose what the graph will display: ('True' for true, 'False' for false)
show_susceptible = False
show_infected = True
show_immune = True
show_dead = True
show_isolated = True

############################################
sim_time += 1

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

'''
# variables:
# change these to see their effects!

infection_rate = 5
# percentage chance that a person will become infected when exposed

pop_size = 500
# the number of simulated people

recreationals_daily = 3
# the number of extra locations which the people visit daily

sim_time = 120
# the number of days in the simulation

death_rate = 5
# the number of deaths per 100 infected people

cure_rate = 6
# the percentage chance of being cured every day

hospital_capacity = 100
# the effective capacity of the hospital system

immune_time = 15
# the number of days a person is immune after being infected

prevention_rate = 50
# the percentage of people who use preventitive techniques

prevention_efficiency = 80
# the efficiency of preventative techniques

import random as rand
import math
import matplotlib.pyplot as plt

number_workplaces = math.floor(((pop_size / 10)))
number_homes = math.floor(((pop_size / 8)))
number_recreationals = math.floor(pop_size * 0.125)
#print(number_recreationals)

people_workplaces = {}
people_homes = {}
infected_list = []
cured_list = []
died_list = []

infected_by_day = []
cured_by_day = []
died_by_day = []

people = ['p1', 'p2', 'p3', 'p4', 'p5', 'p6', 'p7', 'p8', 'p9', 'p10', 'p11', 'p12', 'p13', 'p14', 'p15', 'p16', 'p17', 'p18', 'p19', 'p20', 'p21', 'p22', 'p23', 'p24', 'p25', 'p26', 'p27', 'p28', 'p29', 'p30', 'p31', 'p32', 'p33', 'p34', 'p35', 'p36', 'p37', 'p38', 'p39', 'p40', 'p41', 'p42', 'p43', 'p44', 'p45', 'p46', 'p47', 'p48', 'p49', 'p50', 'p51', 'p52', 'p53', 'p54', 'p55', 'p56', 'p57', 'p58', 'p59', 'p60', 'p61', 'p62', 'p63', 'p64', 'p65', 'p66', 'p67', 'p68', 'p69', 'p70', 'p71', 'p72', 'p73', 'p74', 'p75', 'p76', 'p77', 'p78', 'p79', 'p80', 'p81', 'p82', 'p83', 'p84', 'p85', 'p86', 'p87', 'p88', 'p89', 'p90', 'p91', 'p92', 'p93', 'p94', 'p95', 'p96', 'p97', 'p98', 'p99', 'p100', 'p101', 'p102', 'p103', 'p104', 'p105', 'p106', 'p107', 'p108', 'p109', 'p110', 'p111', 'p112', 'p113', 'p114', 'p115', 'p116', 'p117', 'p118', 'p119', 'p120', 'p121', 'p122', 'p123', 'p124', 'p125', 'p126', 'p127', 'p128', 'p129', 'p130', 'p131', 'p132', 'p133', 'p134', 'p135', 'p136', 'p137', 'p138', 'p139', 'p140', 'p141', 'p142', 'p143', 'p144', 'p145', 'p146', 'p147', 'p148', 'p149', 'p150', 'p151', 'p152', 'p153', 'p154', 'p155', 'p156', 'p157', 'p158', 'p159', 'p160', 'p161', 'p162', 'p163', 'p164', 'p165', 'p166', 'p167', 'p168', 'p169', 'p170', 'p171', 'p172', 'p173', 'p174', 'p175', 'p176', 'p177', 'p178', 'p179', 'p180', 'p181', 'p182', 'p183', 'p184', 'p185', 'p186', 'p187', 'p188', 'p189', 'p190', 'p191', 'p192', 'p193', 'p194', 'p195', 'p196', 'p197', 'p198', 'p199', 'p200', 'p201', 'p202', 'p203', 'p204', 'p205', 'p206', 'p207', 'p208', 'p209', 'p210', 'p211', 'p212', 'p213', 'p214', 'p215', 'p216', 'p217', 'p218', 'p219', 'p220', 'p221', 'p222', 'p223', 'p224', 'p225', 'p226', 'p227', 'p228', 'p229', 'p230', 'p231', 'p232', 'p233', 'p234', 'p235', 'p236', 'p237', 'p238', 'p239', 'p240', 'p241', 'p242', 'p243', 'p244', 'p245', 'p246', 'p247', 'p248', 'p249', 'p250', 'p251', 'p252', 'p253', 'p254', 'p255', 'p256', 'p257', 'p258', 'p259', 'p260', 'p261', 'p262', 'p263', 'p264', 'p265', 'p266', 'p267', 'p268', 'p269', 'p270', 'p271', 'p272', 'p273', 'p274', 'p275', 'p276', 'p277', 'p278', 'p279', 'p280', 'p281', 'p282', 'p283', 'p284', 'p285', 'p286', 'p287', 'p288', 'p289', 'p290', 'p291', 'p292', 'p293', 'p294', 'p295', 'p296', 'p297', 'p298', 'p299', 'p300', 'p301', 'p302', 'p303', 'p304', 'p305', 'p306', 'p307', 'p308', 'p309', 'p310', 'p311', 'p312', 'p313', 'p314', 'p315', 'p316', 'p317', 'p318', 'p319', 'p320', 'p321', 'p322', 'p323', 'p324', 'p325', 'p326', 'p327', 'p328', 'p329', 'p330', 'p331', 'p332', 'p333', 'p334', 'p335', 'p336', 'p337', 'p338', 'p339', 'p340', 'p341', 'p342', 'p343', 'p344', 'p345', 'p346', 'p347', 'p348', 'p349', 'p350', 'p351', 'p352', 'p353', 'p354', 'p355', 'p356', 'p357', 'p358', 'p359', 'p360', 'p361', 'p362', 'p363', 'p364', 'p365', 'p366', 'p367', 'p368', 'p369', 'p370', 'p371', 'p372', 'p373', 'p374', 'p375', 'p376', 'p377', 'p378', 'p379', 'p380', 'p381', 'p382', 'p383', 'p384', 'p385', 'p386', 'p387', 'p388', 'p389', 'p390', 'p391', 'p392', 'p393', 'p394', 'p395', 'p396', 'p397', 'p398', 'p399', 'p400', 'p401', 'p402', 'p403', 'p404', 'p405', 'p406', 'p407', 'p408', 'p409', 'p410', 'p411', 'p412', 'p413', 'p414', 'p415', 'p416', 'p417', 'p418', 'p419', 'p420', 'p421', 'p422', 'p423', 'p424', 'p425', 'p426', 'p427', 'p428', 'p429', 'p430', 'p431', 'p432', 'p433', 'p434', 'p435', 'p436', 'p437', 'p438', 'p439', 'p440', 'p441', 'p442', 'p443', 'p444', 'p445', 'p446', 'p447', 'p448', 'p449', 'p450', 'p451', 'p452', 'p453', 'p454', 'p455', 'p456', 'p457', 'p458', 'p459', 'p460', 'p461', 'p462', 'p463', 'p464', 'p465', 'p466', 'p467', 'p468', 'p469', 'p470', 'p471', 'p472', 'p473', 'p474', 'p475', 'p476', 'p477', 'p478', 'p479', 'p480', 'p481', 'p482', 'p483', 'p484', 'p485', 'p486', 'p487', 'p488', 'p489', 'p490', 'p491', 'p492', 'p493', 'p494', 'p495', 'p496', 'p497', 'p498', 'p499',]

#---functions---
def infection(infected):
  global infected_list
  for person in infected_list:
    if infected == person:
      return None
  for person in died_list:
    if infected == person:
      return None
  for person in cured_list:
    if infected == person:
      return None
  if rand.randint(0, 100) <= infection_rate:
    if rand.randint(0, (100 - (math.floor(prevention_rate*(100/prevention_efficiency))))) <= infection_rate:
      return None
    infected_list.append(infected)
    #for person in cured_list:
    #    if infected == person:
    #        cured_list.remove(person)

infected_list.append(people[0])
def run():
  global infected_by_day, died_by_day, cured_by_day
  for day in range(0, sim_time):
    for infected in infected_list:
      infected_home = people_homes[infected]
      for person in people_homes:
        if people_homes[person] == infected_home:
          infection(person)
      infected_workplace = people_workplaces[infected]
      for person in people_workplaces:
        if people_workplaces[person] == infected_home:
          infection(person)
      cured = rand.randint(1, 100)
      if cured < death_rate:
        #print(infected)
        #people.remove(str(infected))
        died_list.append(infected)
        infected_list.remove(infected)
        #print(infected)
      elif cured > (100 - cure_rate):
        #people.remove(infected)
        if len(infected_list) < hospital_capacity:
          cured_list.append(infected)
          infected_list.remove(infected)
      #susceptable = math.floor(len(cured_list) / immune_time)
      #for i in range(0,susceptable):
      #  infected_list.append(cured_list[0])
      #  del cured_list[0]
    #print(infected_list)
    #print("DAY " + str(day))
    #print(str(len(infected_list)) + " infected")
    infected_by_day.append(len(infected_list))
    #print(str(len(died_list)) + " dead")
    died_by_day.append(len(died_list))
    #print(str(len(cured_list)) + " cured")
    cured_by_day.append(len(cured_list))

#---main---
for person in people:
  for pi in range(0, pop_size):
    people_workplaces[person] = rand.randint(1,number_workplaces)
    people_homes[person] = rand.randint(1,number_homes)
    pi += 1
#randomizes workplaces / homes
#print(people_homes)
#print(people_workplaces)
#print()
print("DAY 1")
print("1 infected")
print("0 dead")
run()

print("Done")

days_list = []
for day in range(1,sim_time):
  days_list.append(day)
plt.plot(days_list, infected_by_day)
plt.plot(days_list, died_by_day)
plt.plot(days_list, cured_by_day)

#plt.ylabel('PEOPLE')
#plt.xlabel('DAYS')
#plt.legend('IDC')
plt.show()
print("BLUE - INFECTED")
print("RED - CURED/IMMUNE")
print("GREEN - DEAD")
'''