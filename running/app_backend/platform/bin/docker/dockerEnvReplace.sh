#!/bin/sh
# dockerEnv.sh �Ѽ�
## 1. ���y�Ѽƪ���Ƨ�
## 2. ���y���ɮ�����
## 3. �n�ư����y���ɮצW��
bash ./platform/bin/docker/dockerEnv.sh ./platform/bin sh dockerEnvReplace.sh dockerEnv.sh dockerRun.sh
sed -i s#@space@#" "#g ./platform/bin/run.sh
sed -i s#@space@#" "#g ./platform/bin/runEncrypt.sh
bash ./platform/bin/docker/dockerEnv.sh /jmx properties
bash ./platform/bin/docker/dockerEnv.sh ./platform/conf xml
bash ./platform/bin/docker/dockerEnv.sh ./platform/conf properties 
bash ./platform/bin/docker/dockerEnv.sh ./application properties
