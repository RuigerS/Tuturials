#!/usr/bin/env python3

import os
import requests

url = 'http://localhost/upload/'

os.chdir("./supplier-data/images")
for img in os.listdir("."):
  if "jpeg" in img:
    with open(img, 'rb') as opened:
      r = requests.post(url, files={'file': opened})