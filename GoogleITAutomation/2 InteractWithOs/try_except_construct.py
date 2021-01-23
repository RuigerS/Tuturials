#!usr/bin/env python3

def character_frequency(filename):
    """counts the frequency of each character in the given file"""
    #first try open the file
    characters={}
    try:
        f=open(filename)
    except FileNotFoundError:  # first most detailed exception
        print("File not found")
        characters=None
    except OSError: # second less detailed exception
        print("Other error raised by OS. Maybe disk full?")
        characters=None
    except:     # last most global exception
        print("Something else went wrong")
        characters=None
    else:
        print("Jeeeh, it worked!!")
        # Now process the file (intermezzo)
        for line in f:
            for char in line:
                characters[char]=characters.get(char,0)+1
        f.close()
    finally:
        return characters
def validate_user(username,minlen):
    # Use assert to verify unexpected situations
    # assert will be removed with code optimization
    assert type(username)==str,"username must be a string"  
    #  Use raise to check for expected (anticipated) exceptions in normal operation
    if minlen<1:
        raise ValueError("minlen must be at least 1")
    if len(username)<minlen:
        return False
    if not username.isalnum():
        return False
    return True