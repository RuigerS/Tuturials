import tkinter as tk
from tkinter import Canvas, ttk

window=tk.Tk()
window.title("Sjabloon")
window.minsize(800,600)

window.columnconfigure([0],weight=0,minsize=200)
window.columnconfigure([1],weight=1,minsize=200)
window.columnconfigure([2],weight=0,minsize=200)
window.rowconfigure([0],weight=0,minsize=75)
window.rowconfigure([1],weight=1,minsize=100)
window.rowconfigure([2],weight=0,minsize=24)

frm_topbar=tk.Frame(
    master=window,
    relief=tk.RIDGE,
    bg="snow4",
    height=75
)
frm_topbar.grid(row=0,column=0,columnspan=3,sticky="ewn")

frm_leftmenu=tk.Frame(
    master=window,
    relief=tk.GROOVE,
    bg="snow2",
    width=200
)
frm_leftmenu.grid(row=1,column=0,sticky="ens")

frm_content=tk.Frame(
    master=window,
    relief=tk.FLAT,
    bg="snow",
    width=200
)
frm_content.grid(row=1,column=1,sticky="ewns")

frm_rightmenu=tk.Frame(
    master=window,
    relief=tk.GROOVE,
    bg="snow3"
)
frm_rightmenu.grid(row=1,column=2,sticky="wns")

frm_statusbar=tk.Frame(
    master=window,
    relief=tk.GROOVE,
    bg="snow4",
    height=24
)
frm_statusbar.grid(row=2,column=0,columnspan=3,sticky="ews")

content_scrollbar_horizontal=ttk.Scrollbar(frm_content,orient='horizontal')
content_scrollbar_vertical=ttk.Scrollbar(frm_content,orient='vertical')
canvas=Canvas(frm_content,
    width=800,height=600,bg="#ff7700",
    scrollregion=(0,0,800,600),
    yscrollcommand=content_scrollbar_vertical.set,xscrollcommand=content_scrollbar_horizontal.set)
content_scrollbar_horizontal['command']=canvas.xview
content_scrollbar_vertical['command']=canvas.yview
canvas.grid(column=0,row=0,sticky="ewns")
content_scrollbar_horizontal.grid(column=0,row=1,sticky='we')
content_scrollbar_vertical.grid(column=1,row=0,sticky='ns')
frm_content.grid_columnconfigure(0,weight=1)
frm_content.grid_rowconfigure(0,weight=1)
canvas.config(width=1800,height=1400)
canvas.config(scrollregion=(0,0,canvas['width'],canvas['height']))


window.mainloop()