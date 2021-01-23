#!/usr/bin/env python3

import requests
import socket

def check_localhost():
        """Verify localhost translates to 127.0.0.1:"""
        localhost=socket.gethostbyname('localhost')
        return localhost=="127.0.0.1"

def check_connectivity():
        """Verify we get STATUS OK (200) from Google:"""
        request=requests.get("http://www.google.com")
        return request.status_code == 200

# if not check_localhost() or not check_connectivity():
#     print("NETWORK ERROR!")
# else:
#     print("All's'swell")