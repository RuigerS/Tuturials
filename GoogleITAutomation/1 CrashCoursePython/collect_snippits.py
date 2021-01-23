#####################################################################################

wardrobe = {'shirt': ['red', 'blue', 'white'], 'jeans': ['blue', 'black']}
new_items = {'jeans': ['white'], 'scarf': ['yellow'], 'socks': ['black', 'brown']}
wardrobe.update(new_items)
print(wardrobe)
print(new_items)

#####################################################################################

import shutil
du=shutil.disk_usage("/")
print(du)
# amounts of bytes on disk
print("Percentage used: "+str((du.free/du.total)*100))

#####################################################################################

import psutil
print(psutil.cpu_percent(0.1))

#####################################################################################
