# CryptoGUI [![Build Status](https://travis-ci.com/jmpreyes/cryptogui.svg?branch=master)](https://travis-ci.com/jmpreyes/cryptogui)
A little project with cryptography and Java GUI programming!
___
I use this project as a way for me to improve my skills and to learn new ones.<br>
*Inspiration: using my previous projects from school (undergrad and postgrad) and programming skills to make something cool!*<br>

**Tasks (current, upcoming, planned, things that come into mind, etc.)**

Cryptography:
- [x] Implement Caesar cipher
- [x] Implement Vigenère cipher
- [x] Implement Porta cipher
- [x] Implement Zimmermann cipher<br>
...and more variations in the future!

User Interface (with Java Swing and AWT):
- [x] Implement menu for cipher selection
- [ ] Implement fluid transition between frames

Others:
- [ ] Importing from or exporting to files
- [ ] Including and/or ignoring special characters
- [x] Design pattern implementation (for practice too!)
- [ ] Adding descriptions for each cipher technique
___
### Sample Zimmermann run:

A quick implementation of it like a prototype or something.<br>
[Good read from this article!](https://hackaday.com/2017/01/26/the-zimmermann-telegram/)<br>
So currently, given file `Lorem_Ipsum.txt`, a sample code book would be something like:
```
LOREM : 15223
IPSUM : 78836
DOLOR : 93383
SIT : 50157
AMET : 26838
CONSECTETUR : 29881
ADIPISCING : 33637
ELIT : 89538
PRAESENT : 41857
EGET : 66016
MI : 48628
ANTE : 64336
RHONCUS : 46783
RUTRUM : 48206
VITAE : 97042
VEL : 98538
NULLA : 76717
LACUS : 73639
. . .
```
Then the encrypted output of the file would be:
```
96710 71577 21786 26204 76040 
26087 45901 45460 78431 95622 
77196 77992 61404 11029 34005 
27736 74975 71577 35881 27983 
96661 81134 96528 12830 53127 
65645 13247 61660 49471 96212 
38386 95581 51664 90116 44481 
49619 66214 19543 65891 58667 
45649 50956 72719 34097 71344 
82821 89394 43606 28172 15900 
76622 68425 25288 31937 90996 
63379 58475 55240 76504 51039 
49510 46506 84265 83093 11217 
99218 47864 78862 84948 27363 
63976 44013 27884 88538 10079 
67809 90053 98386 83402 96435 
79118 95157 49059 14043 31898 
43387 30232 59315 53357 42102 
34167 54084 32125 23342 81620 
62251 47331 79096 43951 44308 
10281 67092 15613 53399 46712 
40616 53980 53776 20122 46731 
56072 10226 29349 15430 81751 
33905 86001 70160 49193 29393 
34310 68984 69469 12032 47226 
62386 71786 82050 39723 54887 
49841 78275 87781 69326 51080 
99678 88656 89101 17406 24368 
26037 83209 91322
```
