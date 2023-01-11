(ns sv.container-image.dev
  (:require [sv.container-image.yarn :as yarn]
            [sv.container-image.gcloud :as gcloud]
            [sv.container-image.node :as node]
            [sv.container-image.datomic :as datomic]
            [sv.container-image.process :as process]
            [sv.container-image.kubectl :as kubectl]
            [sv.container-image.terraform :as terraform]
            [sv.container-image.openvscode :as openvscode]
            [sv.container-image.clj-kondo :as clj-kondo]
            [sv.container-image.github-actions-runner :as github-actions-runner]
            [sv.container-image.maven :as maven]
            ))

(defn install
  [params]
  (concat
   (kubectl/install params)
   (terraform/install params)
   (yarn/install params)
   (gcloud/install params)
   (node/install params)
   (maven/install params)
   (datomic/install params)
   (openvscode/install params)
   (clj-kondo/install params)
   (github-actions-runner/install params)
   ))

(defn install!
  [params]
  (process/execute! (install params))
  )
