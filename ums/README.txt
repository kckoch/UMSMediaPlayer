Universal Media Server
======================

Based on PS3 Media Server by shagrath, all files copyright shagrath unless otherwise specified.

This is a special distribution of UMS that is configured to disable uPNP network broadcasts
and to listen only to connections from localhost (127.0.0.1).

Starting the server:
---------------------

1. Open a terminal window (Linux) or command prompt (Windows) and navigate to the directory containing this README.
2. Execute the following command:
    java -Dums.profile.path=. -cp ums.jar net.pms.PMS
3. Media is served from the Music folder. Use a web browser to access it:
    http://127.0.0.1:9001



Current Developers
------------------

* SubJunk
* SharkHunter
* valib
* skeptical

Current Forum Moderators
------------------------

* Optimus_prime
* DeFlanko


Links
-----

* Website:       http://www.universalmediaserver.com/
* Source code:   https://github.com/UniversalMediaServer/UniversalMediaServer
* Issue tracker: http://code.google.com/p/universal-media-server/issues/list


Thanks
------

Thanks to:

* Redlum
* tcox
* taconaut
* tomeko
* chocolateboy
* ditlew
* Raptor399
* renszarv
* happy.neko

for major code contributions.

Thanks to:

* meskibob
* otmanix

for documentation and contributions to the community.

Thanks to:

* AlfredoRamos
* Tianuchka

for significant/frequent language translations.

* boblinds and snoots for the network test cases :)
* sarraken, bleuecinephile, bd.azerty, fabounnet for the support and feedback