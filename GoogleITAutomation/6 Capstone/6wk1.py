#!/usr/bin/env python3

from PIL import Image
import os

os.chdir("./images")
for file in os.listdir("."):
  try:
    with Image.open(file) as im:
      print(file)
      new_im=im.convert('RGB').resize((128,128)).rotate(90)
      outfile=file+".jpg"
      print(outfile)
      new_im.save(outfile,"JPEG")
      os.rename(outfile,"/opt/icons/"+outfile)
  except:
    print("Next")

os.chdir("..")
