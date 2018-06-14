
class next(object):


    def __init__(self,size, level):
        self.size = size
        self.level = level


    def __repr__(self):
        return ("there is a block on "+str(self.level)+" level, its size is: "+str(self.size))

