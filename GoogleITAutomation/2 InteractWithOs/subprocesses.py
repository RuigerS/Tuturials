#!/usr/bin/env python3

import subprocess
import os

#########################################
# Using system commands
#########################################
subprocess.run(["date"])
subprocess.run(["sleep","2"])  # One thread, jumping to other program, then returning control after end
result=subprocess.run(["dir","this_does_not_exist"])
print(result, result.returncode)

#########################################
# Capturing external output (python 3.7 and up)
#########################################
result=subprocess.run(["host","8.8.8.8"], capture_output=True)
print(result.returncode)
print(result.stdout)  # b'8.8.8.8.in-addr.arpa domain name pointer dns.google.\n' // b'xxx': array of bytes
print(result.stdout.decode())  # 8.8.8.8.in-addr.arpa domain name pointer dns.google.
print(result.stdout.decode().split())  # ['8.8.8.8.in-addr.arpa', 'domain', 'name', 'pointer', 'dns.google.']

result=subprocess.run(["rm","does_not_exist_to_get_error"], capture_output=True)
print(result.returncode)
print(result.stdout)  # b''
print(result.stderr.decode())  # rm: cannot remove 'does_not_exist_to_get_error': No such file or directory

#########################################
# Advanced subprocess management
#########################################
my_env=os.environ.copy()
my_env["PATH"]=os.pathsep.join(["/opt/myapp",my_env["PATH"]])  # Add DIR to PATH
result=subprocess.run(["myapp"],env=my_env)

# run inspiration
# cwd: to change working directory
# timeout parameter kills the subprocess if it takes more than any given number of seconds
# shell parameter makes sure the command gets run in a shell, having expansions and operations available ! Security issues

# Make sure: script calling is OS specific and less secure as using python native libs
# Good: quick and dirty
# Less good: long term and cross platform
