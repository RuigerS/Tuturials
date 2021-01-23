#!/bin/bash

line="------------------------------------------"

echo "Starting at: $(date)"
echo $line

echo "UPTIME"
uptime
echo $line

# use \n or ; to seperate commands
echo "FREE"; free; echo $line

echo "WHO"
who 
echo $line

echo "Finishing at: $(date)"
echo $line;echo

##################################################
# Variables and Globs
##################################################
localexample=hello # Local
export globalexample=hey # Global for all Bash subprocesses
echo $localexample 
echo $globalexample

# Globs are chars that allow us to create lists of files, e.g. wildcards * and ?
echo *.py
echo c*
echo *
echo ???.py

# In Python there is a glob module to work with wildcards

##################################################
# Conditionals
##################################################
# using program exit status; if exit==0 then True
if grep "127.0.0.1" /etc/hosts 
then
    echo "All's swell"
else
    echo "ERROR: 127.0.0.1 not found in /etc/hosts"
fi

# test command is helpful:
if test -n "$PATH"; then echo "PATH is not empty";fi
#aka thanks to ALIAS
if [ -n  "$PATH" ]; then echo "PATH is not empty";fi

##################################################
# While loops
##################################################
n=1
while [ $n -le 5 ];do
    echo "Iteration number $n"
    ((n+=1))  # Double dash: arithmetic operations with variables
done

# repeated try execute if failed:
n=0
command=$1 # command line argument
while ! $command && [ $n -le 5 ]; do
    sleep $n
    ((n=n+1))
    echo "Retry #$n"
done

##################################################
# For loops
##################################################
for fruit in peach orange apple; do
    echo "I like $fruit!"
done

for file in *.ext; do
    name=$(basename "$file" .ext) # $file in aanhalingtekens omdat kan spaties bevatten
    # before really moving, test it by echoing the commands:
    echo mv "$file" "$name.next"
    # mv "$file" "$name.next"
done

for logfile in /var/log/*.log; do
    echo "Processing: $logfile"
    cut -d' ' -f5- $logfile | sort | uniq -c | sort -nr | head -5
done