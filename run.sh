#!/bin/bash
#set -x
ARGS_NUM=1
if [[ ( $# -lt $ARGS_NUM ) ]]; then
  echo "Usage: script.sh PARAM1"
  exit 1
fi

param1=$1

java -jar target/Anagram-1.0-SNAPSHOT-jar-with-dependencies.jar "$param1"
