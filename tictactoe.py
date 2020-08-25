import sys
import random

def printBoard(board):
    print("     0   1   2")
    print("    ----------- ")
    print(" 0 | "+board[0]+" | "+board[1]+" | "+board[2]+" |")
    print("    ----------- ")
    print(" 1 | "+board[3]+" | "+board[4]+" | "+board[5]+" |")
    print("    ----------- ")
    print(" 2 | "+board[6]+" | "+board[7]+" | "+board[8]+" |")
    print("    ----------- ")

def computerMove(state):
    # RANDOM CHOICE
    move = random.choice(state[1])
    (state[0])[move] = "x"
    (state[1]).remove(move)
    print("> I've made a move, this is what we're at now:")
    printBoard(state[0])
    print("> Show me what you've got!")
    return state

def userMove(state):
    coord = input()
    try:
        if len(coord) is not 3:
            raise ValueError
        row = int(coord[0])
        col = int(coord[2])
        if row < 0 or row > 2 or col < 0 or col > 2:
            raise ValueError
    except ValueError:
        sys.exit("> Please enter your move as follows: rownumber columnnumber")
    move = 3*row + col
    if move in state[1]:
        (state[0])[move] = "o"
    else:
        sys.exit("> This move is not allowed, you dumb-dumb!")
    printBoard(state[0])
    return state

def main():
    print("> Hello and welcome to this game of Tic-Tac-Toe!")
    print("> I'll be playing as x, you'll be playing as o. I'll start.")
    board = []
    available = []
    for i in range(9):
        board.append(" ")
        available.append(i)
    # TUPLE DOESN'T WORK!!
    state = []
    state.append((board, available))
    print(state[1])
    state = computerMove(state)
    print("> Now, it's your first turn. The way you'll enter your move is first entering the x coordinate and then the y coordinate.")
    state = userMove(state)
    state = computerMove(state)

if __name__ == "__main__":
    main()
