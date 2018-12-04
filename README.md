# Magnolia Dev Days 2018 - Hackathon - Headless

### Java VM options
You should change the ``magnolia.resources.dir`` and ``magnolia.home`` arguments.

```
-Xms512m
-Xmx1024m
-Djava.awt.headless=true
-Dmagnolia.home=[/path/to/hackathon-headless]/hackathon-headless-webapp/src/main/webapp-data 
-Dmagnolia.resources.dir=[/path/to/hackathon-headless/hackathon-headless-module]/src/main/resources
-XX:-UseConcMarkSweepGC
```

Start with `contextpath` set to `/mgnl-author`.