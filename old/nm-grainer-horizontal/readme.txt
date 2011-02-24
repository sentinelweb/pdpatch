a granular synthesis patch by Nick Mariette (nmariette@gmail.com)

main patch name: nm-grainer.pd

new in current release:
horizontal sliders, removed graph on parent features.
OSC control

current release: April 2005
original release: May 2002

requires: zexy lib

uses the following third party patches: 
* an adaptation of not-quite-poly (nqpoly~.pd) from pix.test.at
* an adaptation of 29.sampler.loop.smooth.pd help patch for hamming window
* zexy lib, for mavg (however the patch will mostly function without zexy lib)

how-to-use?
mostly self explanatory - play with the coloured sliders and buttons for vastly variable effects....

known limitations:
1. suffers from the minimum 64 sample control signal block size - giving it a harsher sound when playing sequential grains due to the unreliable timing of grain playback.  i don't think this can be fixed without making an external.



have fun playing with this.  
if you have comments please email me:
nmariette@gmail.com