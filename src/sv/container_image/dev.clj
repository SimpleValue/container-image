(ns sv.container-image.dev
  (:require [sv.container-image.yarn :as yarn]
            [sv.container-image.gcloud :as gcloud]
            [sv.container-image.node :as node]
            [sv.container-image.datomic :as datomic]
            [sv.container-image.process :as process]))

(defn install
  [params]
  (concat
   (yarn/install params)
   (gcloud/install params)
   (node/install params)
   (datomic/install params)
   ))

(defn install!
  [params]
  (process/execute! (install params))
  )
