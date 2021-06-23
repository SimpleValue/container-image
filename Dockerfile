FROM babashka/babashka:0.4.6

ADD . /container-image

RUN cd /container-image && bb -m sv.container-image.default
