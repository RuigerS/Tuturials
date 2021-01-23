#! /usr/bin/env python3
import os
import requests

os.chdir("/data/feedback")
for file in os.listdir("."):
  print(file)
  with open(file) as inp:
    title=inp.readline().strip()
    name=inp.readline().strip()
    date=inp.readline().strip()
    feedback=inp.read().strip()
    url='http://35.194.20.19/feedback/'
    object={'title':title, 'name':name,'date':date,'feedback':feedback}
    print(object)
    x=requests.post(url,data=object)
    print("***********************************************\n",x.text)
    print(x.status_code)
