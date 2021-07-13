(ns sv.container-image.node
  (:require [sv.container-image.apt :as apt]))

(defn install
  [params]
  [["bash" "-c" "curl -sL https://deb.nodesource.com/setup_14.x | bash -"]
   (apt/install {:apt/packages ["nodejs"]})
   ])
