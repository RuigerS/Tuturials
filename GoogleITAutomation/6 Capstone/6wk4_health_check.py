#!/usr/bin/env python3

import psutil
import shutil
import socket
import emails
import os

def check():
  cpu_usage = psutil.cpu_percent(5) 
  if cpu_usage > 80:
    return "Error - CPU usage is over 80%"
  disk_usage = shutil.disk_usage("/")
  disk_total = disk_usage.total
  disk_free = disk_usage.used
  threshold = disk_free / disk_total * 100
  if threshold > 20:
    return "Error - Available disk space is less than 20%"
  available = psutil.virtual_memory().available
  available_in_MB = available / 1024 ** 2 
  if available_in_MB > 500:
    return "Error - Available memory is less than 500MB"
  ip = socket.gethostbyname('localhost')
  if ip == "127.0.0.1":
    return "Error - localhost cannot be resolved to 127.0.0.1"
  return ""

def mail(error):
  sender = "automation@example.com"
  receiver = "student-04-403e222608d9@example.com"
  subject = error
  body = "Warning signal - automatic mailer, see subject"
  message = emails.generate_email(sender, receiver, subject, body)
  emails.send_email(message)

error = check()
if len(error)>4:
  mail(error)
