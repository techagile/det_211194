#!/usr/bin/python

# Script to output hostname, timestamp to file on schedule, continuously

import socket
import datetime
import time
import platform

def gethostname_val():
  hostname_val=socket.gethostname();
  return hostname_val

def gettimestamp_val():
  timestamp_val = str(datetime.datetime.now())
  return timestamp_val

def writetofile():
  if (ostype.startswith("Linux")):
    filelog = open("/tmp/host_ts.log","a")
    filelog.write("\n" + gethostname_val() + " " + gettimestamp_val())
    filelog.close()
  elif ostype.startswith("Windows"):
    filelog = open("c:\\temp\\host_ts.log","a")
    filelog.write("\n" + gethostname_val() + " " + gettimestamp_val())
    filelog.close()
    

def readfile():
  if (ostype.startswith("Linux")):
    filelog = open("/tmp/host_ts.log","r")
    print(filelog.read())
    filelog.close()
  elif ostype.startswith("Windows"):
    filelog = open("c:\\temp\\host_ts.log","r")
    print(filelog.read())
    filelog.close()

def main():
  # Running endless loop, unti interrupted!
  while(not time.sleep(5)):
    writetofile()

if __name__ == "__main__":
  ostype=platform.platform()
  main()
