(ns sv.container-image.clojure
  (:require [sv.container-image.apt :as apt]))

(defn install
  [params]
  [(apt/update params)
   (apt/install {:apt/packages ["rlwrap"
                                "openjdk-11-jre-headless"]})
   ["bash" "-c" "curl https://download.clojure.org/install/linux-install-1.10.3.1040.sh | bash"]])
