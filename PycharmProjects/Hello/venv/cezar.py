
def cezar(word, dif):
    nword =""
    for c in word:
        nword += chr(ord(c)+dif)

    return nword
