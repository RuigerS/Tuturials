#!/usr/bin/env python3
import re
import sys
import operator

errors={}
usersinfo={}
userserror={}
logfile="./syslog.log"
with open(logfile) as f:
  for line in f:
    line=line.strip()
    line=line.split("ticky: ",1)[1]
    name=line.split("(")[1][:-1]
    line=line.split(" (")[0]
    if "ERROR " in line:
      error=line.split(" ",1)[1]
      errors[error]=errors.get(error,0)+1
      userserror[name]=userserror.get(name,0)+1
    elif "INFO " in line:
      usersinfo[name]=usersinfo.get(name,0)+1
usersinfo=sorted(usersinfo.items(),key=operator.itemgetter(0))
userserror=sorted(userserror.items(),key=operator.itemgetter(0))
errors=sorted(errors.items(),key=operator.itemgetter(1),reverse=True)
with open("./error_message.csv","w") as f:
  f.write("Error,Count\n")
  for error,aantal in userserror.items():
    f.write("{},{}".format(error,aantal))
