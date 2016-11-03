#!/bin/bash
if [[ -z "$1" ]]
	then
	echo "Missing cpp file"
elif [ ! -f $1 ]
	then
	echo "That cpp is not here!"
elif [ ! -f _gold ]
	then
	echo "Missing the _gold file?"
else
	g++ $1
	./a.out
	cmp _out _gold
fi