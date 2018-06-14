from cezar import cezar


class decode(object):

    def __init__(self,list,pas):
        self.list = list
        self.pas = pas

    def dec(self):
        steps = 0
        for word in self.list:
            for i in range(0,21):
                temp = cezar(word,i)
                steps += 1
                if(temp == self.pas):
                    print ("steps: "+str(steps))
                    print ("difference: "+str(i))
                    return word
        print ("Cant Find this shit")
        return ("shiiiit")
