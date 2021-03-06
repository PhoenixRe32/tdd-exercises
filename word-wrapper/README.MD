## Word wrapper

You write a class called Wrapper.

Has a single static function named wrap that takes two arguments, a string, and a column number.

The function returns the string, but with line breaks inserted at just the right places to make sure that no line is longer than the column number.

You try to break lines at word boundaries.

Like a word processor, break the line by replacing the last space in a line with a newline.

Rating: Easy

A Solution: https://github.com/WolfgangOfner/TDD-Kata/tree/master/WordWrapper

Source: http://codingdojo.org/kata/WordWrap/

#### Additional Detail
I have added the implementation detail that word boundaries are not just spaces 
but also commas, fullstops, semicolons. Because sometimes these are not followed
by a space (human error)