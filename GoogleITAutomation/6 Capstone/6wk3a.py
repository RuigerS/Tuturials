#! /usr/bin/env python3

from email.message import EmailMessage
import os.path
import mimetypes
import smtplib

message=EmailMessage()
sender="email sender"
recipient="ontvanger email"
subject="Onderwerpregel"
messagebody="""Hello,
multiple lines,
end of body"""

attachment_path="./6wk2.py"
att_file=os.path.basename(attachment_path)
mime_type, _ = mimetypes.guess_type(attachment_path)
mime_type,mime_subtype=mime_type.split('/',1)


message['From']=sender
message['To']=recipient
message['Subject']=subject
message.set_content(messagebody)
with open(attachment_path,'rb') as ap:
  message.add_attachment(ap.read(), maintype=mime_type,subtype=mime_subtype,filename=att_file)
  
print(message)

try:
  mail_server = smtplib.SMTP('localhost')
  # extern: mail_server = smtplib.SMTP_SSL('smtp.example.com')
  mail_server.set_debuglevel(1)
  # import getpass
  # mail_pass-getpass.getpass('Password? ')
  # mail_server.login(sender, mail_pass)
  mail_server.send_message(message)
  mail_server.quit()
except:
  print("Error with mailserver sending")


