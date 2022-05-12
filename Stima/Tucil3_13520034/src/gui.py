import tkinter as tk
from tkinter import messagebox
from fifteen_puzzle import *
import time

class Fifteen_Puzzle:
    def __init__(self):
        for i in range(4):
            for j in range(4):
                entry = tk.Entry(window, width = 5)
                entry.grid(row = i, column = j)
                entry = entry.insert(tk.END, "")
                
    def show_each_move(self, puzzle, iterasi_ke):
        for i in range(4):
            for j in range(4):
                entry = tk.Entry(window, width = 5)
                entry.grid(row = i, column = j)
                if (puzzle.list[4*i + j] == 16):
                    entry.insert(tk.END, "")
                else:
                    entry.insert(tk.END, puzzle.list[4*i+j])
        if(not puzzle.up):
            move = "Down"
        elif(not puzzle.down):
             move = "Up"
        elif(not puzzle.left):
            move = "Right"
        elif(not puzzle.right):
            move = "Left"
        else:
            move = "-"
        text = "Langkah ke-" + str(iterasi_ke+1) + ": " + move
        tk.Label(window, text = text).grid(row = mod(iterasi_ke,6), column = 6)

    def showall(self, array_fifteen_puzzle):
        global window
        for i in range(len(array_fifteen_puzzle)-1,0,-1):
            self.show_each_move(array_fifteen_puzzle[i],len(array_fifteen_puzzle)-i-1)
            time.sleep(1)
            window.update()
        
    
def SolveOnClick():
    global array_fifteen_puzzle
    global layouts
    filepath =  file_entry.get()
    array = openFile(filepath)
    hasil = solve(array)
    if(len(hasil)==0):
        tk.messagebox.showinfo("Error","Puzzle Tidak Bisa Diselesaikan!") 
    else:
        layout.showall(hasil)
        
    
window = tk.Tk()
window.geometry("300x150")
window.title("15-Puzzle Solver")

layout = Fifteen_Puzzle()

file_entry = tk.Entry(window, text = "Enter file name")
file_entry.place(x = 0, y = 85)

solve_button = tk.Button(window, text = "Solve", width = 15, command = SolveOnClick)
solve_button.place(x = 5, y = 110)

window.mainloop()

