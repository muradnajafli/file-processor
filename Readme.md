# File Processor.

## Purpose
Get familiar with Kotlin collections and operations over them. Also, get familiar with Generic specifics in Kotlin. 

## Introduction
Let’s imagine that we need to implement file processor. There are some filter rules that can be applied to a file: 
* By numbers of word in the line 
* By length of the line 
* If line contains particular substring 

Also, after filtering mapping might be applied. Following mapping can be selected: 
* Map to number of words in the line 
* Map to number of symbols in the line 
* Map that replaces substring in the line 

After mapping some transformation can be applied to mapped result: 
* Mapped items can be chunked. Chunk size is fixed during entire process flow 
* Mapped items can be dropped by predicate. 
* Only n items can be taken after mapping is performed 
* Only unique values are produced after mapping 

Then following terminal operations can be executed: 
* Print each value to console 
* Sum in case of numbers sequence after transformation is produced 
* Multiply all items in case of mapping to number applied 
* Find particular string in case of string sequence after transformation is produced 

## Task description
To complete task perform following activities: 
* Add implementation for each filter, mapper, transformation and terminate operation 
* Add implementation for file reader. File should be read line by line 
* Add implementation for file processor pipeline. Order of operations to apply: 
    1. Filtering of strings 
    2. Mapping of strings to another type 
    3. Transformation of mapped sequence 
    4. Terminate operation.

Tips:
* Chek Java docs for more details
* Also, there is an example of entire pipeline in FileProcessor class 
* Finally, please check that all tests successfully passed before submitting your solution