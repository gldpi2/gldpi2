# -*- coding: ISO-8859-1 -*-

from Tkinter import Tk, Frame, BOTH

class Example(Frame):
    def __init__(self, parent):
        Frame.__init__(self, parent, background="red")
        
        self.parent = parent
        
        self.initUI()
    
    def initUI(self):
        self.parent.title("GLD+")
        self.pack(fill=BOTH, expand = 1)

def main():
    root = Tk()
    root.geometry("800x600")
    
    app = Example(root)
    root.mainloop()
    
if __name__ == '__main__':
    main()