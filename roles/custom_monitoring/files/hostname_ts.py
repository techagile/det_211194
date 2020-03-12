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
  filelog = open("/tmp/host_ts.log","a")
  filelog.write("\n" + gethostname_val() + " " + gettimestamp_val())
  filelog.close()

def readfile():
  filelog = open("/tmp/host_ts.log","r")
  print(filelog.read())
  filelog.close()

def main():
  print(platform.platform())
  # Running endless loop, unti interrupted!
  while(not time.sleep(5)):
    writetofile()

if __name__ == "__main__":
  main()
