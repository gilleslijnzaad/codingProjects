def letterToKey(letter):
    return {
        "a" : "2",
        "b" : "2",
        "c" : "2",
        "d" : "3",
        "e" : "3",
        "f" : "3",
        "g" : "4",
        "h" : "4",
        "i" : "4",
        "j" : "5",
        "k" : "5",
        "l" : "5",
        "m" : "6",
        "n" : "6",
        "o" : "6",
        "p" : "7",
        "q" : "7",
        "r" : "7",
        "s" : "7",
        "t" : "8",
        "u" : "8",
        "v" : "8",
        "w" : "9",
        "x" : "9",
        "y" : "9",
        "z" : "9",
    }[letter]

def keyToLetter(key):
    return {
        "a" : "2",
        "b" : "2",
        "c" : "2",
        "d" : "3",
        "e" : "3",
        "f" : "3",
        "g" : "4",
        "h" : "4",
        "i" : "4",
        "j" : "5",
        "k" : "5",
        "l" : "5",
        "m" : "6",
        "n" : "6",
        "o" : "6",
        "p" : "7",
        "q" : "7",
        "r" : "7",
        "s" : "7",
        "t" : "8",
        "u" : "8",
        "v" : "8",
        "w" : "9",
        "x" : "9",
        "y" : "9",
        "z" : "9",
    }[key]

# converts keys into words and words into keys
def convert(item):
    convertedItem = ""
    for char in convertedItem:
        if char.isalpha():
            item += letterToKey(char)
        else:
            item += keyToLetter(char)
    print(item)
    return item

def findWord(keys, wordsWithKeys):
    for i in wordsWithKeys:
        if i[1] == keys:
            word = i[0]
            break
    else:
        word = "?"
    return word

# the actual magic: translating the key-words into letter-words
def T9translate(input, wordsWithKeys):
    output = ""
    tok = 0
    for word in input:
        output += (findWord(word, wordsWithKeys) + " ")
    return output

def main():
    # read words from file
    file = open("word_list.txt", "r")
    numWords = 1000
    items = file.read().splitlines()
    words = []

    # fill up words array
    for i in range(len(items)):
        # only keep the first #numWords words from the list
        if i == numWords:
            break
        words.append(items[i])

    # convert words from the list into keys, put into wordsWithKeys array
    wordsWithKeys = []
    for w in words:
        k = convert(w)
        wordsWithKeys.append((w,k))

    print("Please enter the word or phrase you want to translate into keys:")
    alphaInput = str(input()).split()
    numOutput = convert(alphaInput)
    print("This is your input translated to keys:\n" + str(numOutput))
    alphaOutput = T9translate(numOutput, wordsWithKeys)
    print("This is those keys translated back to your input (hopefully):")
    print(alphaOutput)
    print("Thank you for translating with us today!")

if __name__ == "__main__":
    main()
