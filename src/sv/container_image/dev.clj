(ns sv.container-image.dev
  (:require [sv.container-image.yarn :as yarn]
            [sv.container-image.gcloud :as gcloud]
            [sv.container-image.node :as node]
            [sv.container-image.datomic :as datomic]
            [sv.container-image.process :as process]
            [sv.container-image.kubectl :as kubectl]
            [sv.container-image.terraform :as terraform]
            ))

(defn install
  [params]
  (concat
   (kubectl/install params)
   (terraform/install params)
   (yarn/install params)
   (gcloud/install params)
   (node/install params)
   (datomic/install params)
   ))

(defn install!
  [params]
  (process/execute! (install params))
  )
