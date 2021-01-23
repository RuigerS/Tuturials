#!/usr/bin/env python3
import shutil
import psutil
from AutomationExampleModuleCheckNetwork import *

def check_disk_usage(disk):
    """Verify enough (more 20%) free disk space:"""
    du=shutil.disk_usage(disk)
    free= du.free/du.total*100
    return free>20

def check_cpu_usage():
    """Verify enough (at least 25%) CPU free cycles:"""
    usage=psutil.cpu_percent(1)
    return usage<75

if not check_disk_usage("/") or not check_cpu_usage():
    print("ERROR!")
elif check_localhost() and check_connectivity():
    print("All's'swell")
else:
    print("Network check failed!")