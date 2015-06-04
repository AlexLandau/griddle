#!/usr/bin/env bash

# Instructions at http://www2.cs.tum.edu/projects/cup/install.php
# and http://www2.cs.tum.edu/projects/cup/docs.php#running

java -jar lib/java-cup-11a.jar -destdir src/main/java/net/alloyggp/griddle/generated -package net.alloyggp.griddle.generated -parser GdlParser -symbols Symbols schemas/GdlParser.cup
