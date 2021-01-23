#!usr/bin/env python3

import re

def rearrange_name(name):
    # if not isinstance(name,str):
    if not type(name) is str:
        return ""
    result=re.search(r"^([\w .]*), ([\w .]*)$",name)
    if result is None:
        return name
    return "{} {}".format(result[2],result[1])