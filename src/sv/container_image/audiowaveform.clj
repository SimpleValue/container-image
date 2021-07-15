(ns sv.container-image.audiowaveform
  (:require [sv.container-image.apt :as apt]))

(defn install
  [params]
  [["add-apt-repository" "-y" "ppa:chris-needham/ppa"]
   (apt/update params)
   (apt/install {:apt/packages ["audiowaveform"]})
   ])
