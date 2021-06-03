#!/usr/bin/env python3

import tkinter as tk

window=tk.Tk()
window.title("First first")


frm_A=tk.Frame()
frm_B=tk.Frame()

# Label, Button, Entry, Text, Frame (prefixes: lbl_ btn_ ent_ txt_ frm_)
lbl_A=tk.Label(
    master=frm_A,
    bd=5,  # border
    text="Frame a",
    foreground="white",  # or abbr. fg
    background="black",  # or abbr. bg
    highlightbackground="#ff7701",
    highlightcolor="#0077ff",
    highlightthickness="3",
    cursor="hand1",
    width=10,  # textunits
    height=2  # textunits
    )
lbl_A.pack()

lbl_B=tk.Label(
    master=frm_B,
    text="Frame b",
    foreground="#ff7701",  # or abbr. fg
    background="#400040",  # or abbr. bg
    width=10,  # textunits
    height=2  # textunits
    )
lbl_B.pack()

frm_A.pack()
frm_B.pack()

btn_test_text=tk.StringVar()
btn_test_text.set("Test Click me!")
btn_test=tk.Button(
    textvariable=btn_test_text,
    width=15,
    height=3,
    bg="blue",
    fg="yellow"
    )
btn_test.pack()

def handle_click(event):
    #btn_test.text=btn_test.cget('text')
    btn_test_text.set("Clicked")
    lbl_A["text"]="Clicked"

btn_test.bind("<Button-1>",handle_click)

ent_leeg=tk.Entry(fg="yellow",bg="blue",width=50)
ent_leeg.pack()
# inhoud=entry.get()
# entry.delete(0) removes first char
# entry.delete(1,5) removes chars indexed 1-4 (exclusive 2nd param)
# entry.delete(0,tk.END) removes chars indexed 0-EOS
#entry.insert(0,"Tekst to insert") insert string @ index

txt_box=tk.Text()
txt_box.pack()
# textbox.get("1.0") gets the char @ first line index 0 (lines start count @ 1)
# textbox.get("1.0","1.5") gets the char @ first line index 0 to 4 (excl 5)
# textbox.get("1.0",tk.END) gets all chars with \n between lines
# textbox.delete("1.5","1.8") is also available (delete I mean)
# textbox.insert("2.0","String to insert") index and string !! If newline then prefix \n or it will append last line
# textbox.append(tk.END, "Put me at the end!")
# textbox.append(tk.END, "\nPut me at the end on a new line!")

border_effects = {
    "flat": tk.FLAT,
    "sunken": tk.SUNKEN,
    "raised": tk.RAISED,
    "groove": tk.GROOVE,
    "ridge": tk.RIDGE,
}
for relief_name, relief in border_effects.items():
    frame = tk.Frame(master=window, relief=relief, borderwidth=5)
    frame.pack(side=tk.LEFT)
    label = tk.Label(master=frame, text=relief_name)
    label.pack()

frm_geo1=tk.Frame(master=window,width=100,height=100,relief=tk.GROOVE,bg="red")
frm_geo2=tk.Frame(master=window,width=50,height=50,relief=tk.GROOVE,bg="yellow")
frm_geo3=tk.Frame(master=window,width=25,height=25,relief=tk.GROOVE,bg="blue")
frm_geo1.pack(fill=tk.X, expand=True)  # tk.Y fills wide, tk.BOTH fills both directions
frm_geo2.pack()
frm_geo3.pack(side=tk.LEFT)  # tk.LEFT, tk.RIGHT, tk.TOP, tk.BOTTOM

lbl_1 = tk.Label(master=window, text="I'm at (0, 0)", bg="red")
lbl_1.place(x=0, y=0)
lbl_2 = tk.Label(master=window, text="I'm at (75, 75)", bg="green")
lbl_2.place(x=75, y=75)

window.mainloop()

# window.destroy() to exit on command line