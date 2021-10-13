(ns sv.container-image.docker-build
  (:require [babashka.process :as process]))

(defn new-tag
  []
  (.format (java.time.format.DateTimeFormatter/ofPattern
            "yyyyMMddHHmmss")
           (java.time.LocalDateTime/now)))

(defn build!
  [{:keys [image target dir]}]
  (let [image-tag (str image
                       ":"
                       (new-tag))
        execute! (fn [args]
                   @(process/process
                     args
                     (cond-> {:out :inherit
                              :err :inherit}
                       dir
                       (assoc :dir dir))))]
    (execute! ["docker" "build" "--target" target "-t" image-tag "."])
    (spit (str target
               "-latest")
          image-tag)
    (execute! ["docker" "push" image-tag])
    ))
