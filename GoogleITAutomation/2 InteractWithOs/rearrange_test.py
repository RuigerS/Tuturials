#!usr/bin/env python3

import unittest

# import a single specific function from a py file
from rearrange import rearrange_name

###########################################
# Simple unit test: prints result
###########################################



class TestRearrange(unittest.TestCase):
    def test_basic(self):
        testcase="Lovelace, Ada"
        expected="Ada Lovelace"
        self.assertEqual(rearrange_name(testcase),expected)

    def test_double_name(self):
        testcase="Hopper, Grace M."
        expected="Grace M. Hopper"
        self.assertEqual(rearrange_name(testcase),expected)

    def test_one_name(self):
        testcase="Voltaire"
        expected="Voltaire"
        self.assertEqual(rearrange_name(testcase),expected)

    def test_empty(self):
        testcase=""
        expected=""
        self.assertEqual(rearrange_name(testcase),expected)
    
    def test_string_number(self):
        testcase="123"
        expected="123"
        self.assertEqual(rearrange_name(testcase),expected)

    def test_int(self):
        testcase=213
        expected=""
        self.assertEqual(rearrange_name(testcase),expected)

    def test_high_int(self):
        testcase=982367498761238478937893274987874828390474892374987328947
        expected=""
        self.assertEqual(rearrange_name(testcase),expected)

    def test_int_0(self):
        testcase=0
        expected=""
        self.assertEqual(rearrange_name(testcase),expected)

    def test_int_negative(self):
        testcase=-123
        expected=""
        self.assertEqual(rearrange_name(testcase),expected)
        
    def test_int_negative_lowcanyougo(self):
        testcase=-123987549846576784623784673264786328746783264612783467832678
        expected=""
        self.assertEqual(rearrange_name(testcase),expected)

unittest.main()


###############################################
# Basic assertions:
# assertEqual(a, b)	        a == b	
# assertNotEqual(a, b)	    a != b	
# assertTrue(x)	            bool(x) is True	
# assertFalse(x)	        bool(x) is False	
# assertIs(a, b)	        a is b	
# assertIsNot(a, b)	        a is not b	
# assertIsNone(x)	        x is None	
# assertIsNotNone(x)	    x is not None	
# assertIn(a, b)	        a in b	
# assertNotIn(a, b)	        a not in b	
# assertIsInstance(a, b)	isinstance(a, b)	
# assertNotIsInstance(a, b)	not isinstance(a, b)	
###############################################
