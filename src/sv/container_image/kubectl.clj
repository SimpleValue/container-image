(ns sv.container-image.kubectl
  (:require [sv.container-image.apt :as apt]))

(defn install
  [_params]
  [(apt/install {:apt/packages ["kubectl"]})
   ])
