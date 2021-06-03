import tkinter as tk

window=tk.Tk()

frm_top=tk.Frame(
    master=window,
    relief=tk.RAISED,
    borderwidth=1
)


for i in range (3):
    frm_top.columnconfigure(i,weight=1,minsize=75)
    frm_top.rowconfigure(i,weight=1,minsize=50)
    for j in range (3):
        frm_loop=tk.Frame(
            master=frm_top,
            relief=tk.RAISED,
            borderwidth=1
        )
        frm_loop.grid(row=i,column=j, padx=3,pady=3)
        lbl_A=tk.Label(master=frm_loop,text=f"Row {i}\nColumn {j}")
        lbl_A.pack(padx=3,pady=3)

lbl_sticky=tk.Label(master=frm_top,text="NorthEast - Sticky")
lbl_sticky.grid(row=3,column=0,columnspan=3,sticky="ne")  # North nN East eE South sS West wW
frm_top.pack()

frm_2nd=tk.Frame(
    master=window,
    relief=tk.RAISED,
    borderwidth=1
)
frm_2nd.rowconfigure(0,minsize=50)
frm_2nd.columnconfigure([0,1,2,3],minsize=50)

lbl_1=tk.Label(text="1",bg="black",fg="white",master=frm_2nd)
lbl_2=tk.Label(text="2",bg="black",fg="white",master=frm_2nd)
lbl_3=tk.Label(text="3",bg="#000",fg="#fff",master=frm_2nd)
lbl_4=tk.Label(text="4",bg="#000000",fg="#ffffff",master=frm_2nd)

lbl_1.grid(row=0,column=0)
lbl_2.grid(row=0,column=1,sticky="ew")
lbl_3.grid(row=0,column=2,sticky="ns")
lbl_4.grid(row=0,column=3,sticky="nsew")

frm_2nd.pack()

frm_3rd=tk.Frame(
    master=window,
    relief=tk.RAISED,
    borderwidth=1
)
def increase():
    value=int(lbl_value["text"])
    lbl_value["text"]=f"{value+1}"
def decrease():
    value=int(lbl_value["text"])
    lbl_value["text"]=f"{value-1}"

btn_decrease = tk.Button(master=frm_3rd, text="-", command=decrease)
btn_decrease.grid(row=0,column=0,sticky="nsew")
lbl_value=tk.Label(master=frm_3rd,text="0")
lbl_value.grid(row=0,column=1)
btn_increase = tk.Button(master=frm_3rd, text="+", command=increase)
btn_increase.grid(row=0,column=2,sticky="nsew")

frm_3rd.pack()
window.mainloop()