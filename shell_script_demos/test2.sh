#!/bin/bash
# read-secret: input a secret pass phrass
if read -t 10 -sp "Enter secret pass phrass > " secret_pass; then
    echo "\nSecret pass phrass = '$secret_pass'"
else
    echo "\nInput timed out" >&2
    exit 1
fi