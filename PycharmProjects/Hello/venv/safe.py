from random import randint

class safe(object):

    def __init__(self,list):
        self.list = list

    def SelectPassword(self):
        i = randint(0,419998)
        return self.list[i]