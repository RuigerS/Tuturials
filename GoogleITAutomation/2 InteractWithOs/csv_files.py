# CSV: each newline == row seperated
#   each comma == column seperated

import csv

##################################
# READING
##################################
f=open("csv_file.txt")
csv_f=csv.reader(f)
for row in csv_f:
    name,phone,role=row
    print("Name: {}, Phone: {}, Role: {}".format(name,phone,role))
f.close()

##################################
# WRITING
##################################
hosts=[["workstation.local","192.168.25.46"],["webserver.cloud","10.2.5.6"]]
with open('hosts.csv','w',newline='') as hosts_csv:  # newline because bug in windows gives extra empty line
    writer=csv.writer(hosts_csv)
    # specific: writer.writerow or all: writer.writerows
    writer.writerows(hosts)

##################################
# R+W with dictionaries
##################################
with open("software.csv")as software:
    reader=csv.DictReader(software)
    for row in reader:
        print(("{} has {} users").format(row["name"],row["users"]))

users=[{"name":"Sol Mansi","username":"solm","department":"IT infrastructure"},
{"name":"Lio Nelson","username":"lion","department":"UX research"},
{"name":"Charlie Grey","username":"greyc","department":"Development"}]

keys=["name","username","department"]
with open('by_department.csv','w',newline='')as by_department:  # newline because bug in windows gives extra empty line
    writer=csv.DictWriter(by_department,fieldnames=keys)
    writer.writeheader()
    writer.writerows(users)
