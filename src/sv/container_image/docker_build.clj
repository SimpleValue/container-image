(ns sv.container-image.docker-build
  (:require [babashka.process :as process]))

(defn new-tag
  []
  (.format (java.time.format.DateTimeFormatter/ofPattern
            "yyyyMMddHHmmss")
           (java.time.LocalDateTime/now)))

(defn build!
  [{:keys [image target]}]
  (let [image-tag (str image
                       ":"
                       (new-tag))]
    @(process/process ["docker" "build" "--target" target "-t" image-tag "."])
    (spit (str target
               "-latest")
          image-tag)
    @(process/process ["docker" "push" image-tag])
    ))
