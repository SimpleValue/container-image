(ns sv.container-image.yarn
  (:require [sv.container-image.apt :as apt]))

(defn install
  [params]
  [(apt/update params)
   (apt/install {:apt/packages ["gpg-agent"]})
   ["bash" "-c" "curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -"]
   ["bash" "-c" "echo 'deb https://dl.yarnpkg.com/debian/ stable main' | tee /etc/apt/sources.list.d/yarn.list"]
   (apt/update params)
   (apt/install {:apt/packages ["yarn"]})
   ;; ensure that global installed binaries are in the path:
   ["bash" "-c" "echo 'export PATH=\"$PATH:$(yarn global bin)\"' >> ~/.profile"]
   ])
