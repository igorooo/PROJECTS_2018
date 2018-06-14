from safe import safe
from cezar import cezar
from random import randint
from decode import decode

# words form 0 to 420000

file = open("words.txt" ,"r")
list = []

for i in range(0 ,420000):
    list.append(file.readline().lower())

gen = safe(list)

pas = gen.SelectPassword()

diff = randint(0,20)

print ("password before cezar is "+ pas)

pas = cezar(pas,diff)

print ("password after cezar is "+ pas)

decod = decode(list,pas)

password = decod.dec()

print ("word used: "+password)




