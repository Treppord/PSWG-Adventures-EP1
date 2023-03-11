import argparse
import os
import re
import subprocess
import sys

import requests


parser = argparse.ArgumentParser()

parser.add_argument("--result", type=str, default="success")
parser.add_argument("--webhook", type=str, action="append")
parser.add_argument("--serverupdate", type=str, action="append")

args = parser.parse_args()

print("Current directory: " + os.getcwd())

files = [file for file in os.listdir(".") if file.rpartition("-")[2] not in {"sources.jar", "javadoc.jar", "dev.jar"}]

if files and args.result == "success":
    file, = files
    print("Trying to upload", os.path.realpath(file))
    if args.webhook:
        for url in args.webhook:
            with open(file, "rb") as fp:
                with requests.post(url, files={"file": fp}, data={
                        "content": f"Build {os.environ['BUILD_NUMBER']} built! <:mc_cake:711406798292254792>"}) as resp:
                    print("discord response:", resp.text)
    if args.serverupdate:
        for url in args.serverupdate:
            subprocess.check_call(["curl", "--location", "--request", "POST", url, "--form", f"file=@{file}"])
else:
    if not files:
        print("Did not find file")
    for url in args.webhook:
        with requests.post(url, data={"content": f"Build {os.environ['BUILD_NUMBER']} failed! \N{CROSS MARK}"}) as resp:
            print("discord response:", resp.text)
