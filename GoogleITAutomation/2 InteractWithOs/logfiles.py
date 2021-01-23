#!usr/bin/env python3

import sys
import re
#########################################
# Logfile reading line per line, parameter logfile
#########################################
logfile=sys.argv[1]
with open(logfile) as f:
    for line in f:
        if "Subject" not in line:
            continue
        pattern=r"Subject \((\w+)\)$"
        result=re.search(pattern,line)
        print(result[1])

#########################################
# simple counting using dictionaries
#########################################
usernames={}
name="good_user"
usernames[name]=usernames.get(name,0)+1
print (usernames)
usernames[name]=usernames.get(name,0)+1
print (usernames)

#########################################
# Combined:
#########################################
logfile=sys.argv[1]
subjects={}
with open(logfile) as f:
    for line in f:
        if "Phrase" not in line:
            continue
        pattern=r"Subject \((\w+)\)$"
        result=re.search(pattern,line)
        if result is None:
            continue
        subject=result[1]
        subjects[subject]=subjects.get(name,0)+1
print(subjects)

#########################################
# Cloud example lab:
#########################################
#!/usr/bin/env python3
import sys
import os
import re


def error_search(log_file):
  error = input("What is the error? ")
  returned_errors = []
  with open(log_file, mode='r',encoding='UTF-8') as file:
    for log in  file.readlines():
      error_patterns = ["error"]
      for i in range(len(error.split(' '))):
        error_patterns.append(r"{}".format(error.split(' ')[i].lower()))
      if all(re.search(error_pattern, log.lower()) for error_pattern in error_patterns):
        returned_errors.append(log)
    file.close()
  return returned_errors

  
def file_output(returned_errors):
  with open(os.path.expanduser('~') + '/data/errors_found.log', 'w') as file:
    for error in returned_errors:
      file.write(error)
    file.close()
if __name__ == "__main__":
  log_file = sys.argv[1]
  returned_errors = error_search(log_file)
  file_output(returned_errors)
  sys.exit(0)
