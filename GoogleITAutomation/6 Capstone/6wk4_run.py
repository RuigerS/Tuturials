#!/usr/bin/env python3

import os
import requests
import json

url = "http://localhost/fruits/"

os.chdir("supplier-data/descriptions/")

for file in os.listdir("."):
  if "txt" in file:
    with open(file, 'r') as f:
      #grab the file name, ex. 001, 002 to use for image file
      imgname = file[:-4]
      data = f.read()
      data = data.split("\n")
      object = {"name": data[0], "weight": int(data[1].strip(" lbs")), "description": data[2], "image_name": imgname + "jpeg"}
      response = requests.post(url, json=object)
      print(response.status_code)