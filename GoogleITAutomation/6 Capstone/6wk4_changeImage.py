#!/usr/bin/env python3

from PIL import Image
import os

os.chdir("./supplier-data/images")
for img in os.listdir("."):
  if "tiff" in img:
    with Image.open(img) as im:
      im.convert("RGB").resize((600,400)).save(img[:-4]+"jpeg","JPEG")
